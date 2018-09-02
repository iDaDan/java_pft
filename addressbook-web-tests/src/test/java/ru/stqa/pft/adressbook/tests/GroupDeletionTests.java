package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        app.group().isGroupPresented();
    }
    
    @Test
    public void testGroupDeletion() {

        Set<GroupData> before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        app.group().returnToGroupPage();
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size()- 1);

        before.remove(deletedGroup);
        Assert.assertEquals(before, after);

    }

}
