package pages.base_abstract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.*;
import pages.footer_menu.AboutUsPage;
import pages.footer_menu.TechnologyPage;
import pages.footer_menu.WidgetsPage;
import pages.home.HomeAskQuestionPage;
import pages.top_menu.PricePage;
import pages.top_menu.WeatherDashboardPage;

import java.util.ArrayList;
import java.util.List;

public abstract class FooterMenuPage extends TopMenuPage {

    final static String FOOTER_MENU_ID = "//div[@id='footer-website']";

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/weather-dashboard']")
    private WebElement weatherDashboardFooterMenu;

    @FindBy(css = FOOTER_MENU_ID + "a[href='/technology']")
    private WebElement ourTechnologyFooterMenu;

    @FindBy(css = FOOTER_MENU_ID + "a[href='https://openweather.co.uk/privacy-policy']")
    private WebElement privacyPolicyFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href = '/about-us']")
    private WebElement aboutUsFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/widgets-constructor']")
    private WebElement widgetsFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://apps.apple.com/gb/app/openweather/id1535923697'] "
            + "[@target='_blank']")
    private WebElement downloadOnTheAppStoreLinkFooterMenu;

    @FindBy(className = "social")
    private WebElement socialPanelFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//div[@class='social']/a")
    private List<WebElement> socialPanelIconsFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='https://github.com/search?q=openweathermap&ref=cmdform']")
    private WebElement githubIconFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID + "//a[@href='/stations']")
    private WebElement connectYourWeatherStationFooterMenu;

    @FindBy(xpath = FOOTER_MENU_ID +"//p[text()='Download OpenWeather app']")
    private WebElement downloadOpenWeatherApp;

    @FindBy(xpath = "//div[@id = 'footer-website']//a[@href = 'https://home.openweathermap.org/questions']")
    private WebElement askQuestionFooterMenu;

    @FindBy(xpath = "//div[@class='section-content']//a[@href='/price']")
    private WebElement pricingFooterMenu;

    @FindBy(xpath = "//div[@style='display: flex; flex-direction: row;']/a")
    private List<WebElement> storeIcons;

    @FindBy(xpath = "//img[@alt='Get it on Google Play']")
    private WebElement iconGooglePlay;

    @FindBy(xpath = "//div[@class='horizontal-section my-5']/div/span[2]")
    private WebElement copirightSign;

    @FindBy(xpath = "//div[@class = 'social']//img[contains(@src, 'facebook')]")
    private WebElement iconFacebook;

    @FindBy(xpath = "//div[@id='footer-website']//div[1]/div[2]/p")
    private WebElement subscription;

    @FindBy(xpath = "//div[@id='footer-website']//div[1]/div[2]/div/ul/li")
    private List<WebElement> subscriptionList;
    
    @FindBy(css = "div[class = 'inner-footer-container']")
    private WebElement footerMenu;

    @FindBy(xpath = "//div[@class = 'inner-footer-container']//a")
    private List<WebElement> footerMenuLinks;

    @FindBy(xpath = "//a[@href='https://openweather.co.uk/']")
    private WebElement openWeatherForBusinessFooterMenuLink;

    @FindBy(xpath = "//div[@class='my-5']/div[@style='display: flex; flex-direction: row;']/a")
    private List<WebElement> storePanelIconsFooterMenu;

    public FooterMenuPage(WebDriver driver) {
        super(driver);
    }

    public FooterMenuPage(WebDriver driver, String originalHandle) {
        super(driver, originalHandle);
    }

    public WeatherDashboardPage clickWeatherDashboardFooterMenu() {
        click(weatherDashboardFooterMenu);

        return new WeatherDashboardPage(getDriver());
    }

    public TechnologyPage clickOurTechnologyFooterMenu() {
        click(ourTechnologyFooterMenu);

        return new TechnologyPage(getDriver());
    }

    public void clickPrivacyPolicyFooterMenu() {

        click(privacyPolicyFooterMenu);
    }

    public AboutUsPage clickOnAboutUsFooterMenu() {
        click20(aboutUsFooterMenu);

        return new AboutUsPage(getDriver());
    }

    public WidgetsPage clickWidgetsPageFooterMenu() {
        click(widgetsFooterMenu);

        return new WidgetsPage(getDriver());
    }

    public boolean isSocialPanelDisplayed() {

        return isDisplayedElement(socialPanelFooterMenu);
    }

    public int getSocialPanelSize() {

        return getListSize(socialPanelIconsFooterMenu);
    }

    public boolean isGithubIconDisplayed() {

        return isDisplayedElement(githubIconFooterMenu);
    }

    public MainPage clickToGithubIcon() {
        click20(githubIconLinkFooterMenu);

        return new MainPage(getDriver());
    }

    public WeatherStationsPage clickConnectYourWeatherStationFooterMenu() {
        click(connectYourWeatherStationFooterMenu);

        return new WeatherStationsPage(getDriver());
    }

    public String getTextDownloadOpenWeatherApp() {

        return getText(textDownloadOpenWeatherApp);
    }

    public boolean textDownloadOpenWeatherAppIsDisplayed() {

        return isDisplayedElement(textDownloadOpenWeatherApp);
    }

    public MainPage clickDownloadOnTheAppStoreLinkFooterMenu() {
        click20(downloadOnTheAppStoreLinkFooterMenu);

        return new MainPage(getDriver());
    }

    public FooterMenuPage clickOnAskQuestionFooterMenu() {
        wait10ElementToBeClickable(askQuestionFooterMenu);
        click20(askQuestionFooterMenu);

        return this;
    }

    public HomeAskQuestionPage switchToHomeAskQuestionPage() {
        switchToAnotherWindow();

        return new HomeAskQuestionPage(getDriver());
    }

    public PricePage clickPricingFooterMenu() {
        click20(pricingFooterMenu);

        return new PricePage(getDriver());
    }

    public int getStoreIconsSize() {

        return getListSize(storeIcons);
    }

    public String getCopyrightSign(){

        return getText(copirightSign);
    }

    public MainPage clickDownloadGooglePlayLinkFooterMenu() {
        click20(iconGooglePlay);

        return new MainPage(getDriver());
    }

    public MainPage clickFacebookIcon(){
        click20(iconFacebook);

        return new MainPage(getDriver());
    }

    public List<String> clickEachIconAndGetURL() {
        String mainWindow = getDriver().getWindowHandle();
        List<String> currentURLs = new ArrayList<>();

        for (int i = 0; i < socialPanelIconsFooterMenu.size(); i++) {
            click(socialPanelIconsFooterMenu.get(i));
            if (getDriver().getWindowHandles().size() > 1) {
                switchToAnotherWindow();
                currentURLs.add(getCurrentURL());
                getDriver().close();
                getDriver().switchTo().window(mainWindow);
            } else {
                currentURLs.add(getCurrentURL());
            }
        }

        return currentURLs;
    }

    public WebElement getSubscriptionFooterMenu() {

        return subscription;
    }

    public List<String> getMenusTexts() {

        return getTexts(subscriptionList);
    }
    
    protected WebElement getFooterMenu() {

        return footerMenu;
    }

    public int footerMenuLinks() {
        allElementsVisibleAndClickable(footerMenuLinks);

        return getListSize(footerMenuLinks);
    }

    public MainPage clickOpenWeatherForBusinessFooterMenuLink() {
        click(openWeatherForBusinessFooterMenuLink);

        return new MainPage(getDriver());
    }

    public boolean storePanelIsDisplayed() {

        return isElementsInListDisplayed(storePanelIconsFooterMenu);
    }

    public int getStoresIconsSize() {

        return getListSize(storePanelIconsFooterMenu);
    }
}