package org.com.fintech.test.paginas.registro;

import io.cucumber.java.en.When;

public class RegistroSteps {

    @When("clico no botão Receita na tela Registro")
    public void clicoNoBotãoReceitaNaTelaRegistro() {
        RegistroActions.clicarBtnReceita();
    }

    @When("clico no botão Categoria na tela Registro")
    public void clicoNoBotãoCategoriaNaTelaRegistro() {
        RegistroActions.clicarBtnCategoria();
    }

    @When("preencho o campo valor na tela Registro")
    public void preenchoOCampoValorNaTelaRegistro() {
        RegistroActions.preencherValor();
    }
    @When("clico no botão Salvar na tela Registro")
    public void clicoNoBotãoOkNaTelaRegistro() {
        RegistroActions.clicarBtnSalvar();
    }

}
