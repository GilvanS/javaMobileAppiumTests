package org.testes.paginas.registro.categoria.receita;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;

import static org.testes.utils.Context.acoes;

@Slf4j
public class ReceitaActions {

    public static ReceitaPage receitaPage() {
        return MasterPageFactory.getPage(ReceitaPage.class);
    }

    public static void clicarBtnSalariosFatura() {
        log.info("clico no botão Receita na tela Registro");
        acoes().click(receitaPage().getBtnSalarioFaturas());
    }


}
