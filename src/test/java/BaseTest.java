import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver browser;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        browser.quit();
    }

    public String gettingOnlyName(WebElement nameLocator) {
        String onlyName;
        List<String> stringName = Arrays.asList(nameLocator.getText().split(":"));
        onlyName = stringName.get(1).trim();
        return onlyName;
    }

    public void clickOnArrowUpButton(int amountOfClick, WebElement input) {
        for (int i = 0; i < amountOfClick; i++) {
            input.sendKeys(Keys.ARROW_UP);
        }
    }

    public void clickOnArrowDownButton(int amountOfClick, WebElement input) {
        for (int i = 0; i < amountOfClick; i++) {
            input.sendKeys(Keys.ARROW_DOWN);
        }
    }

    public int gettingStatusCode(String request) {
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(request);
        return response.getStatusCode();
    }
}
