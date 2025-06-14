package org.testes.paginas.pacotes;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;

@Slf4j
public class PacotesActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions();
    public static PacotesPage pacotesPage(){
        return MasterPageFactory.getPage(PacotesPage.class);
    }

    public static void clicarEPreencherCampoOrigem(String origem) {
        log.info("Origem " + origem);
        acoes.click(pacotesPage().getCampoDeOndeVocePegaraSeuVoo());
        acoes.sendKeys(pacotesPage().getCampoDeOndeVocePegaraSeuVoo(), origem);
        acoes.click(pacotesPage().getDestinoSaoPauloSP());
    }

    public static void clicarEPreencherCampoDestino(String destino) {
        log.info("Destino " + destino);
        acoes.click(pacotesPage().getCampoParaQualDestinoViajara());
        acoes.sendKeys(pacotesPage().getCampoParaQualDestinoViajara(), destino);
        acoes.click(pacotesPage().getDestinoFozDoIguacu());
    }

    public static void clicarBtnContinuar() {
        acoes.click(pacotesPage().getBtnContinuar());
    }

    public static void clicarBtnConfirmarDetalhes() {
        acoes.click(pacotesPage().getBtnConfirmarDetalhes());
    }

    public static void selecionarDataIda() {
        acoes.click(pacotesPage().getBtnDataSaida());
    }

    public static void selecionarDataRetorno() {
        acoes.click(pacotesPage().getBtnDataRetorno());
    }

    public static void clicarBtnConfirmarDatas() {
        acoes.click(pacotesPage().getBtnConfirmarDatas());
    }

    public static void vldTxtPacoteRecomendado() throws InterruptedException {
        Thread.sleep(10000);
        acoes.waitElement(pacotesPage().getVlTxtPacoteRecomendado());
    }

    public static void vldTxtIda() throws InterruptedException {
        Thread.sleep(1000);
        acoes.swipeOrScrollImproved(pacotesPage().getVlTxtIda());
    }

    public static void clicarBtnReservarAgora() throws InterruptedException {
        Thread.sleep(1000);
        acoes.swipeVertical(pacotesPage().getVlTxtReservarAgora());

    }


}
