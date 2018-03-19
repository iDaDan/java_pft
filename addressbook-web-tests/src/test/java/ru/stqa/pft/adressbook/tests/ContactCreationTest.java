package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreationContact() {

        app.initNewConact();
        app.fillContactForm(new ContactData("TestName", "TestMiddlename", "TestLastName", "Test", "9097778881", "dadada@lol.net"));
        app.submitContactCreation();
        app.gotoHomePage();
    }


}
