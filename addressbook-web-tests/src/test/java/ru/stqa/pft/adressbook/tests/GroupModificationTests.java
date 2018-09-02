package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.*;

public class GroupModificationTests  extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        app.group().isGroupPresented();
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
        GroupData modifyedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifyedGroup.getId()).withName("test4")
                .withFooter("test3").withHeader("test2");
        app.group().modifyGroup(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifyedGroup);
        before.add(group);
        Assert.assertEquals(before,after);
    }


}
