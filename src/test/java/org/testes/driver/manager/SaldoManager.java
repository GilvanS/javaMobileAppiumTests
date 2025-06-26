package org.testes.driver.manager;

public class SaldoManager {

	private static final ThreadLocal<String> saldo = new ThreadLocal<>();
	private static final ThreadLocal<String> saldoHoje = new ThreadLocal<>();



	public static String getSaldo() {
		return saldo.get();
	}

	public static String getSaldoHoje() {
		return saldoHoje.get();
	}

	public static void setSaldo(String valor) {
		saldo.set(valor);
	}

	public static void setSaldoHoje(String valor) {
		saldoHoje.set(valor);
	}

	public static void remove() {
		saldo.remove();
		saldoHoje.remove();
	}
}
