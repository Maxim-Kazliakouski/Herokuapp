import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class DropdownTest extends BaseTest {
    String dropdownUrl = "https://the-internet.herokuapp.com/dropdown";
    ArrayList<String> optionListTestData = new ArrayList<>(Arrays.asList("Option 1", "Option 2"));

    /*
    1. Open the site
    2. Get all options from dropdown list
    3. Compare with test list
     */

    @Test
    public void dropdownList() {
        browser.get(dropdownUrl);
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select dropdownList = new Select(dropdown);
        List<WebElement> allOptionList = dropdownList.getOptions();
        List<String> optionList = new ArrayList<>();
        for (WebElement eachOption : allOptionList) {
            if (!eachOption.getText().equals("Please select an option")) {
                optionList.add(eachOption.getText());
            }
        }
        assertEquals(optionList, optionListTestData, "The actual list is differ from test data!\n" +
                "Actual list is --> " + optionList + "\nTest data list is --> " + optionListTestData + "\nResult ");
    }

    /*
    1. Open the site
    2. Select 1st option from dropdown
    3. Check that 1st option is selected
     */

    @Test
    public void select1stOptionFromDropdown() {
        browser.get(dropdownUrl);
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select dropdownList = new Select(dropdown);
        dropdownList.selectByVisibleText("Option 1");
        String firstSelectedOption = dropdownList.getFirstSelectedOption().getText();
        assertEquals(firstSelectedOption, "Option 1", "The 1st option hasn't been selected");
    }

    /*
    1. Open the site
    2. Select 2nd option from dropdown
    3. Check that 2nd option is selected
     */

    @Test
    public void select2ndOptionFromDropdown() {
        browser.get(dropdownUrl);
        WebElement dropdown = browser.findElement(By.id("dropdown"));
        Select dropdownList = new Select(dropdown);
        dropdownList.selectByVisibleText("Option 2");
        String firstSelectedOption = dropdownList.getFirstSelectedOption().getText();
        assertEquals(firstSelectedOption, "Option 2", "The 2nd option hasn't been selected");
    }
}
