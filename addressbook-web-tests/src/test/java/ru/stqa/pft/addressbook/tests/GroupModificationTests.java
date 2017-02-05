package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

/**
 * Created by Z51-70 on 09.01.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("TEST1", "TEST3", "TEST3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    // int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before.size() - 1);//Group selection by index (now it is the last element)
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("The Surgeons", "test header (Logo)", "test footer (comment)"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    // int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before.size(), after.size());
  }
}
