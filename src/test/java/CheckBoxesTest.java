import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckBoxesTest extends BaseTest {
    String checkBoxUrl = "https://the-internet.herokuapp.com/checkboxes";

    /*
    1. Open the site
    2. Check that 1st checkbox is unselected
     */
    @Test
    public void firstCheckboxUnchecked() {
        browser.get(checkBoxUrl);
        WebElement checkbox1st = browser.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));
        boolean isChecked = checkbox1st.isSelected();
        assertFalse(isChecked, "The 1st checkbox is already selected!");
    }

    /*
    1. Open the site
    2. Select the 1st checkbox
    3. Check that 1st checkbox is selected
     */
    @Test
    public void firstCheckboxChecked() {
        browser.get(checkBoxUrl);
        WebElement checkbox1st = browser.findElement(By.cssSelector("[type=checkbox]:nth-child(1)"));
        checkbox1st.click();
        boolean isChecked = checkbox1st.isSelected();
        assertTrue(isChecked, "The 1st checkbox isn't selected!");
    }

    /*
    1. Open the site
    2. Check that 2nd checkbox is selected
    */
    @Test
    public void secondCheckboxChecked() {
        browser.get(checkBoxUrl);
        WebElement checkbox2nd = browser.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
        boolean isChecked = checkbox2nd.isSelected();
        assertTrue(isChecked, "The 2nd checkbox isn't selected!");
    }

    /*
    1. Open the site
    2. Click on 2nd checkbox (unselect)
    3. Check that 2nd checkbox is unselected
    */
    @Test
    public void secondCheckboxUnchecked() {
        browser.get(checkBoxUrl);
        WebElement checkbox2nd = browser.findElement(By.cssSelector("[type=checkbox]:nth-child(3)"));
        checkbox2nd.click();
        boolean isChecked = checkbox2nd.isSelected();
        assertFalse(isChecked, "The 2nd checkbox is already selected!");
    }
}
