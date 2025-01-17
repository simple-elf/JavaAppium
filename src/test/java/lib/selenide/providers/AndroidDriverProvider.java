package lib.selenide.providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static lib.selenide.providers.PlatformCapabilities.*;

public class AndroidDriverProvider implements WebDriverProvider {

    public WebDriver createDriver(DesiredCapabilities capabilities) {
        return new AndroidDriver(getAppiumUrl(), getAndroidDesiredCapabilities());
    }

}
