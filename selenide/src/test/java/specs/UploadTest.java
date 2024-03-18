package specs;

import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class UploadTest {
    @Test
    public void testUploadFile() {
        // open url
        open("https://practice-automation.com/file-upload/");

        // upload file
        $("#file-upload").uploadFile(new File("src/test/java/data/teste.jpg"));

        // click the upload button
        $("#upload-btn").click();
    }
}
