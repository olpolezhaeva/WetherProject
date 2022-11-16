import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;

public class YulianaDaraganTest extends BaseTest {
    final static String BASE_URL = "https://openweathermap.org/";

    final static By SUPPORT_MENU = By.xpath("//div[@id = 'support-dropdown']");
    final static By ASK_A_QUESTION_SUBMENU_CHOICE_IN_SUPPORT_MENU = By.xpath(
            "//ul[@id = 'support-dropdown-menu']//a[@href = 'https://home.openweathermap.org/questions']");
    final static By EMAIL_FIELD_IN_ASK_A_QUESTION_PAGE= By.xpath("//input[@id = 'question_form_email']");
    final static By SUBJECT_DROPDOWN_LIST_IN_ASK_A_QUESTION_PAGE = By.xpath(
            "//select[@class = 'form-control select required']");
    final static By MESSAGE_FIELD_IN_ASK_A_QUESTION_PAGE= By.xpath("//textarea[@class = 'form-control text required']");
    final static By SUMBIT_BUTTON_IN_ASK_A_QUESTION_PAGE = By.xpath("//input[@name = 'commit']");
    final static By CAPTCHA_HELP_BLOCK_IN_ASK_A_QUESTION_PAGE = By.xpath("//div[@class = 'help-block']");

    private void openURL(String url) {
        getDriver().get(url);
    }

    private void waitForGrayFrameDisappeared() {
        getWait20().until(ExpectedConditions.invisibilityOfElementLocated(
                By.className("owm-loader-container")));
    }

    private void click(By by,  WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    private void waitElementToBeVisible(By by, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private String getText(By by, WebDriver driver) {

        return driver.findElement(by).getText();
    }

    private void inputTextInField(String text, By by, WebDriver driver) {
        driver.findElement(by).sendKeys(text);
    }

    private void moveWebDriverToNewTab() {
        ArrayList<String> tabsList = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabsList.get(1));
    }

    @Test
    public void testFillAskAQuestion_WithoutCapcha() {
        String email = "tester@tester.com";
        String message = "i didn't confirm capcha :)";
        String expectedResult = "reCAPTCHA verification failed, please try again.";

        openURL(BASE_URL);
        waitForGrayFrameDisappeared();

        click(SUPPORT_MENU, getWait5());
        click(ASK_A_QUESTION_SUBMENU_CHOICE_IN_SUPPORT_MENU, getWait10());

        moveWebDriverToNewTab();

        inputTextInField(email, EMAIL_FIELD_IN_ASK_A_QUESTION_PAGE, getDriver());

        click(SUBJECT_DROPDOWN_LIST_IN_ASK_A_QUESTION_PAGE, getWait5());
        getDriver().findElement(SUBJECT_DROPDOWN_LIST_IN_ASK_A_QUESTION_PAGE).sendKeys(Keys.ARROW_DOWN);
        inputTextInField(message, MESSAGE_FIELD_IN_ASK_A_QUESTION_PAGE, getDriver());
        click(SUMBIT_BUTTON_IN_ASK_A_QUESTION_PAGE, getWait5());

        String actualResult = getText(CAPTCHA_HELP_BLOCK_IN_ASK_A_QUESTION_PAGE, getDriver());

        Assert.assertEquals(actualResult,expectedResult);
    }
}