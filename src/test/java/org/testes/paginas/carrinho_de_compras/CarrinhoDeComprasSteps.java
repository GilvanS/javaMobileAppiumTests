package org.testes.paginas.carrinho_de_compras;

import io.cucumber.java.en.Then;
import org.testes.paginas.checkout.CheckoutActions;

public class CarrinhoDeComprasSteps {

    @Then("valido a exibição das mensagem 'Resumo da viagem' na tela 'Carrinho de compras'")
    public void valido_a_exibicao_das_mensagem_resumo_da_viagem_na_tela_carrinho_de_compras() {
        CarrinhoDeComprasActions.validarLblResumoDaViagem();
    }
    @Then("valido a exibição das mensagem 'Hospedagem' na tela 'Carrinho de compras'")
    public void valido_a_exibicao_das_mensagem_hospedagem_na_tela_carrinho_de_compras() {
        CarrinhoDeComprasActions.validarLblHospedagem();
    }
    @Then("valido a exibição das mensagem 'Regras e condições' na tela 'Carrinho de compras'")
    public void valido_a_exibicao_das_mensagem_regras_e_condicoes_na_tela_carrinho_de_compras() {
        CarrinhoDeComprasActions.validarLblRegrasECondicoes();
    }
    @Then("clico no botão 'Ver resumo' na tela 'Carrinho de compras'")
    public void clico_no_botao_ver_resumo_na_tela_carrinho_de_compras() throws InterruptedException {
        CarrinhoDeComprasActions.clicarBtnVerResumo();
    }
    @Then("clico no botão 'Ir para o pagamento' na tela 'Carrinho de compras'")
    public void clicar_no_botao_ir_para_o_pagamento_na_tela_carrinho_de_compras() throws InterruptedException {
        CarrinhoDeComprasActions.clicarBtnIrParaOPagamento();
    }

}
