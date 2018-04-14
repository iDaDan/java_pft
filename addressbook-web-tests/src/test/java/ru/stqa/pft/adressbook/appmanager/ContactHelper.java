package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
         type(By.name("firstname"), contactData.getFirstname());
         type(By.name("middlename"), contactData.getMiddlename());
         type(By.name("lastname"),contactData.getLastname());
         type(By.name("nickname"),contactData.getNickname());
         type(By.name("home"), contactData.getHomePhone());
         type(By.name("email"), contactData.getEmail());

         if (creation) {
             new Select (wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
         } else {
             Assert.assertFalse(isElementPresent(By.name("new_group")));
         }
    }

    public void initNewConact() {
         click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void initContactDeletion() {
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
    }

    public void acceptContactDeletion() {
        wd.switchTo().alert().accept();
    }

    public void isThereAContact() { isElementPresent(By.id("5")); }

    public void createContact() {
        initNewConact();
        fillContactForm(new ContactData("TestName", "TestMiddlename","TestLastName",
                "Test", "9097778881", "dadada@lol.net", "test1"), true);
        submitContactCreation();
    }

    /*public  void isContactPresented() {
        if (! isThereAContact()) {
            createContact(ContactData contact);
        }
    }*/

}
