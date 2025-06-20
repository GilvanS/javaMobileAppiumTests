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
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Tirar foto']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    private WebElement btnTirarFoto;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[@name='navigation close']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='navigation close']")
    private WebElement btnFechar;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Precisamos de uma') and contains(@text,'foto sua')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'Precisamos de uma') and contains(@name,'foto sua')]")
    private WebElement lblPrecisamosDeUmaFotoSua;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[contains(@text,'Não mostrar novamente')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Não mostrar novamente']")
    private WebElement btnNaoMostrarNovamente;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Negociar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Negociar']")
    private WebElement btnNegociar;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[contains(@text,'Você possui débitos pendentes')]/preceding-sibling::android.widget.ImageView[contains(@resource-id,'close')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Você possui débitos pendentes')]/preceding-sibling::XCUIElementTypeOther//XCUIElementTypeButton")
    private WebElement btnFecharNegociacao;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[@text='Confira as mudanças']/../preceding::android.widget.ImageView[@clickable='true']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[contains(@name,'walkthrough-start')]/following-sibling::XCUIElementTypeButton[1]")
    private WebElement btnConfiraAsMudancasFechar;

    // utilizar xpath para Android e IOS (validação de popup)
    @AndroidFindBy(xpath = "//*[contains(@text,'Olá')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Olá, ')]")
    private WebElement lblOla;

    // utilizar xpath para Android e IOS mapear (validação de popup)
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Fechar']")
    @iOSXCUITFindBy(xpath = "//*[@name='Fechar']")
    private WebElement BtnFecharPromocaoJogaNoDigio;

    @AndroidFindBy(uiAutomator = "textContains(\"One\")")
    @iOSXCUITFindBy(iOSNsPredicate = "value CONTAINS 'One'")
    private WebElement lblDigioOne;

    @AndroidFindBy(xpath = "//android.view.View[@clickable='true']")
    @iOSXCUITFindBy(iOSNsPredicate = "name == 'widgets icon' AND type == 'XCUIElementTypeButton'")
    private WebElement btnWidget;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Olá')]/following-sibling::android.widget.ImageView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[contains(@name,'iconMenuHamburger') or not(@name)])[1]")
    public WebElement btnMenu;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@content-desc,'Bottom')]/following-sibling::android.view.View")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Conta'")
    private WebElement btnConta;

    @AndroidFindBy(xpath = "//*[@text='Extrato']")
    @iOSXCUITFindBy(accessibility = "Extrato")
    private WebElement btnExtrato;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Futuros']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Futuros']")
    private WebElement btnFuturos;

    // FATURA
    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Fatura ') or starts-with(@text,'Cartão bloqueado')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[starts-with(@name,'Fatura ') or starts-with(@name,'Cartão bloqueado')]")
    private WebElement lblFatura;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Fatura ') or starts-with(@text,'Cartão bloqueado')]/../android.widget.ImageView[last()]")
    private WebElement btnVisaoFaturaAndroid;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Fatura ') or starts-with(@text,'Cartão bloqueado')]/../android.widget.FrameLayout/android.widget.ImageView")
    private WebElement lblFaturaSaldoOcultoAndroid;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text,'Fatura ') or starts-with(@text,'Cartão bloqueado')]/../android.widget.FrameLayout/android.widget.TextView[starts-with(@text, 'R$')]")
    private WebElement lblFaturaSaldoExibidoAndroid;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='card eye on']")
    private WebElement btnVisaoFaturaLigadoIos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='card eye off']")
    private WebElement btnVisaoFaturaDesligadoIos;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[contains(@name,'card eye')]")
    private WebElement btnVisaoFaturaIos;

    // SALDO
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Saldo disponível']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Saldo disponível'")
    private WebElement lblSaldoDisponivel;

    @AndroidFindBy(xpath = "//*[@content-desc='mask' or starts-with(@text, 'R$')]/../following-sibling::android.widget.ImageView")
    // @iOSXCUITFindBy(? = "?")
    private WebElement btnVisao;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='mask']")
    // @iOSXCUITFindBy(? = "?")
    private WebElement lblSaldoOculto;

    @AndroidFindBy(xpath = "//android.widget.TextView[starts-with(@text, 'R$')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name, 'R$')]")
    private WebElement lblSaldoExibido;

    @AndroidFindBy(xpath = "//*[@text='Saldo disponível']/../..//androidx.recyclerview.widget.RecyclerView")
    private WebElement carrosselConta;

    @AndroidFindBy(xpath = "//*[@text='Pagar']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Pagar']")
    private WebElement btnPagar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Trazer meu salário']")
    @iOSXCUITFindBy(accessibility = "Trazer meu salário")
    private WebElement btnTrazerMeuSalario;

    @AndroidFindBy(xpath = "//*[@text='Receber']")
    @iOSXCUITFindBy(accessibility = "Receber")
    private WebElement btnReceber;

    @AndroidFindBy(xpath = "//*[@text='Sacar']")
    @iOSXCUITFindBy(accessibility = "Sacar")
    private WebElement btnSacar;

    @AndroidFindBy(xpath = "//*[@text='Transferir']")
    @iOSXCUITFindBy(accessibility = "Transferir")
    private WebElement btnTransferir;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'Produtos ')]/following-sibling::android.widget.HorizontalScrollView")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView/preceding::XCUIElementTypeCell)[2]")
    private WebElement carrosselProdutosDigio;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Antecipar FGTS']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Antecipar FGTS'")
    private WebElement btnCardAnteciparFgts;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Grana Extra']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Grana Extra'")
    private WebElement btnCardGranaExtra;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Loja']")
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value == 'Loja'")
    private WebElement btnCardLoja;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Minhas compras'])[1]")
    @iOSXCUITFindBy(accessibility = "Minhas compras")
    private WebElement btnVerMinhasCompras;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView)[2]//android.widget.ImageView)[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView//XCUIElementTypeImage)[1]")
    private WebElement btnCardDigioOneToqueAquiPecaOSeu;

    @AndroidFindBy(xpath = "(//android.widget.HorizontalScrollView)[1]")
    private WebElement carrosselCartoes;

    @AndroidFindBy(xpath = "//*[@text='Pagar fatura']")
    @iOSXCUITFindBy(xpath = "//*[@name='Pagar fatura']")
    private WebElement btnPagarFatura;

    @AndroidFindBy(xpath = "//*[contains(@text,'Fatura')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Fatura')]")
    private WebElement btnVerFatura;

    @AndroidFindBy(xpath = "//*[@text='Débito automático']")
    @iOSXCUITFindBy(xpath = "//*[@name='Débito automático']")
    private WebElement btnDebitoAutomatico;

    @AndroidFindBy(xpath = "//*[@text='Meus cartões']")
    @iOSXCUITFindBy(xpath = "//*[@name='Meus cartões']")
    private WebElement btnMeusCartoes;

    @AndroidFindBy(xpath = "//*[@text='Rastrear']")
    @iOSXCUITFindBy(xpath = "//*[@name='Rastrear']")
    private WebElement btnRastrear;

    @AndroidFindBy(xpath = "//*[@text='Recebi meu Digio']")
    @iOSXCUITFindBy(xpath = "//*[@name='Recebi meu Digio']")
    private WebElement btnRecebiMeuDigio;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[contains(@content-desc,'Bottom')]/following-sibling::android.view.View")
    @iOSXCUITFindBy(iOSNsPredicate = "name CONTAINS 'Cartões'")
    private WebElement btnCartoes;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pix']")
    @iOSXCUITFindBy(accessibility = "h_cash23_headline_area_pix")
    private WebElement btnPix;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='br.com.digio.homol.main:id/content']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCollectionView")
    private WebElement carrosselBanners;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@content-desc='CDB Pós-fixado']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView/..//following::XCUIElementTypeImage)[1]")
    private WebElement btnDeepLink;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Ative sua conta Digio']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Ative sua conta Digio']")
    private WebElement txtAtiveSuaContaDigio;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Rendendo 100% do CDI']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Rendendo 100% do CDI']")
    private WebElement lblRendendoCemPorCentoDoCdi;

    @AndroidFindBy(xpath = "//*[@text='Fatura aberta']")
    @iOSXCUITFindBy(xpath = "//*[@name='Fatura aberta']")
    private WebElement txtFaturaAberta;

    @AndroidFindBy(xpath = "//*[@text='Fatura fechada']")
    @iOSXCUITFindBy(xpath = "//*[@name='Fatura fechada']")
    private WebElement txtFaturaFechada;

    @AndroidFindBy(xpath = "//*[@text='Fatura vencida']")
    @iOSXCUITFindBy(xpath = "//*[@name='Fatura vencida']")
    private WebElement txtFaturaVencida;

    @AndroidFindBy(xpath = "//*[@text='Cartão bloqueado']")
    @iOSXCUITFindBy(xpath = "//*[@name='Cartão bloqueado']")
    private WebElement txtFaturaBloqueada;

    @AndroidFindBy(xpath = "//*[contains(@text,'R$')]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCell/preceding::XCUIElementTypeStaticText[contains(@name,'R$')])[1]")
    private WebElement txtValorFatura;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text='Meu limite']/following-sibling::android.widget.TextView[contains(@text,'R$')])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name='Meu limite']/../XCUIElementTypeStaticText[contains(@name,'R$')])[1]")
    private WebElement txtValorLimiteUtilizado;

    @AndroidFindBy(xpath = "//*[@text='Investimentos']")
    @iOSXCUITFindBy(xpath = "//*[@label='Investimentos']")
    private WebElement btnInvestimentos;

    @AndroidFindBy(xpath = "//*[@text= 'CDB + Limite']")
    @iOSXCUITFindBy(xpath = "//*[@name= 'CDB + Limite']")
    private WebElement btnCdbMaisLimite;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Meu limite']/..//android.widget.TextView[@text= 'Disponível']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Meu limite']")
    private WebElement btnMeuLimite;

    @AndroidFindBy(xpath = "//*[@text='Open Finance']")
    @iOSXCUITFindBy(xpath = "//*[@value='Open Finance']")
    private WebElement btnOpenFinance;

    // ELEMENTOS DO MENU
    @AndroidFindBy(xpath = "//*[contains(@text, 'Olá, ')]")
    @iOSXCUITFindBy(xpath = "//*[@name='Nome']")
    private WebElement txtNomeMenu;

    @AndroidFindBy(xpath = "//*[@text='Instituição: ']")
    @iOSXCUITFindBy(xpath = "//*[@name='Instituição']")
    private WebElement txtInstituicaoMenu;

    @AndroidFindBy(xpath = "//*[@text='Agência: ']")
    @iOSXCUITFindBy(xpath = "//*[@name='Agência']")
    private WebElement txtAgenciaMenu;

    @AndroidFindBy(xpath = "//*[@text='Conta: ']")
    @iOSXCUITFindBy(xpath = "//*[@name='Conta']")
    private WebElement txtContaMenu;

}
