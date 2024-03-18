package page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.testng.Assert.assertTrue;

public class HomePage {

    public HomePage open(){
        Selenide.open("https://selenide.org/quick-start.html"); // abre e fecha o navegador
        return this;
    }

    public SelenideElement getStartedBtn(){
        return $(By.id("selenide-logo"));
    }

    public SelenideElement headingTitle(){
        return $("h3");
    }

    public SelenideElement logoLink(){
        return $(By.xpath("//a[@id=\"selenide-logo\"]"));
    }

    public ElementsCollection linksList(){
        return $$("body > div.head > div > header > div > div.main-menu-pages > a");
    }

    public void assertUrlMatches(String expectedUrl){
        String url = WebDriverRunner.url();
        assertTrue(url.contains(expectedUrl));
    }
}
