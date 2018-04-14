package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupModificationTests  extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().isGroupPresented();
        List<GroupData> before = app.getGroupHelper().getGrouplist();
        app.getGroupHelper().selectGroup(before.size()- 1);
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData("test1", "test2", "test3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGrouplist();
        Assert.assertEquals(before.size(), after.size());

        before.remove(before.size() - 1);
        before.add()
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
