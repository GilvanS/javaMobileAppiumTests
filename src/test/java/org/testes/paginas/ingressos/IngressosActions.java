package org.testes.paginas.ingressos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testes.adb.AdbActions;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.utils.Hooks;
import org.openqa.selenium.WebElement;
import org.utilidades.dados.Usuario;


import static org.testes.utils.Context.acoes;
import static org.testes.utils.Hooks.driver;

@Slf4j
public class IngressosActions {

    public static IngressosPage ingressosPage() {
        return MasterPageFactory.getPage(IngressosPage.class);
    }

    public static void validarEscolharUmParque() {
        log.info("valido a exibição da frase Escolhar um parque na tela 'Ingressos'");
        acoes().waitForVisibility(ingressosPage().getVldLblEscolhaUmParque());
    }

    @SneakyThrows
    public static void clicarEPreencherCamoDestino() {
        String destino = Usuario.getCidadeOrigem();
        log.info("Clicando no botão comprar ingresso");
        acoes().click(ingressosPage().getCampoParaQualDestino());
        acoes().sendKeys(ingressosPage().getCampoParaQualDestino(), destino);
        acoes().sleep(3);
////        AdbActions.tap(200,500);
//        acoes().verticalSwipeDownAndSearch(ingressosPage().getDestinoBetoCarreiro(),5);
        acoes().click(ingressosPage().getDestinoBetoCarreiro());
    }

    public static void clicarNoBotaoConfirmarParque() {
        log.info("Clicando no botão Confirmar parque");
        acoes().click(ingressosPage().getBtnConfirmarParque(), 10);
//        acoes().click(ingressosPage().getBtnContinuar(), 5);
    }

    public static void clicarNoBotaoConfirmarDatas() {
        log.info("Clicando no botão Confirmar datas");
        acoes().click(ingressosPage().getBtnConfirmarDatas(), 10);
    }

    public static void clicarNoBotaoConferirDetalhes() {
        log.info("clico no botão 'Conferir' detalhes na tela 'Ingressos'");
        acoes().sleep(5);
        acoes().waitForElementToBeClickable(ingressosPage().getBtnConferirDetalhes(), 3);
        acoes().click(ingressosPage().getBtnConferirDetalhes(), 3);
    }

    @SneakyThrows
    public static void clicarNoBotaoReservar() {
        log.info("clico o botão Reservar na tela Ingressos");
        acoes().sleep(10);
        acoes().swipeVertical();
        acoes().verticalSwipeDownAndSearch(ingressosPage().getBtnReservar(), 5);
        acoes().click(ingressosPage().getBtnReservar());
    }

    @SneakyThrows
    public static void validarResumoDePedido(String texto) {
        log.info("Validando exibição do resumo de pedido");
        acoes().sleep(5);
        acoes().click(ingressosPage().getBtnCheckout());
        acoes().waitForElementToBeClickable(ingressosPage().getViewResumoPedido(), 10);
    }

    public static void clicarNoDiaDoCalendario() {
        String dia = Usuario.getDataInicio();
        log.info("Clicando no dia '{}' no calendário de datas", dia);
        acoes().click(ingressosPage().getBtnDataInicio());
    }

    public static void clicarNoBotaoContinuar() {
        log.info("Clicando no botão Continuar");
        acoes().click(ingressosPage().getBtnContinuar());
    }

}
