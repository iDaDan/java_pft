package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.*;

public class GroupModificationTests  extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        app.group().isGroupPresented();
    }

    @Test
    public void testGroupModification() {
        Groups before = app.group().all();
        GroupData modifyedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifyedGroup.getId()).withName("test4")
                .withFooter("test3").withHeader("test2");
        app.group().modifyGroup(group);
        Groups after = app.group().all();
        Assert.assertEquals(before.size(), after.size());

        before.remove(modifyedGroup);
        before.add(group);
        Assert.assertEquals(before,after);
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifyedGroup).withAdded(group)));
    }


}
