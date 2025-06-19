package org.br.com.mobile.pages.home;

import lombok.extern.log4j.Log4j2;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class HomeActions {

    private static final Logger log = LoggerFactory.getLogger(HomeActions.class);
    static PageBaseActions acoes = new PageBaseActions();

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void validarExibicaoTelaHome() {
        log.info("valido a exibição da home");
//        popupLogic.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
        PageBaseActions.waitElement(homePage().getLblOla());
        assertTrue("Tela home do Digio não foi apresentada", homePage().getLblOla().isDisplayed());
    }

    public static void validarExibicaoBtnNaoMostrarNovamenteAtiveSuaBiometria() {
        log.info("valido a exibição do botao 'nao mostrar novamente' em 'ative sua biometria'");
        PageBaseActions.waitElement(homePage().getBtnNaoMostrarNovamente());
        assertTrue("Nao foi possivel validar o botão 'nao mostrar novamente' em 'ative sua biometria'",
                homePage().getBtnNaoMostrarNovamente().isDisplayed());
    }
    public static void clicarBtnNaoMostrarNovamenteAtiveSuaBiometria() {
        log.info("clico no botao 'nao mostrar novamente' em 'ative sua biometria'");
        acoes.click(homePage().getBtnNaoMostrarNovamente());
    }
}
