package org.testes.paginas.home;

import java.io.IOException;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testes.driver.manager.SaldoManager;
import org.testes.driver.page.MasterPageFactory;
import org.testes.paginas.popup.PopupActions;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;
import org.utilidades.evidencia.PrintScreen;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

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