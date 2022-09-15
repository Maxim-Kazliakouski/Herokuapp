import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static java.lang.String.format;

import java.io.IOException;

import static org.testng.Assert.*;

public class FileUploadDownloadTest extends BaseTest {

    @Test(description = "uploading file")
    public void uploadFile() {
        String fileName = "upload_file.txt";
        open("https://the-internet.herokuapp.com/upload");
        uploadFile(By.id("file-upload"), fileName);
        clickUpload();
        assertTrue(waitForVisibility(By.id("uploaded-files")), "There is no info about uploaded file!");
        assertEquals(getUploadedFileName(), fileName, "The uploaded file name is different from loaded test file!");
    }

    @Test(description = "download file")
    public void downloadFile() throws InterruptedException, IOException {
        String downloadedFileName = "file.txt";
        open("https://the-internet.herokuapp.com/download");
        WebElement url = browser.findElement(By.xpath(format("//a[@href='download/%s']", downloadedFileName)));
        url.click();
        Thread.sleep(5000);
        assertTrue(isFileDownloaded(downloadedFileName), "The name of downloaded file isn't matched!");
        deleteDownloadedFile(downloadedFileName);
    }
}
