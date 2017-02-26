package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //check and do preconditions
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("TEST3").withHeader("TEST3").withFooter("TEST3"));
    }
  }

  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all();
    // int after = app.group().count();
    Assert.assertEquals(after.size(), before.size() - 1);

    //as we are deleting last entry, so before comparing we need to delete last entry from 'before' collection
    before.remove(deletedGroup);
    Assert.assertEquals(before, after);

  }

}
