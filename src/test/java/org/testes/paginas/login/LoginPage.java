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

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=', Profile']")
    private WebElement btnProfile;

    @AndroidFindBy(xpath = "//*[@text='Welcome to EBAC Shop']")
    private WebElement txtWelcomeEbacShop;

    @AndroidFindBy(xpath = "//*[@content-desc='Sign up']")
    private WebElement btnSignUp;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='First Name']")
    private WebElement campoFirstName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Last Name']")
    private WebElement campoLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone Number']")
    private WebElement campoPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email Address']")
    private WebElement campoEmailAddress;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private WebElement campoPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='repassword']")
    private WebElement campoReEnterPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create']")
    private WebElement btnCreate;

}
