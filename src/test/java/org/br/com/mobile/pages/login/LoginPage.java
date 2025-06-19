package org.br.com.mobile.pages.login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.br.com.mobile.pages.MasterPageFactory;
import org.openqa.selenium.WebElement;

@Getter
public class LoginPage extends MasterPageFactory {

    @AndroidFindBy(xpath = "//*[@text='Acessar minha conta' or contains(@text, 'Olá,')]")
    @iOSXCUITFindBy (xpath = "//*[@text='Acessar minha conta']")
    private WebElement btnAcessarMinhaConta;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[@text='Vamos lá']")
    @iOSXCUITFindBy(xpath = "//*[@name='Vamos lá']")
    private WebElement btnVamosLa;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/child::android.widget.EditText")
    private WebElement campoCpf;

    @AndroidFindBy(xpath = "//*[contains(@text,'CPF Inválido')]")
    private WebElement txtCpfInvalido;

    @AndroidFindBy(xpath = "//*[@text='Próximo']")
    private WebElement btnProximo;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout/child::android.widget.EditText")
    private WebElement campoSenha;

    @AndroidFindBy(xpath = "//*[@text='Entrar']")
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continuar']")
    private WebElement btnContinuar;
}
