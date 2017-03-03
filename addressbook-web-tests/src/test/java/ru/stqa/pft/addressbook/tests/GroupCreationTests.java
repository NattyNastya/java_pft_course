package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupPage();
    Groups before = app.group().all();
    //int before = app.group().count();
    GroupData group = new GroupData().withName("TEST3").withHeader("TEST3").withFooter("TEST3");
    app.group().create(group);
    Groups after = app.group().all();
    //  int after = app.group().count();
    assertThat(after.size(), equalTo(before.size() + 1));

    // `withId` implement object's copy
    assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

}
