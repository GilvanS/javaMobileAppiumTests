package org.br.com.web.pages.home;

import lombok.Getter;
import org.br.com.web.pages.MasterPageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.br.com.web.driver.Driver;

/**
 * Classe que contém os elementos da página inicial
 */
@Getter
public class HomeElements extends MasterPageFactory {

    @FindBy(xpath = "//a[contains(@class, 'cc-allow') and contains(text(), 'Permitir todos os Cookies')]")
    private WebElement btnPermitirCookies;

    @FindBy(xpath = "//*[text()='Trabalhe Conosco']")
    private WebElement btnTrabalheConosco;

    @FindBy(xpath = "//*[text()='Soluções']")
    private WebElement btnSolucoes;
    //*[contains(text(),'FRENTE AUTOMATIZADA')]
    @FindBy(xpath = "//*[contains(text(),'Frente') and contains (text(),'Automatizada')]")
    private WebElement btnFrenteAutomatizada;

    @FindBy(xpath = "//*[text()='Consultoria']")
    private WebElement btnConsultoria;

    @FindBy(xpath = "//*[text()='Quem somos']")
    private WebElement btnQuemSomos;
    //*[contains(text(),'Frente') and contains (text(),'Automatizada')]
    @FindBy(xpath = "(//*[contains(text(),'LGPD na') and contains(text(),'Orizon')])[1]")
    private WebElement btnLgpdNaOrizon;

    @FindBy(xpath = "//*[text()='Sobre a Orizon']")
    private WebElement lblSobreOrizon;

    @FindBy(xpath = "//*[contains(text(),'FRENTE AUTOMATIZADA')]")
    private WebElement lblFrenteAutomatizada;

    @FindBy(xpath = "//*[contains(text(),'Inteligência médica, inteligência')]")
    private WebElement lblConsultoria;

    @FindBy(xpath = "//*[contains(text(),'LGPD NA ORIZON')]")
    private WebElement lblLgpdNaOrizon;

    public HomeElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(text(),'Inteligência de dados para')]")
    private WebElement lblTituloTelaInicial;

    @FindBy(xpath = "//*[text()='Acesso do usuário']")
    private WebElement btnAcessoUsuario;

    @FindBy(xpath = "//*[text()='Seja bem-vindo ao portal do usuário Orizon.']")
    private WebElement lblBemVindo;

    @FindBy(xpath = "//*[text()='Contato']")
    private WebElement btnContato;

    @FindBy(xpath = "//*[contains(text(),'Para saber mais sobre as soluções')]")
    private WebElement lblSobreSolucoes;

} 