package org.testes.paginas.home;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class HomePage extends PageBaseActions {

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    // Elementos para validação de saldo
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dinheiro']/ancestor::android.widget.RelativeLayout[1]/descendant::android.widget.TextView[contains(@text, 'R$')]")
    private WebElement txtValorSaldo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HOJE']/../..//android.widget.TextView[@text= 'R$ %s']")
    private WebElement txtTendenciaSaldo;

    public WebElement valorTendenciaDoSaldo(String valor) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='HOJE']/../..//android.widget.TextView[@text= '" + valor + "']"));
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Início']")
    private WebElement vldTxtInicio;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'DETALHE DA CONTA']")
    private WebElement btnDetalheDaConta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pagamentos planejados futuros']")
    private WebElement vldPagamentosPlanejadosFuturos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dinheiro']/ancestor::android.widget.RelativeLayout[1]/descendant::android.widget.TextView[@text= 'R$ 5.000,00']")
    private WebElement vldSaldo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Estrutura de despesas']")
    private WebElement vldEstruturaDeDespesas;

    @AndroidFindBy(xpath = "//*[@text='ÚLTIMOS 30 DIAS']/..//android.widget.TextView[contains(@text, 'R$')]")
    private WebElement valorUltimos30Dias;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tendência do saldo']")
    private WebElement vldTendenciaDoSaldoTitulo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HOJE']/../..//android.widget.TextView[@text= 'R$ 5.000,00']")
    private WebElement vldSaldoHoje;


}
