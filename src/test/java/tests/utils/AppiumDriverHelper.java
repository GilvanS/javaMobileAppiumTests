package tests.utils;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

@Slf4j
public class AppiumDriverHelper {

    public static final int PORTA = Hooks.gerarPortaAleatoria(); // Gera uma única vez

    public static DesiredCapabilities getCapabilities(){
        log.info("iniciando servidor http://127.0.0.1:" + PORTA);
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:appPackage", "com.saucelabs.mydemoapp.android");
        capabilities.setCapability("appium:appActivity", ".view.activities.SplashActivity");
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("deviceName", "RXCXB02B93D");
        capabilities.setCapability("appium:ignoreHiddenApiPolicyError", true);
        capabilities.setCapability("ensureWebviewsHavePages", true);
        capabilities.setCapability("newCommandTimeout", 3600);
        capabilities.setCapability("connectHardwareKeyboard", true);

        return capabilities;
    }

    public static URL getURL() throws MalformedURLException {
        return new URL("http://127.0.0.1:" + PORTA + "/wd/hub");
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
