package org.testes.paginas.detalheDaConta;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.manager.SaldoManager;
import org.testes.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.testes.utils.Context.acoes;

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

	public static void validarSaldoAposRegistro() {
		log.info("valido o valor na tela 'Detalhe da conta'");
		
		// Aguardar visibilidade do elemento de saldo
		acoes().waitForVisibility(detalheDaContaPage().getValorSaldoHoje());
		
		// Capturar o saldo atual
		String saldoAtual = detalheDaContaPage().getValorSaldoHoje().getText();
		log.info("Saldo atual na tela: {}", saldoAtual);
		
		// Calcular o saldo esperado
		String saldoEsperado = SaldoManager.calcularSaldoEsperado();
		log.info("Saldo esperado: {}", saldoEsperado);
		
		// Validar se os valores são iguais
		assertEquals(saldoEsperado, saldoAtual, "O saldo deve ser igual ao valor esperado após o registro");
		log.info("Validacao do saldo: SUCESSO - Valores conferem");
	}

	public static void clicarBtnVoltar() {
		log.info("clico no botão 'Voltar' na tela 'Detalhe da conta'");
		acoes().click(detalheDaContaPage().getBtnVoltar());
	}
}
