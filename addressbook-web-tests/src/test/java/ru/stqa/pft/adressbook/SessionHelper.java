package ru.stqa.pft.adressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(FirefoxDriver wd) {

        super(wd);
    }
    public void login(String login, String pass) {
        type(By.name("user"), login);
        type(By.name("pass"), pass);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(pass);
        click(By.xpath("//form[@id='LoginForm']/input[3]"));
    }
}
