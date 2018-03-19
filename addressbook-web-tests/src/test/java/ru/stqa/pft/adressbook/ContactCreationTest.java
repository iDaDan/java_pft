package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void testCreationContact() {

        app.initNewConact();
        app.fillContactForm(new ContactData("TestName", "TestMiddlename", "TestLastName", "Test", "9097778881", "dadada@lol.net"));
        app.submitContactCreation();
        app.gotoHomePage();
    }


}
