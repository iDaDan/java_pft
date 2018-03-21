package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getContactHelper().selectContact();
        app.getContactHelper().initContactDeletion();
        app.getContactHelper().acceptContactDeletion();
    }
}
