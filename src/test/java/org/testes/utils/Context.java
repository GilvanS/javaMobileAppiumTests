package org.testes.utils;

import org.testes.driver.actions.PageBaseActions;
import io.appium.java_client.AppiumDriver;

public class Context {

    private static final ThreadLocal<PageBaseActions> acoes = new ThreadLocal<>();
    private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static PageBaseActions acoes() {
        return acoes.get();
    }

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void inicializar(AppiumDriver appiumDriver) {
        driver.set(appiumDriver);
        acoes.set(new PageBaseActions(appiumDriver));
    }

    public static void tearDown() {
        driver.remove();
        acoes.remove();
    }
}
