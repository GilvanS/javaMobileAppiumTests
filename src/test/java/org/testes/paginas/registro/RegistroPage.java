package org.testes.paginas.registro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class RegistroPage extends PageBaseActions {

    public RegistroPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='RECEITA']")
    private WebElement btnReceita;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
    private WebElement vltTxtIntoducao;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Salvar']")
    private WebElement btnSalvar;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'SELECIONE A CATEGORIA']")
    private WebElement btnCategoria;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Salário/faturas']")
    private WebElement btnSalarioFaturas;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=com.droid4you.application.wallet:id/new_record_amount']")
    private WebElement txtAmount;

    public WebElement digitarValor(String valor) {
        return driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id, 'id/button_calculator_"+ valor +"')]']"));
    }

    @AndroidFindBy(id = "com.droid4you.application.wallet:id/editText_value")
    private WebElement txtValor;



}
