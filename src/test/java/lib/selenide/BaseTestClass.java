package lib.selenide;

import com.codeborne.selenide.*;
import lib.selenide.providers.AndroidDriverProvider;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.source;
import static lib.selenide.AppiumBy.byTextApp;
import static org.junit.Assert.assertEquals;

public class BaseTestClass {

    @Before
    public void setUp() {
        Configuration.startMaximized = false;
        //Configuration.captureJavascriptErrors = false;
        Configuration.savePageSource = false;
        Configuration.screenshots = false;
        Configuration.fastSetValue = false;
        Configuration.holdBrowserOpen = true;

        Configuration.browser = AndroidDriverProvider.class.getName();
        //Configuration.browser = IOSDriverProvider.class.getName();
    }

    @Test
    public void testCompareArticleTitle() {
        $(byTextApp("Search Wikipedia"))
                .shouldBe(visible).click();
        $(By.id("org.wikipedia:id/search_src_text"))
                .should(appear)
                .sendKeys("Selenium");

        SelenideElement searchResult = $(By.id("org.wikipedia:id/search_results_list")).should(appear);

        searchResult
                .$$(By.id("org.wikipedia:id/page_list_item_container"))
                .shouldHave(sizeGreaterThan(0));

        searchResult.$(byTextApp("Testing framework for web applications"))
                .should(appear)
                .click();

        //searchPageObject.initSearchInput();
        //searchPageObject.typeSearchInput("Selenium");
        //searchPageObject.clickByArticleWithSubstring("Testing framework for web applications");

        //ArticlePageObject articlePageObject = ArticlePageObjectFactory.get(driver);
        //String articleTitle = articlePageObject.getArticleTitle();

        //assertEquals("Element text is not expected!", "Java (programming language)", articleTitle);
    }


}
