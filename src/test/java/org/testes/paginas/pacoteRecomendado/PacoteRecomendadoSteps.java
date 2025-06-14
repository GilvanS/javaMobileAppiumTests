package org.testes.paginas.pacoteRecomendado;

import io.cucumber.java.en.When;
import org.utilidades.evidencia.PrintScreen;

import java.io.IOException;

public class PacoteRecomendadoSteps {

    @When("clico no botão 'Detalhes do Hotel' na tela 'Pacote recomendado'")
    public void clico_no_botao_detalhes_do_hotel_na_tela_pacote_recomendado() {
        PacoteRecomendadoActions.clicarBtnDetalhesDoHotel();

    }
    @When("valido a exibição da mensagem 'Detalhes do Hotel' na tela 'Pacote recomendado'")
    public void valido_a_exibição_da_mensagem_detalhes_do_hotel_na_tela_pacote_recomendado() throws InterruptedException {
        PacoteRecomendadoActions.validarLblTxtDetalhesDoHotel();
    }
    @When("clico no botão 'Voltar' na tela 'Pacote recomendado'")
    public void clico_no_botao_voltar_na_tela_pacote_recomendado() {
        PacoteRecomendadoActions.clicarBtnVoltarDetalhesDoHotel();
    }
    @When("clico no botão 'Detalhes ida' na tela 'Pacote recomendado'")
    public void clico_no_botao_detalhes_ida_na_tela_pacote_recomendado() throws IOException {
        PrintScreen.screenshot("teste");
    }
    @When("valido a exibição da mensagem 'Em todo voo você tem' na tela 'Pacote recomendado'")
    public void valido_a_exibição_da_mensagem_em_todo_voo_você_tem_na_tela_pacote_recomendado() throws IOException {
        PrintScreen.screenshot("teste");
    }
    @When("clico no botão 'Detalhes volta' na tela 'Pacote recomendado'")
    public void clico_no_botao_detalhes_volta_na_tela_pacote_recomendado() throws IOException {
        PrintScreen.screenshot("teste");
    }
    @When("clico no botão 'Detalhes do valor' na tela 'Pacote recomendado'")
    public void clico_no_botao_detalhes_do_valor_na_tela_pacote_recomendado() throws InterruptedException {
        PacoteRecomendadoActions.clicarBtnDetalhesDoValor();
    }
    @When("clico no botão 'Fechar' na tela 'Pacote recomendado'")
    public void clico_no_botao_fechar_na_tela_pacote_recomendado() {
        PacoteRecomendadoActions.clicarBtnFecharDetalhesDoValor();
    }
    @When("clico no botão 'Reservar Agora' na tela 'Pacote recomendado'")
    public void clico_no_botao_reservar_agora_na_tela_pacote_recomendado() {
        PacoteRecomendadoActions.clicarBtnReservarAgora();
    }
    @When("valido a exibição da mensagem 'Viaje com mais conforto!' na tela 'Pacote recomendado'")
    public void valido_a_exibição_da_mensagem_viaje_com_mais_conforto_na_tela_pacote_recomendado() throws IOException {
        PrintScreen.screenshot("teste");
    }
    @When("clico no botão 'Continuar' na tela 'Pacote recomendado'")
    public void clico_no_botao_continuar_na_tela_pacote_recomendado() {
        PacoteRecomendadoActions.clicarBtnContinuar();
    }
    @When("valido a exibição da mensagem 'Atenção ao inicio da sua estadia' na 'Pacote recomendado'")
    public void valido_a_exibição_da_mensagem_atenção_ao_inicio_da_sua_estadia_na_pacote_recomendado() throws IOException {
        PrintScreen.screenshot("Atenção ao inicio da sua estadia");
    }
    @When("clico no botão 'Estou ciente' na tela 'Pacote recomendado'")
    public void clico_no_botao_estou_ciente_na_tela_pacote_recomendado() {
        PacoteRecomendadoActions.clicarBtnEstouCiente();
    }

}
