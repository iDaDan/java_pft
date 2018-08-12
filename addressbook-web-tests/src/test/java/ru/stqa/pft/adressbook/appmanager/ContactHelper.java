package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase{


    public ContactHelper(WebDriver wd) {
        super(wd);
    }


    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
         type(By.name("firstname"), contactData.getFirstname());
         type(By.name("middlename"), contactData.getMiddlename());
         type(By.name("lastname"),contactData.getLastname());
         type(By.name("nickname"),contactData.getNickname());
         type(By.name("home"), contactData.getHomePhone());
         type(By.name("email"), contactData.getEmail());

         if (contactData.isCreation()) {
             new Select (wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
         } else {
             Assert.assertFalse(isElementPresent(By.name("new_group")));
         }
    }

    public void initNewConact() {
         click(By.linkText("add new"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

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

    public boolean isThereAContact() { return isElementPresent(By.name("selected[]")); }

    public void createContact(ContactData contact) {
        initNewConact();
        fillContactForm(contact);
        submitContactCreation();
    }

    public  void isContactPresented() {
        if (! isThereAContact()) {
            createContact(new ContactData("TestName", "TestMiddlename","TestLastName",
                "Test", null,"9097778881", "dadada@lol.net", "test4", true));
        }
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            ContactData contact = new ContactData( firstName, null, lastName, null, null,
                    null,null,null, false);
            contacts.add(contact);

        }

        return contacts;
    }
}
