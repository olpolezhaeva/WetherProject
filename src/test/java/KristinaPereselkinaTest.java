import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class KristinaPereselkinaTest extends BaseTest {
    static final By A_HREF_PRICE = By.xpath("//div[@id='desktop-menu']//a[@href='/price']");
    static final By H2 = By.xpath("//h2[text()='Professional collections']");
    static final By PROFFESSIONAL_COLLECTION_NAMES = By.xpath("//h3/b");
    static final By H2_HEADER_PROFESSIONAL_COLLECTION = By.xpath("//h2[text()='Current weather and forecasts collection']");
    static final By COLLECTION_SUBSCRIPTION_PRICE = By.xpath("//div/table//th/h4/b");
    static final By BUTTON_SUBSCRIPTION = By.xpath("//div/table//th/a");
    static final By COLLECTION_PRODUCTS = By.xpath("//div/table//td[1]/p");
    static private List<String> getProfessionalSubscriptionPlans() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Free");
        expectedList.add("Startup");
        expectedList.add("Developer");
        expectedList.add("Professional");
        expectedList.add("Enterprise");

        return expectedList;
    }
    private List<String> getProfessionalCollectionProducts() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Current Weather");
        expectedList.add("3-hour Forecast 5 days");
        expectedList.add("Hourly Forecast 4 days");
        expectedList.add("Daily Forecast 16 days");
        expectedList.add("Climatic Forecast 30 days");
        expectedList.add("Bulk Download");
        expectedList.add("Basic weather maps");
        expectedList.add("Historical maps");
        expectedList.add("Global Precipitation Map - Historical data");
        expectedList.add("Weather Dashboard");
        expectedList.add("Road Risk API (basic configuration)");
        expectedList.add("Air Pollution API");
        expectedList.add("Geocoding API");
        expectedList.add("Weather widgets");
        expectedList.add("Uptime 95%");

        return expectedList;
    }
    private List<String> getProfessionalSubscriptionPrices() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("40 USD");
        expectedList.add("180 USD");
        expectedList.add("470 USD");
        expectedList.add("2000 USD");

        return expectedList;
    }
    private List<String> getSubscriptionButtons() {
        List<String> expectedList = new ArrayList<>();
        expectedList.add("Get API key");
        expectedList.add("Subscribe");
        expectedList.add("Subscribe");
        expectedList.add("Subscribe");
        expectedList.add("Subscribe");

        return expectedList;
    }

    @Test
    public void testH2ProfessionalcollectionsText() {
        final String expectedResult = "Professional collections";

        openBaseURL();
        waitForGrayContainerDisappeared();
        click(A_HREF_PRICE);

        String actualResult = getText(H2);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testH2CurrentWeatherAndForecastsCollectionText() {
        final String expectedResult = "Current weather and forecasts collection";

        openBaseURL();
        waitForGrayContainerDisappeared();
        click(A_HREF_PRICE);

        String actualResult = getText(H2_HEADER_PROFESSIONAL_COLLECTION);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSubscriptionPlan() {
        List<String> expectedList = getProfessionalSubscriptionPlans();

        openBaseURL();
        waitForGrayContainerDisappeared();
        click(A_HREF_PRICE);

        List<String> actualList = getListText(PROFFESSIONAL_COLLECTION_NAMES);

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testProfessionalCollectionPrice() {
        List<String> expectedList = getProfessionalSubscriptionPrices();

        openBaseURL();
        waitForGrayContainerDisappeared();
        click(A_HREF_PRICE);

        List<String> actualList = getListText(COLLECTION_SUBSCRIPTION_PRICE);

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testFreeSubscriptionProducts() {
        List<String> expectedList = getProfessionalCollectionProducts();

        openBaseURL();
        waitForGrayContainerDisappeared();
        click(A_HREF_PRICE);

        List<String> actualList = getListText(COLLECTION_PRODUCTS);

        Assert.assertEquals(actualList, expectedList);
    }

    @Test
    public void testProfessionalSubscriptionButtons() {
        List<String> expectedList = getSubscriptionButtons();

        openBaseURL();
        waitForGrayContainerDisappeared();
        click(A_HREF_PRICE);

        List<String> actualList = getListText(BUTTON_SUBSCRIPTION);

        Assert.assertEquals(actualList, expectedList);
    }
}
