package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class GroupHelper extends BaseHelper {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(linkText("group page"));
  }

  public void submitGroupCreation() {
    click(name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    clickClearAndSendkeys(name("group_name"), groupData.getName());
    clickClearAndSendkeys(name("group_header"), groupData.getHeader());
    clickClearAndSendkeys(name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(name("new"));
  }

  public void deleteSelectedGroups() {
    click(name("delete"));
  }

  public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  private void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value = '" + id + "']")).click();
  }

  public void initGroupModification() {
    click(name("edit"));
  }

  public void submitGroupModification() {
    click(name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCach = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());//Group selection by index
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCach = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCach = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresented(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupCach = null;
  
  public Groups all() {
    if (groupCach != null) {
      return new Groups(groupCach);
    }
    groupCach = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCach.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCach);
  }
}
