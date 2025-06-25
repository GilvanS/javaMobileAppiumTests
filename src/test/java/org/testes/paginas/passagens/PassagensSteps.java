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
		PassagensActions.selecionarDataRetorno();
	}

	@Given("Seleciono o voo de ida na tela Passagens")
	public void clicarNoBotaoAplicarNaTelaPassagens() {
		PassagensActions.clicarLblEscolhaDeIda();
		PassagensActions.clicarBtnEscolhaDeIda();
	}

	@When("Seleciono o voo de volta na tela Passagens")
	public void clicarNoBotaoBuscarNaTelaPassagens() {
		PassagensActions.clicatLblEscolhaDeVolta();
		PassagensActions.clicarBtnEscolhaDeVolta();
	}

	@When("clicar no primeiro botão Selecionar voo na tela Buscar passagens")
	public void clicarNoPrimeiroBotaoSelecionarVooNaTelaBuscarPassagens() {
	}

}
