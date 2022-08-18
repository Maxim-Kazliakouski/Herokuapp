import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DataTableTest extends BaseTest {
    String dataTable = "https://the-internet.herokuapp.com/tables";

    /*
    1. Open the site
    2. Check, that last name 'Smith' at the first column and at the first row in table;
     */

    @Test
    public void lastNameSmithAtTheFirstPlace() {
        browser.get(dataTable);
        String lastNameSmith = browser.findElement(By.xpath("//table//tr[1]//td[1]")).getText();
        assertEquals(lastNameSmith, "Smith", "There is no last name 'Smith' at the 1st place." +
                "\nFactically at the first place last name --> " + lastNameSmith);
    }

    /*
    1. Open the site
    2. Check, that first name 'Frank' at the second column and at the second row in table;
     */

    @Test
    public void firstNameFrankAtTheSecondPlace() {
        browser.get(dataTable);
        String firstNameFrank = browser.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
        assertEquals(firstNameFrank, "Frank", "There is no first name 'Frank' at the 2nd place." +
                "\nFactically at the second place first name --> " + firstNameFrank);
    }

    /*
    1. Open the site
    2. Check, that email 'jdoe@hotmail.com' at the third column and at the third row in table;
     */

    @Test
    public void emailAtTheThirdPlace() {
        browser.get(dataTable);
        String email = browser.findElement(By.xpath("//table//tr[3]//td[3]")).getText();
        assertEquals(email, "jdoe@hotmail.com", "There is no email 'jdoe@hotmail.com' at the 3rd place." +
                "\nFactically at the third place email --> " + email);
    }
}
