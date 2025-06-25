package org.testes.paginas.pacotes;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.dados.Usuario;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;

@Slf4j
public class PacotesActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    public static PacotesPage pacotesPage(){
        return MasterPageFactory.getPage(PacotesPage.class);
    }

    public static void clicarEPreencherCampoOrigem() {
        String cidadeOrigem = Usuario.getCidadeOrigem();
        log.info("Origem " + cidadeOrigem);
        acoes.click(pacotesPage().getCampoDeOndeVocePegaraSeuVoo());
        acoes.sendKeys(pacotesPage().getCampoDeOndeVocePegaraSeuVoo(), cidadeOrigem);
        acoes.click(pacotesPage().getDestinoSaoPauloSP());
    }

    public static void clicarEPreencherCampoDestino() {
        String cidadeDestino = Usuario.getCidadeDestino();
        log.info("Destino " + cidadeDestino);
        acoes.click(pacotesPage().getCampoParaQualDestinoViajara());
        acoes.sendKeys(pacotesPage().getCampoParaQualDestinoViajara(), cidadeDestino);
        acoes.click(pacotesPage().getDestinoFozDoIguacu());
    }

    public static void clicarBtnContinuar() {
        log.info("clico no botão Continuar na tela Passagens");
        acoes.click(pacotesPage().getBtnContinuar());
    }

    public static void clicarBtnConfirmarDetalhes() {
        acoes.click(pacotesPage().getBtnConfirmarDetalhes());
    }

    public static void selecionarDataIda() {
        String dataInicio = Usuario.getDataInicio();
        log.info("Data de ida {}", dataInicio);
        acoes.click(pacotesPage().getBtnDataIda(dataInicio));
    }

    public static void selecionarDataRetorno() {
        String dataFim = Usuario.getDataFim();
        log.info("Data de retorno {}", dataFim);
        acoes.click(pacotesPage().getBtnDataRetorno(dataFim));
    }

    public static void clicarBtnConfirmarDatas() {
        acoes.click(pacotesPage().getBtnConfirmarDatas());
    }

    public static void vldTxtPacoteRecomendado() throws InterruptedException {
        Thread.sleep(10000);
        acoes.waitForVisibility(pacotesPage().getVlTxtPacoteRecomendado());
    }

    public static void vldTxtIda() throws InterruptedException {
        Thread.sleep(1000);
        acoes.swipeVertical();
    }

    public static void clicarBtnReservarAgora() throws InterruptedException {
        Thread.sleep(1000);
        acoes.swipeVertical();
    }


}
