package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    @Test(enabled = false)
    public void testCreationContact() {

        {

            app.getNavigationHelper().gotoHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            ContactData contact = new ContactData((before.get(before.size() - 1).getId() + 1),"TestNamedf", "TestMiddlename", "TestLastName",
                    "Test", null,"9097778881", "dadada@lol.net", "test4", true);
            app.getContactHelper().createContact(contact);
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> after = app.getContactHelper().getContactList();
            assertEquals(after.size(), before.size() + 1);

            before.add(contact);
            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);
            assertEquals(before, after);
        }
    }


}
