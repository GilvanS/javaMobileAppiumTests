package org.br.com.web.pages.login;

import lombok.extern.log4j.Log4j2;
import org.br.com.web.driver.CustomActions;
import org.br.com.api.utils.LogFormatter;

import static org.junit.Assert.assertTrue;

@Log4j2
public class LoginLogic {
    private final LoginElements loginElements;
    private final CustomActions actions;

    public LoginLogic() {
        this.loginElements = new LoginElements();
        this.actions = new CustomActions();
    }

    public void validarOpcaoAutorize() {
        LogFormatter.logStep("Validando exibicao da opcao AUTORIZE");
        assertTrue(actions.waitElementDisplayed(loginElements.getLblAutorize()));
    }

    public void clicarBotaoEfetuarLogin() {
        LogFormatter.logStep("Clicando no botao Efetuar login");
        actions.waitElementDisplayed(loginElements.getBtnEfetuarLogin());
        actions.click(loginElements.getBtnEfetuarLogin());
    }

    public void preencherDadosInvalidos() {
        LogFormatter.logStep("Preenchendo dados invalidos de login");
        actions.lidarComPopupCookies(loginElements.getBtnPermitirCookies());
        actions.waitElementDisplayed(loginElements.getTxtLogin());
        actions.sendKeys(loginElements.getTxtLogin(), "usuario.invalido");
        actions.waitElementDisplayed(loginElements.getTxtSenha());
        actions.sendKeys(loginElements.getTxtSenha(), "senha.invalida");
    }

    public void validarMensagemErro(String mensagem) {
        LogFormatter.logStep("Validando mensagem de erro: " + mensagem);
        assertTrue(actions.waitElementDisplayed(loginElements.getLblMensagemUsuarioOuSenhaInvalidos()));
//        String cor = loginElements.getLblMensagemUsuarioOuSenhaInvalidos().getCssValue("color");
//        assertTrue("A cor da mensagem de erro deve ser vermelha", cor.contains("rgb(185, 74, 72)"));
    }
} 