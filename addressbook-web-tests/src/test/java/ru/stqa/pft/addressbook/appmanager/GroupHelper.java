package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.GroupData;

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

  public void initGroupModification() {
    click(name("edit"));
  }

  public void submitGroupModification() {
    click(name("update"));
  }

  public void createGroup(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresented(By.name("selected[]"));
  }

  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
