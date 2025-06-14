package org.testes.paginas.home;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class HomePage extends PageBaseActions {

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@content-desc= 'Pular introdução']")
    private WebElement btnPularIntroducao;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Olá']")
    private WebElement vldTxtOla;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Olá, 4Win']")
    private WebElement vldTxtOla4Win;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Notificações')]/ancestor::*/android.widget.Button[contains(@content-desc, 'Entrar')]")
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Minhas')]/..//android.widget.Button[contains(@content-desc, 'Explorar')]")
    private WebElement btnExplorar;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Pacotes']/..//android.view.View[1]")
    private WebElement btnPacotes;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[6]")
    private WebElement btnCarros;

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.View[4]")
    private WebElement btnIngressos;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Promoções']")
    private WebElement btnPromocoes;

    @AndroidFindBy(xpath = "(//*[@content-desc= 'Hotéis'])[2]")
    private WebElement btnHoteis;

    @AndroidFindBy(xpath = "//android.widget.ScrollView/android.view.View[5]/android.view.View")
    private WebElement carrosselHoteis;


    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Natal')]")
    private WebElement btnHotelNatal;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Maceio')]")
    private WebElement btnHotelMaceio;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Porto de Galinhas')]")
    private WebElement btnHotelPortoDeGalinhas;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Buenos Aires')]")
    private WebElement btnHotelBuenosAires;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Orlando')]")
    private WebElement btnHotelOrlando;

}
