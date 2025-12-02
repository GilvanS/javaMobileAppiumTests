package org.com.fintech.core.support;

import io.appium.java_client.AppiumDriver;
import org.com.fintech.core.data.DataModel;
import org.com.fintech.core.driver.actions.PageBaseActions;

public class Context {

	private static final ThreadLocal<PageBaseActions> acoes = new ThreadLocal<PageBaseActions>();
	private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();

	private static ThreadLocal<DataModel> data = new ThreadLocal<DataModel>();

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

	public static DataModel getData() {
		return data.get();
	}

	public static void setData(DataModel dataModel) {
		data.set(dataModel);
	}

	public static void remove() {
		driver.remove();
		acoes.remove();
		data.remove();
	}
}
