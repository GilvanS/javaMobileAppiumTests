package org.com.fintech.test.paginas.home;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.com.fintech.core.driver.actions.PageBaseActions;

import java.util.HashMap;
import java.util.Map;

@Getter
public class HomePage extends PageBaseActions {

    private Map<String, WebElement> elementosPorTexto;
    private Map<String, WebElement> btnPorAcao;

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    private void iniciarElementoPorTexto() {
        if (elementosPorTexto == null) {
            elementosPorTexto = new HashMap<>();
            elementosPorTexto.put("Bem-vindo!", vldBemVindo);
            elementosPorTexto.put("PIX", btnMenuPix);
            elementosPorTexto.put("Não é cliente? Abra uma conta", msgNaoClienteAbraUmaConta);
            elementosPorTexto.put("Acessar minha conta", msgAcessoMinhaConta);
            elementosPorTexto.put("Começar a usar", btnComecarAUsar);
            elementosPorTexto.put("close", btnFechar);
            elementosPorTexto.put("Dinheiro", txtValorSaldo);
            elementosPorTexto.put("COMECE AGORA", btnComeceAgora);
        }
    }

    private void iniciarBtnPorAcao() {
        if (btnPorAcao == null) {
            btnPorAcao = new HashMap<>();
            btnPorAcao.put("COMECE AGORA", btnComeceAgora);
            btnPorAcao.put("Entrar", btnEntrar);
            btnPorAcao.put("Começar a usar", btnComecarAUsar);
        }
    }

    public WebElement getElementoPorTexto(String chave) {
        iniciarElementoPorTexto();
        return elementosPorTexto.get(chave);
    }

    public WebElement getBtnPorNome(String chave) {
        iniciarBtnPorAcao();
        return btnPorAcao.get(chave);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMECE AGORA']")
    private WebElement btnComeceAgora;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Começar a usar']")
    private WebElement btnComecarAUsar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bem-vindo!']")
    private WebElement vldBemVindo;

    @AndroidFindBy(xpath = "//android.view.View[@text='PIX']")
    private WebElement btnMenuPix;

    @AndroidFindBy(accessibility = "entrar")
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "(//android.widget.Button[@text='credit_card Cartões'])[1]")
    private WebElement btnMenuCartoes;

    @AndroidFindBy(xpath = "//*[text()='Acessar minha conta']/attribute::*\n")
    private WebElement msgAcessoMinhaConta;

    @AndroidFindBy(xpath = "//*[text()= 'Não é cliente? Abra uma conta']")
    private WebElement msgNaoClienteAbraUmaConta;

    // Elementos para validação de saldo
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dinheiro']/ancestor::android.widget.RelativeLayout[1]/descendant::android.widget.TextView[contains(@text, 'R$')]")
    private WebElement txtValorSaldo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HOJE']/../..//android.widget.TextView[@text= 'R$ %s']")
    private WebElement txtTendenciaSaldo;

    public WebElement valorTendenciaDoSaldo(String valor) {
        return driver.findElement(By.xpath("//android.widget.TextView[@text='HOJE']/../..//android.widget.TextView[@text= '" + valor + "']"));
    }

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.droid4you.application.wallet:id/scroll_view']")
    private WebElement lblEncontreSeuBanco;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Você já tentou encontrar e conectar seu banco?']")
    private WebElement vldTxtVoceJaTentouEncontrarEConectarSeuBanco;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.droid4you.application.wallet:id/image_view_close']")
    private WebElement btnFechar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
    private WebElement lblIntroducaoUm;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Início']")
    private WebElement vldTxtInicio;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'DETALHE DA CONTA']")
    private WebElement btnDetalheDaConta;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Pagamentos planejados futuros']")
    private WebElement vldPagamentosPlanejadosFuturos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Dinheiro']/ancestor::android.widget.RelativeLayout[1]/descendant::android.widget.TextView[@text= 'R$ 5.000,00']")
    private WebElement vldSaldo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Estrutura de despesas']")
    private WebElement vldEstruturaDeDespesas;

    @AndroidFindBy(xpath = "//*[@text='ÚLTIMOS 30 DIAS']/..//android.widget.TextView[contains(@text, 'R$')]")
    private WebElement valorUltimos30Dias;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Tendência do saldo']")
    private WebElement vldTendenciaDoSaldoTitulo;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='HOJE']/../..//android.widget.TextView[@text= 'R$ 5.000,00']")
    private WebElement vldSaldoHoje;

    @AndroidFindBy(id = "com.droid4you.application.wallet:id/view_pager_swipe")
    private WebElement vldBannerswipe;

    @AndroidFindBy(accessibility = "Abrir")
    private WebElement btnMenuHamburguer;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.droid4you.application.wallet:id/material_drawer_recycler_view']")
    private WebElement vldDrawerMenu;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,  'id/material_drawer_recycler_view') and @scrollable='true']/descendant::android.widget.TextView[@text='Modo escuro']")
    private WebElement vldModoEscuroMenu;

    @AndroidFindBy(xpath = "(//android.widget.Switch[@resource-id='com.droid4you.application.wallet:id/material_drawer_switch'])[1]")
    private WebElement vldModoEscuroSwitch; //@cheked= 'false'

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Acompanhe seus gastos' and @displayed= 'true']")
    private WebElement vldAcompanheSeusGastos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Modo escuro']")
    private WebElement vldModoEscuro;

    @AndroidFindBy(xpath = "//android.widget.Button[@text= 'EXPERIMENTE O MODO ESCURO']")
    private WebElement btnExperimenteOModoEscuro;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.droid4you.application.wallet:id/fab_toggle_button']")
    private WebElement btnAdd;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Novo registro']/..//android.widget.ImageButton[contains(@resource-id, 'id/fab_toggle_button')]")
    private WebElement btnNovoRegistro;

}
