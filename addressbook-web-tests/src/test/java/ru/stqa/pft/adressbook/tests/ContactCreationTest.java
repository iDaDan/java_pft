package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreationContact() {
        /*int i;
        for (i = 0; i < 5; i++ )*/
        {

            app.getNavigationHelper().gotoHomePage();
            List<ContactData> before = app.getContactHelper().getContactList();
            app.getContactHelper().createContact(new ContactData("TestNamedf", "TestMiddlename", "TestLastName",
                    "Test", null,"9097778881", "dadada@lol.net", "test4", true));
            app.getNavigationHelper().gotoHomePage();
            List<ContactData> after = app.getContactHelper().getContactList();
            Assert.assertEquals(after.size(), before.size() + 1);
        }
    }


}
