package specs;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;
import page.HomePage;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.title;
import static org.testng.Assert.assertEquals;

public class HomeTest{

    HomePage homePage = new HomePage();

    @Test
    public void testPageUrlAndTitle() {
        // Open page url
        homePage.open();

        // Assert the url matches
        homePage.assertUrlMatches("https://selenide.org/quick-start.html");

        // Assert the title matches
        String title = title();
        assertEquals(title, "Quick Start");
    }

    @Test
    public void testInteractingWithElements() {
        // Open page url
        homePage.open();

        // By id
        homePage.getStartedBtn().click();

        // Verify the url contains
        homePage.assertUrlMatches("https://selenide.org/index.html");

        // Verify by CssSelector
        homePage.headingTitle().shouldHave(text("What is Selenide?"));

        // Verify by XPath
        homePage.logoLink().shouldBe(visible);
    }

    @Test
    public void testMultipleElements() {
        // Open page url
        homePage
                .open()
                .assertUrlMatches("https://selenide.org/quick-start.html");

        List<String> expectedLinks = List.of("Quick start", "Docs", "FAQ", "Blog", "Javadoc", "Users", "Quotes");

        // Corrected CSS selector to target individual links
        ElementsCollection linkLists = homePage.linksList();

        // Verify the texts of the elements
        linkLists.shouldHave(CollectionCondition.texts(expectedLinks));
    }

}
