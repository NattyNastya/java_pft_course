package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Z51-70 on 03.01.2017.
 */
public class ApplicationManager {
  FirefoxDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  protected void init() {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    login("admin", "secret");
  }

  private void login(String username, String password) {
    wd.findElement(By.name("user")).click();
    wd.findElement(By.name("user")).clear();
    wd.findElement(By.name("user")).sendKeys(username);
    wd.findElement(By.name("pass")).click();
    wd.findElement(By.name("pass")).clear();
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
  }

  protected void returnToGroupPage() {
    wd.findElement(By.linkText("group page")).click();
  }

  protected void submitCroupCreation() {
    wd.findElement(By.name("submit")).click();
  }

  protected void fillGroupForm(GroupData groupData) {
    wd.findElement(By.name("group_name")).click();
    wd.findElement(By.name("group_name")).clear();
    wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
    wd.findElement(By.name("group_header")).click();
    wd.findElement(By.name("group_header")).clear();
    wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
    wd.findElement(By.name("group_footer")).click();
    wd.findElement(By.name("group_footer")).clear();
    wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
  }

  protected void initGroupCreation() {
    wd.findElement(By.name("new")).click();
  }

  protected void gotoGroupPage() {
    wd.findElement(By.linkText("groups")).click();
  }

  protected void stop() {
    wd.quit();
  }

  protected void deleteSelectedGroups() {
    wd.findElement(By.name("delete")).click();
  }

  protected void selectGroup() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      wd.findElement(By.name("selected[]")).click();
    }
  }

  // Fill in New Contact form
  protected void fillContactMainInfo(ContactMainData contactMainData) {
    wd.findElement(By.name("firstname")).click();
    wd.findElement(By.name("firstname")).clear();
    wd.findElement(By.name("firstname")).sendKeys(contactMainData.getFirst_name());

    wd.findElement(By.name("middlename")).click();
    wd.findElement(By.name("middlename")).clear();
    wd.findElement(By.name("middlename")).sendKeys(contactMainData.getMiddle_name());

    wd.findElement(By.name("lastname")).click();
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactMainData.getLast_name());

    wd.findElement(By.name("nickname")).click();
    wd.findElement(By.name("nickname")).clear();
    wd.findElement(By.name("nickname")).sendKeys(contactMainData.getNickname());

    //Here will be photo selection

    wd.findElement(By.name("title")).click();
    wd.findElement(By.name("title")).clear();
    wd.findElement(By.name("title")).sendKeys(contactMainData.getTitle());

    wd.findElement(By.name("company")).click();
    wd.findElement(By.name("company")).clear();
    wd.findElement(By.name("company")).sendKeys(contactMainData.getContact_company());

    wd.findElement(By.name("address")).click();
    wd.findElement(By.name("address")).clear();
    wd.findElement(By.name("address")).sendKeys(contactMainData.getGeneral_address());
  }

  protected void fillContactPhones(ContactPhonesData contactPhonesData) {
    wd.findElement(By.name("home")).click();
    wd.findElement(By.name("home")).clear();
    wd.findElement(By.name("home")).sendKeys(contactPhonesData.getHome_phone());

    wd.findElement(By.name("mobile")).click();
    wd.findElement(By.name("mobile")).clear();
    wd.findElement(By.name("mobile")).sendKeys(contactPhonesData.getMobile_phone());

    wd.findElement(By.name("work")).click();
    wd.findElement(By.name("work")).clear();
    wd.findElement(By.name("work")).sendKeys(contactPhonesData.getWork_phone());

    wd.findElement(By.name("fax")).click();
    wd.findElement(By.name("fax")).clear();
    wd.findElement(By.name("fax")).sendKeys(contactPhonesData.getFax());
  }

  protected void fillContactAdditionalInfo(ContactAdditionalData contactAdditionalData) {
    wd.findElement(By.name("email")).click();
    wd.findElement(By.name("email")).clear();
    wd.findElement(By.name("email")).sendKeys(contactAdditionalData.getEmail());

    wd.findElement(By.name("email2")).click();
    wd.findElement(By.name("email2")).clear();
    wd.findElement(By.name("email2")).sendKeys(contactAdditionalData.getEmail_2());

    wd.findElement(By.name("email3")).click();
    wd.findElement(By.name("email3")).clear();
    wd.findElement(By.name("email3")).sendKeys(contactAdditionalData.getEmail_3());

    wd.findElement(By.name("homepage")).click();
    wd.findElement(By.name("homepage")).clear();
    wd.findElement(By.name("homepage")).sendKeys(contactAdditionalData.getHomepage_link());

  //fillContactBirthday
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[21]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[1]//option[21]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[2]//option[4]")).click();
    }
    wd.findElement(By.name("byear")).click();
    wd.findElement(By.name("byear")).clear();
    wd.findElement(By.name("byear")).sendKeys(contactAdditionalData.getBirthYear());

    //Anniversary
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[32]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[3]//option[32]")).click();
    }
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[8]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[4]//option[8]")).click();
    }
    wd.findElement(By.name("ayear")).click();
    wd.findElement(By.name("ayear")).clear();
    wd.findElement(By.name("ayear")).sendKeys(contactAdditionalData.getAnniverYear());
  }

  protected void selectContactGroup() {
    if (!wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).isSelected()) {
      wd.findElement(By.xpath("//div[@id='content']/form/select[5]//option[2]")).click();
    }
  }

  protected void fillContactSecondaryInfo(ContactSecondaryData contactSecondaryData) {
    wd.findElement(By.name("address2")).click();
    wd.findElement(By.name("address2")).clear();
    wd.findElement(By.name("address2")).sendKeys(contactSecondaryData.getAddress_2());

    wd.findElement(By.name("phone2")).click();
    wd.findElement(By.name("phone2")).clear();
    wd.findElement(By.name("phone2")).sendKeys(contactSecondaryData.getPhone_2());

    wd.findElement(By.name("notes")).click();
    wd.findElement(By.name("notes")).clear();
    wd.findElement(By.name("notes")).sendKeys(contactSecondaryData.getNotes());
  }

  protected void returnToContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  protected void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  protected void gotoContactCreationForm() {
    wd.findElement(By.linkText("add new")).click();
  }
}
