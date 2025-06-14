package org.testes.paginas.login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;


@Getter
public class LoginPage extends PageBaseActions {

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
