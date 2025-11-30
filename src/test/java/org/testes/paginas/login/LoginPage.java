package org.testes.paginas.login;

import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;


@Getter
public class LoginPage extends PageBaseActions {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Olá!']")
    private WebElement textoOla;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Entre na conta']")
    private WebElement btnEntreNaConta;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='cpf']")
    private WebElement btnCampoCpf;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private WebElement btnCampoSenha;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Entrar']")
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMECE AGORA']")
    private WebElement btnComeceAgora;


}
