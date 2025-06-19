package org.br.com.web.pages.contato;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import lombok.extern.log4j.Log4j2;
import org.br.com.web.driver.CustomActions;
import org.br.com.api.utils.LogFormatter;

@Log4j2
public class ContatoSteps {
    private final ContatoLogic contatoLogic;
    private final CustomActions actions;

    public ContatoSteps() {
        this.contatoLogic = new ContatoLogic();
        this.actions = new CustomActions();
    }

    @Given("que estou na pagina de contato")
    public void queEstouNaPaginaDeContato() {
        contatoLogic.validarMensagemEntreEmContato();
    }

    @Then("valido a exibicao da mensagem 'Entre em Contato'")
    public void validoAExibicaoDaMensagemEntreEmContato() {
        contatoLogic.validarMensagemEntreEmContato();
    }

    @Then("valido a mensagem 'Por favor, preencha todos os campos obrigatorios'")
    public void validoAMensagemCamposObrigatorios() {
        contatoLogic.validarMensagemCamposObrigatorios();
    }

    @Then("valido a mensagem 'Por favor, insira um email valido'")
    public void validoAMensagemEmailInvalido() {
        contatoLogic.validarMensagemEmailInvalido();
    }

    // @Then("valido a exibicao da mensagem 'Sobre a Orizon'")
    // public void validoAExibicaoDaMensagemSobreOrizon() {
    //     contatoLogic.validarMensagemSobreOrizon();
    // }

    // @Then("valido a exibicao da mensagem 'Inteligência médica, inteligência'")
    // public void validoAExibicaoDaMensagemConsultoria() {
    //     contatoLogic.validarMensagemConsultoria();
    // }

    // @Then("valido a exibicao da mensagem 'LGPD na Orizon'")
    // public void validoAExibicaoDaMensagemLgpdNaOrizon() {
    //     contatoLogic.validarMensagemLgpdNaOrizon();
    // }

    @And("seleciono a opcao {string} no campo {string}")
    public void selecionoAOpcaoNoCampo(String opcao, String campo) {
        contatoLogic.selecionarOpcaoAssunto(opcao);
    }

    @And("marco o checkbox de concordo")
    public void marcoOCheckboxDeConcordo() {
        contatoLogic.marcarCheckboxConcordo();
    }

    @Then("valido o reCAPTCHA")
    public void validoOReCAPTCHA() {
        contatoLogic.validarRecaptcha();
    }

    @Then("valido que o formulario foi preenchido corretamente")
    public void validoQueOFormularioFoiPreenchidoCorretamente() {
    }

    @When("preencho o campo 'Nome' com {string}")
    public void preenchoOCampoNomeCom(String nome) {
        contatoLogic.preencherCampoNome(nome);
    }

    @When("preencho o campo 'Email' com {string}")
    public void preenchoOCampoEmailCom(String email) {
        contatoLogic.preencherCampoEmail(email);
    }

    @When("preencho o campo 'Documento' com {string}")
    public void preenchoOCampoDocumentoCom(String documento) {
        contatoLogic.preencherCampoDocumento(documento);
    }

    @When("preencho o campo 'Telefone' com {string}")
    public void preenchoOCampoTelefoneCom(String telefone) {
        contatoLogic.preencherCampoTelefone(telefone);
    }

    @When("preencho o campo 'Mensagem' com {string}")
    public void preenchoOCampoMensagemCom(String mensagem) {
        contatoLogic.preencherCampoMensagem(mensagem);
    }

    @And("preencho o campo 'Assunto' com {string}")
    public void preenchoOCampoAssuntoCom(String assunto) {
        contatoLogic.preencherCampoAssunto(assunto);
    }

    @And("valido que o campo {string} esta destacado em vermelho")
    public void validoQueOCampoEstaDestacadoEmVermelho(String nomeCampo) {
        contatoLogic.validarCampoDestacadoVermelho(nomeCampo);
    }

    @And("clico no botao 'Enviar'")
    public void clicoNoBotaoEnviar() {
        contatoLogic.clicarBotaoEnviar();
    }
    @And("clico no botao 'Entrar'")
        public void clicoNoBotaoEntrar() {
            contatoLogic.clicarBotaoEntrar();
        }

    @Then("valido a mensagem 'Mensagem enviada com sucesso'")
    public void validoAMensagemEnviadaComSucesso() {
        contatoLogic.validarMensagemSucesso();
    }

    @And("valido que o campo 'Nome' retorna {string}")
    public void validoQueOCampoNomeEstaDestacadoComMensagem(String mensagem) {
        contatoLogic.validarMensagemCampoObrigatorio(contatoLogic.getContatoElements().getTxtNome(), mensagem);
    }

    @And("valido que o campo 'Email' esta destacado {string}")
    public void validoQueOCampoEmailEstaDestacadoComMensagem(String mensagem) {
        contatoLogic.validarMensagemCampoObrigatorio(contatoLogic.getContatoElements().getTxtEmail(), mensagem);
    }

    @And("valido que o campo 'Assunto' esta destacado {string}")
    public void validoQueOCampoAssuntoEstaDestacadoComMensagem(String mensagem) {
        contatoLogic.validarMensagemCampoObrigatorio(contatoLogic.getContatoElements().getCmbAssunto(), mensagem);
    }

    @And("valido que o campo 'Mensagem' esta destacado {string}")
    public void validoQueOCampoMensagemEstaDestacadoComMensagem(String mensagem) {
        contatoLogic.validarMensagemCampoObrigatorio(contatoLogic.getContatoElements().getTxtMensagem(), mensagem);
    }

    @Then("valido a mensagem nativa do navegador {string}")
    public void validoAMensagemNativaDoNavegador(String mensagem) {
        contatoLogic.validarMensagemCampoObrigatorio(contatoLogic.getContatoElements().getTxtEmail(), mensagem);
    }
}