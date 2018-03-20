package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.HelperBase;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper extends HelperBase{


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
         type(By.name("firstname"), contactData.getFirstname());
         type(By.name("middlename"), contactData.getMiddlename());
         type(By.name("lastname"),contactData.getLastname());
         type(By.name("nickname"),contactData.getNickname());
         click(By.name("theform"));
         click(By.name("theform"));
         click(By.xpath("//div[@id='content']//label[.='Telephone']"));
         click(By.name("theform"));
         type(By.name("home"), contactData.getHomePhone());
         type(By.name("email"), contactData.getEmail());
    }

    public void initNewConact() {
         click(By.linkText("add new"));
    }
}
