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
    ClickClearAndSendkeys(By.name("firstname"), contactMainData.getFirst_name());

    ClickClearAndSendkeys(By.name("middlename"), contactMainData.getMiddle_name());

    ClickClearAndSendkeys(By.name("lastname"), contactMainData.getLast_name());

    ClickClearAndSendkeys(By.name("nickname"), contactMainData.getNickname());

    //Here will be photo selection

    ClickClearAndSendkeys(By.name("title"), contactMainData.getTitle());

    ClickClearAndSendkeys(By.name("company"), contactMainData.getContact_company());

    ClickClearAndSendkeys(By.name("address"), contactMainData.getGeneral_address());
  }

  public void fillContactPhones(ContactPhonesData contactPhonesData) {
    ClickClearAndSendkeys(By.name("home"), contactPhonesData.getHome_phone());

    ClickClearAndSendkeys(By.name("mobile"), contactPhonesData.getMobile_phone());

    ClickClearAndSendkeys(By.name("work"), contactPhonesData.getWork_phone());

    ClickClearAndSendkeys(By.name("fax"), contactPhonesData.getFax());
  }

  public void fillContactAdditionalInfo(ContactAdditionalData contactAdditionalData) {
    ClickClearAndSendkeys(By.name("email"), contactAdditionalData.getEmail());

    ClickClearAndSendkeys(By.name("email2"), contactAdditionalData.getEmail_2());

    ClickClearAndSendkeys(By.name("email3"), contactAdditionalData.getEmail_3());

    ClickClearAndSendkeys(By.name("homepage"), contactAdditionalData.getHomepage_link());

    //fillContactBirthday
    dropdownMenuSelection("//div[@id='content']/form/select[1]//option[21]"); //select Birth Day
    //dropdwnMenuSelectDay("//div[@id='content']/form/select[1]/", "6");

    dropdownMenuSelection("//div[@id='content']/form/select[2]//option[4]"); //select Birth Month
    ClickClearAndSendkeys(By.name("byear"), contactAdditionalData.getBirthYear());

    //Anniversary
    dropdownMenuSelection("//div[@id='content']/form/select[3]//option[32]"); //select Anniversary Day
    dropdownMenuSelection("//div[@id='content']/form/select[4]//option[8]"); //select Anniversary Month
    ClickClearAndSendkeys(By.name("ayear"), contactAdditionalData.getAnniverYear());
  }

  public void selectContactGroup() {
    dropdownMenuSelection("//div[@id='content']/form/select[5]//option[2]");
  }

  public void fillContactSecondaryInfo(ContactSecondaryData contactSecondaryData) {
    ClickClearAndSendkeys(By.name("address2"), contactSecondaryData.getAddress_2());

    ClickClearAndSendkeys(By.name("phone2"), contactSecondaryData.getPhone_2());

    ClickClearAndSendkeys(By.name("notes"), contactSecondaryData.getNotes());
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
