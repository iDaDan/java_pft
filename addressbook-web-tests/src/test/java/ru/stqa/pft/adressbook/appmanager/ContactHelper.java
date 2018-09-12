package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
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
        contactCache = null;
    }

    public void modifyContact(int index, ContactData contact) {
        selectContact(index);
        initContactModification(index);
        fillContactForm(contact);
        submitContactModification();
        contactCache = null;
    }

    public  void isPresented() {
        if (! isThereAContact()) {
        createContact(new ContactData().withNickname("TestName").withMiddlename("TestMiddlename")
                .withLastname("TestLastName").withNickname("Test").withHomePhone("9097778881")
                .withEmail("dadada@lol.net").withGroup("test4").withCreation(true));
        }
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null){
            return contactCache;
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String allPhones = cells.get(5).getText();
            contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
                    .withAllPhones(allPhones));
        }

        return new Contacts(contactCache);
    }

    public void delete(ContactData deletedContact) {
        selectContactById(deletedContact.getId());
        initContactDeletion();
        acceptContactDeletion();
        contactCache = null;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

    //    wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a",id))).click();
    //    wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a",id))).click();
    //    wd.findElement(By.xpath(String.format("a[href='edit.php?id=%s']",id))).click();
    }
}
