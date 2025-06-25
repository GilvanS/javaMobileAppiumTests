package org.testes.paginas.passagens;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PassagensSteps {


	@Given("clicar no botão Só ida na tela Passagens")
	public void clicarNoBotaoSoIdaNaTelaPassagens() {
		PassagensActions.clicarBtnSoIda();
	}

	@And("seleciono a data no campo Escolha a data na tela Passagens")
	public void selecionoADataNoCampoEscolhaADataNaTelaPassagens() {
		PassagensActions.selecionarDataIda();
	}

	@Given("clicar no botão Aplicar na tela Passagens")
	public void clicarNoBotaoAplicarNaTelaPassagens() {
		PassagensActions.clicarLblEscolhaDeIda();
		PassagensActions.clicarBtnEscolhaDeIda();
	}

	@When("clicar no botão Buscar na tela Passagens")
	public void clicarNoBotaoBuscarNaTelaPassagens() {
	}

	@When("clicar no primeiro botão Selecionar voo na tela Buscar passagens")
	public void clicarNoPrimeiroBotaoSelecionarVooNaTelaBuscarPassagens() {
	}

}
