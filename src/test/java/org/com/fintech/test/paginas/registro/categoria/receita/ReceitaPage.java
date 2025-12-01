package org.com.fintech.test.paginas.registro.categoria.receita;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.com.fintech.core.driver.actions.PageBaseActions;

@Getter
public class ReceitaPage extends PageBaseActions {

    public ReceitaPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Salário, faturas']")
    private WebElement btnSalarioFaturas;
}
