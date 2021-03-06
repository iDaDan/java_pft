package ru.stqa.pft.adressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.Groups;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{


    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        try (BufferedReader reader = new BufferedReader (new FileReader(new File("src/test/resources/contacts.xml"))))
        {
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validContactsFromJson() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();
            List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
            }.getType());
            return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


    @Test (dataProvider = "validContactsFromJson")//(enabled = false)
    public void testCreationContact(ContactData contact) {
        Groups groups = app.db().groups();
        File photo = new File("src/test/resources/smile.jpg");
        //ContactData newContact = new ContactData().withFirstname("test_name")
        // .withLastname("test_surname").withPhoto(photo)
        // .inGroup(groups.iterator().next());
        Contacts before = app.db().contacts();
        app.goTo().homePage();
//        int i;
//        for (i = 0; i< 5; i = i +1) {
        app.contact().createContact(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after,equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
//        }
    }

    @Test(enabled = false)
    public void testBadCreationContact() {

        app.goTo().homePage();
        Contacts before = app.db().contacts();
        ContactData contact = new ContactData()
                .withFirstname("TestName10'").withCreation(true);
        app.contact().createContact(contact);
        app.goTo().homePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.db().contacts();
        assertThat(after,equalTo(before));
        verifyContactListInUI();
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File ("src/test/resources/smile.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
        verifyContactListInUI();
    }


}
