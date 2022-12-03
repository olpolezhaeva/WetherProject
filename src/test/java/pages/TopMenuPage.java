package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class TopMenuPage extends BasePage {

    @FindBy(xpath = "//li[@class='logo']/a")
    private WebElement logo;

    @FindBy(xpath = "//div[@id='desktop-menu']//form[@role='search']")
    private WebElement searchBoxTopMenu;

    @FindBy(xpath = "//div//input[@name='q']")
    private WebElement searchFieldTopMenu;

    @FindBy(xpath = "//div[@id = 'desktop-menu']//a[@href='/guide']")
    private WebElement guideMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//li/a[@href='/api']")
    private WebElement apiMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//a[@href='https://home.openweathermap.org/marketplace']")
    private WebElement marketplaceMenu;

    @FindBy(xpath = "//div[@id = 'desktop-menu']//a[@href = '/price']")
    private WebElement pricingMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//a[@href='/weathermap']")
    private WebElement mapsMenu;

    @FindBy(xpath = "//div[@id = 'desktop-menu']//a[@href='/our-initiatives']")
    private WebElement ourInitiativesMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//a[@href='/examples']")
    private WebElement partnersMenu;

    @FindBy(xpath = "//div[@id='desktop-menu']/ul/li")
    private List<WebElement> topMenuButtons;

    @FindBy(id = "support-dropdown")
    private WebElement supportMenu;

    @FindBy(xpath = "//li[@class='with-dropdown']//li/a")
    private List<WebElement> supportMenuLinks;

    @FindBy(xpath = "//ul[@id='support-dropdown-menu']/li/a[@href='/faq']")
    private WebElement faqSupportSubmenu;

    @FindBy(xpath = "//ul[@id='support-dropdown-menu']/li/a[@href='/appid']")
    private WebElement howToStartSupportSubmenu;

    @FindBy(xpath = "//div[@id='desktop-menu']//a[@href='/weather-dashboard']")
    private WebElement dashboardMenu;


    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public int countTopMenuButtons() {

        return getListSize(topMenuButtons);
    }

    public MainPage clickLogo() {
        click(logo);

        return new MainPage(getDriver());
    }

    public GuidePage clickGuideMenu() {
        click(guideMenu);

        return new GuidePage(getDriver());
    }

    public APIPage clickAPIMenu() {
        click(apiMenu);

        return new APIPage(getDriver());
    }

    public HomeMarketplacePage clickMarketplaceMenu() {
        click(marketplaceMenu);

        return new HomeMarketplacePage(getDriver());
    }

    public PricePage clickPricingMenu() {
        click(pricingMenu);

        return new PricePage(getDriver());
    }

    public WeatherMapsPage clickMapsMenu() {
        click(mapsMenu);

        return new WeatherMapsPage(getDriver());
    }

    public OurInitiativesPage clickOurInitiativesMenu() {
        click(ourInitiativesMenu);

        return new OurInitiativesPage(getDriver());
    }

    public PartnersPage clickPartnersMenu() {
        click(partnersMenu);

        return new PartnersPage(getDriver());
    }

    public MainPage clickSupportMenu() {
        click(supportMenu);

        return new MainPage(getDriver());
    }

    public FAQPage clickFAQSupportSubmenu() {
        click(faqSupportSubmenu);

        return new FAQPage(getDriver());
    }

    public HowToStartPage clickHowToStartSupportSubmenu() {
        click(howToStartSupportSubmenu);

        return new HowToStartPage(getDriver());
    }

    public String getInnerTextOfPlaceholder(String attribute) {

        return getAttribute(searchFieldTopMenu, attribute);
    }

    public boolean isPlaceholderDisplayed() {

        return isDisplayedElement(searchBoxTopMenu);
    }

    public FindPage inputSearchCriteriaIntoSearchFieldAndEnter(String text) {
        inputAndEnter(searchFieldTopMenu, text);

        return new FindPage(getDriver());
    }

    public List<String> getLinksText() {

        return getTexts(supportMenuLinks);
    }

    public String getSupportMenuIsActiveValue(String attribute) {

        return getAttribute(supportMenu, attribute);
    }

    public MainPage clickDashboardMenu() {
        click(dashboardMenu);

        return new MainPage(getDriver());
    }
}
