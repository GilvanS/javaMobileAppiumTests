package org.testes.paginas.pacoteRecomendado;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;

@Slf4j
public class PacoteRecomendadoActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions();
    public static PacoteRecomendadoPage pacoteRecomendadoPage(){
        return MasterPageFactory.getPage(PacoteRecomendadoPage.class);
    }

    public static void clicarBtnDetalhesDoHotel() {
        log.info("clico no botão 'Detalhes do Hotel' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnDetalhesDoHotel());
    }

    public static void validarLblTxtDetalhesDoHotel() throws InterruptedException {
        log.info("valido o texto 'Detalhes do Hotel' na tela 'Detalhes do Hotel'");
        Thread.sleep(1500);
        acoes.waitElement(pacoteRecomendadoPage().getLblTxtDetalhesDoHotel());
    }

    public static void clicarBtnVoltarDetalhesDoHotel() {
        log.info("clico no botão 'Voltar' na tela 'Detalhes do Hotel'");
        acoes.click(pacoteRecomendadoPage().getBtnVoltarDetalhesDoHotel());
    }

    public static void clicarBtnDetalhesDoValor() throws InterruptedException {
        log.info("clico no botão 'Detalhes do valor' na tela 'Pacote recomendado'");
        Thread.sleep(1100);
        acoes.swipeOrScrollImproved(pacoteRecomendadoPage().getBtnDetalhesIda());
        acoes.click(pacoteRecomendadoPage().getBtnDetalhesDoValor());
    }

    public static void clicarBtnFecharDetalhesDoValor() {
        log.info("clico no botão 'Fechar' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnFecharDetalhesDoValor());
    }

    public static void clicarBtnReservarAgora() {
        log.info("clico no botão 'Detalhes da passagem' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnReservarAgora());
    }

    public static void validarLblTxtViajeComMaisConforto() {
        log.info("valido a exibição da mensagem 'Viaje com mais conforto!' na tela 'Pacote recomendado'");
        acoes.waitElement(pacoteRecomendadoPage().getLblTxtViajeComMaisConforto ());
    }

    public static void clicarBtnContinuar() {
        log.info("clico no botão 'Continuar' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnContinuar ());
    }

    public static void validarLblTxtAtencaoAoInicioDaSuaEstadia() {
        log.info("valido a exibição da mensagem 'Atenção ao inicio da sua estadia' na 'Pacote recomendado'");
        acoes.waitElement(pacoteRecomendadoPage().getLblTxtAtencaoAoInicioDaSuaEstadia());
    }

    public static void clicarBtnEstouCiente() {
        log.info("clico no botão 'Estou ciente' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnEstouCiente());
    }
}
