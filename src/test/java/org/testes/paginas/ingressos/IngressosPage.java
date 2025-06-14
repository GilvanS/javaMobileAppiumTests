package org.testes.paginas.ingressos;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class IngressosPage extends PageBaseActions {

    public IngressosPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement campoParaQualDestino;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Beto Carrero - Balneário Camboriú - br']")
    private WebElement destinoBetoCarreiro;

}
