import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class HoversTest extends BaseTest {
    // test data
    String hoverUrl = "https://the-internet.herokuapp.com/hovers";
    String requestFor1stUserProfile = "https://the-internet.herokuapp.com/users/1";
    String requestFor2ndUserProfile = "https://the-internet.herokuapp.com/users/2";
    String requestFor3rdUserProfile = "https://the-internet.herokuapp.com/users/3";
    static String onlyName = null;
    boolean statusCode404 = false;

    /*
    1. Open the site
    2. Hover on the 1st user image
    3. Check the username
     */

    @Test
    public void firstUserName() {
        browser.get(hoverUrl);
        Actions action = new Actions(browser);
        WebElement firstUserIcon = browser.findElement(By.xpath("(//div[@class='figure'])[1]"));
        action.moveToElement(firstUserIcon).perform();
        WebElement userName = browser.findElement(By.xpath("(//h5)[1]"));
        boolean isUserNameDisplayed = userName.isDisplayed();
        if (isUserNameDisplayed) {
            onlyName = gettingOnlyName(userName);
        } else throw new AssertionError("There is no user name, or hover hasn't been worked");
        assertEquals(onlyName, "user1", "The 1st user has another name --> " + onlyName);
    }

    /*
    1. Open the site
    2. Hover on the 1st user image
    3. Click on 'View profile' button
    4. Check that user profile page is opened and there is no 'Not Found' message
     */

    @Test
    public void redirectionToThe1stUserProfile() {
        browser.get(hoverUrl);
        Actions action = new Actions(browser);
        WebElement firstUserIcon = browser.findElement(By.xpath("(//div[@class='figure'])[1]"));
        action.moveToElement(firstUserIcon).perform();
        WebElement userName = browser.findElement(By.xpath("(//h5)[1]"));
        boolean isUserNameDisplayed = userName.isDisplayed();
        if (isUserNameDisplayed) {
            onlyName = gettingOnlyName(userName);
        } else throw new AssertionError("There is no user name, or hover hasn't been worked");
        WebElement userProfileLink = browser.findElement(By.xpath("(//a[contains(text(), 'View profile')])[1]"));
        userProfileLink.click();
        if ((browser.findElement(By.xpath("//h1")).getText()).equals("Not Found")) {
            statusCode404 = true;
            throw new AssertionError("404: Page not found");
        }
        assertFalse(statusCode404, "404: Page not found");
    }

    /*
    1. Send request for getting user profile page
    2. Check the response status code
     */

    @Test
    public void checkStatusCodeFor1stUserProfile() {
        int statusCode = gettingStatusCode(requestFor1stUserProfile);
        assertEquals(statusCode, 200, "Response for getting 1st user profile has another status --> " + statusCode);
    }

    /*
    1. Open the site
    2. Hover on the 2nd user image
    3. Check the username
     */

    @Test
    public void secondUserName() {
        browser.get(hoverUrl);
        Actions action = new Actions(browser);
        WebElement firstUserIcon = browser.findElement(By.xpath("(//div[@class='figure'])[2]"));
        action.moveToElement(firstUserIcon).perform();
        WebElement userName = browser.findElement(By.xpath("(//h5)[2]"));
        boolean isUserNameDisplayed = userName.isDisplayed();
        if (isUserNameDisplayed) {
            onlyName = gettingOnlyName(userName);
        } else throw new AssertionError("There is no user name, or hover hasn't been worked");
        assertEquals(onlyName, "user2", "The 2nd user has another name --> " + onlyName);
    }

    /*
    1. Open the site
    2. Hover on the 2nd user image
    3. Click on 'View profile' button
    4. Check that user profile page is opened and there is no 'Not Found' message
     */

    @Test
    public void redirectionToThe2ndUserProfile() {
        browser.get(hoverUrl);
        Actions action = new Actions(browser);
        WebElement firstUserIcon = browser.findElement(By.xpath("(//div[@class='figure'])[2]"));
        action.moveToElement(firstUserIcon).perform();
        WebElement userName = browser.findElement(By.xpath("(//h5)[2]"));
        boolean isUserNameDisplayed = userName.isDisplayed();
        if (isUserNameDisplayed) {
            onlyName = gettingOnlyName(userName);
        } else throw new AssertionError("There is no user name, or hover hasn't been worked");
        WebElement userProfileLink = browser.findElement(By.xpath("(//a[contains(text(), 'View profile')])[2]"));
        userProfileLink.click();
        if ((browser.findElement(By.xpath("//h1")).getText()).equals("Not Found")) {
            statusCode404 = true;
            throw new AssertionError("404: Page not found");
        }
        assertFalse(statusCode404, "404: Page not found");
    }

    /*
    1. Send request for getting user profile page
    2. Check the response status code
     */

    @Test
    public void checkStatusCodeFor2ndUserProfile() {
        int statusCode = gettingStatusCode(requestFor2ndUserProfile);
        assertEquals(statusCode, 200, "Response for getting 2nd user profile has another status --> " + statusCode);
    }

    /*
    1. Open the site
    2. Hover on the 3rd user image
    3. Check the username
     */

    @Test
    public void thirdUserName() {
        browser.get(hoverUrl);
        Actions action = new Actions(browser);
        WebElement firstUserIcon = browser.findElement(By.xpath("(//div[@class='figure'])[3]"));
        action.moveToElement(firstUserIcon).perform();
        WebElement userName = browser.findElement(By.xpath("(//h5)[3]"));
        boolean isUserNameDisplayed = userName.isDisplayed();
        if (isUserNameDisplayed) {
            onlyName = gettingOnlyName(userName);
        } else throw new AssertionError("There is no user name, or hover hasn't been worked");
        assertEquals(onlyName, "user3", "The 3rd user has another name --> " + onlyName);
    }

    /*
    1. Open the site
    2. Hover on the 2nd user image
    3. Click on 'View profile' button
    4. Check that user profile page is opened and there is no 'Not Found' message
     */

    @Test
    public void redirectionToThe3rdUserProfile() {
        browser.get(hoverUrl);
        Actions action = new Actions(browser);
        WebElement firstUserIcon = browser.findElement(By.xpath("(//div[@class='figure'])[3]"));
        action.moveToElement(firstUserIcon).perform();
        WebElement userName = browser.findElement(By.xpath("(//h5)[3]"));
        boolean isUserNameDisplayed = userName.isDisplayed();
        if (isUserNameDisplayed) {
            onlyName = gettingOnlyName(userName);
        } else throw new AssertionError("There is no user name, or hover hasn't been worked");
        WebElement userProfileLink = browser.findElement(By.xpath("(//a[contains(text(), 'View profile')])[3]"));
        userProfileLink.click();
        if ((browser.findElement(By.xpath("//h1")).getText()).equals("Not Found")) {
            statusCode404 = true;
            throw new AssertionError("404: Page not found");
        }
        assertFalse(statusCode404, "404: Page not found");
    }

    /*
    1. Send request for getting user profile page
    2. Check the response status code
     */

    @Test
    public void checkStatusCodeFor3rdUserProfile() {
        int statusCode = gettingStatusCode(requestFor3rdUserProfile);
        assertEquals(statusCode, 200, "Response for getting 3rd user profile has another status --> " + statusCode);
    }
}
