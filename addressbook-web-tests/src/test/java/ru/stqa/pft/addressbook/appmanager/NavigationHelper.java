package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class NavigationHelper {
  private WebDriver wd;

  public NavigationHelper(WebDriver wd) {
    this.wd = wd;
  }

  public void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
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
