package org.testes.paginas.home;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class HomePage {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='WEBDRIVER']")
    private WebElement lblWebDriverIo;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Home']")
    private WebElement btnHome;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Webview']")
    private WebElement btnWebview;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Next-gen browser']")
    private WebElement lblNextGenBrowser;

}
