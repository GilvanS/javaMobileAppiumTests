package org.testes.paginas.login;

import io.cucumber.java.en.*;
import org.testes.paginas.home.HomeActions;

import java.io.IOException;

public class LoginSteps {

    @Given("clico no botão 'COMECE AGORA' na tela 'Home'")
    public void clicoNoBotaoCOMECEAGORANaTelaHome() {
        LoginActions.clicarBtnComeceAgora();
    }
    @Given("clico no botão 'Conectar' com o Google na tela 'Login'")
    public void clicoNoBotaoConectarComOGoogleNaTelaLogin() {
        LoginActions.clicarBtnConectarComOGoogle();
    }

    @Given("seleciono o 'Email' na tela 'Login'")
    public void selecionoOEmailNaTelaLogin() {
        LoginActions.selecionarEmail();
    }

    @Given("clico no botão 'Concluir' na tela 'Login'")
    public void clicoNoBotaoConcluirNaTelaLogin() {
        LoginActions.clicarBtnConcluir();
    }

}