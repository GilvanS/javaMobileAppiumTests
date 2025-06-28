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

    @When("valido a exibição do banner 'Acompanhe seus gastos' na tela 'Home'")
    public void validoAExibicaoDoBannerNaTela() {
        HomeActions.validarAcompanheSeusGastos();
    }
    
    @When("seleciono o banner 'Modo escuro' na tela Home")
    public void selecionoOBannerNaTelaHome() throws IOException {
        HomeActions.selecionarModoEscuro();
    }

    @When("clico no botão Experimente o modo escuro na tela Home")
    public void clicoNoBotãoExperimenteOModoEscuroNaTelaHome() throws IOException {
        HomeActions.clicarBtnExperimenteModoEscuro();
    }
    @When("clico no botão Hamburguer na tela Home")
    public void clicoNoBotãoHamburguerNaTelaHome() {
        HomeActions.clicarBtnMenuAmburger();
    }
    @Then("Valido o botão Modo escuro ativo na tela Home")
    public void validoOBotãoModoEscuroAtivoNaTelaHome() throws IOException {
        HomeActions.validarModoEscuroAtivo();
    }

    @When("clico no botão Add na tela Home")
    public void clicoNoBotãoAddNaTelaHome() {
        HomeActions.clicarBtnAdd();
    }
    @When("clico no botão Novo registro na tela Home")
    public void clicoNoBotãoNovoRegistroNaTelaHome() {
        HomeActions.clicarBtnNovoRegistro();
    }







}
