package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    @Test//(enabled = false)
    public void testCreationContact() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/smile.jpg");
        ContactData contact = new ContactData()
                .withFirstname("TestName10").withMiddlename("TestMiddlename").withLastname("TestLastName")
                .withNickname("Test").withHomePhone("9097778881").withEmail("dadada@lol.net").withPhoto(photo).withGroup("test4").withCreation(true);
        app.contact().createContact(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after,equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

    @Test//(enabled = false)
    public void testBadCreationContact() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withFirstname("TestName10'").withCreation(true);
        app.contact().createContact(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after,equalTo(before));

    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File ("src/test/resources/smile.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }


}
