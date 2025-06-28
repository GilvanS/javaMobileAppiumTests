package org.testes.paginas.home;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.testes.driver.manager.SaldoManager;
import org.testes.driver.page.MasterPageFactory;
import org.testes.paginas.popup.PopupActions;
import org.testes.paginas.popup.PopupModel;
import static org.testes.utils.Context.acoes;
import org.utilidades.evidencia.PrintScreen;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

@Slf4j
public class HomeActions {

    private static final PopupActions popupActions = new PopupActions();

    public static HomePage homePage(){
        return MasterPageFactory.getPage(HomePage.class);
    }

    /**
     * Configura o PopupModel para a tela Home
     */
    public static PopupModel getPopupModelHome() {
        PopupModel popupModel = new PopupModel("Home");
        popupModel.setElementosEsperados(homePage().getVldTxtInicio());
        popupModel.setElementosIdentificadores(
            homePage().getLblEncontreSeuBanco(),
            homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco()
        );
        popupModel.setElementosDeAcao(homePage().getBtnFechar());
        popupModel.setDelay(false);
        return popupModel;
    }

    /**
     * Fecha o popup de banco
     */
    private static boolean fecharPopupBanco() {
        try {
            if (homePage().getLblEncontreSeuBanco().isDisplayed()) {
                log.info("Fechando popup de banco");
                acoes().click(homePage().getBtnFechar());
                acoes().sleep(2);
                return true; // Popup de banco foi fechado
            }
        } catch (Exception e) {
            // Popup de banco não está visível
        }
        return false; // Popup de banco não foi fechado
    }

    /**
     * Fecha o popup de introdução
     */
    private static void fecharPopupIntroducao() {
        try {
            acoes().sleep(1);
            log.info("Fechando popup de introdução");
            
            // Sempre força 3 cliques para avançar o popup de introdução
            for (int i = 1; i <= 3; i++) {
                acoes().clicarMeioTela();
                acoes().sleep(1);
            }
            
            log.info("Introdução finalizada, prosseguindo para proxima etapa");
            
            // Verifica se precisa de cliques adicionais
            try {
                if (homePage().getLblIntroducaoUm().isDisplayed()) {
                    log.info("Popup de introdução ainda visivel, fazendo cliques adicionais");
                    for (int i = 1; i <= 2; i++) {
                        acoes().clicarMeioTela();
                        acoes().sleep(1);
                    }
                }
            } catch (Exception e) {
                // Popup fechado com sucesso
            }
        } catch (Exception e) {
            log.info("Erro ao fechar popup de introdução: {}", e.getMessage());
        }
    }

    /**
     * Fecha todos os popups na tela Home
     */
    public static void fecharTodosPopups() {
        log.info("Fechando popups na tela Home");
        
        // Fecha popup de banco e verifica se foi fechado
        boolean popupBancoFechado = fecharPopupBanco();
        
        // Só fecha popup de introdução se o popup de banco foi fechado
        if (popupBancoFechado) {
            fecharPopupIntroducao();
        }
        
        log.info("Popups fechados");
    }

    /**
     * Valida a exibição da tela Home
     */
    public static void validarExibicaoTelaHome() {
        log.info("Valido a exibição da tela Home");
        popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
        assertTrue(acoes().waitForElementToBeVisible(homePage().getVldTxtInicio(), 10).isDisplayed(), 
                  "Tela home não foi apresentada corretamente");
        log.info("Tela Home apresentada com sucesso");
    }

    public static void validarLblInicio() throws IOException {
        // Fecha popup antes de validar usando método direto
        fecharTodosPopups();
        
        log.info("valido a exibição da frase 'Inicio' na tela 'Home'");
        acoes().waitForVisibility(homePage().getVldTxtInicio());
        PrintScreen.screenshot("validacao_frase_inicio");
    }

    public static void clicarBtnDetalheDaConta() {
        log.info("clico no botão 'Detalhe da conta' na tela 'Home'");
        acoes().click(homePage().getBtnDetalheDaConta());
    }

    public static void visualizarValorSaldo() throws IOException {
        // Fecha popup antes de visualizar o saldo usando método direto
        fecharTodosPopups();
        
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
