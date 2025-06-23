package org.testes.utils;

import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.paginas.login.LoginPage;

public class Context {

	private static final ThreadLocal<PageBaseActions> acoes = new ThreadLocal<PageBaseActions>();
	private static final ThreadLocal<LoginPage> loginPage = new ThreadLocal<LoginPage>();

	public static PageBaseActions acoes() {
		return acoes.get();
	}

	public static LoginPage loginPage() {
		return loginPage.get();
	}

	public static void remove() {
		acoes.remove();
		loginPage.remove();
	}
}
