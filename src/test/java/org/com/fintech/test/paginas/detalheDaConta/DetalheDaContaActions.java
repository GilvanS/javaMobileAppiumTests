package org.com.fintech.test.paginas.detalheDaConta;

import lombok.extern.slf4j.Slf4j;
import org.com.fintech.test.manager.SaldoManager;
import org.com.fintech.core.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.com.fintech.core.support.Context.acoes;

@Slf4j
public class DetalheDaContaActions {

	public static DetalheDaContaPage detalheDaContaPage() {
		return MasterPageFactory.getPage(DetalheDaContaPage.class);
	}

	public static void visualizarValorSaldoHoje() {
		log.info("visualiso o 'valor do saldo' na tela 'Detalhe da conta'");
		acoes().waitForVisibility(detalheDaContaPage().getValorSaldoHoje());
		String valorSaldoHoje = detalheDaContaPage().getValorSaldoHoje().getText();
		SaldoManager.setSaldo(valorSaldoHoje);
		log.info("Valor do saldo {}", valorSaldoHoje);
	}

	/**
	 * Captura o valor do saldo atual sem sobrescrever o saldo anterior
	 */
	public static String capturarSaldoAtual() {
		log.info("capturando valor do saldo atual na tela 'Detalhe da conta'");
		acoes().waitForVisibility(detalheDaContaPage().getValorSaldoHoje());
		String valorSaldoHoje = detalheDaContaPage().getValorSaldoHoje().getText();
		log.info("Saldo atual capturado: {}", valorSaldoHoje);
		return valorSaldoHoje;
	}

	public static void validarSaldoAposRegistro() {
		log.info("valido o valor na tela 'Detalhe da conta'");
		
		// Capturar saldo atual sem sobrescrever o anterior
		String saldoAtual = capturarSaldoAtual();
		log.info("Saldo atual na tela: {}", saldoAtual);

		// Obter saldo anterior e valor digitado
		String saldoAnterior = SaldoManager.getSaldo();
		String valorDigitado = SaldoManager.getValorRegistro();
		
		log.info("Saldo anterior: {}", saldoAnterior);
		log.info("Valor digitado: {}", valorDigitado);

		// Normalizar valores para comparação
		String saldoAtualNormalizado = SaldoManager.normalizarValorMonetario(saldoAtual);
		String saldoAnteriorNormalizado = SaldoManager.normalizarValorMonetario(saldoAnterior);
		String valorDigitadoNormalizado = SaldoManager.normalizarValorMonetario(valorDigitado);
		
		log.info("Saldo atual normalizado: {}", saldoAtualNormalizado);
		log.info("Saldo anterior normalizado: {}", saldoAnteriorNormalizado);
		log.info("Valor digitado normalizado: {}", valorDigitadoNormalizado);

		// Converter para double para cálculo
		double saldoAtualDouble = SaldoManager.converterParaDouble(saldoAtual);
		double saldoAnteriorDouble = SaldoManager.converterParaDouble(saldoAnterior);
		double valorDigitadoDouble = SaldoManager.converterParaDouble(valorDigitado);

		// Calcular diferença
		double diferenca = saldoAtualDouble - saldoAnteriorDouble;
		
		log.info("Calculo: {} - {} = {}", saldoAtualDouble, saldoAnteriorDouble, diferenca);
		
		// Validar se a diferença é igual ao valor digitado
		assertEquals(valorDigitadoDouble, diferenca, 0.01, 
			"A diferença entre o saldo atual e anterior deve ser igual ao valor digitado");
		
		log.info("Validacao do saldo: SUCESSO - Diferenca de R$ %.2f confere com valor digitado R$ %.2f", 
			diferenca, valorDigitadoDouble);
	}

	public static void clicarBtnVoltar() {
		log.info("clico no botão 'Voltar' na tela 'Detalhe da conta'");
		acoes().click(detalheDaContaPage().getBtnVoltar());
	}
}
