package org.testes.paginas.carrinho_de_compras;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.testes.paginas.pacoteRecomendado.PacoteRecomendadoActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.testes.utils.Context.acoes;

@Slf4j
public class CarrinhoDeComprasActions {
    
    public static CarrinhoDeComprasPage carrinhoDeComprasPage(){
        return MasterPageFactory.getPage(CarrinhoDeComprasPage.class);
    }

    public static void validarLblTxtAtencaoAoInicioDaSuaEstadia() {
        acoes().pullToRefreshAndWaitForElement(carrinhoDeComprasPage().getLbltxtAtencaoAoInicioDaSuaEstadia(),1);
        if (carrinhoDeComprasPage().getLbltxtAtencaoAoInicioDaSuaEstadia().isDisplayed()) {
            log.info("A mensagem 'Atencao ao inicio da sua estadia' esta visivel, clicando no botao 'Estou ciente'");
            acoes().click(carrinhoDeComprasPage().getBtnEstouCiente());
            acoes().waitForVisibility(carrinhoDeComprasPage().getLblResumoDaViagem());
            acoes().sleep(5);
        } else {
            log.info("A mensagem 'Atencao ao inicio da sua estadia' nao esta visivel, prosseguindo para validar 'Resumo da viagem'");
        }
    }

    public static void validarLblCarrinhoDeCompras() {
        if (carrinhoDeComprasPage().getLblCarrinhoDeCompras().isDisplayed()) {
            log.info("A mensagem 'Carrinho de compras' esta visivel");
            acoes().click(carrinhoDeComprasPage().getLblCarrinhoDeCompras());
            acoes().sleep(5);
        } else {
            log.info("A mensagem 'Carrinho de compras' nao esta visivel");
        }
    }

    @SneakyThrows
    public static void validarLblResumoDaViagem() {
        validarLblTxtAtencaoAoInicioDaSuaEstadia();
        validarLblCarrinhoDeCompras();
        log.info("valido a exibicao da mensagem 'Resumo da viagem' na tela 'Carrinho de compras'");
        acoes().verticalSwipeDownAndSearch(carrinhoDeComprasPage().getLblResumoDaViagem(), 3);
        acoes().waitForVisibility(carrinhoDeComprasPage().getLblResumoDaViagem());
    }

    @SneakyThrows
    public static void validarLblHospedagem() {
        log.info("valido a exibicao da mensagem 'Hospedagem' na tela 'Carrinho de compras'");
        acoes().swipeVertical();
        acoes().verticalSwipeDownAndSearch(carrinhoDeComprasPage().getLblHospedagem(),3);
        acoes().waitForVisibility(carrinhoDeComprasPage().getLblHospedagem());
    }

    @SneakyThrows
    public static void validarLblRegrasECondicoes() {
        log.info("valido a exibicao da mensagem 'Regras e condicoes' na tela 'Carrinho de compras'");
        acoes().swipeVertical();
        acoes().verticalSwipeDownAndSearch(carrinhoDeComprasPage().getLblRegrasECondicoes(),3);
        acoes().waitForVisibility(carrinhoDeComprasPage().getLblRegrasECondicoes());
    }

    @SneakyThrows
    public static void clicarBtnVerResumo() throws InterruptedException {
        acoes().pullToRefresh(5);
        log.info("clico no botão 'Ver resumo' na tela 'Carrinho de compras'");
        acoes().verticalSwipeDownAndSearch(carrinhoDeComprasPage().getBtnlVerResumo(), 3);
        acoes().click(carrinhoDeComprasPage().getBtnlVerResumo());
        acoes().sleep(5);
    }

    public static void clicarBtnIrParaOPagamento() throws InterruptedException {
        log.info("clicar no botao Ir para o pagamento na tela Carrinho de compras");
        acoes().click(carrinhoDeComprasPage().getBtnIrParaOPagamento());
        Thread.sleep(2000);
    }

}
