package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.assertEquals;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test2");
        app.group().createGroup(group);
        Set<GroupData> after = app.group().all();
        assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt());
        before.add(group);
        assertEquals(before, after);

    }

}