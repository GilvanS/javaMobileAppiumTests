package org.testes.paginas.hotel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

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

    }

    @Given("clico no botão Resorts na tela Hotel")
    public void clicarNoBotaoResortsNaTelaHotel() {

    }
    @Given("seleciono a data {string} no campo Início na tela Hotel")
    public void selecionoADataNoCampoInícioNaTelaHotel(String string) {

    }
    @Given("seleciono a data {string} no campo Fim na tela Hotel")
    public void selecionoADataNoCampoFimNaTelaHotel(String string) {

    }
    @Given("clico no botão Buscar na tela Hotel")
    public void clicarNoBotaoBuscarNaTelaHotel() {

    }
    @Given("clico no botão Ver detalhes na tela Hotel")
    public void clicarNoBotaoVerDetalhesNaTelaHotel() {

    }
    @Given("valido a exibição da label Ver quartos disponiveis na tela Hotel")
    public void validoAExibicaoDaLabelVerQuartosDisponiveisNaTelaHotel() {

    }
    @Given("clico no botão ver quartos disponiveis na tela Hotel")
    public void clicarNoBotaoVerQuartosDisponiveisNaTelaHotel() {

    }
    @Given("clico no botão reservar na tela Hotel")
    public void clicarNoBotaoReservarNaTelaHotel() {

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

    @Given("valido os Hoteis {string} para selecionar na tela Hoteis")
    public void validoOsHoteisParaSelecionarNaTelaHoteis(String string) {
    }

    @Given("valido a exibição da label Ver quartos disponiveis na tela Hoteis")
    public void validoAExibicaoDaLabelVerQuartosDisponiveisNaTelaHoteis() {
    }

    @And("clico no botão Marcador do mapa na tela Hoteis")
    public void clicoNoBotaoMarcadorDoMapaNaTelaHoteis() {
        HotelActions.clicarBtnMarcadorDoMapa();

    }
}
