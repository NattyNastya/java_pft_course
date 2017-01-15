package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  // Fill in New Contact form
  public void fillContactMainInfo(ContactMainData contactMainData) {
    ClickClearAndSendkeys("firstname", contactMainData.getFirst_name());

    ClickClearAndSendkeys("middlename", contactMainData.getMiddle_name());

    ClickClearAndSendkeys("lastname", contactMainData.getLast_name());

    ClickClearAndSendkeys("nickname", contactMainData.getNickname());

    //Here will be photo selection

    ClickClearAndSendkeys("title", contactMainData.getTitle());

    ClickClearAndSendkeys("company", contactMainData.getContact_company());

    ClickClearAndSendkeys("address", contactMainData.getGeneral_address());
  }

  public void fillContactPhones(ContactPhonesData contactPhonesData) {
    ClickClearAndSendkeys("home", contactPhonesData.getHome_phone());

    ClickClearAndSendkeys("mobile", contactPhonesData.getMobile_phone());

    ClickClearAndSendkeys("work", contactPhonesData.getWork_phone());

    ClickClearAndSendkeys("fax", contactPhonesData.getFax());
  }

  public void fillContactAdditionalInfo(ContactAdditionalData contactAdditionalData) {
    ClickClearAndSendkeys("email", contactAdditionalData.getEmail());

    ClickClearAndSendkeys("email2", contactAdditionalData.getEmail_2());

    ClickClearAndSendkeys("email3", contactAdditionalData.getEmail_3());

    ClickClearAndSendkeys("homepage", contactAdditionalData.getHomepage_link());

    //fillContactBirthday
    dropdownMenuSelection("//div[@id='content']/form/select[1]//option[21]"); //select Birth Day
    dropdownMenuSelection("//div[@id='content']/form/select[2]//option[4]"); //select Birth Month
    ClickClearAndSendkeys("byear", contactAdditionalData.getBirthYear());

    //Anniversary
    dropdownMenuSelection("//div[@id='content']/form/select[3]//option[32]"); //select Anniversary Day
    dropdownMenuSelection("//div[@id='content']/form/select[4]//option[8]"); //select Anniversary Month
    ClickClearAndSendkeys("ayear", contactAdditionalData.getAnniverYear());
  }

  public void selectContactGroup() {
    dropdownMenuSelection("//div[@id='content']/form/select[5]//option[2]");
  }

  public void fillContactSecondaryInfo(ContactSecondaryData contactSecondaryData) {
    ClickClearAndSendkeys("address2", contactSecondaryData.getAddress_2());

    ClickClearAndSendkeys("phone2", contactSecondaryData.getPhone_2());

    ClickClearAndSendkeys("notes", contactSecondaryData.getNotes());
  }

  public void returnToContactPage() {
    wd.findElement(By.linkText("add new")).click();
  }

  public void submitContactCreation() {
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void submitContactModification() {
    wd.findElement(By.xpath("//div[@id='content']/form[1]/input[22]")).click();
  }

  public void submitContactDeletion() {
    wd.findElement(By.xpath("//div[@id='content']/form[2]/input[2]")).click();
  }
}
