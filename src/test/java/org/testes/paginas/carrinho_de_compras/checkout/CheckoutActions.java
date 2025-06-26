package org.testes.paginas.carrinho_de_compras.checkout;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.testes.driver.page.MasterPageFactory;

import org.utilidades.evidencia.PrintScreen;

import static org.testes.utils.Context.acoes;


@Slf4j
public class CheckoutActions {

    public static CheckoutPage checkoutPage(){
        return MasterPageFactory.getPage(CheckoutPage.class);
    }

    @SneakyThrows
    public static void validarLblResumoDoPedido() {
        log.info("valido a exibicao da mensagem 'Resumo do pedido' na tela 'Checkout'");
        Thread.sleep(6000);
        acoes().waitForVisibility(checkoutPage().getBtnCheckout());
        acoes().click(checkoutPage().getBtnCheckout());
        acoes().waitForVisibility(checkoutPage().getVldLblResumo());
        acoes().click(checkoutPage().getVldLblResumo());
        PrintScreen.screenshot("resumo do pedido"); // Descomente se quiser evidência
    }
}