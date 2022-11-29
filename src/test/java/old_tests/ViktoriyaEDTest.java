package old_tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import base.BaseTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ViktoriyaEDTest extends BaseTest {
    private final By SUPPORT_BUTTON = By.xpath("//div[@id='support-dropdown']");
    private final By DIFFERENT_WEATHER_BUTTON = By.xpath("//span[@class='control-el owm-switch']");
    private final By DIFFERENT_WEATHER_POP_UP = By.xpath("//div[@class='pop-up-container']");
    private final By SUPPORT_DROPDOWN = By.xpath("//ul[@id='support-dropdown-menu']");
    private final By SUPPORT_SUBMENUS_LIST = By.xpath("//ul[@id='support-dropdown-menu']/li/a");
    final static By SUPPORT_MENU_FAQ = By.xpath("//ul[@id='support-dropdown-menu']//a[@href='/faq']");
    final static By SUPPORT_MENU_HOW_TO_START = By.xpath("//ul[@id='support-dropdown-menu']//a[@href='/appid']");
    final static By SUPPORT_MENU_ASK_A_QUESTION = By.xpath("//ul[@id='support-dropdown-menu']//a[@target='_blank']");
    final static String[] SUBMENU_NAMES = {"FAQ", "How to start", "Ask a question"};
    final static By WIDGET_BUTTON = By.xpath("//div[@class='section-content']/ul/li/a[@href='/widgets-constructor']");
    final static By YOUR_API_KEY_FIELD = By.id("api-key");
    final static By YOUR_CITY_NAME_FIELD = By.id("city-name");
    final static By SEARCH_CITY_BUTTON = By.id("search-city");
    final static By SELECT_UNITS_C = By.xpath("//h4/span[@id='metric'])");
    final static By SELECT_UNITS_F = By.id("imperial");
    final static By WIDGETS_4LEFT_TEMP_UNIT = By.xpath("//span[@class='weather-left-card__degree']");
    final static By WIDGETS_3MIDDLE_RIGHT_TEMP_UNIT = By.xpath("//span[@class='weather-left-card__degree']");
    final static By WIDGETS_4RIGHT_TEMP_UNIT = By.xpath("//td[contains(@class, 'weather-right-card__item weather-right-card__temperature')]/span");

    private boolean wait20ForTextNotToBeEmpty(WebElement element) {
        while (element.getText() == null || element.getText().length() < 1) {
            getWait20().until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element, "")));
        }

        return element.getText().length() > 0;
    }

    private String getLocation() {
        String oldCity = "";
        WebElement header = getDriver().findElement(By.xpath("//h2[@class='widget-left-menu__header']"));

        if (wait20ForTextNotToBeEmpty(header)) {
            oldCity = header.getText();
        } else {
            Reporter.log("OldCity was NOT found" + oldCity, true);
        }

        return oldCity;
    }

    private String getNewLocationInCitiesList(String cityCountry) {
        getWait20().until(ExpectedConditions
                .attributeToBe(
                        By.xpath("//ul[@id = 'city-list']/li/label/input"), "value", cityCountry)
        );

        return getDriver().findElement(
                By.xpath("//ul[@id = 'city-list']/li/label/input")).getAttribute("value");
    }

    private List<WebElement> getWidgets() {
        List<WebElement> widgets = getDriver().findElements(By.xpath("//div[@class = 'widget-right__title']"));
        List<WebElement> widgetsList2 = getDriver().findElements(By.xpath("//h2[@class = 'widget-right__title']"));
        List<WebElement> widgetsList3 = getDriver().findElements(By.xpath("//h2[@class = 'widget-left-menu__header']"));

        widgets.addAll(widgetsList2);
        widgets.addAll(widgetsList3);

        return widgets;
    }

    @Test
    public void test_SupportMenuIsClickable() {
        openBaseURL();
        click(SUPPORT_BUTTON);

        Assert.assertTrue(getTextByAttribute(
                SUPPORT_DROPDOWN, "class").equals("dropdown-menu dropdown-visible"));

        click(SUPPORT_BUTTON);

        Assert.assertTrue(getTextByAttribute(
                SUPPORT_DROPDOWN, "class").equals("dropdown-menu"));
    }

    @Test
    public void test_SupportMenuHas3Submenus() {

        openBaseURL();
        click(SUPPORT_BUTTON);
        List<WebElement> supportSubmenuList = getListOfElements(SUPPORT_SUBMENUS_LIST);

        int listSize = getListSize(SUPPORT_SUBMENUS_LIST);

        Assert.assertTrue(listSize == 3);

        for (int i = 0; i < listSize; i++) {
            Assert.assertTrue(supportSubmenuList.get(i).getText().equals(SUBMENU_NAMES[i]));
        }
    }

    @Test
    public void test_SupportMenuSubmenusAreClickableAndRedirectedToTheRightPage() {

        openBaseURL();
        click20(SUPPORT_BUTTON);
        click20(SUPPORT_MENU_FAQ);

        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://openweathermap.org/faq"));

        click20(SUPPORT_BUTTON);
        click20(SUPPORT_MENU_HOW_TO_START);

        Assert.assertTrue(getDriver().getCurrentUrl().contains("https://openweathermap.org/appid"));

        click20(SUPPORT_BUTTON);
        click20(SUPPORT_MENU_ASK_A_QUESTION);
        List<String> tabs = new ArrayList<>(getDriver().getWindowHandles());

        Assert.assertEquals(tabs.size(), 2);

        getDriver().switchTo().window(tabs.get(1));
        getWait10().until(ExpectedConditions.not(ExpectedConditions.urlMatches(BASE_URL)));

        Assert.assertTrue(getCurrentURL().contains("https://home.openweathermap.org/questions"));
    }

    @Test
    public void test_VerifyPopupWindowIsShownWhenClickingDifferentWeatherButton() {

        openBaseURL();
        click(DIFFERENT_WEATHER_BUTTON);

        Assert.assertTrue(getDriver().findElement(DIFFERENT_WEATHER_POP_UP).isDisplayed());
    }

    @Test
    public void test_WidgetsIsClickableAndRedirectsUserToTheWidgetsPage() {

        final String expectedWidgetsPage = "https://openweathermap.org/widgets-constructor";

        openBaseURL();
        scrollToPageBottom();
        click20(WIDGET_BUTTON);

        Assert.assertTrue(getCurrentURL().contains(expectedWidgetsPage));
    }

    @Test
    public void test_VerifySelectYourCityFieldContainsChosenCity() {

        final String key = "20cbbe5f82ae947874eb39f29f8ffbe1";
        final String city = "Rome";

        openBaseURL();
        scrollToPageBottom();
        click20(WIDGET_BUTTON);

        click(YOUR_API_KEY_FIELD);
        clear(YOUR_API_KEY_FIELD);
        input(key, YOUR_API_KEY_FIELD);


        click(YOUR_CITY_NAME_FIELD);

        String oldCity = getDriver().findElement(By.xpath("//h2[@class='widget-left-menu__header']")).getText();

        clear(YOUR_CITY_NAME_FIELD);
        input(city, YOUR_CITY_NAME_FIELD);
        click20(SEARCH_CITY_BUTTON);

        waitTextToBeChanged(By.xpath("//h2[@class='widget-left-menu__header']"), oldCity);

        List<WebElement> selectYourCityList = getListOfElements(By.xpath("//ul[@id='city-list']//span"));
        Assert.assertTrue(selectYourCityList.size() == 5);

        List<String> cityNameList = getElemntsText(By.xpath("//ul[@id='city-list']//span"));

        for (int i = 0; i < cityNameList.size(); i++) {
            Assert.assertTrue(cityNameList.get(i).contains(city));
        }
    }

    @Ignore
    @Test
    public void test_VerifyTheWeatherUnitCelsius() {

        final String key = "20cbbe5f82ae947874eb39f29f8ffbe1";
        final String city = "Rome";
        final String tempUnitC = "°C";
        final String rgbColor = "235, 110, 75";

        openBaseURL();
        scrollToPageBottom();
        click20(WIDGET_BUTTON);

        click(YOUR_API_KEY_FIELD);
        clear(YOUR_API_KEY_FIELD);
        input(key, YOUR_API_KEY_FIELD);

        click(YOUR_CITY_NAME_FIELD);
        clear(YOUR_CITY_NAME_FIELD);
        input(city, YOUR_CITY_NAME_FIELD);
        click20(SEARCH_CITY_BUTTON);

        WebElement tempUnitCelsius = getDriver().findElement(By.id("metric"));
        String selectedCelsius = tempUnitCelsius.getCssValue("color");

        Assert.assertTrue(selectedCelsius.contains(rgbColor));

        List<String> widgetsTemp1 = getElemntsText(WIDGETS_4LEFT_TEMP_UNIT);
        List<String> widgetsTemp2 = getElemntsText(WIDGETS_3MIDDLE_RIGHT_TEMP_UNIT);
        List<String> widgetsTemp3 = getElemntsText(WIDGETS_4RIGHT_TEMP_UNIT);

        widgetsTemp1.addAll(widgetsTemp2);
        widgetsTemp1.addAll(widgetsTemp3);

        Assert.assertTrue(widgetsTemp1.size() > 0);

        for (int i = 0; i < widgetsTemp1.size(); i++) {
            Assert.assertTrue(widgetsTemp1.get(i).equals(tempUnitC));
        }
    }

    @Ignore
    @Test
    public void test_VerifyTheWeatherUnitFahrenheit() {

        final String key = "20cbbe5f82ae947874eb39f29f8ffbe1";
        final String city = "Rome";
        final String tempUnitF = "°F";
        final String rgbColor = "235, 110, 75";

        openBaseURL();
        scrollToPageBottom();
        click20(WIDGET_BUTTON);

        click(YOUR_API_KEY_FIELD);
        clear(YOUR_API_KEY_FIELD);
        input(key, YOUR_API_KEY_FIELD);

        click(SELECT_UNITS_F);
        WebElement tempUnitFahrenheit = getDriver().findElement(SELECT_UNITS_F);
        Assert.assertTrue(tempUnitFahrenheit.getCssValue("color").contains(rgbColor));

        click(YOUR_CITY_NAME_FIELD);
        clear(YOUR_CITY_NAME_FIELD);
        input(city, YOUR_CITY_NAME_FIELD);
        click20(SEARCH_CITY_BUTTON);

        List<String> widgetsTempF = getElemntsText(WIDGETS_4LEFT_TEMP_UNIT);
        List<String> widgetsTempF1 = getElemntsText(WIDGETS_3MIDDLE_RIGHT_TEMP_UNIT);
        List<String> widgetsTempF2 = getElemntsText(WIDGETS_4RIGHT_TEMP_UNIT);

        widgetsTempF.addAll(widgetsTempF1);
        widgetsTempF.addAll(widgetsTempF2);

        Assert.assertTrue(widgetsTempF.size() > 0);

        for (int i = 0; i < widgetsTempF.size(); i++) {
            Assert.assertTrue(widgetsTempF.get(i).equals(tempUnitF));
        }
    }
    @Test
    public void test_VerifyAllWidgetsHasChosenCity() {

        final String key = "20cbbe5f82ae947874eb39f29f8ffbe1";
        final String cityCountry = "Rome, IT";

        openBaseURL();
        scrollToPageBottom();
        click20(WIDGET_BUTTON);

        click20(YOUR_API_KEY_FIELD);
        clear(YOUR_API_KEY_FIELD);
        input(key, YOUR_API_KEY_FIELD);

        String oldCity = getLocation();
        Reporter.log("OldCity was found ------- " + oldCity, true);

        click(YOUR_CITY_NAME_FIELD);
        clear(YOUR_CITY_NAME_FIELD);
        input(cityCountry, YOUR_CITY_NAME_FIELD);

        click(SEARCH_CITY_BUTTON);

        String newCityCountry = getNewLocationInCitiesList(cityCountry);
        Reporter.log("CityCountry changed to ------- " + newCityCountry, true);

        List<WebElement> allWidgets = getWidgets();

        List<String> texts = new ArrayList<>();
        for (WebElement element : allWidgets) {
            texts.add(element.getText());
        }

        Reporter.log(String.valueOf(texts), true);

        for (String cityCountryName : texts) {
            Assert.assertEquals(cityCountryName, cityCountry);
        }
    }
}
