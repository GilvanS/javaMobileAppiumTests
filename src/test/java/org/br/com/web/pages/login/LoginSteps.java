package org.br.com.web.pages.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.br.com.api.utils.LogFormatter;

public class LoginSteps {
    private final LoginLogic loginLogic;

    public LoginSteps() {
        this.loginLogic = new LoginLogic();
    }

    @And("valido a exibicao da opcao 'AUTORIZE' na tela de login")
    public void validoAExibicaoDaOpcaoAutorizeNaTelaDeLogin() {
        loginLogic.validarOpcaoAutorize();
    }

    @And("clico no botao 'Efetuar login' na tela login")
    public void clicoNoBotaoEfetuarLoginNaTelaLogin() {
        loginLogic.clicarBotaoEfetuarLogin();
    }

    @And("preencho o campo login e senha com dados invalidos")
    public void preenchoOCampoLoginESenhaComDadosInvalidos() {
        loginLogic.preencherDadosInvalidos();
    }

    @Then("valido a mensagem 'Usuario ou senha invalidos'")
    public void validoAMensagemUsuarioOuSenhaInvalidos() {
        loginLogic.validarMensagemErro("Usuario ou senha invalidos");
    }
} 