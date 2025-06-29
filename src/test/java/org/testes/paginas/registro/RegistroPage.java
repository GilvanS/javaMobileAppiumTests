package org.testes.paginas.registro;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

@Getter
public class RegistroPage {

    private final AppiumDriver driver;

    public RegistroPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
        // Tentar diferentes localizadores para encontrar o botão da calculadora
        try {
            // Primeiro, tentar com resource-id específico da calculadora
            return driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.droid4you.application.wallet:id/button_" + valor + "']"));
        } catch (Exception e1) {
            try {
                // Segundo, tentar com resource-id genérico
                return driver.findElement(By.xpath("//android.widget.Button[@resource-id='*button*" + valor + "*']"));
            } catch (Exception e2) {
                try {
                    // Terceiro, tentar com content-desc
                    return driver.findElement(By.xpath("//android.widget.Button[@content-desc='" + valor + "']"));
                } catch (Exception e3) {
                    try {
                        // Quarto, tentar com texto exato
                        return driver.findElement(By.xpath("//android.widget.Button[@text='" + valor + "']"));
                    } catch (Exception e4) {
                        try {
                            // Quinto, tentar com texto parcial
                            return driver.findElement(By.xpath("//android.widget.Button[contains(@text,'" + valor + "')]"));
                        } catch (Exception e5) {
                            // Sexto, tentar com qualquer elemento clicável que contenha o valor
                            return driver.findElement(By.xpath("//*[@text='" + valor + "' and @clickable='true']"));
                        }
                    }
                }
            }
        }
    }

    @AndroidFindBy(id = "com.droid4you.application.wallet:id/editText_value")
    private WebElement txtValor;

}
