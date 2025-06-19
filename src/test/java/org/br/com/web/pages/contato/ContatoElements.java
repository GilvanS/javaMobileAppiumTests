package org.br.com.web.pages.contato;

import lombok.Getter;
import org.br.com.web.pages.MasterPageFactory;
import org.br.com.web.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

@Getter
public class ContatoElements extends MasterPageFactory {

    @FindBy(xpath = "//h1[contains(text(),'Contato')]")
    private WebElement tituloContato;

    @FindBy(xpath = "//*[@name= 'nome']")
    private WebElement campoNome;

    @FindBy(xpath = "//*[@name= 'email']")
    private WebElement campoEmail;

    @FindBy(id = "assunto")
    private WebElement campoAssunto;

    @FindBy(id = "mensagem")
    private WebElement campoMensagem;

    @FindBy(xpath = "//div[contains(@class,'success')]")
    private WebElement mensagemSucesso;

    @FindBy(xpath = "//div[contains(@class,'error')]")
    private WebElement mensagemErro;

    @FindBy(xpath = "//h1[contains(@class,'elementor-heading-title') and contains(text(),'Inteligência de dados para')]")
    private WebElement lblTituloPrincipal;

    @FindBy(xpath = "//*[text()='Contato']")
    private WebElement btnContato;

    @FindBy(xpath = "//h2[contains(text(),'ENTRE EM CONTATO')]")
    private WebElement lblEntreEmContato;

    @FindBy(xpath = "//a[@id='acesso_solucao_orizon']")
    private WebElement btnAcessoUsuario;

    @FindBy(xpath = "//a[contains(@class,'elementor-item') and contains(text(),'Quem somos')]")
    private WebElement btnQuemSomos;

    @FindBy(xpath = "//a[contains(@class,'elementor-item') and contains(text(),'Soluções')]")
    private WebElement btnSolucoes;

    @FindBy(xpath = "//a[contains(@class,'elementor-item') and contains(text(),'Trabalhe Conosco')]")
    private WebElement btnTrabalheConosco;

    @FindBy(xpath = "//input[@name='nome']")
    private WebElement txtNome;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@name='documento']")
    private WebElement txtDocumento;

    @FindBy(xpath = "//input[@name='telefone']")
    private WebElement txtTelefone;

    @FindBy(xpath = "//select[@id='form-field-field_69121a8']")
    private WebElement cmbAssunto;

    @FindBy(xpath = "//textarea[@name='mensagem']")
    private WebElement txtMensagem;

    @FindBy(xpath = "//input[@type='checkbox' and @name='term']")
    private WebElement chkConcordo;

    @FindBy(xpath = "//iframe[contains(@src,'recaptcha')]")
    private WebElement iframeRecaptcha;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    private WebElement chkRecaptcha;

    @FindBy(xpath = "//*[text()= 'Enviar']")
    private WebElement btnEnviar;

    @FindBy(xpath = "//*[text()= 'Entrar']")
    private WebElement btnEntrar;

    @FindBy(xpath = "//div[contains(@class,'elementor-message') and contains(text(),'Por favor, preencha todos os campos obrigatorios')]")
    private WebElement lblCamposObrigatorios;

    @FindBy(xpath = "//div[contains(@class,'elementor-message') and contains(text(),'Por favor, insira um email valido')]")
    private WebElement lblEmailInvalido;

    // Método para verificar elementos similares
    public List<WebElement> getElementosSimilares(String texto) {
        return Driver.getDriver().findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
    }

    public ContatoElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement campoDestacadoVermelho(String nomeCampo) {
        String xpathFormatado = String.format("//div[contains(@class,'elementor-field-group') and .//label[contains(text(),'%s')]]//input[contains(@class,'elementor-field') and contains(@class,'elementor-error')]", nomeCampo);
        return Driver.getDriver().findElement(By.xpath(xpathFormatado));
    }
}