package org.testes.paginas.checkout;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testes.driver.page.MasterPageFactory;
import org.testes.utils.Hooks;

@Getter
public class CheckoutPage extends MasterPageFactory {
    
    @FindBy(xpath = "//*[text()='Ver Resumo']")
    private WebElement btnVerResumo;

    public CheckoutPage() {
        PageFactory.initElements(Hooks.getDriver(), this);
    }
} 