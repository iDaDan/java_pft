package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        app.contact().isPresented();

    }

    @Test(enabled = false)
    public void testContactModification() {

        Set<ContactData> before = app.contact().all();
        int index = before.size() - 1;

        ContactData contact = new ContactData().withFirstname("TestName2").withMiddlename("TestMiddlename")
                .withLastname("TestLastName").withNickname("Test2").withHomePhone("9097772222")
                .withEmail("dadada22@lol.net").withCreation(false);
        app.contact().modifyContact(index, contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        assertEquals(after.size(), before.size());

        contact.withId(after.stream().mapToInt((c)-> c.getId()).max().getAsInt());
        before.add(contact);
        assertEquals(before, after);
    }


}
