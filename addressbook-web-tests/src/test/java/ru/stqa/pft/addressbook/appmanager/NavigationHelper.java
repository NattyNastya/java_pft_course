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
    if (isElementPresented(By.xpath("//h1"))
            && wd.findElement(By.xpath("//h1")).getText().equals("Groups")
            && isElementPresented(By.name("new"))) {
     return;
    }
    click(By.linkText("groups"));
  }

  public void gotoContactCreationForm() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void gotoHomePage() {
    wd.findElement(By.linkText("home")).click();
  }

  public void gotoContactEditPage() {
    wd.findElement(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]")).click();
  }
}
