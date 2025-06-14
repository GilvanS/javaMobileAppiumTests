package org.testes.paginas.hotel;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class HotelPage extends PageBaseActions {

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
}
