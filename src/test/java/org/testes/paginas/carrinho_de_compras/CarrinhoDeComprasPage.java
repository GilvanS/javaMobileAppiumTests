package org.testes.paginas.carrinho_de_compras;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

@Getter
public class CarrinhoDeComprasPage extends PageBaseActions {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Resumo da viagem']")
    private WebElement lblResumoDaViagem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hospedagem']")
    private WebElement lblHospedagem;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Regras e condições']")
    private WebElement lblRegrasECondicoes;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='IR PARA O PAGAMENTO']")
    private WebElement btnIrParaOPagamento;

    @AndroidFindBy(xpath = "//*[@content-desc='Checkout']")
    private WebElement btnCheckout;

    @AndroidFindBy(xpath = "//*[@text='Ver resumo']")
    private WebElement btnlVerResumo;

    @AndroidFindBy(xpath = "//*[@text= 'Detalhes do hotel']")
    private WebElement lblDetalhesDoHotel;

    @AndroidFindBy(xpath = "//*[@text= 'Viajantes']")
    private WebElement lblViajantes;
}
