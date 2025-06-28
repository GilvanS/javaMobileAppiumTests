package org.testes.paginas.registro.categoria;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;

import static org.testes.utils.Context.acoes;

@Slf4j
public class CategoriaActions {

    public static CategoriaPage categoriaPage() {
        return MasterPageFactory.getPage(CategoriaPage.class);
    }

    public static void clicarBtnReceita() {
        log.info("clico no botão Receita na tela Categoria");
        acoes().click(categoriaPage().getBtnReceita());
    }
}
