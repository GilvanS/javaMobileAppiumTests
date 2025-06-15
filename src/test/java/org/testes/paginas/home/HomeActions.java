package org.testes.paginas.home;

import lombok.SneakyThrows;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HomeActions {

    private static final Logger log = LoggerFactory.getLogger(HomeActions.class);

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static HomePage homePage(){
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void clicarBtnPularIntroducao() {
        log.info("clicar no botão pular introdução");
        acoes.click(homePage().getBtnPularIntroducao());
    }

    public static void vldTxtOla() throws IOException {
        log.info("valido a exibicao da tela 'Home'");
        acoes.waitForVisibility(homePage().getVldTxtOla());
        PrintScreen.screenshot("tela home");
    }

    public static void clicarBtnEntrar() {
        log.info("Clicar no botão Entrar na tela 'Home'");
        acoes.click(homePage().getBtnEntrar());
    }

    public static void vldTxtOla4Win() throws IOException {
        log.info("Valido o perfil 4Win logado");
        acoes.waitForVisibility(homePage().getVldTxtOla4Win());
        PrintScreen.screenshot("tela home");
    }

    public static void clicarBtnExplorar() {
        acoes.click(homePage().getBtnExplorar());
    }

    public static void clicarBtnPacotes() {
        log.info("clicar no botão pacotes");
        acoes.click(homePage().getBtnPacotes());
    }

    public static void clicarBtnCarros() {
        log.info("clicar no botão 'Carros' tela 'Home'");
        acoes.click(homePage().getBtnCarros());
    }

    @SneakyThrows
    public static void clicarBtnIngressos() {
        log.info("clicar no botão 'Ingressos' na tela 'Home'");
        acoes.horizontalSwipeFingerAndSearch(900, 400, 300, 200, homePage().getBtnIngressos(), 3);
        acoes.click(homePage().getBtnIngressos(), 5);
    }

    public static void clicarBtnHoteis() {
        log.info("clicar no botão 'Hotéis' na tela 'Home'");
        acoes.click(homePage().getBtnHoteis());
    }

}
