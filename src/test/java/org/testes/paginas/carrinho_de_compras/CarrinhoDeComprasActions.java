package org.testes.paginas.carrinho_de_compras;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CarrinhoDeComprasActions {
    private static final Logger log = LoggerFactory.getLogger(CarrinhoDeComprasActions.class);

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static CarrinhoDeComprasPage carrinhoDeComprasPage(){
        return MasterPageFactory.getPage(CarrinhoDeComprasPage.class);
    }

    @SneakyThrows
    public static void validarLblResumoDaViagem() {
        log.info("valido a exibição da mensagem 'Resumo da viagem' na tela 'Carrinho de compras'");
        acoes.verticalSwipeDownAndSearch(carrinhoDeComprasPage().getLblResumoDaViagem(), 3);
        acoes.waitForVisibility(carrinhoDeComprasPage().getLblResumoDaViagem());
    }

    @SneakyThrows
    public static void validarLblHospedagem() {
        log.info("valido a exibição da mensagem 'Hospedagem' na tela 'Carrinho de compras'");
        acoes.verticalSwipeDownAndSearch(carrinhoDeComprasPage().getLblHospedagem(),3);
        acoes.waitForVisibility(carrinhoDeComprasPage().getLblHospedagem());
    }

    @SneakyThrows
    public static void validarLblRegrasECondicoes() {
        log.info("valido a exibição da mensagem 'Regras e condições' na tela 'Carrinho de compras'");
        acoes.verticalSwipeDownAndSearch(carrinhoDeComprasPage().getLblRegrasECondicoes(),3);
        acoes.waitForVisibility(carrinhoDeComprasPage().getLblRegrasECondicoes());
    }

    @SneakyThrows
    public static void clicarBtnVerResumo() throws InterruptedException {
        log.info("clico no botão Ver resumo na tela Carrinho de compras");
        acoes.verticalSwipeDownAndSearch(carrinhoDeComprasPage().getBtnlVerResumo(), 3);
        acoes.click(carrinhoDeComprasPage().getBtnlVerResumo());
        Thread.sleep(500);
    }

    public static void clicarBtnIrParaOPagamento() throws InterruptedException {
        log.info("clicar no botão Ir para o pagamento na tela Carrinho de compras");
        acoes.click(carrinhoDeComprasPage().getBtnIrParaOPagamento());
        Thread.sleep(2000);
    }

}
