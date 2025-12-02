package org.com.fintech.test.paginas.pix;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class PixSteps {



    @And("clico no botao 'Cadastrar Nova Chave' na 'tela Minhas Chaves PIX'")
    public void clicoNoBotaoCadastrarNovaChaveNaTelaMinhasChavesPIX() {
        PixActions.clicarCadastrarNovaChave();
    }

    @And("clico no botao 'Minhas Chaves' na 'tela PIX'")
    public void clicoNoBotaoMinhasChavesNaTelaPIX() {
        PixActions.clicarMinhasChaves();
    }

    @And("seleciono o tipo de chave para cadastro na tela 'tela Minhas Chaves PIX'")
    public void selecioOTipoDeChaveParaCadastroNaTelaCadastrarNovaChavePIX() {
        PixActions.selecionarTipoChaveEmail();
    }

    @And("preencho o campo chave com 'email' 'tela Minhas Chaves PIX'")
    public void preenchoOCampoChaveComEmailCadastrarNovaChavePIX() {
        PixActions.preencherChaveEmail();
    }

    @And("clico no botao 'Cadastrar' na 'tela Minhas Chaves PIX'")
    public void clicoNoBotaoCadastrarNaTelaMinhasChavesPIX() {
        PixActions.clicarBtnCadastrar();
    }

    @Then("valido a mensagem de sucesso 'Chave cadastrada com sucesso!' na 'tela Minhas Chaves PIX'")
    public void validoAMensagemDeSucessoChaveCadastradaComSucessoNaTelaMinhasChavesPIX() throws InterruptedException {
        PixActions.validarMensagemSucesso();
    }

    @And("valido a chave cadastrada na lista de chaves na 'tela Minhas Chaves PIX'")
    public void validoAChaveCadastradaNaListaDeChavesNaTelaMinhasChavesPIX() {
        PixActions.validarChaveNaLista();
    }

    @And("clico no botão excluir chave pix Email na 'tela Minhas Chaves PIX'")
    public void clicoNoBotãoExcluirChavePixEmailNaTelaMinhasChavesPIX() {
        PixActions.btnExcluirChavePixEmail();
    }

    @Then("valido a mensagem de sucesso 'Chave removida' na 'tela Minhas Chaves PIX'")
    public void validoAMensagemDeSucessoChaveRemovidaNaTelaMinhasChavesPIX() {
        PixActions.validarMensagemChaveRemovida();
    }

    @Then("valido a mensagem de sucesso 'Nenhuma chave PIX cadastrada.' na 'tela Minhas Chaves PIX'")
    public void validoAMensagemDeSucessoNenhumaChavePixCadastradaNaTelaMinhasChavesPIX() {
        PixActions.validarMensagemNenhumaChavePixCadastrada();
    }


}
