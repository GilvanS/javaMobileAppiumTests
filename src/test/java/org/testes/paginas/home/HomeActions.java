package org.testes.paginas.home;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testes.driver.manager.SaldoManager;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import static org.testes.utils.Context.acoes;

@Slf4j
public class HomeActions {

    public static HomePage homePage(){
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void validarLblInicio() throws IOException {
        log.info("valido a exibição da frase 'Inicio' na tela 'Home'");
        acoes().waitForVisibility(homePage().getVldTxtInicio());
        PrintScreen.screenshot("validacao_frase_inicio");
    }

    public static void clicarBtnDetalheDaConta() {
        log.info("clico no botão 'Detalhe da conta' na tela 'Home'");
        acoes().click(homePage().getBtnDetalheDaConta());
    }

    public static void visualizarValorSaldo() throws IOException {
        log.info("Visualizando valor do saldo na tela Home");
        acoes().waitForVisibility(homePage().getTxtValorSaldo());
        String valorSaldo = homePage().getTxtValorSaldo().getText();
        SaldoManager.setSaldo(valorSaldo);
        log.info("Valor do saldo capturado: {}", valorSaldo);
        PrintScreen.screenshot("valor_saldo_capturado");
    }

    public static void validarTendenciaSaldo() throws IOException {
        log.info("Validando valor do saldo no campo Tendencia do saldo");
        if (acoes().verticalSwipeDownAndSearch(homePage().getVldTendenciaDoSaldoTitulo(),3)) {
            log.info("Rolando a tela para baixo para encontrar o campo 'Tendência do saldo'");
        } else {
            acoes().swipeVertical();
        }
        
        String saldoAnterior = SaldoManager.getSaldo();
        acoes().waitForVisibility(homePage().valorTendenciaDoSaldo(saldoAnterior));
        String valorTendencia = homePage().valorTendenciaDoSaldo(saldoAnterior).getText();
        SaldoManager.setSaldoHoje(valorTendencia);
        
        log.info("Saldo anterior: {}", saldoAnterior);
        log.info("Saldo na tendencia: {}", valorTendencia);
        
        // Validar se os valores são iguais
        assertEquals(saldoAnterior, valorTendencia, "O valor do saldo deve ser igual ao valor na tendência");
        log.info("Validação do saldo: SUCESSO - Valores conferem");
        
        PrintScreen.screenshot("validacao_tendencia_saldo");
    }

}
