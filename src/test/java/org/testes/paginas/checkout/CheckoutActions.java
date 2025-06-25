package org.testes.paginas.checkout;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.testes.utils.Hooks;

@Slf4j
public class CheckoutActions {
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    
    public static CheckoutPage checkoutPage() {
        return MasterPageFactory.getPage(CheckoutPage.class);
    }

    public static void clicarBtnVerResumo() {
        acoes.pullToRefresh(5);
        log.info("clico no botão Ver Resumo na tela Checkout");
        acoes.click(checkoutPage().getBtnVerResumo());
    }
} 