package org.testes.utils;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Slf4j
public class AppiumDriverHelper {

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:appPackage", "com.fintechbank.app");
        capabilities.setCapability("appium:appActivity", "com.fintechbank.app.MainActivity");
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:deviceName", "emulator-5554");
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:noReset", false);
        return capabilities;
    }

    public static URL getURL() throws MalformedURLException, URISyntaxException {
        return new URI("http://127.0.0.1:4723/wd/hub").toURL();
    }

    public static AppiumDriver getDriver() {

        AppiumDriver driver = null;

        try {
            driver = new AppiumDriver(getURL(), getCapabilities());
        } catch (Exception e) {
//            log.error("Error on driver instantiation", e);
            System.out.println("Error on driver instantiation" + e);
            throw new RuntimeException(e);
        }

        return driver;

    }


}