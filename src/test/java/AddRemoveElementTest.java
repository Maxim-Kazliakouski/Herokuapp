import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class AddRemoveElementTest extends BaseTest {
    String url = "https://the-internet.herokuapp.com/add_remove_elements/";

    /*
    1. Open the site
    2. Find the 'Add element' button and click on it
    3. Repeat 2nd step
    4. Check that 2 new 'Delete' buttons appear
     */
    @Test
    public void addElement() {
        browser.get(url);
        browser.findElement(By.xpath("//button[@onclick]")).click();
        browser.findElement(By.xpath("//button[@onclick]")).click();
        List<WebElement> list = browser.findElements(By.className("added-manually"));
        int amountOfButtons = list.size();
        assertEquals(amountOfButtons, 2, "The amount of elements is wrong!");
    }

    /*
    1. Open the site
    2. Find the 'Add element' button and click on it
    3. Repeat 2nd step
    4. Check that 2 new 'Delete' buttons appear
    5. Click on one of the 'Delete' button
     */
    @Test
    public void removeElement() {
        browser.get(url);
        browser.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        browser.findElement(By.xpath("//button[@onclick='addElement()']")).click();
        browser.findElement(By.xpath("(//button[@onclick='deleteElement()'])[1]")).click();
        List<WebElement> list = browser.findElements(By.className("added-manually"));
        int amountOfButtons = list.size();
        assertEquals(amountOfButtons, 1, "The amount of 'Delete' buttons is wrong, should be 2, tactically --> " + amountOfButtons);
    }
}