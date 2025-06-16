package org.testes.paginas.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;


@Getter
public class LoginPage extends PageBaseActions {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@content-desc= 'Entre para aproveitar a melhor experiência']")
    private WebElement vldTxtEntreParaAproveitar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Entre')]")
    private WebElement btnEntreParaAproveitar;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement CampoSeuEmail;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Próximo']")
    private WebElement btnProximo;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    private WebElement campoSenha;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Entrar')]")
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EBAC Store']")
    private WebElement txtEbacStore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
    private WebElement btnProfile;

    @AndroidFindBy(xpath = "//*[@content-desc='Welcome to EBAC Shop']")
    private WebElement txtWelcomeEbacShop;

    @AndroidFindBy(xpath = "//*[@content-desc='Sign up']")
    private WebElement btnSignUp;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='First Name']")
    private WebElement campoFirstName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Last Name']")
    private WebElement campoLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Phone Number']")
    private WebElement campoPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Email Address']")
    private WebElement campoEmailAddress;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='Password']")
    private WebElement campoPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='ReEnter Password']")
    private WebElement campoReEnterPassword;

    @AndroidFindBy(xpath = "//*[@content-desc='Create']")
    private WebElement btnCreate;

}
