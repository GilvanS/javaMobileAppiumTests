package org.testes.paginas.aluguelDeCarros;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class AluguelDeCarrosPage extends PageBaseActions {

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement btnOndeVoceQuerRetirarSeuCarro;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'São Paulo')][1]")
    private WebElement retirarSaoPauloSP;

    @AndroidFindBy(xpath = "//*[@content-desc='Sorocaba (Airport) , Brasil (SOD)']")
    private WebElement retirarSorocaba;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    private WebElement btnCheckboDevolverNoMesmoLocalDaRetirada;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement btnOndeVoceQuerDevolverSeuCarro;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Foz do Iguaçu - PR, Brasil']")
    private WebElement devolverFozDoIguacu;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continuar']")
    private WebElement btnContinuar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Retirada']/following-sibling::android.widget.Button[contains(@content-desc, 'Escolher horário') and not(preceding-sibling::android.view.View[@content-desc='Devolução'])]")
    private WebElement btnRetiradaAlterarHorario;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Devolução']/following-sibling::android.widget.Button[contains(@content-desc, 'Escolher horário')]")
    private WebElement btnDevolucaoAlterarHorario;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='OK']")
    private WebElement btnOk;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc='Selecione as horas 10']")
    private WebElement btnSelecioneAsHoras;

    @AndroidFindBy(xpath = "//android.widget.SeekBar[@content-desc='Selecione os minutos 00']")
    private WebElement btnSelecioneOsMinutos;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Buscar carros']")
    private WebElement btnBuscarCarros;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Audi Q3')]")
    private WebElement selecionarOcarroAudiQ3;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Fiat Toro')]")
    private WebElement selecionarOcarroFiatToro;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Volkswagen Polo')]")
    private WebElement selecionarOcarroVolkswagenPolo;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Fiat Cronos')]")
    private WebElement selecionarOcarroFiatCronos;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Citroen C4')]")
    private WebElement selecionarOcarroCitroenC4;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Volkswagen T-Cross')]")
    private WebElement selecionarOcarroVolkswagenTCross;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Marcador do mapa')]")
    private WebElement lblMarcadorDoMapa;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Escolher carro')]")
    private WebElement lblEscolerCarro;

    @AndroidFindBy(xpath = "//*[@text= 'Ver detalhes']")
    private WebElement lblVerDetalhes;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Carro escolhido')]")
    private WebElement lblCarroEscolhido;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Ver mais')]")
    private WebElement lblVerMais;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Escolher carro')]")
    private WebElement lblEscolherCarro;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Voltar ao topo')]")
    private WebElement btnVoltarAoTopo;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Reservar')]")
    private WebElement btnReservar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Características')]")
    private WebElement btnCaracteristicas;

    public org.openqa.selenium.By getBySelecionarOcarroVolkswagenPolo() {
        return org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Volkswagen Polo')]");
    }

}
