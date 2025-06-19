package org.br.com.web.pages.contato;

import lombok.extern.log4j.Log4j2;
import org.br.com.web.driver.CustomActions;
import org.br.com.api.utils.LogFormatter;
import org.br.com.web.pages.home.HomeLogic;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

@Log4j2
public class ContatoLogic {
    private final ContatoElements contatoElements;
    private final CustomActions actions;
    private final HomeLogic homeLogic = new HomeLogic();

    public ContatoLogic() {
        this.contatoElements = new ContatoElements();
        this.actions = new CustomActions();
    }

    public void validarMensagemEntreEmContato() {
        LogFormatter.logStep("Validando mensagem 'Entre em Contato'");
        assertTrue(actions.waitElementDisplayed(contatoElements.getLblEntreEmContato()));
    }

    public void validarMensagemCamposObrigatorios() {
        LogFormatter.logStep("Validando mensagem de campos obrigatorios");
        assertTrue(actions.waitElementDisplayed(contatoElements.getLblCamposObrigatorios()));
    }

    public void validarMensagemEmailInvalido() {
        LogFormatter.logStep("Validando mensagem de email invalido");
        assertTrue(actions.waitElementDisplayed(contatoElements.getLblEmailInvalido()));
    }

    public void validarMensagemSobreOrizon() {
        LogFormatter.logStep("Validando mensagem 'Sobre a Orizon'");
        homeLogic.validarMensagemSobreOrizon();
    }

    public void validarMensagemConsultoria() {
        LogFormatter.logStep("Validando mensagem de consultoria");
        homeLogic.validarMensagemConsultoria();
    }

    public void validarMensagemLgpdNaOrizon() {
        LogFormatter.logStep("Validando mensagem 'LGPD na Orizon'");
        homeLogic.validarMensagemLgpdNaOrizon();
    }

    public void selecionarOpcaoAssunto(String opcao) {
        LogFormatter.logStep("Selecionando opcao do campo Assunto: " + opcao);
        actions.waitElementDisplayed(contatoElements.getCmbAssunto());
        Select select = new Select(contatoElements.getCmbAssunto());
        select.selectByVisibleText(opcao);
    }

    public void marcarCheckboxConcordo() {
        LogFormatter.logStep("Marcando checkbox de concordo");
        actions.waitElementDisplayed(contatoElements.getChkConcordo());
        actions.click(contatoElements.getChkConcordo());
    }

    public void validarRecaptcha() {
        LogFormatter.logStep("Validando reCAPTCHA");
        actions.waitElementDisplayed(contatoElements.getIframeRecaptcha());
    }

    public void preencherCampoNome(String nome) {
        LogFormatter.logStep("Preenchendo campo Nome");
        actions.waitElementDisplayed(contatoElements.getTxtNome());
        actions.sendKeys(contatoElements.getTxtNome(), nome);
    }

    public void preencherCampoEmail(String email) {
        LogFormatter.logStep("Preenchendo campo Email"+ email);
        actions.waitElementDisplayed(contatoElements.getTxtEmail());
        actions.sendKeys(contatoElements.getTxtEmail(), email);
    }

    public void preencherCampoDocumento(String documento) {
        LogFormatter.logStep("Preenchendo campo Documento"+ documento);
        actions.waitElementDisplayed(contatoElements.getTxtDocumento());
        actions.sendKeys(contatoElements.getTxtDocumento(), documento);
    }

    public void preencherCampoTelefone(String telefone) {
        LogFormatter.logStep("Preenchendo campo Telefone"+ telefone);
        actions.waitElementDisplayed(contatoElements.getTxtTelefone());
        actions.sendKeys(contatoElements.getTxtTelefone(), telefone);
    }

    public void preencherCampoAssunto(String assunto) {
        LogFormatter.logStep("Preenchendo campo Assunto"+ assunto);
        actions.waitElementDisplayed(contatoElements.getCmbAssunto());
        Select select = new Select(contatoElements.getCmbAssunto());
        select.selectByVisibleText(assunto);
    }

    public void preencherCampoMensagem(String mensagem) {
        LogFormatter.logStep("Preenchendo campo Mensagem"+ mensagem);
        actions.waitElementDisplayed(contatoElements.getTxtMensagem());
        actions.sendKeys(contatoElements.getTxtMensagem(), mensagem);
    }

    public void clicarBotaoEnviar() {
        LogFormatter.logStep("Clicando no botao Enviar");
        actions.waitElementDisplayed(contatoElements.getCampoNome());
        actions.click(contatoElements.getBtnEnviar());
    }

    public void clicarBotaoEntrar() {
        LogFormatter.logStep("Clicando no botao Entrar");
        actions.waitElementDisplayed(contatoElements.getBtnEntrar());
        actions.click(contatoElements.getBtnEntrar());
    }

    public void validarMensagemSucesso() {
        LogFormatter.logStep("Validando mensagem de sucesso");
        assertTrue(actions.waitElementDisplayed(contatoElements.getMensagemSucesso()));
    }

    public void validarMensagemErro() {
        LogFormatter.logStep("Validando mensagem de erro");
        actions.waitElementDisplayed(contatoElements.getCampoNome());
        assertTrue(actions.waitElementDisplayed(contatoElements.getMensagemErro()));
    }

    public void validarCampoDestacadoVermelho(String nomeCampo) {
        LogFormatter.logStep("Validando campo " + nomeCampo + " destacado em vermelho");
        assertTrue(actions.waitElementDisplayed(contatoElements.campoDestacadoVermelho(nomeCampo)));
    }

    /**
     * Valida a mensagem nativa de campo obrigatório do navegador
     * @param campo WebElement do campo a ser validado
     * @param mensagemEsperada Texto esperado da mensagem nativa
     */
    public void validarMensagemCampoObrigatorio(WebElement campo, String mensagemEsperada) {
        LogFormatter.logStep("Validando mensagem nativa de campo obrigatorio: " + mensagemEsperada);
        try {
            org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) org.br.com.web.driver.Driver.getDriver();
            String validationMessage = (String) js.executeScript(
                "return arguments[0].validationMessage;", campo);
            assertTrue(validationMessage.contains(mensagemEsperada));
        } catch (Exception e) {
            LogFormatter.logStep("Erro ao validar mensagem nativa de campo obrigatorio: " + e.getMessage());
            throw e;
        }
    }

    public ContatoElements getContatoElements() {
        return this.contatoElements;
    }
}