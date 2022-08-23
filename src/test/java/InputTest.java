import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class InputTest extends BaseTest {
//  test data
    String inputsUrl = "https://the-internet.herokuapp.com/inputs";
    String integers = "123456";
    String chars = "ABCdef";
    String symbols = "!@#$%^&*()";
    int amountOfClick = 3;

    /*
    1. Open the site
    2. Enter integer values into input field
    3. Check that integer values has been entered
     */

    @Test
    public void inputInt() {
        browser.get(inputsUrl);
        WebElement input = browser.findElement(By.xpath("//input[@type='number']"));
        input.sendKeys(integers);
        assertEquals(input.getAttribute("value"), integers, "Input field doesn't accept int values!");
    }

    /*
    1. Open the site
    2. Enter char values into input field
    3. Check that char values hasn't been entered
     */

    @Test
    public void inputChars() {
        browser.get(inputsUrl);
        WebElement input = browser.findElement(By.xpath("//input[@type='number']"));
        input.sendKeys(chars);
        assertEquals(input.getAttribute("value"), "", "Error! Input field accept char values!");
    }

    /*
    1. Open the site
    2. Enter symbol values into input field
    3. Check that symbol values hasn't been entered
     */

    @Test
    public void inputSymbols() {
        browser.get(inputsUrl);
        WebElement input = browser.findElement(By.xpath("//input[@type='number']"));
        input.sendKeys(symbols);
        assertEquals(input.getAttribute("value"), "", "Error! Input field accept symbols!");
    }

    /*
    1. Open the site
    2. Via keyboard button ARROW_UP enter integer values
    3. Check that integer values has been entered into input field
     */

    @Test
    public void inputIntegersWithUseOfKeyboardButtonArrowUp() {
        browser.get(inputsUrl);
        WebElement input = browser.findElement(By.xpath("//input[@type='number']"));
        clickOnArrowUpButton(amountOfClick, input);
        assertEquals(input.getAttribute("value"), String.valueOf(amountOfClick), "Error! Input field accept symbols!");
    }

    /*
    1. Open the site
    2. Via keyboard button ARROW_DOWN enter integer values
    3. Check that integer values has been entered into input field
     */

    @Test
    public void inputIntegersWithUseOfKeyboardButtonArrowDown() {
        browser.get(inputsUrl);
        WebElement input = browser.findElement(By.xpath("//input[@type='number']"));
        clickOnArrowDownButton(amountOfClick, input);
        assertEquals(input.getAttribute("value"), "-" + amountOfClick, "Error! Input field accept symbols!");
    }
}
