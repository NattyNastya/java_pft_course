package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactAdditionalData;
import ru.stqa.pft.addressbook.model.ContactMainData;
import ru.stqa.pft.addressbook.model.ContactPhonesData;
import ru.stqa.pft.addressbook.model.ContactSecondaryData;

import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.name;
import static org.openqa.selenium.By.xpath;

/**
 * Created by Z51-70 on 05.01.2017.
 */
public class ContactHelper extends BaseHelper {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  // Fill in New Contact form
  public void fillContactMainInfo(ContactMainData contactMainData) {
    clickClearAndSendkeys(name("firstname"), contactMainData.getFirst_name());

    clickClearAndSendkeys(name("middlename"), contactMainData.getMiddle_name());

    clickClearAndSendkeys(name("lastname"), contactMainData.getLast_name());

    clickClearAndSendkeys(name("nickname"), contactMainData.getNickname());

    //Here will be photo selection

    clickClearAndSendkeys(name("title"), contactMainData.getTitle());

    clickClearAndSendkeys(name("company"), contactMainData.getContact_company());

    clickClearAndSendkeys(name("address"), contactMainData.getGeneral_address());
  }

  public void fillContactPhones(ContactPhonesData contactPhonesData) {
    clickClearAndSendkeys(name("home"), contactPhonesData.getHome_phone());

    clickClearAndSendkeys(name("mobile"), contactPhonesData.getMobile_phone());

    clickClearAndSendkeys(name("work"), contactPhonesData.getWork_phone());

    clickClearAndSendkeys(name("fax"), contactPhonesData.getFax());
  }

  public void fillContactAdditionalInfo(ContactAdditionalData contactAdditionalData, boolean creation) {
    clickClearAndSendkeys(name("email"), contactAdditionalData.getEmail());

    clickClearAndSendkeys(name("email2"), contactAdditionalData.getEmail_2());

    clickClearAndSendkeys(name("email3"), contactAdditionalData.getEmail_3());

    clickClearAndSendkeys(name("homepage"), contactAdditionalData.getHomepage_link());

    //fillContactBirthday
    dropdownMenuSelection(xpath("//form/select[1]"),"19"); //select Birth Day

    dropdownMenuSelection(xpath("//form/select[2]"),"March"); //select Birth Month
    clickClearAndSendkeys(name("byear"), contactAdditionalData.getBirthYear());

    //Anniversary
    dropdownMenuSelection(xpath("//form/select[3]"),"30"); //select Anniversary Day
    dropdownMenuSelection(xpath("//form/select[4]"),"July"); //select Anniversary Month
    clickClearAndSendkeys(name("ayear"), contactAdditionalData.getAnniverYear());

    //creation = true -> select group exist on the page, else - does not exist
    if (creation) {
      new Select(wd.findElement(name("new_group"))).selectByVisibleText(contactAdditionalData.getGroup());
    } else {
      Assert.assertFalse(isElementPresented(name("new_group"))); //check that element shouldn't exist
    }
  }

  /*public void selectContactGroup() {
    dropdownMenuSelection(xpath("//form/select[5]"),"5");
  }*/

  public void fillContactSecondaryInfo(ContactSecondaryData contactSecondaryData) {
    clickClearAndSendkeys(name("address2"), contactSecondaryData.getAddress_2());

    clickClearAndSendkeys(name("phone2"), contactSecondaryData.getPhone_2());

    clickClearAndSendkeys(name("notes"), contactSecondaryData.getNotes());
  }

  public void returnToContactPage() {
    findElement(linkText("add new")).click();
  }

  public void submitContactCreation() {
    findElement(xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void submitContactModification() {
    wd.findElement(xpath("//div[@id='content']/form[1]/input[22]")).click();
  }

  public void submitContactDeletion() {
    findElement(xpath("//div[@id='content']/form[2]/input[2]")).click();
  }
}
