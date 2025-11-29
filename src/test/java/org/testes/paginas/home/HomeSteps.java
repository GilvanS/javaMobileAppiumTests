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
    public void clicoNoBotãoEntreNaContaNaTelaInicial() {
    }

    @And("preencho o campo CPF com {string} {string}")
    public void preenchoOCampoCPFComTelaInicial(int arg0) {
    }

    @And("preencho o campo Senha com {string} {string}")
    public void preenchoOCampoSenhaComAdminTelaInicial(int arg0) {
    }

    @And("clico no botao {string} {string}")
    public void clicoNoBotaoEntrarTelaInicial() {
    }

    @Then("devo ver a mensagem de boas vindas {string} {string}")
    public void devoVerAMensagemDeBoasVindasAcessoMinhaContaTelaHome() {
    }
}
