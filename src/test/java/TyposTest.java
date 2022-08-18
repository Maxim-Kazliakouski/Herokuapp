import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TyposTest extends BaseTest {
    String typoUrl = "https://the-internet.herokuapp.com/typos";
    String correctText = "Sometimes you'll see a typo, other times you won't.";

    /*
    1. Open the site
    2. Check the orthography of the last message
     */

    @Test
    public void checkTextForMistakes() {
        browser.get(typoUrl);
        String text = browser.findElement(By.xpath("//p[2]")).getText();
        assertEquals(text, correctText, "There is mistake, please check text:");
    }
}
