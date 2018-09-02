package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    @Test(enabled = true)
    public void testCreationContact() {
        app.goTo().homePage();
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("TestNameOFF").withMiddlename("TestMiddlename").withLastname("TestLastName")
                .withNickname("Test").withHomePhone("9097778881").withEmail("dadada@lol.net").withGroup("test4").withCreation(true);
        app.contact().createContact(contact);
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        assertEquals(before, after);

    }


}
