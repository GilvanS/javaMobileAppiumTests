package org.testes.paginas.detalheDaConta;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.manager.SaldoManager;
import org.testes.driver.page.MasterPageFactory;

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

	public static void clicarBtnVoltar() {
		log.info("clico no botão 'Voltar' na tela 'Detalhe da conta'");
		acoes().click(detalheDaContaPage().getBtnVoltar());
	}
}
