package org.com.fintech.test.paginas.home;

import java.io.IOException;

import io.cucumber.java.en.*;


public class HomeSteps {
    
    @Given("que estou na pagina inicial")
    public void queEstouNaPaginaInicial() {
    }

    @Then("devo ver a mensagem de boas vindas 'Bem-vindo!' 'tela Home'")
    public void devoVerAMensagemDeBoasVindasAcessoMinhaContaTelaHome() {
        org.com.fintech.test.paginas.home.HomeActions.validarAcessoMinhaConta();
    }

    @Given("que estou na tela Home")
    public void queEstouNaTelaHome() {

    }

    @When("clico no menu 'PIX' na 'tela Home'")
    public void clicoNoMenuPIXNaTelaHome() {
        org.com.fintech.test.paginas.home.HomeActions.clicarMenuPix();
    }

    @And("clico no botao 'Comecar a usar' na 'tela Home'")
    public void clicoNoBotaoGenerico() {
        org.com.fintech.test.paginas.home.HomeActions.clicarBtnComecarAUsar();
    }





}
