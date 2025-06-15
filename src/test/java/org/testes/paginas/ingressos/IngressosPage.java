package org.testes.paginas.ingressos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class IngressosPage extends PageBaseActions {

    public IngressosPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Escolha um parque']")
    private WebElement vldLblEscolhaUmParque;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement campoParaQualDestino;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Beto Carrero - Balneário Camboriú - br']")
    private WebElement destinoBetoCarreiro;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirmar destino']")
    private WebElement btnConfirmarDestino;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continuar']")
    private WebElement btnContinuar;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirmar parque']")
    private WebElement btnConfirmarParque;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirmar datas']")
    private WebElement btnConfirmarDatas;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Conferir detalhes']")
    private WebElement btnConferirDetalhes;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Checkout']")
    private WebElement viewResumoPedido;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='20']")
    private WebElement btnDia20;

    public WebElement getBtnDia(String dia) {
        return driver.findElement(By.xpath("//android.view.View[@content-desc='" + dia + "']"));
    }

}
