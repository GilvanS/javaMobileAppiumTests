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

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMECE AGORA']")
    private WebElement btnComeceAgora;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='CONECTAR COM O GOOGLE']")
    private WebElement btnConectarComGoogle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.google.android.gms:id/account_display_name' and @text='Rosilda Dos Santos Andrade Pereira']")
    private WebElement btnContaGoogle;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sincronização em andamento']")
    private WebElement vldTxtSincronizacaoEmAndamento;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.droid4you.application.wallet:id/enable_biometrics_face_title']")
    private WebElement vldTxtHabilitarBiometriaFace;

    @AndroidFindBy(xpath = "//android.widget.Switch[@resource-id='com.droid4you.application.wallet:id/enable_biometrics_switch']")
    private WebElement btnHabilitarBiometriaFace;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'CONFIRMAR']")
    private WebElement btnConcluir;

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


}
