package org.com.fintech.test.paginas.login;

import org.openqa.selenium.WebElement;
import org.com.fintech.core.driver.actions.PageBaseActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Getter
public class LoginPage extends PageBaseActions {

    private Map<String, WebElement> elementoPorTexto;
    private Map<String, WebElement> btnPorAcao;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    private void iniciarElementoPorTexto() {
        if (elementoPorTexto == null) {
            elementoPorTexto = new HashMap<>();
            elementoPorTexto.put("Olá!", textoOla);
        }
    }

    private void iniciarBtnPorAcao() {
        if (btnPorAcao == null) {
            btnPorAcao = new HashMap<>();
            btnPorAcao.put("Entre na conta", btnEntreNaConta);
            btnPorAcao.put("CPF", btnCampoCpf);
            btnPorAcao.put("Senha", btnCampoSenha);
            btnPorAcao.put("Entrar", btnEntrar);
        }
    }

    public WebElement getElementoPorTexto(String chave) {
        iniciarElementoPorTexto();
        return elementoPorTexto.get(chave);
    }

    public WebElement getBtnPorAcao(String chave) {
        iniciarBtnPorAcao();
        return btnPorAcao.get(chave);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='prelogin-title']")
    private WebElement textoOla;

    @AndroidFindBy(accessibility = "Entre na conta")
    private WebElement btnEntreNaConta;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='cpf']")
    private WebElement btnCampoCpf;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private WebElement btnCampoSenha;

    @AndroidFindBy(accessibility = "entrar")
    private WebElement btnEntrar;

}
