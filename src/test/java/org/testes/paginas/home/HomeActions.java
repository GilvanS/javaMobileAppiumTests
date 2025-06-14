package org.testes.paginas.home;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;

import java.io.IOException;

@Slf4j
public class HomeActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions();
    public static HomePage homePage(){
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void clicarBtnPularIntroducao() {
        log.info("clicar no botão pular introdução");
        acoes.click(homePage().getBtnPularIntroducao());
    }

    public static void vldTxtOla() throws IOException {
        log.info("valido a exibicao da tela 'Home'");
        acoes.waitElement(homePage().getVldTxtOla());
        print.screenshot("tela home");
    }

    public static void clicarBtnEntrar() {
        log.info("Clicar no botão Entrar na tela 'Home'");
        acoes.click(homePage().getBtnEntrar());
    }

    public static void vldTxtOla4Win() throws IOException {
        log.info("Valido o perfil 4Win logado");
        acoes.waitElement(homePage().getVldTxtOla4Win());
        print.screenshot("tela home");
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

    public static void clicarBtnIngressos() {
        log.info("clicar no botão 'Ingressos' na tela 'Home'");
        acoes.horizontalSwipeLeft(homePage().getBtnCarros(), homePage().getBtnIngressos(), 5);
        acoes.click(homePage().getBtnIngressos());
    }

    public static void clicarBtnHoteis() {
        log.info("clicar no botão 'Pacotes' na tela 'Home'");
        acoes.swipeOrScrollImproved (homePage().getBtnHoteis());
        acoes.horizontalSwipeLeft(homePage().getCarrosselHoteis(), homePage().getBtnHotelOrlando(), 5);
        acoes.click(homePage().getBtnHotelOrlando());
    }
}
