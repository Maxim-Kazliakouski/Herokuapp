import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class IFrameTest extends BaseTest {

    @Test(description = "check the text in iFrame, the text should be 'Your content goes here.'")
    public void textInIFrame(){
        open("https://the-internet.herokuapp.com/iframe");
        browser.switchTo().frame("mce_0_ifr");
        String innerText = browser.findElement(By.xpath("//body[@id='tinymce']//p[1]")).getText();
        assertEquals(innerText, "Your content goes here.", "There is another message in the iFrame");
    }
}
