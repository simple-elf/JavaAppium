package lib.selenide.providers;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class PlatformCapabilities {

    private static String macosPath = "/Users/simple1elf/JavaAppium/apks/";
    private static String windowsPath = "C:\\Users\\simpl\\IdeaProjects\\JavaAppiumAutomation\\apks\\";

    public static DesiredCapabilities getAndroidDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        //capabilities.setCapability("version", "4.4.2");
        //capabilities.setCapability("automationName", "Appium");
        //capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("deviceName", "0123456789ABCDEF");
        //capabilities.setCapability("appPackage", "com.android.calculator2");
        //capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        capabilities.setCapability("version", "4.4.2");

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","6.0");
        capabilities.setCapability("deviceName","AndroidTestDevice");

        capabilities.setCapability("automationName","appium");
        capabilities.setCapability("appPackage","org.wikipedia");
        capabilities.setCapability("appActivity",".main.MainActivity");

        //for Windows
        //capabilities.setCapability("app", windowsPath + "org.wikipedia.apk");
        capabilities.setCapability("app", macosPath + "org.wikipedia.apk"); //for MacOs

        return capabilities;
    }

    public static DesiredCapabilities getIOSDesiredCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "12.1");
        capabilities.setCapability("deviceName", "iPhone 5s");
        capabilities.setCapability("automationName", "XCUITest"); //xcode 10.1

        capabilities.setCapability("app", macosPath + "Wikipedia.app");

        return capabilities;
    }

    public static URL getAppiumUrl() {
        URL hostURL = null;
        try {
            hostURL = new URL(System.getProperty("appium.url", "http://127.0.0.1:4723/wd/hub"));
        } catch (MalformedURLException e) {
            //e.printStackTrace();
        }
        return hostURL;
    }

}
