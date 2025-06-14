package org.testes.paginas.carrinho_de_compras.checkout;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.utils.Hooks;
import org.utilidades.evidencia.PrintScreen;


@Slf4j
public class CheckoutActions {

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static CheckoutPage checkoutPage(){
        return MasterPageFactory.getPage(CheckoutPage.class);
    }

    @SneakyThrows
    public static void validarLblResumoDoPedido() {
        log.info("valido a exibicao da mensagem 'Resumo do pedido' na tela 'Checkout'");
        acoes.waitForVisibility(checkoutPage().getVldLblResumo());
        PrintScreen.screenshot("resumo do pedido"); // Descomente se quiser evidência
    }
}