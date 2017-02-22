package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //  int before = app.getGroupHelper().getGroupCount();
    GroupData group = new GroupData("TEST3", "TEST3", "TEST3");
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //  int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(after.size(), before.size() + 1);

    //Look for MAX id value in the `after` collection
    /*int max = 0;
    for (GroupData g : after) {
      int id = g.getId();
      if (id > max) {
        max = id;
      }
    }*/

    /* Look for max ID(it is new created group), or if we need sorting we can next: (in GroupData class) this.id = Integer.MAX_VALUE (instead of 0) */
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(group);

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

    //Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
