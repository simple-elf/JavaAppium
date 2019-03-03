package lib.selenide.providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static lib.selenide.providers.PlatformCapabilities.*;

public class IOSDriverProvider implements WebDriverProvider {

    public WebDriver createDriver(DesiredCapabilities capabilities) {
        return new IOSDriver(getAppiumUrl(), getIOSDesiredCapabilities());
    }

}
