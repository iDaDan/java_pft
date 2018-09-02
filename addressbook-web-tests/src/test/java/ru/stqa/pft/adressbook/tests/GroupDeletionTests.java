package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        app.group().isGroupPresented();
    }
    
    @Test
    public void testGroupDeletion() {
        app.goTo().groupPage();
        app.group().isGroupPresented();
        List<GroupData> before = app.group().list();
        int index = before.size()- 1;
        app.group().delete(index);
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().list();
        Assert.assertEquals(after.size(), index);

        before.remove(index);
        Assert.assertEquals(before, after);

    }

}
