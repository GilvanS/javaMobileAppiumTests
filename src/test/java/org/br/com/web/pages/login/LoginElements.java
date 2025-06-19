package org.br.com.web.pages.login;

import lombok.Getter;
import org.br.com.web.pages.MasterPageFactory;
import org.br.com.web.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginElements extends MasterPageFactory {

    @FindBy(xpath = "//*[text()='AUTORIZE']")
    private WebElement lblAutorize;

    @FindBy(xpath = "//button[@value='AUTORIZE' and text()='Efetuar login']")
    private WebElement btnEfetuarLogin;

    @FindBy(xpath = "//input[@placeholder='login']")
    private WebElement txtLogin;

    @FindBy(xpath = "//input[@placeholder='senha']")
    private WebElement txtSenha;

    @FindBy(xpath = "//*[text()='Permitir todos os Cookies']")
    private WebElement btnPermitirCookies;

    @FindBy(xpath = "//span[contains(., 'Usuário ou senha inválido(s).')]")
    private WebElement lblMensagemUsuarioOuSenhaInvalidos;

    public LoginElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement getLblMensagemErro(String mensagem) {
        String xpathFormatado = String.format("//div[contains(@class,'alert') and contains(text(),'%s')]", mensagem);
        return Driver.getDriver().findElement(By.xpath(xpathFormatado));
    }
} 