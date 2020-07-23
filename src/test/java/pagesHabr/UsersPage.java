package pagesHabr;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class UsersPage extends BasePage{

    private Actions actions = new Actions(driver);
    private WebElement firstUserInList = driver.findElements(By.xpath("//ul[@id='peoples']/li[contains(@class, 'content-list__item_users')]/div/div/div/a")).get(0);

    public UsersPage(WebDriver driver) {
        super(driver);
    }

    @Step("open personal information first user in the list")
    public UsersPage openPersonalInfoFirstUser() {
        actions.click(firstUserInList).build().perform();
        return this;
    }
}
