package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        app.contact().isPresented();

    }

    @Test //(enabled = false)
    public void testContactModification() {
        Contacts before = app.db().contacts();
        int index = before.size() - 1;
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("TestName2").withMiddlename("TestMiddlename")
                .withLastname("TestLastName").withNickname("Test2").withHomePhone("9097772222")
                .withEmail("dadada22@lol.net").withCreation(false);
        app.contact().modifyContact(index, contact);
        app.goTo().homePage();
        assertEquals(before.size(), app.contact().count());
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListInUI();
    }



}
