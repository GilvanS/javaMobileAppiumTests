package org.br.com.web.pages.home;

import org.br.com.web.driver.CustomActions;
import org.br.com.api.utils.LogFormatter;

import static org.junit.Assert.assertTrue;

/**
 * Classe que contém a lógica de negócio da página inicial
 */
public class HomeLogic {

    private final HomeElements homeElements;
    private final CustomActions actions;

    public HomeLogic() {
        this.homeElements = new HomeElements();
        this.actions = new CustomActions();
    }

    public void lidarComPopupCookies() {
        LogFormatter.logStep("Verificando e lidando com popup de cookies");
        actions.lidarComPopupCookies(homeElements.getBtnPermitirCookies());
    }

    public void validarExibicaoTelaInicial() {
        LogFormatter.logStep("Validando que estou na pagina inicial");
        lidarComPopupCookies();
        assertTrue(actions.waitElementDisplayed(homeElements.getLblTituloTelaInicial()));

    }

    public void validarMenuPrincipal() {
        LogFormatter.logStep("Validando exibicao do menu principal");
//        assertTrue(actions.waitElementDisplayed(homeElements.getBtnMenu()));
    }


    public void clicarBotaoAcessoUsuario() {
        LogFormatter.logStep("Clicando no botao de acesso do usuario");
        actions.click(homeElements.getBtnAcessoUsuario());
    }

    public void validarMensagemBemVindo() {
        LogFormatter.logStep("Validando mensagem de bem-vindo");
        assertTrue(actions.waitElementDisplayed(homeElements.getLblBemVindo()));
    }

    public void clicarBtnContato() {
        LogFormatter.logStep("Clicando no botao Contato");
        actions.click(homeElements.getBtnContato());
    }

    public void validarExibicaoLblSobreSolucoes() {
        LogFormatter.logStep("Validando exibicao da mensagem sobre solucoes");
        assertTrue(actions.waitElementDisplayed(homeElements.getLblSobreSolucoes()));
    }

    public void clicarBotaoTrabalheConosco() {
        LogFormatter.logStep("Clicando no botao Trabalhe Conosco");
        actions.click(homeElements.getBtnTrabalheConosco());
    }

    public void trocarNovaAba() {
        LogFormatter.logStep("Trocando para a nova aba");
        actions.trocarParaNovaAba();
    }

    public void validarMensagemSobreOrizon() {
        LogFormatter.logStep("Validando mensagem Sobre a Orizon");
        assertTrue(actions.waitElementDisplayed(homeElements.getLblSobreOrizon()));
    }

    public void clicarBotaoSolucoes() {
        LogFormatter.logStep("Clicando no botao Solucoes");
        actions.click(homeElements.getBtnSolucoes());
    }

    public void validarMensagensSolucoes() {
        LogFormatter.logStep("Validando mensagens de Solucoes");
        assertTrue(actions.waitElementDisplayed(homeElements.getBtnFrenteAutomatizada()));
        assertTrue(actions.waitElementDisplayed(homeElements.getBtnConsultoria()));
    }

    public void clicarBotaoFrenteAutomatizada() {
        LogFormatter.logStep("Clicando no botao Frente Automatizada");
        actions.click(homeElements.getBtnFrenteAutomatizada());
    }

    public void validarMensagemFrenteAutomatizada() {
        LogFormatter.logStep("Validando mensagem FRENTE AUTOMATIZADA");
        assertTrue(actions.waitElementDisplayed(homeElements.getLblFrenteAutomatizada()));
    }

    public void clicarBotaoConsultoria() {
        LogFormatter.logStep("Clicando no botao Consultoria");
        actions.click(homeElements.getBtnConsultoria());
    }

    public void validarMensagemConsultoria() {
        LogFormatter.logStep("Validando mensagem de Consultoria");
        assertTrue(actions.waitElementDisplayed(homeElements.getLblConsultoria()));
    }

    public void clicarBotaoQuemSomos() {
        LogFormatter.logStep("Clicando no botao Quem somos");
        actions.click(homeElements.getBtnQuemSomos());
    }

    public void clicarBotaoLgpdNaOrizon() {
        LogFormatter.logStep("Clicando no botao LGPD na Orizon");
        actions.click(homeElements.getBtnLgpdNaOrizon());
    }

    public void validarMensagemLgpdNaOrizon() {
        LogFormatter.logStep("Validando mensagem LGPD NA ORIZON");
        assertTrue(actions.waitElementDisplayed(homeElements.getLblLgpdNaOrizon()));
    }
} 