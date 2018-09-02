package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().homePage();
        app.contact().isPresented();

    }

    @Test(enabled = true)
    public void testContactDeletion() {
        List<ContactData> before = app.contact().getList();
        int index = before.size() - 1;
        app.contact().delete(index);
        app.goTo().homePage();
        List<ContactData> after = app.contact().getList();
        Assert.assertEquals(after.size(), before.size()-1);
        before.remove(before.size()-1);
        Assert.assertEquals(before, after);
    }


}
