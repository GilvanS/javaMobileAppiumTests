package org.com.fintech.test.paginas.home;


import org.junit.jupiter.api.Assertions;
import org.com.fintech.core.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.com.fintech.core.support.Context.acoes;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HomeActions {

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void validarAcessoMinhaConta() {
        log.info("Validando a mensagem de boas vindas");
        acoes().sleep(5);
        Assertions.assertAll("Validação da Tela Home",
                () -> assertTrue(acoes().waitForVisibility(homePage().getVldBemVindo()).isDisplayed(),
                        "Texto 'Bem-vindo!' não está visível"),
                () -> assertTrue(homePage().getVldBemVindo().isDisplayed(),
                        "Texto 'Bem-vindo!' não está visível"));
    }

    public static void clicarBtnComecarAUsar() {
        log.info("Clicando no botão 'Começar a usar'");
        acoes().click(homePage().getBtnComecarAUsar());
    }

    public static void clicarMenuPix() {
        log.info("Clicando no menu 'PIX'");
        acoes().click(homePage().getBtnMenuPix());
    }
}