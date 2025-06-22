package org.testes.paginas.home;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;

@Slf4j
public class HomeActions {

    private static HomePage HomePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void clicarBtnHome(){
        log.info("Clico no botão Home");
        acoes().click(HomePage().getBtnHome());
    }

    public static void clicarBtnSwipe() {
        log.info("Clicando no botao 'Swipe'");
        acoes().click(HomePage().getBtnSwipe());
    }

    public static void validarLblWebDriveIo() {
        log.info("Valido a exibição da frase WEBDRIVERIO na tela Home");
        acoes().waitForElementToBeVisible(HomePage().getLblWebDriverIo(), 10);
        assertTrue(HomePage().getLblWebDriverIo().isDisplayed(),
                "Nao foi posivel validar o texto 'WEBDRIVERIO'");
        acoes().sleep(2);
    }

    public static void clicarBtnWebview() {
        log.info("Clicando no botao 'Webview'");
        acoes().click(HomePage().getBtnWebview());
    }

    public static void validarLblNextGenBrowser() {
        log.info("Valido a exibição da frase Next-gen browser na tela Webview");
        acoes().waitForElementToBeVisible(HomePage().getLblNextGenBrowser(), 10);
        assertTrue(HomePage().getLblNextGenBrowser().isDisplayed(),
                "Nao foi posivel validar o texto 'Next-gen browser'");
        acoes().sleep(2);
    }
}
