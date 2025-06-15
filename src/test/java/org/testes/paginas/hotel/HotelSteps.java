package org.testes.paginas.hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HotelSteps {

    @Given("seleciono Onde você irá se hospedar? {string} na tela Hoteis")
    public void selecionoOndeVoceIraSeHospedarNaTelaHoteis(String destino) {
        HotelActions.campoOndeVoceIraSeHospedar(destino);
        HotelActions.selecionarDestino(destino);
    }
    @Given("clico no botão Confirmar destino na tela Hoteis")
    public void clicoNoBotaoConfirmarDestinoNaTelaHoteis() {
        HotelActions.clicarBtnConfirmarDestino();
    }
    @Given("clico no botão Continuar na tela Defina os detalhes")
    public void clicoNoBotaoContinuarNaTelaDefinaOsDetalhes() {
        HotelActions.clicarBtnContinuar();
    }
    @Given("clico no botão Continuar na tela Hoteis")
    public void clicoNoBotaoContinuarNaTelaHoteis() {
        HotelActions.clicarBtnContinuar();
    }
    @Given("valido a exibição da frase {string} na tela Hoteis")
    public void validoAExibicaoDaFraseNaTelaHoteis(String string) {
        HotelActions.validarLblEscolhaAEstadia();
    }

    @Given("valido a exibição da mensagem Sobre a hospedagem na tela Hoteis")
    public void validoAExibicaoDaMensagemSobreAHospedagemNaTelaHoteis() {
        HotelActions.validarLblSobreAHosedagem();
    }
    @Given("valido a exibição da mensagem Ver Mapas na tela Hoteis")
    public void validoAExibicaoDaMensagemVerMapasNaTelaHoteis() {
        HotelActions.validarLblVerMapas();
    }
    @And("seleciono a data {string} no campo Início na tela Hoteis")
    public void selecionoADataNoCampoInicioNaTelaHoteis(String dia) {
        HotelActions.selecionarDataInicio(dia);
    }

    @And("seleciono a data {string} no campo Fim na tela Hoteis")
    public void selecionoADataNoCampoFimNaTelaHoteis(String dia) {
        HotelActions.selecionarDataFim(dia);
    }

    @And("clico no botão Marcador do mapa na tela Hoteis")
    public void clicoNoBotaoMarcadorDoMapaNaTelaHoteis() {
        HotelActions.clicarBtnMarcadorDoMapa();

    }

    @Given("valido os Hotel {string} para selecionar na tela Hoteis")
    public void validoOsHotelParaSelecionarNaTelaHoteis(String string) {
        HotelActions.validarHotelArcelon();
    }

    @Given("valido a exibição da frase Ler mais na tela Hoteis")
    public void validoAExibicaoDaFraseSobreAHospedagemNaTelaHoteis() {
        HotelActions.validarLblLerMais();
    }
    @Given("valido a exibição da frase Ver mais na tela Hoteis")
    public void validoAExibicaoDaFraseComodidadesNaTelaHoteisNaTelaHoteis() {
        HotelActions.validarLblVerMais();
    }
    @Given("valido a exibição da frase Quartos disponíveis na tela Hoteis")
    public void validoAExibicaoDaFraseQuartosDisponiveisNaTelaHoteis() {
        HotelActions.validarLblQuartosEscolhido();
    }
    @When("clico no botão 'Continuar' na tela de Hoteis")
    public void clicoNoBotaoContinuarNaTelaDeHoteis() {
        HotelActions.clicarBtnContinuar();
    }

    @When("clico no botão 'Reservar' na tela de Hoteis")
    public void clicoNoBotaoReservarNaTelaDeHoteis() {
        HotelActions.clicarBtnReservar();
    }

    @When("clico no botão 'Voltar ao topo' na tela de Hoteis")
    public void clicoNoBotaoVoltarAoTopoNaTelaDeHoteis() {
        HotelActions.clicarBtnVoltarAoTopo();
    }

    @Given("clico no botão Ver resumo na tela {string}")
    public void clicoNoBotaoVerResumoNaTela(String string) {
        HotelActions.clicarBtnCheckout();
    }

    @Given("valido o Resumo do pedido na tela {string}")
    public void validoOResumoDoPedidoNaTela(String string) {
        HotelActions.clicarBtnVerResumo();
    }


}
