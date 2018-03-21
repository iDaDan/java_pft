package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {
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
    }

    public void initNewConact() {
         click(By.linkText("add new"));
    }

    public void selectContact() {
        click(By.id("1"));
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
}
