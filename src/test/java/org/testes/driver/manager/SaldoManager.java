package org.testes.driver.manager;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class SaldoManager {

	private static final ThreadLocal<String> saldo = new ThreadLocal<>();
	private static final ThreadLocal<String> saldoHoje = new ThreadLocal<>();
	private static final ThreadLocal<String> valorRegistro = new ThreadLocal<>();

	public static String getSaldo() {
		return saldo.get();
	}

	public static String getSaldoHoje() {
		return saldoHoje.get();
	}

	public static String getValorRegistro() {
		return valorRegistro.get();
	}

	public static void setSaldo(String valor) {
		saldo.set(valor);
	}

	public static void setSaldoHoje(String valor) {
		saldoHoje.set(valor);
	}

	public static void setValorRegistro(String valor) {
		valorRegistro.set(valor);
	}

	/**
	 * Converte valor monetário brasileiro para double
	 * @param valorMonetario Valor no formato "R$ 1.234,56"
	 * @return Valor como double
	 */
	public static double converterParaDouble(String valorMonetario) {
		try {
			// Remove "R$ " e espaços
			String valorLimpo = valorMonetario.replace("R$", "").trim();
			
			// Converte para double usando NumberFormat brasileiro
			NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
			return format.parse(valorLimpo).doubleValue();
		} catch (ParseException e) {
			throw new RuntimeException("Erro ao converter valor monetário: " + valorMonetario, e);
		}
	}

	/**
	 * Converte double para formato monetário brasileiro
	 * @param valor Valor como double
	 * @return Valor no formato "R$ 1.234,56"
	 */
	public static String converterParaMonetario(double valor) {
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return format.format(valor);
	}

	/**
	 * Calcula o saldo esperado após adicionar o valor do registro
	 * @return Saldo esperado no formato monetário
	 */
	public static String calcularSaldoEsperado() {
		double saldoAtual = converterParaDouble(getSaldo());
		double valorRegistro = converterParaDouble(getValorRegistro());
		double saldoEsperado = saldoAtual + valorRegistro;
		return converterParaMonetario(saldoEsperado);
	}

	public static void remove() {
		saldo.remove();
		saldoHoje.remove();
		valorRegistro.remove();
	}
}
