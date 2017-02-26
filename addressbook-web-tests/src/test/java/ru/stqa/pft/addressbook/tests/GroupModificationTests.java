package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * Created by Z51-70 on 09.01.2017.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("TEST1 - the first added group").withHeader("TEST3").withFooter("TEST3"));
    }
  }

  @Test
  public void testGroupModification() {
    Set<GroupData> before = app.group().all();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("TEST3").withHeader("test header (Logo)").withFooter("test footer (comment)");

    app.group().modify(group);
    Set<GroupData> after = app.group().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedGroup);//removes element to predict the expected result and add to this place modified group
    before.add(group);//replaced group with modified data
    Assert.assertEquals(after, before);
  }
}
