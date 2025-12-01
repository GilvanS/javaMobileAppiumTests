package org.com.fintech.test.paginas.registro.categoria;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.com.fintech.core.driver.actions.PageBaseActions;

@Getter
public class CategoriaPage extends PageBaseActions {

    public CategoriaPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Receita']")
    private WebElement btnReceita;

}
