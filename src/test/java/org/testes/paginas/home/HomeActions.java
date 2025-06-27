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
        log.info("Configurando PopupModel para tela Home");
        
        PopupModel popupModel = new PopupModel("Home");
        
        // Define os elementos esperados (elementos que indicam que a tela está carregada)
        popupModel.setElementosEsperados(homePage().getVldTxtInicio());
        
        // Define os elementos identificadores do popup (elementos que indicam que o popup está presente)
        // Apenas popup de banco - popup de introdução é tratado separadamente
        popupModel.setElementosIdentificadores(
            homePage().getLblEncontreSeuBanco(),
            homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco()
        );
        
        // Define os elementos de ação (botões para fechar o popup)
        // Apenas popup de banco - popup de introdução é tratado separadamente
        popupModel.setElementosDeAcao(homePage().getBtnFechar());
        
        // Configura delay (false por padrão, pode ser configurado via properties se necessário)
        popupModel.setDelay(false);
        
        log.info("PopupModel configurado com sucesso para tela Home");
        log.info("Elementos identificadores: lblEncontreSeuBanco, vldTxtVoceJaTentouEncontrarEConectarSeuBanco");
        log.info("Elementos de ação: btnFechar");
        log.info("Elementos esperados: vldTxtInicio");
        
        return popupModel;
    }

    /**
     * Fecha o popup de introdução que aparece 3 vezes
     */
    public static void fecharPopupIntroducao() {
        try {
            log.info("Verificando se popup de introdução está visível...");
            
            // Aguarda um pouco para o popup aparecer
            acoes().sleep(2);
            
            if (homePage().getLblIntroducaoUm().isDisplayed()) {
                log.info("Popup de introdução detectado, fechando...");
                
                // Clica 3 vezes no meio da tela
                for (int i = 1; i <= 3; i++) {
                    log.info("Clicando no meio da tela pela {}ª vez", i);
                    acoes().clicarMeioTela();
                    acoes().sleep(1); // Aguarda entre os cliques
                }
                
                log.info("Popup de introdução fechado com sucesso");
            } else {
                log.info("Popup de introdução nao esta visivel");
            }
        } catch (Exception e) {
            log.info("Popup de introdução nao encontrado: {}", e.getMessage());
        }
    }

    /**
     * Fecha os popups se estiverem visíveis na tela Home
     */
    public static void fecharPopups() {
        try {
            if (isPopupVisivel()) {
                // Fecha popup de banco
                try {
                    if (homePage().getLblEncontreSeuBanco().isDisplayed()) {
                        acoes().click(homePage().getBtnFechar());
                        acoes().sleep(2);
                    }
                } catch (Exception e) {
                    // Popup de banco não está visível
                }
                
                // Fecha popup de introdução
                fecharPopupIntroducao();
                acoes().pullToRefresh();
            }
        } catch (Exception e) {
            log.info("Nenhum popup encontrado");
        }
    }

    /**
     * Fecha os popups usando PopupModel e PopupActions
     */
    public static void fecharPopupBancoComPopupModel() {
        try {
            popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome(), 5);
            
            // Após fechar o popup de banco, verifica se o popup de introdução apareceu
            fecharPopupIntroducao();
            
        } catch (Exception e) {
            fecharPopups();
        }
    }

    /**
     * Verifica se o popup de banco está visível de forma segura
     */
    private static boolean isPopupVisivel() {
        try {
            // Verifica popup de banco
            if (homePage().getLblEncontreSeuBanco().isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
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
        // Fecha popup antes de validar usando PopupModel
        fecharPopupBancoComPopupModel();
        
        log.info("valido a exibição da frase 'Inicio' na tela 'Home'");
        acoes().waitForVisibility(homePage().getVldTxtInicio());
        PrintScreen.screenshot("validacao_frase_inicio");
    }

    public static void clicarBtnDetalheDaConta() {
        log.info("clico no botão 'Detalhe da conta' na tela 'Home'");
        acoes().click(homePage().getBtnDetalheDaConta());
    }

    public static void visualizarValorSaldo() throws IOException {
        // Fecha popup antes de visualizar o saldo usando PopupModel
        fecharPopupBancoComPopupModel();
        
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
