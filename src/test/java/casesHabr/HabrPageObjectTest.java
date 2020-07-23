package casesHabr;

import io.qameta.allure.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pagesHabr.MainPage;

public class HabrPageObjectTest extends HabrBaseTest{

    @Epic("test for habr web page")
    @Feature(value="main page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the opening of the main page habr.com/ru")
    @Test
    public void habrTest1() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();

        WebElement logo = driver.findElement(By.xpath("//a[@class='logo']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Epic("test for habr web page")
    @Feature(value="language popup")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the opening of the language selection popup")
    @Test
    public void habrTest2() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .openLangPopup();

        WebElement langPopup = driver.findElement(By.xpath("//*[@id=\"js-lang_settings\"]/div[@class=\"popup\"]"));
        Assert.assertTrue(langPopup.isDisplayed());
    }

    @Epic("test for habr web page")
    @Feature(value="auth page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the opening of the authorization page")
    @Test
    public void habrTest3() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .auth();

        WebElement enterButton = driver.findElement(By.xpath("//button[@name = 'go']"));
        Assert.assertTrue(enterButton.isDisplayed());
    }

    @Epic("test for habr web page")
    @Feature(value="reg page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the opening of the registration page")
    @Test
    public void habrTest4() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .reg();

        WebElement registrationButton = driver.findElement(By.xpath("//button[@id = 'registration_button']"));
        Assert.assertTrue(registrationButton.isDisplayed());
    }

    @Epic("test for habr web page")
    @Feature(value="users page")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Checking the rating of the first user in the user list")
    @Test
    public void habrTest5() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open()
                .openUsersList()
                .openPersonalInfoFirstUser();

        WebElement firstRate = driver.findElement(By.xpath("(//li[@class='defination-list__item defination-list__item_profile-summary'])[1]//a"));
        String firstRateText = firstRate.getText();
        Assert.assertEquals(firstRateText, "1–й");
    }
}
