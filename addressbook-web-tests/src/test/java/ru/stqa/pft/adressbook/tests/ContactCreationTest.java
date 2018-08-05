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
            //List<ContactData> before = app.getContactHelper().getContactList();
            int before =  app.getContactHelper().getContactCount();
            app.getContactHelper().createContact(new ContactData("TestName", "TestMiddlename", "TestLastName",
                    "Test", "9097778881", "dadada@lol.net", "test4", true));
            app.getNavigationHelper().gotoHomePage();
            //List<ContactData> after = app.getContactHelper().getContactList();
            int after =  app.getContactHelper().getContactCount();
            Assert.assertEquals(after, before + 1);
        }
    }


}
