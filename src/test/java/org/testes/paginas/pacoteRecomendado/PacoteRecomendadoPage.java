package org.testes.paginas.pacoteRecomendado;


import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class PacoteRecomendadoPage extends PageBaseActions {

    @AndroidFindBy(xpath = "//*[@text= 'Detalhes do hotel']")
    private WebElement btnDetalhesDoHotel;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Detalhes')]")
    private WebElement btnVoltarDetalhesDoHotel;

    @AndroidFindBy(xpath = "//*[@text= 'Detalhes do Hotel']")
    private WebElement lblTxtDetalhesDoHotel;

    @AndroidFindBy(xpath = "//*[@text= 'Detalhes ida']")
    private WebElement btnDetalhesIda;

    @AndroidFindBy(xpath = "//*[@text= 'Detalhes volta']")
    private WebElement btnDetalhesVolta;

    @AndroidFindBy(xpath = "//*[@text= 'Detalhes do valor']")
    private WebElement btnDetalhesDoValor;

    @AndroidFindBy(xpath = "//android.app.Dialog/android.widget.Button")
    private WebElement btnFecharDetalhesDoValor;

    @AndroidFindBy(xpath = "//*[@text= 'Reservar Agora']")
    private WebElement btnReservarAgora;

    @AndroidFindBy(xpath = "//*[contains(@text, '*Em todo voo você tem')]")
    private WebElement lblTxtEmTodoVooVoceTem;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Viaje com mais conforto!')]")
    private WebElement lblTxtViajeComMaisConforto;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
    private WebElement btnContinuar;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Atenção ao inicio da sua estadia')]")
    private WebElement lblTxtAtencaoAoInicioDaSuaEstadia;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Estou ciente']")
    private WebElement btnEstouCiente;

}
