package alerts;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("C:\\Users\\maria\\Desktop\\webdriver_java\\resources\\chromedriver.exe");  //trying with uploading webdriver file
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver.exe", "Uploaded file not found");
    }
}
