package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class NavigationHelper extends BaseHelper {
  //private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresented(By.xpath("//.//*[@id='content']/h1"))
            && wd.findElement(By.xpath("//.//*[@id='content']/h1")).getText().equals("Groups")
            && isElementPresented(By.name("new"))) {
     return;
    }
    click(By.linkText("groups"));
  }

  public void homePage() {
    if (isElementPresented(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void contactCreationForm() {
    if (isElementPresented(By.xpath(".//*[@id='content']/h1"))
            && wd.findElement(By.xpath(".//*[@id='content']/h1")).getText().equals("Edit / add address book entry")
            && isElementPresented(By.name("submit"))) {
      return;
    }
    click(By.linkText("add new"));
  }
}
