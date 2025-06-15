package org.testes.paginas.hotel;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

@Getter
public class HotelPage extends PageBaseActions {

    public HotelPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement campoOndeVoceIraSeHospedar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Atenas']")
    private WebElement destinoAtenas;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Barcelona - Catalunha , Espanha']")
    private WebElement destinoBarcelona;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirmar destino']")
    private WebElement btnConfirmarDestino;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continuar']")
    private WebElement btnContinuar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Escolha ']")
    private WebElement lblEscolha;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Marcador do mapa']")
    private WebElement btnMarcadorDoMapa;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Sobre a hospedagem')]")
    private WebElement lblSobreAHospedagem;

    @AndroidFindBy(xpath = "//*[@content-desc='Ver galeria']")
    private WebElement lblVerGaleria;

    @AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc, 'Este hotel está no Programa de Parceiros Preferenciais')]/android.view.View[6]")
    private WebElement lblEsteHotelEstaNoProgramaDeParceirosPreferenciais;

    @AndroidFindBy(xpath = "//*[@content-desc='Ver mais']")
    private WebElement lblVerMais;

    @AndroidFindBy(xpath = "(//*[@content-desc='Escolher quarto'])[1]")
    private WebElement lblEscolherQuarto;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Voltar ao topo')]")
    private WebElement btnVoltarAoTopo;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Reservar')]")
    private WebElement btnReservar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Checkout']")
    private WebElement btnCheckout;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Sem Café da Manhã\nArcelon Hotel\nCarrer de Mallorca\nTaxas inclusas']")
    private WebElement btnHotelArcelon;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id='android:id/content']/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]")
    private WebElement btnFechar;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Ver resumo']")
    private WebElement btnVerResumo;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Ler mais']")
    private WebElement lblLerMais;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Quarto escolhido']")
    private WebElement lblQuartoEscolhido;

    public WebElement getBtnDia(String dia) {
        return driver.findElement(By.xpath("//android.view.View[@content-desc='" + dia + "']"));
    }

    public WebElement getHotelByName(String nomeHotel) {
        return driver.findElement(By.xpath("//android.view.View[contains(@content-desc,'" + nomeHotel + "')]"));
    }
}
