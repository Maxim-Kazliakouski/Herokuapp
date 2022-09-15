import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.String.format;

public class BaseTest {
    WebDriver browser;
    public static WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        String downloadFilepath = "src/test/java/downloadedFiles";
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("download.default_directory", downloadFilepath);
        options.setExperimentalOption("prefs", chromePrefs);
        browser = new ChromeDriver(options);
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(browser, Duration.ofSeconds(5));

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

    public void open(String url) {
        browser.get(url);
    }

    public void clickUpload() {
        browser.findElement(By.id("file-submit")).click();
    }

    public String getUploadedFileName() {
        return browser.findElement(By.id("uploaded-files")).getText();
    }

    public static boolean waitForVisibility(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public static boolean waitForElementClickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        } catch (TimeoutException ex) {
            return false;
        }
    }

    public void uploadFile(By locator, String fileName) {
        WebElement input = browser.findElement(locator);
        File f = new File(format("src/test/java/%s", fileName));
        String absolute = f.getAbsolutePath();
        input.sendKeys(absolute);
    }

    public boolean isFileDownloaded(String fileName) {
        //Creating a File object for directory
        File directoryPath = new File("src/test/java/downloadedFiles/");
        //List of all files and directories
        String[] contents = directoryPath.list();
        System.out.println("List of files and directories in the specified directory:");
        for (String content : contents) {
            System.out.println(content);
        }
        return fileName.equals(contents[0]);
    }

    public void deleteDownloadedFile(String downloadedFileName) throws IOException {
        Files.delete(Paths.get("src/test/java/downloadedFiles/" + downloadedFileName));
    }
}
