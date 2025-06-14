package org.testes.paginas.carrinho_de_compras;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;

@Slf4j
public class CarrinhoDeComprasActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions();
    public static CarrinhoDeComprasPage carrinhoDeComprasPage(){
        return MasterPageFactory.getPage(CarrinhoDeComprasPage.class);
    }

    public static void validarLblResumoDaViagem() {
        log.info("valido a exibição das mensagem 'Resumo da viagem' na tela 'Carrinho de compras'");
        acoes.waitElement(carrinhoDeComprasPage().getLblResumoDaViagem());
    }

    public static void validarLblHospedagem() {
        log.info("valido a exibição das mensagem 'Hospedagem' na tela 'Carrinho de compras'");
        acoes.swipeOrScrollImproved(carrinhoDeComprasPage().getLblHospedagem());
    }

    public static void validarLblRegrasECondicoes() {
        log.info("valido a exibição das mensagem 'Regras e condições' na tela 'Carrinho de compras'");
        acoes.waitElement(carrinhoDeComprasPage().getLblRegrasECondicoes());
    }

    public static void clicarBtnVerResumo() throws InterruptedException {
        log.info("clico no botão Ver resumo na tela Carrinho de compras");
        Thread.sleep(500);
        acoes.click(carrinhoDeComprasPage().getBtnCheckout());
        acoes.click(carrinhoDeComprasPage().getBtnlVerResumo());
        Thread.sleep(500);
    }

    public static void clicarBtnIrParaOPagamento() throws InterruptedException {
        log.info("clicar no botão Ir para o pagamento na tela Carrinho de compras");
        Thread.sleep(2000);
        acoes.click(carrinhoDeComprasPage().getBtnIrParaOPagamento());
    }

}
