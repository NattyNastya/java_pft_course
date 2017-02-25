package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Z51-70 on 09.01.2017.
 */
public class GroupModificationTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("TEST1 - the first added group", "TEST3", "TEST3"));
    }
  }

  @Test
  public void testGroupModification() {
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;// it's group's index which we are going to modify
    GroupData group = new GroupData(before.get(index).getId(), "Anesthesiologist", "test header (Logo)", "test footer (comment)");
    //Where before.get(index).getId() — ID which was before the modification
    // int before = app.group().count();

    app.group().modify(index, group);
    List<GroupData> after = app.group().list();
    // int after = app.group().count();
    Assert.assertEquals(before.size(), after.size());

    before.remove(index);//removes last element to predict the expected result and add to this place modified group
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
