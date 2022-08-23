import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NotificationTest extends BaseTest {
    String notificationUrl = "https://the-internet.herokuapp.com/notification_message_rendered";

    /*
    1. Open the site
    2. Click on 'Click here' button
    3. Check, there should be alert message 'Action successful'
     */

    @Test
    public void messageText() {
        browser.get(notificationUrl);
        WebElement clickHereButton = browser.findElement(By.xpath("//a[contains(text(),'Click here')]"));
        clickHereButton.click();
        WebElement alert = browser.findElement(By.id("flash"));
        String alertText = alert.getText().replace("×", "").trim();
        assertEquals(alertText, "Action successful", "There is another alert message --> "
                + alertText);
    }
}
