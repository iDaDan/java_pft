package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(WebDriver wd) {

        super(wd);
    }
    public void login(String login, String pass) {
        type(By.name("user"), login);
        type(By.name("pass"), pass);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
