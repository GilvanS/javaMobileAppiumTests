package org.br.com.mobile.pages.home;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

@Getter
public class HomePage extends MasterPageFactory {

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[contains(@text,'Olá')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Olá, ')]")
    private WebElement lblOla;

    @AndroidFindBy(xpath = "//*[@text='Não mostrar novamente']")
    private WebElement btnNaoMostrarNovamente;

}
