package pagesHabr;

import casesHabr.HabrBaseTest;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BasePage {
    WebDriver driver;
    public Logger logger = LogManager.getLogger(HabrBaseTest.class);

    BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
