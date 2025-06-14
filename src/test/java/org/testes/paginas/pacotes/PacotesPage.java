package org.testes.paginas.pacotes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class PacotesPage extends PageBaseActions {

    public PacotesPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "(//android.widget.EditText)[1]")
    private WebElement campoDeOndeVocePegaraSeuVoo;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement campoParaQualDestinoViajara;

    @AndroidFindBy(xpath = "//*[@content-desc= 'São Paulo - SP, Brasil']")
    private WebElement destinoSaoPauloSP;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Porto Seguro - BA, Brasil']")
    private WebElement destinoPortoSeguroBA;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Porto - Porto , Portugal']")
    private WebElement destinoPorto;

    @FindBy(xpath="//*[contains(@content-desc, 'Rodes - ')]")
    private WebElement destinoGrecia;

    @FindBy(xpath="//*[contains(@content-desc, 'Foz do Iguaçu')]")
    private WebElement destinoFozDoIguacu;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Continuar']")
    private WebElement btnContinuar;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Confirmar detalhes']")
    private WebElement btnConfirmarDetalhes;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Junho')]/..//android.view.View[@content-desc= '20']")
    private WebElement btnDataSaida;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Julho')]")
    private WebElement vldTxtMesRetorno;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Julho')]/descendant::*[contains(@content-desc, '15')]")
    private WebElement btnDataRetorno;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Confirmar datas']")
    private WebElement btnConfirmarDatas;

    @AndroidFindBy(xpath = "//*[@text= 'Pacote recomendado']")
    private WebElement vlTxtPacoteRecomendado;

    @AndroidFindBy(xpath = "//*[@text= 'Ida']")
    private WebElement vlTxtIda;

    @AndroidFindBy(xpath = "//*[@text= 'Reservar Agora']")
    private WebElement vlTxtReservarAgora;

}
