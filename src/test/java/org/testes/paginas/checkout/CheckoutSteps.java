package org.testes.paginas.checkout;

import io.cucumber.java.en.Then;

public class CheckoutSteps {
    
    @Then("clico no botão Ver Resumo na tela Checkout")
    public void clicoNoBotaoVerResumoNaTelaCheckout() {
        CheckoutActions.clicarBtnVerResumo();
    }
} 