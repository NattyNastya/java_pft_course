package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    //check and do preconditions
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("TEST3", "TEST3", "TEST3"));
    }
  }

  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.group().list();
    // int before = app.group().count();
    int index = before.size() - 1;//last element in the 'before' list
    app.group().delete(index);
    List<GroupData> after = app.group().list();
    // int after = app.group().count();
    Assert.assertEquals(after.size(), before.size() - 1);

    //as we are deleting last entry, so before comparing we need to delete last entry from 'before' collection
    before.remove(index);
    Assert.assertEquals(before, after);

  }

}
