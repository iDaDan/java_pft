package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



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

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("[title=Edit]")).get(index).click();

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

    public void modifyContact(int index, ContactData contact) {
        selectContact(index);
        initContactModification(index);
        fillContactForm(contact);
        submitContactModification();
    }

    public  void isPresented() {
        if (! isThereAContact()) {
        createContact(new ContactData().withNickname("TestName").withMiddlename("TestMiddlename")
                .withLastname("TestLastName").withNickname("Test").withHomePhone("9097778881")
                .withEmail("dadada@lol.net").withGroup("test4").withCreation(true));
        }
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public Set<ContactData> all() {
        Set<ContactData> contacts = new HashSet<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastName = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstName = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            contacts.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName));
        }

        return contacts;
    }

    public void delete(int index) {
        selectContact(index);
        initContactDeletion();
        acceptContactDeletion();
    }

    public void delete(ContactData deletedContact) {
        selectContactById(deletedContact.getId());
        initContactDeletion();
        acceptContactDeletion();
    }

}
