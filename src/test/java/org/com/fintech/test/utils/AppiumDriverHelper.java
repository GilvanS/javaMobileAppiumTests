package org.com.fintech.test.utils;

import io.appium.java_client.AppiumDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Slf4j
public class AppiumDriverHelper {

    private static AppiumDriver driver;

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
        return new URI("http://127.0.0.1:4723/").toURL();
    }

    public static AppiumDriver getDriver() {
        // Verifica se o driver existe e ainda está válido (não foi fechado)
        if (driver == null || isDriverClosed(driver)) {
            try {
                driver = new AppiumDriver(getURL(), getCapabilities());
            } catch (Exception e) {
                System.out.println("Error on driver instantiation" + e);
                throw new RuntimeException(e);
            }
        }
        return driver;
    }

    /**
     * Verifica se o driver foi fechado tentando acessar uma propriedade básica.
     */
    private static boolean isDriverClosed(AppiumDriver driver) {
        try {
            // Tenta acessar uma propriedade básica do driver. Se foi fechado, lançará exceção
            driver.getCapabilities();
            return false;
        } catch (Exception e) {
            // Se houver exceção, o driver foi fechado
            return true;
        }
    }

    /**
     * Limpa a referência estática do driver.
     * Deve ser chamado após fechar o driver para garantir que um novo será criado no próximo teste.
     */
    public static void reset() {
        driver = null;
    }
}