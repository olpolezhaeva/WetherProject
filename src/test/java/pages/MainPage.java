package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends FooterMenuPage {

    @FindBy(className = "owm-loader-container")
    private WebElement grayContainer;

    @FindBy(xpath = "//div[@id = 'weather-widget']//h2")
    private WebElement h2CityCountryHeader;

    @FindBy(xpath = "//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
    private WebElement searchCityField;

    @FindBy(xpath = "//div[@id = 'weather-widget']//button[@type = 'submit']")
    private WebElement searchButton;

    @FindBy(className = "search-dropdown-menu")
    private WebElement searchDropdownMenu;

    @FindBy(xpath = "//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
    private WebElement parisFRChoiceInDropdownMenu;

    @FindBy(xpath = "//div[@class='mobile-padding']/h1/span")
    private WebElement colorAndFontSizeOfH1Header;

    @FindBy(xpath = "//ul[@class = 'search-dropdown-menu']/li/span[@style='width: 140px;']")
    private List<WebElement> allChoicesInDropDownMenu;

    @FindBy(xpath = "//div[@class = 'controls']//span")
    private WebElement differentWeatherButton;

    @FindBy(className = "pop-up-container")
    private WebElement differentWeatherPopUpContainer;

    @FindBy(xpath = "//ul[@class='icons']/*")
    private WebElement differentWeatherIconsContainer;

    @FindBy(xpath = "//ul[@class = 'icons']/*")
    private List<WebElement> iconsList;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void waitForGrayContainerDisappeared() {
        getWait20().until(ExpectedConditions.invisibilityOf(grayContainer));
    }

    public String getCityCountryName() {

        return getText(h2CityCountryHeader);
    }

    public MainPage clickSearchCityField() {
        click(searchCityField);

        return this;
    }

    public MainPage inputSearchCriteria(String text) {
        input(text, searchCityField);

        return this;
    }

    public MainPage clickSearchButton() {
        click(searchButton);

        return this;
    }

    public MainPage clickParisInDropDownList() {
        wait20ElementToBeVisible(searchDropdownMenu);
        click(parisFRChoiceInDropdownMenu);

        return this;
    }

    public MainPage clickChoiceInDropDownList(String cityCountry) {
        wait20ElementToBeVisible(searchDropdownMenu);
        for (WebElement choice : allChoicesInDropDownMenu) {
            if (choice.getText().equalsIgnoreCase(cityCountry)) {
                click(choice);
            }
        }

        return this;
    }

    public MainPage waitForCityCountryNameChanged(String oldText) {
        waitTextToBeChanged(h2CityCountryHeader, oldText);

        return this;
    }

    public String getColor() {

        return getBackgroundColor(colorAndFontSizeOfH1Header);
    }

    public String getFontSize() {

        return getFontSize(colorAndFontSizeOfH1Header);
    }

    public MainPage clickDifferentWeatherButton() {
        click(differentWeatherButton);

        return this;
    }

    public MainPage waitUntilDifferentWeatherPopUpIsVisible() {
        getWait10().until(ExpectedConditions.visibilityOf(differentWeatherPopUpContainer));

        return this;
    }

    public int getListSizeOfIconsOnDifferentWeatherPopUp() {
        return getListSize(iconsList);
    }

    public List<WebElement> getListOfIconsOnDifferentWeatherPopUp() {
        return iconsList;
    }

    public MainPage clickOnIconsOnDifferentWeatherPopUp(WebElement element) {
        click(element);
        return this;
    }
}