package org.testes.paginas.home;


import org.testes.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HomeActions {

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void validarOTextoOla() {
        log.info("Validando que estou na tela inicial");
        org.junit.jupiter.api.Assertions.assertAll("Validação da Home",
                () -> assertTrue(acoes().waitForVisibility(homePage().getTextoOla()).isDisplayed(),
                        "Texto 'Olá' não está visível"),
                () -> assertTrue(homePage().getBtnEntreNaConta().isDisplayed(),
                        "Botão 'Entre na conta' não está visível"));
    }

    public static void clicarNoBotaoEntreNaSuaConta() {
        log.info("Clicando no botão 'Entre na sua conta'");
        acoes().click(homePage().getBtnEntreNaConta());
    }

    public static void clicarCampoCpf() {
        log.info("Clicando no campo 'CPF'");
        acoes().click(homePage().getBtnCampoCpf());
    }

}