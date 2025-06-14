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

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Resumo do')]")
    private WebElement vldLblResumo;



}
