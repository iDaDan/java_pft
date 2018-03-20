package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactHelper {
    private FirefoxDriver wd;


    public ContactHelper(FirefoxDriver wd) {
        this.wd = wd;
    }


    public void gotoHomePage() {
        wd.findElement(By.linkText("home")).click();
    }

    public void submitContactCreation() {
        wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
         wd.findElement(By.name("firstname")).click();
         wd.findElement(By.name("firstname")).clear();
         wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
         wd.findElement(By.name("middlename")).click();
         wd.findElement(By.name("middlename")).clear();
         wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
         wd.findElement(By.name("lastname")).click();
         wd.findElement(By.name("lastname")).clear();
         wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
         wd.findElement(By.name("nickname")).click();
         wd.findElement(By.name("nickname")).clear();
         wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
         wd.findElement(By.name("theform")).click();
         wd.findElement(By.name("theform")).click();
         wd.findElement(By.xpath("//div[@id='content']//label[.='Telephone']")).click();
         wd.findElement(By.name("theform")).click();
         wd.findElement(By.name("home")).click();
         wd.findElement(By.name("home")).clear();
         wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
         wd.findElement(By.name("email")).click();
         wd.findElement(By.name("email")).clear();
         wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initNewConact() {
         wd.findElement(By.linkText("add new")).click();
    }
}
