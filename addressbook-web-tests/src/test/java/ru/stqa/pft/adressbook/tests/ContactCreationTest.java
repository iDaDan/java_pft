package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreationContact() {

        app.getContactHelper().createContact();
        app.getNavigationHelper().gotoHomePage();
    }


}
