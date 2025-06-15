package org.testes.paginas.ingressos;

import io.cucumber.java.en.Given;
import org.testes.driver.actions.PageBaseActions;
import org.testes.utils.Hooks;

public class IngressosSteps {

    private static final PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    @Given("valido a exibição da frase Escolhar um parque na tela {string}")
    public void validoAExibicaoDaFraseEscolharUmParqueNaTela(String string) {
        IngressosActions.validarEscolharUmParque();
    }

    @Given("seleciono o {string} na tela 'Ingressos'")
    public void selecionoONaTelaIngressos(String destino) {
        IngressosActions.clicarEPreencherCamoDestino(destino);
    }
    @Given("clicar no botão Escolha a data {string} na tela 'Ingressos'")
    public void clicarNoBotaoEscolhaADataNaTelaIngressos(String dia) {
        IngressosActions.clicarNoDiaDoCalendario(dia);
    }

    @Given("seleciono a data {string} na tela 'Ingressos'")
    public void selecionoADataFimNaTelaIngressos(String dia) {
        IngressosActions.clicarNoDiaDoCalendario(dia);
    }

    @Given("clico no botão Continuar na tela Ingressos")
    public void clicoNoBotaoContinuarNaTelaIngressos() {
        IngressosActions.clicarNoBotaoContinuar();
    }

    @Given("clicar no botão Escolha a data {string} e {string} na tela 'Ingressos'")
    public void clicarNoBotaoEscolhaADataInicioEFimNaTelaIngressos(String dataInicio, String dataFim) {
        IngressosActions.selecionarDatasCalendario(dataInicio, dataFim);
    }
    @Given("clicar no botão 'Buscar' na tela {string}")
    public void clicarNoBotãoBuscarNaTela(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("clicar no botão 'Conferir' detalhes na tela 'Ingressos'")
    public void clicarNoBotãoConferirDetalhesNaTelaIngressos() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("clico no botão Confirmar parque na tela Ingressos")
    public void clicoNoBotaoConfirmarParqueNaTelaIngressos() {
        IngressosActions.clicarNoBotaoConfirmarParque();
    }

    @Given("clico no botão Confirmar datas na tela Ingressos")
    public void clicoNoBotaoConfirmarDatasNaTelaIngressos() {
        IngressosActions.clicarNoBotaoConfirmarDatas();
    }

    @Given("clico no botão Conferir detalhes na tela Ingressos")
    public void clicoNoBotaoConferirDetalhesNaTelaIngressos() {
        IngressosActions.clicarNoBotaoConferirDetalhes();
    }

    @Given("clico o botão Reservar na tela Ingressos")
    public void clicoOBotaoReservarNaTelaIngressos() {
        IngressosActions.clicarNoBotaoReservar();
    }

    @Given("valido a exibição da frase Resumo de Pedido tela {string}")
    public void validoAExibicaoDaFraseResumoDePedidoTela(String texto) {
        IngressosActions.validarResumoDePedido(texto);
    }
}
