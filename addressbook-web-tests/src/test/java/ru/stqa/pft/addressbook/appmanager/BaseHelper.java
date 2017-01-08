package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Z51-70 on 08.01.2017.
 */
public class BaseHelper {
  protected FirefoxDriver wd;

  public BaseHelper(FirefoxDriver wd) {
    this.wd = wd;
  }

  public void ClickClearAndSendkeys(String locator, String send_keys) {
    wd.findElement(By.name(locator)).click();
    wd.findElement(By.name(locator)).clear();
    wd.findElement(By.name(locator)).sendKeys(send_keys);
  }

  public void dropdownMenuSelection(String xpathExpression) {
    if (!wd.findElement(By.xpath(xpathExpression)).isSelected()) {
      wd.findElement(By.xpath(xpathExpression)).click();
    }
  }
}
