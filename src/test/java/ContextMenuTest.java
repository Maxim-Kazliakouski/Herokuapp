import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {
    String CONTEXT_MENU_URL = "https://the-internet.herokuapp.com/context_menu";

    @Test
    public void contextMenu() {
        String testAlertMessage = "You selected a context menu";
        browser.get(CONTEXT_MENU_URL);
        WebElement box = browser.findElement(By.id("hot-spot"));
        Actions actions = new Actions(browser);
        actions.contextClick(box);
        actions.perform();
        String alertMessage = browser.switchTo().alert().getText();
        browser.switchTo().alert().accept();
        assertEquals(alertMessage, testAlertMessage, "Alert message is differ from test data!");
    }
}
