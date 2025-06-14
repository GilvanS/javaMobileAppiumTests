package org.testes.paginas.aluguelDeCarros;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class AluguelDeCarrosSteps {

    @When("seleciono o {string} na tela 'Aluguel de carros'")
    public void selecionoONaTelaAluguelDeCarros(String retirar) throws InterruptedException {
        AluguelDeCarrosActions.clicarEPreencherCampoOndeVoceQuerRetirarSeuCarro(retirar);
    }

    @When("clico no botão 'Continuar' na tela 'Aluguel de carros'")
    public void clicarNoBotaoContinuarNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnContinuar();
    }

    @When("clico no botão 'Alterar Horario Retirada' na tela 'Aluguel de carros'")
    public void clicoNoBotaoAlterarHorarioRetiradaNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnAlterarHorarioRetirada();
    }

    @When("seleciono o horario na tela 'Aluguel de carros'")
    public void selecionoOHorarioNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.informoOHorarioDevolucao();
        AluguelDeCarrosActions.clicarBtnOk();
    }

    @When("clico no botão 'Alterar Horario Devolução' na tela 'Aluguel de carros'")
    public void clicoNoBotaoAlterarHorarioDevolucaoNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnAlterarHorarioDevolucao();
    }

    @When("clico no botão 'Buscar carros' na tela 'Aluguel de carros'")
    public void clicarNoBotaoBuscarNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnBuscarCarros();
    }
    @Then("clico no botão 'Conferir' detalhes na tela 'Aluguel de carros'")
    public void clicarNoBotaoConferirDetalhesNaTelaAluguelDeCarros() throws InterruptedException {
        AluguelDeCarrosActions.SelecionaroCarroToyota();
    }

    @Then("valido a exibição da frase 'Ver Rotas' na tela 'Aluguel de carros'")
    public void validoAExibicaoDaFraseVerRotasNaTelaAluguelDeCarros() throws InterruptedException, IOException {
        AluguelDeCarrosActions.validarLblVerRotas();
//        AluguelDeCarrosActions.validarLblVerMais();
    }

    @Then("valido a exibição da frase 'Carro escolhido' na tela 'Aluguel de carros'")
    public void validoAExibicaoDaFraseCarroEscolhidoNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.validarLblCarroEscolhido();
    }

    @Then("valido a exibição da frase 'Escolher carro' na tela 'Aluguel de carros'")
    public void validoAExibicaoDaFraseEscolherCarroNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.validarLblEscolherCarro();
    }

    @Then("clico no botão 'Voltar ao topo' na tela 'Aluguel de carros'")
    public void clicoNoBotaoVoltarAoTooNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnVoltarAoTopo();
    }

    @Then("clico no botão 'Reservar' na tela 'Aluguel de carros'")
    public void clicoNoBotaoReservarNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnReservar();
    }
    @Then("clico no botão 'Ver detalhes' na tela 'Aluguel de carros'")
    public void clicoNoBotaoVerDetalhesNaTelaAluguelDeCarros() {
        AluguelDeCarrosActions.clicarBtnVerDetalhes();
    }
    @Then("valido a exibição da frase 'Características' na tela 'Aluguel de carros'")
    public void validoAExibicaoDaFraseCaracteristicasNaTelaLogin() throws InterruptedException {
        AluguelDeCarrosActions.btnCaracteristicas();
    }


}
