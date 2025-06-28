package org.testes.paginas.home;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testes.driver.manager.SaldoManager;
import org.testes.driver.page.MasterPageFactory;
import org.testes.paginas.popup.PopupActions;
import static org.testes.utils.Context.acoes;
import org.utilidades.evidencia.PrintScreen;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HomeActions {

    private static final PopupActions popupActions = new PopupActions();

    public static HomePage homePage(){
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void fecharTodosPopups() {
        popupActions.fecharTodosPopups(
            homePage().getLblEncontreSeuBanco(), 
            homePage().getBtnFechar()
        );
    }

    public static void validarLblInicio() throws IOException {
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

    public static void validarAcompanheSeusGastos() {
        log.info("Validando a exibição do banner 'Acompanhe seus gastos'");
        acoes().waitForVisibility(homePage().getVldAcompanheSeusGastos());
    }

    public static void selecionarModoEscuro() throws IOException {
        log.info("Selecionando o banner 'Modo escuro'");
        acoes().horizontalSwipeLeft(homePage().getVldBannerswipe(), homePage().getVldModoEscuro(),3);
    }

    public static void clicarBtnExperimenteModoEscuro() {
        log.info("Clico no botão 'Experimente o modo escuro'");
        acoes().click(homePage().getBtnExperimenteOModoEscuro());
    }

    public static void clicarBtnMenuAmburger() {
        log.info("Clico no botão 'Hamburguer'");
        acoes().click(homePage().getBtnMenuHamburguer());
    }

    public static void validarModoEscuroAtivo() throws IOException {
        log.info("Validando o botao 'Modo escuro' ativo");
        acoes().verticalSwipeDownAndSearch(homePage().getVldDrawerMenu(), homePage().getVldModoEscuroMenu(),3);
        acoes().waitForVisibility(homePage().getVldModoEscuroMenu());
    }

    public static void clicarBtnAdd() {
        log.info("Clico no botão 'Add'");
        acoes().click(homePage().getBtnAdd());
    }

    public static void clicarBtnNovoRegistro() {
        log.info("Clico no botão 'Novo registro'");
        acoes().click(homePage().getBtnNovoRegistro());
    }

    // ============================================================================
    // MÉTODOS REMOVIDOS - DOCUMENTAÇÃO PARA USO FUTURO
    // ============================================================================
    
    /*
     * MÉTODOS REMOVIDOS POR NÃO ESTAREM SENDO UTILIZADOS:
     * 
     * 1. getPopupModelHome() - Configuração do PopupModel para tela Home
     * 2. validarExibicaoTelaHome() - Validação da exibição da tela Home
     * 
     * SE PRECISAR REUTILIZAR NO FUTURO:
     * 
     * // Para configurar PopupModel da tela Home:
     * public static PopupModel getPopupModelHome() {
     *     PopupModel popupModel = new PopupModel("Home");
     *     popupModel.setElementosEsperados(homePage().getVldTxtInicio());
     *     popupModel.setElementosIdentificadores(
     *         homePage().getLblEncontreSeuBanco(),
     *         homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco()
     *     );
     *     popupModel.setElementosDeAcao(homePage().getBtnFechar());
     *     popupModel.setDelay(false);
     *     return popupModel;
     * }
     * 
     * // Para validar exibição da tela Home:
     * public static void validarExibicaoTelaHome() {
     *     log.info("Valido a exibição da tela Home");
     *     popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
     *     assertTrue(acoes().waitForElementToBeVisible(homePage().getVldTxtInicio(), 10).isDisplayed(), 
     *               "Tela home não foi apresentada corretamente");
     *     log.info("Tela Home apresentada com sucesso");
     * }
     * 
     * IMPORTS NECESSÁRIOS:
     * import org.testes.paginas.popup.PopupModel;
     */
}
