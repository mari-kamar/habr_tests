package pagesHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage{
    public static final String URL = "https://habr.com/ru";
    private By langBtn = By.xpath("//button[contains(@class, 'btn_navbar_lang')]");
    private By authBtn = By.xpath("//a[@id=\"login\"]");
    private By regBtn = By.xpath("//a[contains(@class, 'btn_navbar_registration')]");
    private By usersLink = By.xpath("//h3[contains(text(),'Авторы')]");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("open main habr page")
    public MainPage open() {
        driver.get(URL);
        logger.info("Main page habr is open");
        return this;
    }

    @Step("open language popup")
    public MainPage openLangPopup() {
        driver.findElement(langBtn).click();
        logger.info("language popup is open");
        return new MainPage(driver);
    }

    @Step("open authorization page")
    public AuthPage auth() {
        driver.findElement(authBtn).click();
        logger.info("auth page is open");
        return new AuthPage();
    }

    @Step("open registration page")
    public RegPage reg() {
        driver.findElement(regBtn).click();
        logger.info("auth page is open");
        return new RegPage();
    }

    @Step("open list of users")
    public UsersPage openUsersList() {
        driver.findElement(usersLink).click();
        logger.info("users list is open");
        return new UsersPage(driver);
    }
}
