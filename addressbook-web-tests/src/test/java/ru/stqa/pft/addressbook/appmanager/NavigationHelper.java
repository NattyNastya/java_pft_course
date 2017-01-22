package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class NavigationHelper extends BaseHelper {
  //private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    if (isElementPresented(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresented(By.name("new"))) {
     return;
    }
    click(By.linkText("groups"));
  }

  public void gotoContactCreationForm() {
    if (isElementPresented(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresented(By.name("submit"))) {
      return;
    }
    click(By.linkText("add new"));
  }

  public void gotoHomePage() {
    if (isElementPresented(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void gotoContactEditPage() {
    if (isElementPresented(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Edit / add address book entry")
            && isElementPresented(By.name("update"))) {
      return;
    }
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]"));
  }
}
