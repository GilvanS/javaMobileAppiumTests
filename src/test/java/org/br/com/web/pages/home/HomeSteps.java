package org.br.com.web.pages.home;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.br.com.api.utils.LogFormatter;

/**
 * Classe que contém os passos de teste da página inicial
 */
public class HomeSteps {

    private final HomeLogic homeLogic;

    public HomeSteps() {
        this.homeLogic = new HomeLogic();
    }

    @Given("que estou na pagina inicial")
    public void queEstouNaPaginaInicial() {
        homeLogic.validarExibicaoTelaInicial();
    }

    @Then("valido a exibicao do menu principal")
    public void validoAExibicaoDoMenuPrincipal() {
        homeLogic.validarMenuPrincipal();
    }

    @When("clico no botao 'Acesso do usuario'")
    public void clicoNoBotaoAcessoDoUsuario() {
        homeLogic.clicarBotaoAcessoUsuario();
    }

    @Then("valido a exibicao da mensagem 'Seja bem-vindo ao portal do usuario Orizon.'")
    public void validoAExibicaoDaMensagemBemVindo() {
        homeLogic.validarMensagemBemVindo();
    }

    @When("clico no botao 'Contato'")
    public void clicoNoBotaoContato() {
        homeLogic.clicarBtnContato();
    }


    @Then("valido a exibicao da mensagem 'Para saber mais sobre as soluções'")
    public void validoAExibicaoDaMensagemSobreSolucoes() {
        homeLogic.validarExibicaoLblSobreSolucoes();
    }

    @When("clico no botao 'Trabalhe Conosco'")
    public void clicoNoBotaoTrabalheConosco() {
        homeLogic.clicarBotaoTrabalheConosco();
    }

    @And("troco para a nova aba")
    public void trocoParaNovaAba() {
        homeLogic.trocarNovaAba();
    }

    @Then("valido a exibicao da mensagem 'Sobre a Orizon'")
    public void validoExibicaoMensagemSobreOrizon() {
        homeLogic.validarMensagemSobreOrizon();
    }

    @When("clico no botao 'Soluções'")
    public void clicoNoBotaoSolucoes() {
        homeLogic.clicarBotaoSolucoes();
    }

    @Then("valido a exibicao das mensagens 'Frente', 'Automatizada', 'Apoio', 'Consultoria'")
    public void validoExibicaoMensagensSolucoes() {
        homeLogic.validarMensagensSolucoes();
    }

    @And("clico no botao 'Frente Automatizada'")
    public void clicoNoBotaoFrenteAutomatizada() {
        homeLogic.clicarBotaoFrenteAutomatizada();
    }

    @Then("valido a exibicao da mensagem 'FRENTE AUTOMATIZADA'")
    public void validoExibicaoMensagemFrenteAutomatizada() {
        homeLogic.validarMensagemFrenteAutomatizada();
    }

    @And("clico no botao 'Consultoria'")
    public void clicoNoBotaoConsultoria() {
        homeLogic.clicarBotaoConsultoria();
    }

    @Then("valido a exibicao da mensagem 'Inteligência médica, inteligência'")
    public void validoExibicaoMensagemConsultoria() {
        homeLogic.validarMensagemConsultoria();
    }

    @When("clico no botao 'Quem somos'")
    public void clicoNoBotaoQuemSomos() {
        homeLogic.clicarBotaoQuemSomos();
    }

    @And("clico no botao 'LGPD na Orizon'")
    public void clicoNoBotaoLgpdNaOrizon() {
        homeLogic.clicarBotaoLgpdNaOrizon();
    }

    @Then("valido a exibicao da mensagem 'LGPD NA ORIZON'")
    public void validoExibicaoMensagemLgpdNaOrizon() {
        homeLogic.validarMensagemLgpdNaOrizon();
    }
} 