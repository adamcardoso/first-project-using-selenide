package specs;

import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormTest {
    @Test
    public void testFormFields() {
        // open url
        open("https://practice-automation.com/form-fields/");

        // fill in all the fields
        // input name
        $("input#name").val("Luffy");

        // checkboxes
        $("#feedbackForm > label:nth-child(9)").click();
        $("#feedbackForm > label:nth-child(27)").click();

        // dropdown
        $("#siblings").selectOption("Maybe");

        // inputs
        $("input#email").val("teste@gmail.com");
        $("textarea#message").val("Hello world!");

        // button
        $("#submit-btn").click();
    }
}
