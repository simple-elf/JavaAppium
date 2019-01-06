package lib;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileElement;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.WelcomePageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import lib.ui.providers.AndroidDriverProvider;
import lib.ui.providers.IOSDriverProvider;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;

public class BaseTestClass {

    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        Configuration.captureJavascriptErrors = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.holdBrowserOpen = true;

        Configuration.browser = AndroidDriverProvider.class.getName();
        //Configuration.browser = IOSDriverProvider.class.getName();
    }

    @Test
    public void testCompareArticleTitle() {
        //SearchPageObject searchPageObject = SearchPageObjectFactory.get(driver);
        sleep(5000);

        //By by = By.xpath("//*[contains(@text, 'Search Wikipedia')]");
        By by = By.xpath("//android.widget.TextView");
        //By by = By.xpath("//XCUIElementTypeSearchField[@name='Search Wikipedia']"); //By.id("Search Wikipedia");
        //By by = By.id("Skip");

        //MobileElement search1 = (MobileElement) getWebDriver().findElement(by);
        //System.out.println(search1.isDisplayed());

        SelenideElement searchInput = $(by);
        System.out.println(searchInput.isDisplayed());

        searchInput
                //.waitUntil(appear, 10000)
                .should(appear)
                .shouldBe(visible)
                .click();

        //searchPageObject.initSearchInput();
        //searchPageObject.typeSearchInput("Selenium");
        //searchPageObject.clickByArticleWithSubstring("Testing framework for web applications");

        //ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        //String articleTitle = articlePageObject.getArticleTitle();

        //assertEquals("Element text is not expected!", "Java (programming language)", articleTitle);
    }


}
