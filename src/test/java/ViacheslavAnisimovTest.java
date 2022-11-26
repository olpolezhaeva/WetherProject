import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import base.BaseTest;

public class ViacheslavAnisimovTest extends BaseTest {
    final static String BASE_URL = "https://openweathermap.org/";
    final static String EMAIL = "jka59433@xcoxc.com";
    final static String PASSWORD = "Tester12#";
    final static String SYMBOL_FAHRENHEIT = "°F";
    final static By HAMBURGER_MENU = By.id("hamburger");
    final static By LINK_TO_GUIDE_IN_HAMBURGER_MENU = By.xpath("//ul[@id='mobile-menu']//a[@href='/guide']");
    final static By LINK_TO_MARKETPLACE = By.linkText("Marketplace");
    final static By LINK_TO_HISTORY_WEATHER_DATA = By.xpath("//div[@id='footer-website']//a[@href='/api#history']");
    final static By LINK_SIGN_IN = By.xpath("//div[@id='desktop-menu']//li/a[@href='https://openweathermap.org/home/sign_in']");
    final static By ENTER_EMAIL_FIELD = By.xpath("//input[@id='user_email']");
    final static By PASSWORD_FIELD = By.xpath(("//input[@id='user_password']"));
    final static By SUBMIT_BUTTON = By.xpath("//input[@name='commit']");
    final static By SUCCESSFUL_LOGIN_TEXT = By.xpath("//div[@class='panel-body']");
    final static By FAHRENHEIT = By.xpath("//div[@class='option'][contains(text(), 'Imperial: °F, mph')]");
    final static By TEMP_TEXT_IN_HEADING = By.xpath("//span[@class='heading'][contains(text(), '°F')]");
    final static By SEARCH_CITY_FIELD = By.xpath("//input[@placeholder='Search city']");
    final static By SUB_NOT_FOUND = By.xpath("//div[@class='sub not-found notFoundOpen']");
    final static By NO_RESULTS_FOR = By.xpath("//div[@class='widget-notification']/span");

    @Test
    public void testHamburgerMenuAndGuidePageTitle() {

        final String expectedResult1 = "https://openweathermap.org/guide";
        final String expectedResult2 = "OpenWeatherMap API guide - OpenWeatherMap";

        getDriver().manage().window().setSize(new Dimension(1024, 970));

        openBaseURL();

        click(HAMBURGER_MENU);
        click(LINK_TO_GUIDE_IN_HAMBURGER_MENU);

        String actualResult1 = getDriver().getCurrentUrl();
        String actualResult2 = getDriver().getTitle();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
    }

    @Test
    public void testMarketplaceMenuIsClickableOpenCustomWeatherProducts() {
        final String expectedResult1 = "https://home.openweathermap.org/marketplace";
        final String expectedResult2 = "Custom Weather Products";

        openBaseURL();

        click(LINK_TO_MARKETPLACE);
        jumpToNextWindow();

        String actualResult1 = getDriver().getCurrentUrl();
        String actualResult2 = getDriver().findElement(By.cssSelector("h1")).getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);

    }

    @Test
    public void testLinkHistoricalWeatherData() {
        String expectedResult = "https://openweathermap.org/api#history";

        openBaseURL();

        scrollToPageBottom();

        click(LINK_TO_HISTORY_WEATHER_DATA);

        String actualResult = getDriver().getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSignInToYourAccount_HappyPath() {
        String expectedResult = "Signed in successfully.";

        openBaseURL();

        click(LINK_SIGN_IN);

        input(EMAIL, ENTER_EMAIL_FIELD);
        input(PASSWORD, PASSWORD_FIELD);
        click(SUBMIT_BUTTON);

        String actualResult = getDriver().findElement(SUCCESSFUL_LOGIN_TEXT).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testChangeTempFahrenheitInHeadingAfterClickButtonF() {

        openBaseURL();

        click(FAHRENHEIT);
        waitForGrayContainerDisappeared();

        Assert.assertTrue(getText(TEMP_TEXT_IN_HEADING).contains(SYMBOL_FAHRENHEIT));
    }

    @Test
    public void testEnterSearchCityFieldWrongData() {
        final String wrongText = "Dsa";
        final String expectedResult = "Not found. To make search more precise put the city's name, comma, 2-letter country code (ISO3166).";
        final String expectedResult2 = "No results for Dsa";

        openBaseURL();

        inputAndEnter(SEARCH_CITY_FIELD, wrongText);

        String actualResult = getText(SUB_NOT_FOUND);
        String actualResult2 = getText(NO_RESULTS_FOR);

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(actualResult2, expectedResult2);
    }
}
