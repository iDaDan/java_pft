package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper extends HelperBase{
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void goToGroupPage() {
        click(By.linkText("groups"));
        //System.out.println("1");
    }

    public void gotoHomePage() {
        click(By.linkText("home"));
    }
}
