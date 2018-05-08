package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupDeletionTests extends TestBase {


    
    @Test
    public void testGroupDeletion() {
        app.getNavigationHelper().goToGroupPage();
        app.getGroupHelper().isGroupPresented();
        List<GroupData> before = app.getGroupHelper().getGroupList(); // в этой строчке короч надо придумать, как сократить путь до .getName,
        // потому что он используется в каждом аргументе new GroupData;
        GroupData preIndicator = new GroupData(before.get(before.size()- 1).getId(),before.get(before.size()- 1));
        GroupData group = new GroupData(before.get(before.size()- 1).getId(),before.get(before.size()- 1).getName(), "test2", "test3");
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(before.size() - 1);
        Assert.assertEquals(before, after);

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.remove(group);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }


}
