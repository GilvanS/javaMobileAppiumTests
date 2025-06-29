package org.testes.paginas.registro;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.paginas.popup.PopupActions;
import org.testes.driver.manager.SaldoManager;
import static org.testes.paginas.home.HomeActions.homePage;
import static org.testes.utils.Context.acoes;

@Slf4j
public class RegistroActions {

    public static RegistroPage registroPage() {
        return MasterPageFactory.getPage(RegistroPage.class);
    }

    public static void clicarBtnReceita() {
        log.info("clico no botão Receita na tela Registro");
        // Fechar popup de introdução se estiver visível
        fecharPopupIntroducao();
        acoes().click(registroPage().getBtnReceita());
    }

    /**
     * Fecha popup de introdução com cliques no meio da tela
     */
    private static void fecharPopupIntroducao() {
        try {
            acoes().sleep(1);
            log.info("Fechando popup de introdução na tela Registro");
            for (int i = 1; i <= 2; i++) {
                acoes().clicarMeioTela();
                acoes().sleep(1);
            }
            log.info("Introdução finalizada na tela Registro, prosseguindo para proxima etapa");
            // Verifica se precisa de cliques adicionais
            try {
                log.info("Fazendo cliques adicionais para garantir fechamento");
                for (int i = 1; i <= 2; i++) {
                    acoes().clicarMeioTela();
                    acoes().sleep(1);
                }
            } catch (Exception e) {
                // Popup fechado com sucesso
            }
        } catch (Exception e) {
            log.info("Erro ao fechar popup de introdução na tela Registro: {}", e.getMessage());
        }
    }

    public static void clicarBtnCategoria() {
        log.info("clico no botão Categoria na tela Registro");
        acoes().click(registroPage().getBtnCategoria());
    }

    public static void preencherValor() {
        String valor = "100";
        log.info("preencho o campo com valor R$ " + valor + " na tela Registro");
        
        // Armazenar o valor digitado para validação posterior
        SaldoManager.setValorRegistro("R$ " + valor + ",00");
        
        // Clicar nos dígitos individualmente
        for (char digito : valor.toCharArray()) {
            acoes().click(registroPage().digitarValor(String.valueOf(digito)));
            acoes().sleep(1); // Pequena pausa entre os cliques
        }
    }

    public static void clicarBtnSalvar() {
        log.info("clico no botão Salvar na tela Registro");
        acoes().click(registroPage().getBtnSalvar());
    }
}
