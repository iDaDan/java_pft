package ru.stqa.pft.adressbook.tests;

import org.hamcrest.CoreMatchers;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests  extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0){
            app.goTo().groupPage();
            app.group().isGroupPresented();
        }
    }

    @Test
    public void testGroupModification() {
        Groups before = app.db().groups();
        GroupData modifiedGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("test4")
                .withFooter("test3").withHeader("test2");
        app.goTo().groupPage();
        app.group().modifyGroup(group);
        assertEquals(before.size(), app.group().count());
        Groups after = app.db().groups();
        assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }




}
