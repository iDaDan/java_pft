package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {


    
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().isGroupPresented();
        List<GroupData> before = app.getGroupHelper().getGrouplist();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGrouplist();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);
    }


}
