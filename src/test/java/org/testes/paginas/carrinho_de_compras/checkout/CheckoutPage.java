package org.testes.paginas.carrinho_de_compras.checkout;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class CheckoutPage extends PageBaseActions {

    public CheckoutPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ver resumo']")
    private WebElement vldLblResumo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Checkout']")
    private WebElement btnCheckout;

    @AndroidFindBy(xpath = "//android.view.View[@resource-id='__next']/android.view.View[5]/android.view.View[1]/android.view.View[3]/android.view.View/android.view.View[2]/android.widget.EditText")
    private WebElement campoPrimeiroNome;



}
