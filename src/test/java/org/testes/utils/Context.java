package org.testes.utils;

import io.appium.java_client.AppiumDriver;
import org.testes.driver.actions.PageBaseActions;

public class Context {

	private static final ThreadLocal<PageBaseActions> acoes = new ThreadLocal<PageBaseActions>();
	private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

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

	public static void remove() {
		driver.remove();
		acoes.remove();
	}
}
