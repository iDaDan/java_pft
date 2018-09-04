package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    @Test//(enabled = false)
    public void testCreationContact() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("TestNameOFF").withMiddlename("TestMiddlename").withLastname("TestLastName")
                .withNickname("Test").withHomePhone("9097778881").withEmail("dadada@lol.net").withGroup("test4").withCreation(true);
        app.contact().createContact(contact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        assertThat(after.size(), equalTo(before.size() + 1));

        assertEquals(before, after);
        assertThat(after,equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }


}
