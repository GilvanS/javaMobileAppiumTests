package org.com.fintech.test.paginas.home;

import io.cucumber.java.en.*;
import org.com.fintech.test.paginas.login.LoginActions;


public class HomeSteps {
    
    @Given("que estou na pagina inicial")
    public void queEstouNaPaginaInicial() {
    }

    @Then("devo ver a mensagem {string} na {string}")
    public void devoVerAMensagemBemVindoNaTelaHome(String mensagem, String tela) {
        HomeActions.validarTextoPorChave(mensagem);
    }

    @Then("devo ver a mensagem de boas vindas 'Bem-vindo!' 'tela Home'")
    public void devoVerAMensagemDeBoasVindasAcessoMinhaContaTelaHome() {
        HomeActions.validarAcessoMinhaConta();
    }

    @Given("que estou na tela Home")
    public void queEstouNaTelaHome() {
    }

}
