package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    clickClearAndSendkeys(By.name("firstname"), contactMainData.getFirst_name());

    clickClearAndSendkeys(By.name("middlename"), contactMainData.getMiddle_name());

    clickClearAndSendkeys(By.name("lastname"), contactMainData.getLast_name());

    clickClearAndSendkeys(By.name("nickname"), contactMainData.getNickname());

    //Here will be photo selection

    clickClearAndSendkeys(By.name("title"), contactMainData.getTitle());

    clickClearAndSendkeys(By.name("company"), contactMainData.getContact_company());

    clickClearAndSendkeys(By.name("address"), contactMainData.getGeneral_address());
  }

  public void fillContactPhones(ContactPhonesData contactPhonesData) {
    clickClearAndSendkeys(By.name("home"), contactPhonesData.getHome_phone());

    clickClearAndSendkeys(By.name("mobile"), contactPhonesData.getMobile_phone());

    clickClearAndSendkeys(By.name("work"), contactPhonesData.getWork_phone());

    clickClearAndSendkeys(By.name("fax"), contactPhonesData.getFax());
  }

  public void fillContactAdditionalInfo(ContactAdditionalData contactAdditionalData) {
    clickClearAndSendkeys(By.name("email"), contactAdditionalData.getEmail());

    clickClearAndSendkeys(By.name("email2"), contactAdditionalData.getEmail_2());

    clickClearAndSendkeys(By.name("email3"), contactAdditionalData.getEmail_3());

    clickClearAndSendkeys(By.name("homepage"), contactAdditionalData.getHomepage_link());

    //fillContactBirthday
    dropdownMenuSelection("//div[@id='content']/form/select[1]//option[21]"); //select Birth Day
    //dropdwnMenuSelectDay("//div[@id='content']/form/select[1]/", "6");

    dropdownMenuSelection("//div[@id='content']/form/select[2]//option[4]"); //select Birth Month
    clickClearAndSendkeys(By.name("byear"), contactAdditionalData.getBirthYear());

    //Anniversary
    dropdownMenuSelection("//div[@id='content']/form/select[3]//option[32]"); //select Anniversary Day
    dropdownMenuSelection("//div[@id='content']/form/select[4]//option[8]"); //select Anniversary Month
    clickClearAndSendkeys(By.name("ayear"), contactAdditionalData.getAnniverYear());
  }

  public void selectContactGroup() {
    dropdownMenuSelection("//div[@id='content']/form/select[5]//option[2]");
  }

  public void fillContactSecondaryInfo(ContactSecondaryData contactSecondaryData) {
    clickClearAndSendkeys(By.name("address2"), contactSecondaryData.getAddress_2());

    clickClearAndSendkeys(By.name("phone2"), contactSecondaryData.getPhone_2());

    clickClearAndSendkeys(By.name("notes"), contactSecondaryData.getNotes());
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
