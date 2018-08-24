package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreationContact() {
        /*int i;
        for (i = 0; i < 5; i++ )*/
        {

            app.getNavigationHelper().gotoHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            ContactData contact = new ContactData((before.get(before.size() - 1).getId() + 1),"TestNamedf", "TestMiddlename", "TestLastName",
                    "Test", null,"9097778881", "dadada@lol.net", "test4", true);
            app.getContactHelper().createContact(contact);
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> after = app.getContactHelper().getContactList();
            assertEquals(after.size(), before.size() + 1);

            contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
            before.add(contact);
            assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        }
    }


}
