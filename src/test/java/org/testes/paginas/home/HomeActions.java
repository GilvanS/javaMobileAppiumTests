package org.testes.paginas.home;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class HomeActions {

    private static HomePage homePage = new HomePage();
    private static PageBaseActions acoes;

    public HomeActions() {
        homePage = MasterPageFactory.getPage(HomePage.class);
        acoes = new PageBaseActions(Hooks.getDriver());
    }

    public static void clicarBtnHome(){
        log.info("Clico no botão Home");
        acoes.click(homePage.getBtnHome());
    }

    public static void validarLblWebDriveIo() {
        log.info("Valido a exibição da frase WEBDRIVERIO na tela Home");
        acoes.waitForElementToBeVisible(homePage.getLblWebDriverIo(), 10);
        assertTrue(homePage.getLblWebDriverIo().isDisplayed(),
                "Não foi posivel validar o texto 'WEBDRIVERIO'");
        acoes.sleep(2);
    }

    public static void clicarBtnWebview() {
        log.info("Clicando no botao 'Webview'");
        acoes.click(homePage.getBtnWebview());
    }

    public static void validarLblNextGenBrowser() {
        log.info("Valido a exibição da frase Next-gen browser na tela Webview");
        acoes.waitForElementToBeVisible(homePage.getLblNextGenBrowser(), 10);
        assertTrue(homePage.getLblNextGenBrowser().isDisplayed(),
                "Não foi posivel validar o texto 'Next-gen browser'");
        acoes.sleep(2);
    }
}
