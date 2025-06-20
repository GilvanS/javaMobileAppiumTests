package org.br.com.mobile.appium_driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.br.com.api.utils.LogFormatter;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Slf4j
public class AppiumDriverHelper {
    private static final int IMPLICIT_WAIT = 10;

    public static DesiredCapabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:platformName", "android");
        capabilities.setCapability("appium:appPackage", "br.com.digio.homol");
        capabilities.setCapability("appium:appActivity", "br.com.digio.newarchitecture.ui.splash.activity.SplashActivity");
        capabilities.setCapability("appium:autoGrantPermissions", true);
        capabilities.setCapability("appium:udid", "192.168.0.106:5555");
        capabilities.setCapability("appium:automationName", "uiautomator2");

        return capabilities;

        // MotoG85 Wifi = 192.168.0.106:5555
        // MotoG85local = 0078720227
    }

    public static URL getURL() throws MalformedURLException {
        return new URL("http://127.0.0.1:4723/");
    }

    public static AppiumDriver getDriver() {
        try {
            DesiredCapabilities capabilities = getCapabilities();
            AndroidDriver driver = new AndroidDriver(getURL(), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
            LogFormatter.logStep("Driver inicializado com sucesso");
            return driver;
        } catch (Exception e) {
            LogFormatter.logStep("Erro ao inicializar o driver");
            throw new RuntimeException(e);
        }
    }
}