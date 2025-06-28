package org.testes.paginas.registro;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.paginas.popup.PopupActions;

import static org.testes.paginas.home.HomeActions.homePage;
import static org.testes.utils.Context.acoes;

@Slf4j
public class RegistroActions {

    private static final PopupActions popupActions = new PopupActions();

    public static RegistroPage registroPage() {
        return MasterPageFactory.getPage(RegistroPage.class);
    }

    public static void fecharTodosPopups() {
        popupActions.fecharTodosPopups(
                homePage().getLblEncontreSeuBanco(),
                homePage().getBtnFechar()
        );
    }
    public static void clicarBtnReceita() {
        log.info("clico no botão Receita na tela Registro");
        acoes().click(registroPage().getBtnReceita());
    }

    public static void clicarBtnCategoria() {
        log.info("clico no botão Categoria na tela Registro");
        acoes().click(registroPage().getBtnCategoria());
    }

    public static void preencherValor() {
        String valor = "100";
        log.info("preencho o campo valor na tela Registro");
        acoes().click(registroPage().digitarValor(valor));
    }
}
