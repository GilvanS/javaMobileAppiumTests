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
        capabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.rn");
        capabilities.setCapability("appium:appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:deviceName", "192.168.0.107:46759"); // S24+ RXCXB02B93D   motoG 0078720227
        capabilities.setCapability("appium:automationName", "uiautomator2");
        capabilities.setCapability("appium:noReset", false);
        return capabilities;

        //INFO:     -->   (tcpip)  192.168.0.106:5555     device  moto_g82_5G 0078720227
        //INFO:     -->   (usb)  RXCXB02B93D              device  SM_S926B
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