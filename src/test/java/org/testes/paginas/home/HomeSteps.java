package org.testes.paginas.home;

import java.io.IOException;

import io.cucumber.java.en.*;
import org.testes.paginas.pix.PixActions;
import org.testes.paginas.home.HomeActions;
import org.testes.paginas.login.LoginActions;

public class HomeSteps {
    
    @Given("que estou na pagina inicial")
    public void queEstouNaPaginaInicial() {
    }

    @Then("devo ver a mensagem de boas vindas 'Bem-vindo!' 'tela Home'")
    public void devoVerAMensagemDeBoasVindasAcessoMinhaContaTelaHome() {
        HomeActions.validarAcessoMinhaConta();
    }

    @Given("que estou na tela Home")
    public void queEstouNaTelaHome() {

    }

    @When("clico no menu 'PIX' na 'tela Home'")
    public void clicoNoMenuPIXNaTelaHome() {
        HomeActions.clicarMenuPix();
    }

    @And("clico no botao 'Comecar a usar' na 'tela Home'")
    public void clicoNoBotaoGenerico() {
        HomeActions.clicarBtnComecarAUsar();
    }





}
