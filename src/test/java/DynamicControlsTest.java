import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DynamicControlsTest extends BaseTest {
    String DYNAMIC_CONTROLS_URL = "https://the-internet.herokuapp.com/dynamic_controls";

    @Test(description = "Check text 'It's gone' and checkbox disappearing")
    public void checkTextItIsGone() {
        browser.get(DYNAMIC_CONTROLS_URL);
        WebElement checkbox = browser.findElement(By.id("checkbox"));
        checkbox.click();
        browser.findElement(By.xpath("//button[text()='Remove']")).click();
        assertTrue(waitForVisibility(By.id("message")), "Text <<It's gone>> wasn't appeared!");
        assertFalse(waitForVisibility(By.id("checkbox")), "The checkbox still visible at the page!");
    }

    @Test(description = "Check text 'It's enabled' and input field is enabled")
    public void checkTextItsEnabled() {
        browser.get(DYNAMIC_CONTROLS_URL);
        WebElement input = browser.findElement(By.cssSelector("[type='text']"));
        assertFalse(input.isEnabled(), "Input field has already enabled without clicking on 'Enable' button");
        browser.findElement(By.xpath("//button[text()='Enable']")).click();
        assertTrue(waitForElementClickable(By.id("message")), "There is no message 'It's enabled' after clicking on 'Enable' button");
        assertTrue(waitForElementClickable(By.cssSelector("[type='text']")), "Input isn't enable!");
    }
}
