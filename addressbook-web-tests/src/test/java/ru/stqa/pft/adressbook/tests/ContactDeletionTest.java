package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        app.contact().isPresented();

    }

    @Test(enabled = false)
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size()-1);
        MatcherAssert.assertThat(after,CoreMatchers.equalTo(before.without(deletedContact)));
    }


}
