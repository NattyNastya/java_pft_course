package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Z51-70 on 08.01.2017.
 */
public class BaseHelper {
  protected WebDriver wd;

  public BaseHelper(WebDriver wd) {
    this.wd = wd;
  }

  public WebElement findElement(By by) {
    return wd.findElement(by);
  }


  /*public boolean isElementPresented (By locator) {
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    List<WebElement> list = wd.findElements(locator);
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    if (list.size() == 0) {
      return false;
    } else {
      return list.get(0).isDisplayed();
    }
  }*/

   // It is method from lesson (do not work with my code О_о)
  public boolean isElementPresented (By locator) {
    wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    List<WebElement> list = wd.findElements(locator);
    wd.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException ex) {
      return false;
    }
  }

  protected void click (By locator) {
    if (isElementPresented(locator)) {
      findElement(locator).click();
    }
  }

  public void clickClearAndSendkeys(By locator, String send_keys) {
    //findElement(locator).click();

    if(send_keys != null) {
      String existingTest = wd.findElement(locator).getAttribute("value");
      if (existingTest.isEmpty()) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(send_keys);
      } else if (!send_keys.equals(existingTest)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(send_keys);
      }
    }
  }

  public void attach(By locator, File file) {

    if(file != null) {
        wd.findElement(locator).sendKeys(file.getAbsolutePath());
      }
    }

  public void dropdownMenuSelection (By locator, String text) {
    Select select = new Select(findElement(locator));
    if (findElement(locator).isSelected()) {
      findElement(locator).click();
      findElement(locator).clear();
    }
    select.selectByVisibleText(text);
  }


}
