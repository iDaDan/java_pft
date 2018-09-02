package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ContactCreationTest extends TestBase{

    @Test(enabled = true)
    public void testCreationContact() {

            app.goTo().homePage();
            List<ContactData> before = app.contact().getList();
            ContactData contact = new ContactData((before.get(before.size() - 1).getId() + 1),"TestNameOFF", "TestMiddlename", "TestLastName",
                    "Test", null,"9097778881", "dadada@lol.net", "test4", true);
            app.contact().createContact(contact);
            app.goTo().homePage();
            List<ContactData> after = app.contact().getList();
            assertEquals(after.size(), before.size() + 1);

            contact.setId(after.stream().max((c1, c2) -> Integer.compare(c1.getId(), c2.getId())).get().getId());
            before.add(contact);
            Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(),c2.getId());
            before.sort(byId);
            after.sort(byId);
            assertEquals(before, after);

    }


}
