package org.com.fintech.test.paginas.pix;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.com.fintech.core.driver.actions.PageBaseActions;

@Getter
public class PixPage extends PageBaseActions {

    public PixPage(AppiumDriver driver) {
        super(driver);
    }



    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Minhas Chaves']")
    private WebElement btnMinhasChaves;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Cadastrar Nova Chave']")
    private WebElement btnCadastrarNovaChave;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='keyType']")
    private WebElement btnTipoChave;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='E-mail']")
    private WebElement btnTipoChaveCPF;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='CPF']")
    private WebElement btnTipoChaveCelular;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@text, 'Chave de e-mail')]")
    private WebElement btnTipoChaveEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='keyValue']")
    private WebElement inputChave;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='O valor da chave é obrigatório.']")
    private WebElement vldTxtChaveObrigatoria;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Cadastrar']")
    private WebElement btnCadastrar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='toast-message']")
    private WebElement msgSucessoCadastro;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private WebElement btnOk;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Fechar']")
    private WebElement btnFechar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cpf']")
    private WebElement vldChaveCadastradaCPF;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']")
    private WebElement vldChaveCadastradaEmail;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '@')]")
    private WebElement listaChaves;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.view.View/android.widget.Button")
    private WebElement btnExcluirChave;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Confirmar exclusão']")
    private WebElement btnSimRemoverChave;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Chave removida']")
    private WebElement msgChaveRemovida;

}
