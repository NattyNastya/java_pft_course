package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Groups before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Assert.assertEquals(app.group().count(), before.size() - 1);
    Groups after = app.group().all();

    assertThat(after, equalTo(before.without(deletedGroup)));

  }

}
