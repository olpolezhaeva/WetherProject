package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends HomeTopMenuPage {

    @FindBy(xpath = "//div[@class = 'panel-body']")
    WebElement signedInMessage;

    @FindBy(id = "user-dropdown")
    WebElement userTopMenu;

    @FindBy(xpath = "//ul[@id='user-dropdown-menu']/li")
    List<WebElement> userDropdownMenuLinks;

    @FindBy(xpath = "//ul[@id='myTab']//a[@href='/api_keys']")
    private WebElement apiKeysTab;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getMessage() {

        return getText(signedInMessage);
    }

    public HomePage clickUserDropdown() {
        click(userTopMenu);

        return this;
    }

    public List<String> getTextUserDropDownMenuLInks() {

        return getListText(userDropdownMenuLinks);
    }

    public HomeAPIKeysPage clickAPIKeysTab() {
        click(apiKeysTab);

        return new HomeAPIKeysPage(getDriver());
    }
}