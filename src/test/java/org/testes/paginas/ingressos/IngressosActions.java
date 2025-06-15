package org.testes.paginas.ingressos;

import io.cucumber.java.en.Given;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testes.adb.AdbActions;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.utils.Hooks;
import org.openqa.selenium.WebElement;


import static org.testes.utils.Hooks.driver;

@Slf4j
public class IngressosActions {

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static IngressosPage ingressosPage() {
        return MasterPageFactory.getPage(IngressosPage.class);
    }

    public static void validarEscolharUmParque() {
        log.info("Validando exibição da frase Escolhar um parque");
        acoes.waitForVisibility(ingressosPage().getVldLblEscolhaUmParque());
    }


    @SneakyThrows
    public static void clicarEPreencherCamoDestino(String destino) {
        log.info("Clicando no botão comprar ingresso");
        acoes.click(ingressosPage().getCampoParaQualDestino());
        acoes.sendKeys(ingressosPage().getCampoParaQualDestino(), destino);
        Thread.sleep(2000);
        AdbActions.tap(200,500);
    }

    public static void clicarNoBotaoConfirmarParque() {
        log.info("Clicando no botão Confirmar parque");
        acoes.click(ingressosPage().getBtnConfirmarDestino(), 10);
        acoes.click(ingressosPage().getBtnContinuar(), 5);
    }

    public static void clicarNoBotaoConfirmarDatas() {
        log.info("Clicando no botão Confirmar datas");
        acoes.click(ingressosPage().getBtnConfirmarDatas(), 10);
    }

    public static void clicarNoBotaoConferirDetalhes() {
        log.info("Clicando no botão Conferir detalhes");
        acoes.click(ingressosPage().getBtnConferirDetalhes(), 10);
    }

    public static void clicarNoBotaoReservar() {
        log.info("Clicando no botão Reservar");
        // TODO: Adicionar o elemento correto quando disponível
        // Exemplo: acoes.click(ingressosPage().getBtnReservar(), 10);
    }

    public static void validarResumoDePedido(String texto) {
        log.info("Validando exibição do resumo de pedido");
        org.openqa.selenium.WebElement resumo = ingressosPage().getViewResumoPedido();
        if (!resumo.isDisplayed() || (texto != null && !resumo.getText().contains(texto))) {
            throw new AssertionError("Resumo de pedido não exibido ou texto não confere: " + texto);
        }
    }

    public WebElement getBtnDia(String dia) {
        return driver.findElement(By.xpath("//android.view.View[@content-desc='" + dia + "']"));
    }

    /**
     * Clica no dia informado no calendário de datas.
     *
     * @param dia String representando o dia (ex: "20")
     */
    public static void clicarNoDiaDoCalendario(String dia) {
        log.info("Clicando no dia '{}' no calendário de datas", dia);
        acoes.click(ingressosPage().getBtnDia(dia));
    }

    public static void clicarNoBotaoContinuar() {
        log.info("Clicando no botão Continuar");
        acoes.click(ingressosPage().getBtnContinuar());
    }

    /**
     * Seleciona as datas de início e fim no calendário de ingressos.
     * Aguarda visibilidade e clica em cada data, com delay para robustez.
     *
     * @param dataInicio String da data de início (ex: "23")
     * @param dataFim
     */
    public static void selecionarDatasCalendario(String dataInicio, String dataFim) {
        log.info("Selecionando data de início: " + dataInicio);
        acoes.waitForVisibility(ingressosPage().getBtnDia(dataInicio));
        acoes.click(ingressosPage().getBtnDia(dataInicio));
        acoes.delay(500);

        log.info("Selecionando data de fim: " + dataFim);
        acoes.waitForVisibility(ingressosPage().getBtnDia(dataFim));
        acoes.click(ingressosPage().getBtnDia(dataFim));
        acoes.delay(500);
    }

}
