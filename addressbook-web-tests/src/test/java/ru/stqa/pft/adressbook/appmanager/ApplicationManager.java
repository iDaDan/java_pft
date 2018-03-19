package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    FirefoxDriver wd;

    private final NavigationHelper navigationHelper = new NavigationHelper();
    private GroupHelper groupHelper;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        navigationHelper.wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        navigationHelper.wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        navigationHelper.wd.get("http://localhost/addressbook/index.php");
        groupHelper = new GroupHelper(navigationHelper.wd);
        navigationHelper = new NavigationHelper(wd);
        login("admin", "secret");
    }

    public void login(String login, String pass) {
        navigationHelper.wd.findElement(By.name("user")).click();
        navigationHelper.wd.findElement(By.name("user")).click();
        navigationHelper.wd.findElement(By.name("user")).clear();
        navigationHelper.wd.findElement(By.name("user")).sendKeys(login);
        navigationHelper.wd.findElement(By.name("pass")).click();
        navigationHelper.wd.findElement(By.name("pass")).clear();
        navigationHelper.wd.findElement(By.name("pass")).sendKeys(pass);
        navigationHelper.wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public void stop() {
        navigationHelper.wd.quit();
    }

    public void gotoHomePage() {
        navigationHelper.wd.findElement(By.linkText("home")).click();
    }

    public void submitContactCreation() {
        navigationHelper.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }

    public void fillContactForm(ContactData contactData) {
        navigationHelper.wd.findElement(By.name("firstname")).click();
        navigationHelper.wd.findElement(By.name("firstname")).clear();
        navigationHelper.wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
        navigationHelper.wd.findElement(By.name("middlename")).click();
        navigationHelper.wd.findElement(By.name("middlename")).clear();
        navigationHelper.wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
        navigationHelper.wd.findElement(By.name("lastname")).click();
        navigationHelper.wd.findElement(By.name("lastname")).clear();
        navigationHelper.wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
        navigationHelper.wd.findElement(By.name("nickname")).click();
        navigationHelper.wd.findElement(By.name("nickname")).clear();
        navigationHelper.wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
        navigationHelper.wd.findElement(By.name("theform")).click();
        navigationHelper.wd.findElement(By.name("theform")).click();
        navigationHelper.wd.findElement(By.xpath("//div[@id='content']//label[.='Telephone']")).click();
        navigationHelper.wd.findElement(By.name("theform")).click();
        navigationHelper.wd.findElement(By.name("home")).click();
        navigationHelper.wd.findElement(By.name("home")).clear();
        navigationHelper.wd.findElement(By.name("home")).sendKeys(contactData.getHomePhone());
        navigationHelper.wd.findElement(By.name("email")).click();
        navigationHelper.wd.findElement(By.name("email")).clear();
        navigationHelper.wd.findElement(By.name("email")).sendKeys(contactData.getEmail());
    }

    public void initNewConact() {
        navigationHelper.wd.findElement(By.linkText("add new")).click();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
