package org.testes.paginas.home;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps {

    @Given("visualizo o 'Valor' do saldo na tela 'Home'")
    public void visualizoOValorDoSaldoNaTelaHome() throws IOException {
        HomeActions.visualizarValorSaldo();
    }
    
    @Then("valido o valor do saldo no campo 'Tendencia do saldo' na tela 'Home'")
    public void validoOValorDoSaldoNoCampoTendenciaDoSaldoNaTelaHome() throws IOException {
        HomeActions.validarTendenciaSaldo();
    }

    @Given("valido a exibição da frase 'Inicio' na tela 'Home'")
    public void validoAExibicaoDaFraseInicioNaTelaHome() throws IOException {
        HomeActions.validarLblInicio();
    }

    @When("clico no botão 'Detalhe da conta' na tela 'Home'")
    public void clicoNoBotaoDetalheDaContaNaTelaHome() {
        HomeActions.clicarBtnDetalheDaConta();
    }


}
