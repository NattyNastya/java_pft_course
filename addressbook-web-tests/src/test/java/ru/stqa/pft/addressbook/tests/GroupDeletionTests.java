package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupPage();
    //check and do preconditions
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("TEST3", "TEST3", "TEST3"));
    }
  }

  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.getGroupHelper().getGroupList();
    // int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before.size() - 1);//Group selection by index (now it is the last element)
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    // int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() - 1);

    //as we are deleting last entry, so before comparing we need to delete last entry from 'before' collection
    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }

}
