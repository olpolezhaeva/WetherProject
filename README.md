### Java 11 | Selenium | TestNG | Maven | POM | Rest Assured Project
This is a sample Java 11 AdoptOpenJDK | Selenium WebDriver | Maven | TestNG | Rest Assured project created in IntelliJ IDE, using Page Object Model and Generic Type.

Website https://openweathermap.org/ was used to create functional, API, and UI tests.

ci.yml file was used for the GitHub workflow

dorny/test-reporter@v1 was used to generate reports after each CI run


## For testing requests and responses DevTools type property was used 

setUpDevTool(WebDriver driver)  method was created in the class CaptureNetworkTraffic  to capture the traffic:


    public CaptureNetworkTraffic setUpDevTool(WebDriver driver) {
        devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
     
        return this;
    } 
 
org.openqa.selenium.devtools.v106.network.Network was used for traffic interception.

Class HttpURLConnection was used to send direct API calls and check responses.

Rest Assured library and POJO Model was used for testing and validating REST APIs.



## Setup the project:

1. Clon project from the GitHub repository: 
https://github.com/olpolezhaeva/WetherProject.git

2. Go to the resources package, and copy local.properties.TEMPLATE file. Paste it to the resources package, and re-name the new file as local.properties
