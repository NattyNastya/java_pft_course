package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

  protected void click (By locator) {
    findElement(locator).click();
  }
  /*protected void click(By locator) {
    wd.findElement(locator).click();
  }*/


  public void clickClearAndSendkeys(By locator, String send_keys) {
    wd.findElement(locator).click();

    if(send_keys != null) {
      String existingTest = wd.findElement(locator).getAttribute("value");
      if(! send_keys.equals(existingTest)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(send_keys);
      }
    }
  }

  public void dropdownMenuSelection(String xpathExpression) {
    if (!wd.findElement(By.xpath(xpathExpression)).isSelected()) {
      wd.findElement(By.xpath(xpathExpression)).click();
    }
  }

  /*public dropdownMenuSelectDay(String xpathExpression, String selectValue) {
    Select selector = new Select(wd.findElement(By.xpath(xpathExpression))).selectByValue(selectValue);
  }*/

}
