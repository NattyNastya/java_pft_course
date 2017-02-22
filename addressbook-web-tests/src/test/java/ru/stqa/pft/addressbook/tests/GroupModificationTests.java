package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Z51-70 on 09.01.2017.
 */
public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("TEST1 - the first added group", "TEST3", "TEST3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();
    // int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().selectGroup(before.size() - 1);//Group selection by index (now it is the last element)
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size() - 1).getId(), "Anesthesiologist", "test header (Logo)", "test footer (comment)");
    //Where before.get(before.size() - 1).getId() — ID which was before the modification

    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList();
    // int after = app.getGroupHelper().getGroupCount();
    Assert.assertEquals(before.size(), after.size());

    before.remove(before.size() - 1);//remove last element to predict the expected result and add to this place modified group
    before.add(group);//replaced last group with modified data

    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    //now no reason to convert List to Set, because List had sorted (see above)
    Assert.assertEquals(after, before);

    /*//Convert List to Set
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));*/
  }
}
