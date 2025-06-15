package org.testes.paginas.home;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class HomeSteps {

    @Given("clico no botão 'Pular introdução'")
    public void clicar_no_botão_pular_introdução() {
        HomeActions.clicarBtnPularIntroducao();
    }

    @Given("valido a exibição da frase 'Olá' Pesquise na tela 'Home'")
    public void valido_a_exibição_da_frase_olá_pesquise_na_tela_home() throws IOException {
        HomeActions.vldTxtOla();
    }

    @Given("clico no botão 'Entrar' na tela 'Home'")
    public void clicar_no_botão_entrar_na_tela_home() {
        HomeActions.clicarBtnEntrar();
    }

    @Then("valido a exibição da frase 'Olá, 4Win' na tela 'Home'")
    public void valido_a_exibição_da_frase_olá_4win_na_tela_home() throws IOException {
        HomeActions.vldTxtOla4Win();
    }

    @Given("clico no botão 'Pacotes' na tela 'Home'")
    public void clicar_no_botão_pacotes_na_tela_home() {
        HomeActions.clicarBtnPacotes();
    }

    @When("clico no botão 'Carros' tela 'Home'")
    public void clicarNoBotaoCarrosTelaHome() {
        HomeActions.clicarBtnCarros();
    }

    @Given("clico no botão 'Ingressos' na tela 'Home'")
    public void clicarNoBotaoIngressosNaTelaHome() {
        HomeActions.swipeCarrosselAteIngressosEClicarView3();
    }

    @Given("clico no botão 'Hotéis' na tela 'Home'")
    public void clicarNoBotaoHoteisNaTelaHome() {
        HomeActions.clicarBtnHoteis();
    }

}
