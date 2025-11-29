package org.testes.paginas.home;

import java.io.IOException;

import io.cucumber.java.en.*;


public class HomeSteps {
    
    @Given("que estou na pagina inicial")
    public void queEstouNaPaginaInicial() {
    }

    @When("valido o titulo da pagina como {string}")
    public void validoOTituloDaPaginaComoOlá(String arg0) {
        HomeActions.validarOTextoOla();
    }


    @And("clico no botão Entre na conta na {string}")
    public void clicoNoBotãoEntreNaContaNaTelaInicial(String tela) {
        HomeActions.clicarNoBotaoEntreNaSuaConta();
    }

    @And("preencho o campo CPF com {string} {string}")
    public void preenchoOCampoCPFComTelaInicial(String cpf, String tela) {
        HomeActions.clicarCampoCpf();
    }

    @And("preencho o campo Senha com {string} {string}")
    public void preenchoOCampoSenhaComAdminTelaInicial(String senha, String tela) {
        HomeActions.clicarCampoSenha();
    }

    @And("clico no botao {string} {string}")
    public void clicoNoBotaoEntrarTelaInicial(String botao, String tela) {
        HomeActions.clicarBrnEntrar();
    }

    @Then("devo ver a mensagem de boas vindas {string} {string}")
    public void devoVerAMensagemDeBoasVindasAcessoMinhaContaTelaHome(String mensagem, String tela) {
        HomeActions.validarAcessoMinhaConta();
    }

    @And("clico no botao {string} na {string}")
    public void clicoNoBotaoComecarAUsarNaTelaHome(String mensagem, String tela) {
        HomeActions.clicarBtnComecarAUsar();
    }
}
