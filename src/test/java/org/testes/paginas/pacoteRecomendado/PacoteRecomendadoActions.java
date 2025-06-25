package org.testes.paginas.pacoteRecomendado;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.testes.utils.Hooks;
import org.utilidades.evidencia.PrintScreen;

@Slf4j
public class PacoteRecomendadoActions {
    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    
    public static PacoteRecomendadoPage pacoteRecomendadoPage(){
        return MasterPageFactory.getPage(PacoteRecomendadoPage.class);
    }

    public static void clicarBtnEditar() {
        acoes.pullToRefresh();
        if (pacoteRecomendadoPage().getBtnEditar().isDisplayed()) {
            log.info("clico no botao 'Editar' na tela 'Pacote recomendado'");
            acoes.click(pacoteRecomendadoPage().getBtnEditar());
            acoes.click(pacoteRecomendadoPage().getBtnFechar());
        } else {
            log.info("Botao 'Detalhes do hotel' esta visivel, prosseguindo com as demais acoes.");
        }

    }

    public static void clicarBtnDetalhesDoHotel() {
        clicarBtnEditar();
        log.info("clico no botao 'Detalhes do Hotel' na tela 'Pacote recomendado'");
        acoes.sleep(5);
        acoes.click(pacoteRecomendadoPage().getBtnDetalhesDoHotel(),5);
    }

    public static void validarLblTxtDetalhesDoHotel() {
        log.info("valido o texto 'Detalhes do Hotel' na tela 'Detalhes do Hotel'");
        acoes.sleep(5);
        acoes.waitForVisibility(pacoteRecomendadoPage().getLblTxtDetalhesDoHotel());
    }

    public static void clicarBtnVoltarDetalhesDoHotel() {
        log.info("clico no botao 'Voltar' na tela 'Detalhes do Hotel'");
        acoes.click(pacoteRecomendadoPage().getBtnVoltarDetalhesDoHotel());
    }

    public static void clicarBtnDetalhesDoValor() throws InterruptedException {
        log.info("clico no botao 'Detalhes do valor' na tela 'Pacote recomendado'");
        Thread.sleep(1100);
        acoes.swipeVertical();
        acoes.click(pacoteRecomendadoPage().getBtnDetalhesDoValor());
    }

    public static void clicarBtnFecharDetalhesDoValor() {
        log.info("clico no botao 'Fechar' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnFecharDetalhesDoValor());
    }

    public static void clicarBtnReservarAgora() {
        log.info("clico no botao 'Reservar Agora' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnReservarAgora());
    }

    public static void validarLblTxtViajeComMaisConforto() {
        log.info("valido a exibicao da mensagem 'Viaje com mais conforto!' na tela 'Pacote recomendado'");
        acoes.waitForVisibility(pacoteRecomendadoPage().getLblTxtViajeComMaisConforto());
    }

    public static void clicarBtnContinuar() {
        log.info("clico no botao 'Continuar' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnContinuar());
    }

    public static void validarLblTxtAtencaoAoInicioDaSuaEstadia() {
        log.info("valido a exibicao da mensagem 'Atencao ao inicio da sua estadia' na 'Pacote recomendado'");
        acoes.waitForVisibility(pacoteRecomendadoPage().getLblTxtAtencaoAoInicioDaSuaEstadia());
    }

    public static void clicarBtnEstouCiente() {
        log.info("clico no botao 'Estou ciente' na tela 'Pacote recomendado'");
        acoes.click(pacoteRecomendadoPage().getBtnEstouCiente());
    }
}
