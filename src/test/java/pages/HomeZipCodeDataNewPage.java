package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomeZipCodeDataNewPage extends HomeMarketplacePage {

    @FindBy(xpath = "//label[text()='Select state']//following-sibling::ul/li//span[1]")
    private List<WebElement> stateList;

    @FindBy(xpath = "//label[text()='Select year']//following-sibling::ul/li//span[1]")
    private List<WebElement> yearList;

    @FindBy(xpath = "//label[text()='Select state']//following-sibling::div//*[local-name() = 'svg']")
    private WebElement dropdownSelectStateButton;

    @FindBy(xpath = "//label[text()='Select year']//following-sibling::div//*[local-name() = 'svg']")
    private WebElement dropdownSelectYearButton;

    @FindBy(xpath = "//div[@class='footer-content']//h4")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@class='page']//ul[@class='dropdown-menu']/li")
    private List<WebElement> statesPricesZipcodes;

    @FindBy(xpath = "//div[@class='page']//div[@class='section']/ul/li")
    private List<WebElement> weatherParameters;

    @FindBy(xpath = "//div[@class=\"footer-content\"]//button")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//div[@class='pop-up-container big']")
    private WebElement placeOrderContainer;

    @FindBy(xpath = "//div[@class=\"mb-4 container\"]/h4")
    private WebElement placeOrderPopUpHeader;

    @FindBy(xpath = "//div[@class='page']//div[@class='col-sm-8']")
    private List<WebElement> orderParameters;

    @FindBy(xpath = "//button[@class='button-round dark']")
    private WebElement nextButton;

    @FindBy(xpath = "//div[@class='pop-up-content']//h4")
    private WebElement billingDetailsHeader;

    @FindBy(id = "first_name")
    private WebElement firstNameField;

    @FindBy(id = "last_name")
    private WebElement lastNameField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(xpath = "//div[@class='form-group']/label[text()='Email *']/following::input")
    private WebElement emailField;

    @FindBy(xpath = "//div[@class='col']/h4")
    private WebElement billingAddressHeader;

    @FindBy(xpath = "//ul[@class='dropdown-menu']//div[@class='menu-item']/span[2]")
    private List<WebElement> zipCodesPricesList;

    @FindBy(xpath = "//span[(text()='Virginia')]")
    private WebElement stateVirginia;

    @FindBy(xpath = "//div[@class='pop-up-container big']//ul/li[text()='Order details']")
    private WebElement orderPopUpWindow1;

    @FindBy(xpath = "//div[@class='pop-up-container big']//ul/li[text()='Billing details']")
    private WebElement orderPopUpWindow2;

    @FindBy(xpath = "//div[@class='pop-up-container big']//ul/li[text()='Billing address']")
    private WebElement orderPopUpWindow3;

    @FindBy(xpath = "//select[@class='custom-select']")
    private WebElement titleField;

    @FindBy(xpath = "//select[@class='custom-select']/option")
    private List<WebElement> titleOptions;

    @FindBy(xpath = "//input[@class='form-control']")
    private List<WebElement> billingDetailsInputFields;

    public HomeZipCodeDataNewPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getStatesNames() {

        List<String> statesNames = new ArrayList<>();
        statesNames = getTexts(stateList);

        return statesNames;
    }

    public List<String> getYearsNames() {

        List<String> yearsNames = new ArrayList<>();
        yearsNames = getTexts(yearList);

        return yearsNames;
    }

    public HomeZipCodeDataNewPage clickDropdownSelectStateButton() {
        click20(dropdownSelectStateButton);
        return this;
    }

    public HomeZipCodeDataNewPage clickDropdownSelectYearButton() {
        click20(dropdownSelectYearButton);
        return this;
    }

//
//    public List<WebElement> getVisibleStates() {
//
//        return getListOfVisibleElements(stateList, 51);
//    }
//
//    public List<WebElement> getVisibleYears() {
//
//        return getListOfVisibleElements(yearList, 2);
//    }

    public String getVirginiaTotalPrice() {

        return getText(totalPrice).substring(6);
    }

    public List<String> getStatesPricesZipCodes() {

        List<String> statesPricesZipCodes = getTexts(statesPricesZipcodes);

        return statesPricesZipCodes;
    }

    public List<String> getWeatherParameters() {
        List<String> weather_Parameters = new ArrayList<>();

        return getTexts(weatherParameters);
    }

    public HomeZipCodeDataNewPage clickPlaceOrder() {
        click20(placeOrderButton);

        return this;
    }

    public HomeZipCodeDataNewPage waitUntilPlaceOrderPopUpIsVisible() {
        wait10ElementToBeVisible(placeOrderContainer);

        return this;
    }

    public String getPlaceOrderPopUpHeader() {

        return getText(placeOrderPopUpHeader);
    }

    public List<WebElement> getOrderParameters() {

        return getListOfVisibleElements(orderParameters, 6);
    }

    public List<String> getOrderParametersTexts() {

        return getListText(orderParameters);
    }

    public HomeZipCodeDataNewPage clickNextButton() {
        click20(nextButton);

        return this;
    }

    public String getBillingDetailsHeader() {

        return getText(billingDetailsHeader);
    }

    public HomeZipCodeDataNewPage inputFirstName(String firstName) {
        inputText(firstNameField, firstName);

        return this;
    }

    public HomeZipCodeDataNewPage inputLastName(String lastName) {
        inputText(lastNameField, lastName);

        return this;
    }

    public HomeZipCodeDataNewPage inputPhone(String number) {
        inputText(phoneField, number);

        return this;
    }

    public HomeZipCodeDataNewPage inputEmail(String email) {
        inputText(emailField, email);

        return this;
    }

    public String getBillingAddressHeader() {

        return getText(billingAddressHeader);
    }

    public HomeZipCodeDataNewPage clickState(String state) {
        WebElement stateName = getDriver().findElement(By.xpath("//span[(text()='" + state + "')]"));
        click20(stateName);

        return this;
    }

    public HomeZipCodeDataNewPage clickYear(String year) {
        WebElement yearNumber = getDriver().findElement(By.xpath("//span[(text()='" + year + "')]"));
        click20(yearNumber);

        return this;
    }

    public boolean isOrderPopUpDisplayed() {

        return isDisplayedElement(placeOrderContainer);
    }

    public String getAttributeTopPopUpWindow1() {

        return getAttribute(orderPopUpWindow1, "class");
    }

    public String getAttributeTopPopUpWindow2() {

        return getAttribute(orderPopUpWindow2, "class");
    }

    public String getAttributeTopPopUpWindow3() {

        return getAttribute(orderPopUpWindow3, "class");
    }

    public boolean isNextButtonVisible() {

        return isDisplayedElement(nextButton);
    }
}