package org.testes.paginas.pacotes;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PacotesSteps {


    @When("seleciono a cidade {string} no campo Origem na tela Passagens")
    public void seleciono_a_cidade_no_campo_origem_na_tela_passagens(String origem) {
        PacotesActions.clicarEPreencherCampoOrigem(origem);
    }

    @When("seleciono a cidade {string} no campo Destino na tela Passagens")
    public void seleciono_a_cidade_no_campo_destino_na_tela_passagens(String destino) {
        PacotesActions.clicarEPreencherCampoDestino(destino);
    }

    @When("clico no botão Continuar na tela Passagens")
    public void clicar_no_botão_continuar_na_tela_passagens() {
        PacotesActions.clicarBtnContinuar();
    }

    @When("clico no botão Confirmar Detalhes na tela Passagens")
    public void clicar_no_botão_confirmar_detalhes_na_tela_passagens() {
        PacotesActions.clicarBtnConfirmarDetalhes();
    }

    @When("seleciono a data {string} no campo Início na tela Passagens")
    public void seleciono_a_data_no_campo_início_na_tela_passagens(String string) {
        PacotesActions.selecionarDataIda();
    }
    @When("seleciono a data {string} no campo Fim na tela Passagens")
    public void seleciono_a_data_no_campo_fim_na_tela_passagens(String string) {
        PacotesActions.selecionarDataRetorno();
    }

    @When("clico no botão Confirmar datas na tela Passagens")
    public void clicar_no_botão_confirmar_datas_na_tela_passagens() {
        PacotesActions.clicarBtnConfirmarDatas();
    }

    @Then("valido a exibição das buscas disponiveis na tela Passagens")
    public void valido_a_exibição_das_buscas_disponiveis_na_tela_passagens() throws InterruptedException {
        PacotesActions.vldTxtPacoteRecomendado();
        PacotesActions.vldTxtIda();
        PacotesActions.clicarBtnReservarAgora();
    }

}
