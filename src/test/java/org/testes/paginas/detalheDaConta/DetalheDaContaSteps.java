package org.testes.paginas.detalheDaConta;

import io.cucumber.java.en.When;

public class DetalheDaContaSteps {

	@When("visualiso o 'Valor' do saldo na tela 'Detalhe da conta'")
	public void visualisoOValorDoSaldoNaTelaDetalheDaConta() {
		DetalheDaContaActions.visualizarValorSaldoHoje();
	}

	@When("clico no botão 'Voltar' na tela 'Detalhe da conta'")
	public void clicoNoBotaoVoltarNaTelaDetalheDaConta() {
		DetalheDaContaActions.clicarBtnVoltar();
	}
}
