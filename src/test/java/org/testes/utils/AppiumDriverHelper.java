package org.testes.utils;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class AppiumDriverHelper {

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:appPackage", "com.droid4you.application.wallet");
        capabilities.setCapability("appium:appActivity", "com.droid4you.application.wallet.SplashScreenActivity");
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:deviceName", "0078720227"); // S24+ RXCXB02B93D   motoG 0078720227
        capabilities.setCapability("appium:automationName", "uiautomator2");   // 192.168.16.89:5555
        capabilities.setCapability("appium:noReset", false);
        return capabilities;
    }

    public static URL getURL() throws MalformedURLException {
        return new URL("http://127.0.0.1:4723/");
    }

    public static AppiumDriver getDriver() {

        AppiumDriver driver = null;

        try {
            driver = new AppiumDriver(getURL(), getCapabilities());
        } catch (Exception e) {
            log.error("Error on driver instantiation", e);
            throw new RuntimeException(e);
        }

        return driver;

    }


}