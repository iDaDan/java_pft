package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        app.contact().isPresented();

    }

    @Test(enabled = true)
    public void testContactModification() {

        List<ContactData> before = app.contact().getList();
        int index = before.size() - 1;

        ContactData contact = new ContactData(before.get(index).getId(),"TestName2", "TestMiddlename", "TestLastName",
                "Test2", null,"9097772222", "dadada22@lol.net", null, false);
        app.contact().modifyContact(index, contact);
        app.goTo().homePage();

        List<ContactData> after = app.contact().getList();
        assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
        assertEquals(before, after);
    }


}
