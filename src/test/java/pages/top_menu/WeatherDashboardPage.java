package pages.top_menu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.reporters.jq.Main;
import pages.base_abstract.FooterMenuPage;
import pages.home.HomeDashBoardEventsPage;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherDashboardPage extends FooterMenuPage {

    @FindBy(xpath = "//div[@class='col-lg-6']//a")
    private WebElement tryTheDashBoardButton;

    public WeatherDashboardPage(WebDriver driver) {
        super(driver);
    }

    public WeatherDashboardPage(WebDriver driver, String originalHandle) {
        super(driver, originalHandle);
    }

    public HomeDashBoardEventsPage clickTryTheDashBoardButton() {
        click(tryTheDashBoardButton);

        return new HomeDashBoardEventsPage(getDriver());
    }

    public HomeDashBoardEventsPage clickTryTheDashBoardButtonSaveOriginalHandle() {
        click(tryTheDashBoardButton);

        return new HomeDashBoardEventsPage(getDriver(), getOriginalHandle());
    }

    public WeatherDashboardPage logger_Info(String str) {
        final Logger logger = Logger.getLogger(Main.class.getName());
        logger.log(Level.INFO, String.valueOf(str));

        return this;
    }

}
