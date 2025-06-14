package org.testes.paginas.carrinho_de_compras.checkout;

import io.cucumber.java.en.Then;

public class CheckoutSteps {

    @Then("clico no botão Ver Resumo na tela Checkout")
    public void clico_no_botao_ver_resumo_na_tela_checkout() {
        CheckoutActions.validarLblResumoDoPedido();
    }
}
