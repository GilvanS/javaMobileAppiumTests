package org.com.fintech.test.paginas.login;

import io.cucumber.java.en.*;

public class LoginSteps {

    @When("valido o titulo da pagina como 'Olá!'")
    public void validoOTituloDaPaginaComoOlá() {
        LoginActions.validarOTextoOla();
    }

    @And("clico no botão Entre na conta na 'tela inicial'")
    public void clicoNoBotãoEntreNaContaNaTelaInicial() throws InterruptedException {
        LoginActions.clicarNoBotaoEntreNaSuaConta();
    }

    @And("preencho o campo CPF com '11111111111' 'tela inicial'")
    public void preenchoOCampoCPFComTelaInicial() {
        LoginActions.clicarCampoCpf();
    }

    @And("preencho o campo Senha com 'admin999' 'tela inicial'")
    public void preenchoOCampoSenhaComAdminTelaInicial() {
        LoginActions.clicarCampoSenha();
    }

    @And("clico no botao 'Entrar' 'tela inicial'")
    public void clicoNoBotaoEntrarTelaInicial() {
        LoginActions.clicarBrnEntrar();
    }

    @Given("clico no botão 'COMECE AGORA' na tela 'Home'")
    public void clicoNoBotaoCOMECEAGORANaTelaHome() {
        LoginActions.clicarBtnComeceAgora();
    }

}