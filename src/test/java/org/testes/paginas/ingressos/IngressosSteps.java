package org.testes.paginas.ingressos;

import io.cucumber.java.en.Given;

public class IngressosSteps {

    @Given("seleciono o {string} na tela 'Ingressos'")
    public void selecionoONaTelaIngressos(String destino) {
        IngressosActions.clicarEPreencherCamoDestino(destino);
    }
    @Given("clicar no botão Escolha a data {string} na tela 'Ingressos'")
    public void clicarNoBotãoEscolhaADataNaTelaIngressos(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
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

}
