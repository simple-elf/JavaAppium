package lib.selenide;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Quotes;

public class AppiumBy {
    private static final String NORMALIZE_SPACE_XPATH = "normalize-space(translate(string(.), '\t\n\r\u00a0', '    '))";

    public AppiumBy() {
    }

    public static By byTextApp(String elementText) {
        return new AppiumBy.ByTextApp(elementText);
    }

    public static class ByTextApp extends By.ByXPath {
        protected final String elementText;

        public ByTextApp(String elementText) {
            super(".//*/@text[" + NORMALIZE_SPACE_XPATH + " = " + Quotes.escape(elementText) + "]/parent::*");
            this.elementText = elementText;
        }

        public String toString() {
            return "by @text: " + this.elementText;
        }

        String getXPath() {
            return super.toString().replace("By.xpath: ", "");
        }
    }

}
