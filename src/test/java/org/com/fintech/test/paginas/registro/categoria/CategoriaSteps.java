package org.com.fintech.test.paginas.registro.categoria;

import io.cucumber.java.en.When;

public class CategoriaSteps {

    @When("clico no botão Receita na tela Categoria")
    public void clicoNoBotãoReceitaNaTelaCategoria() {
        CategoriaActions.clicarBtnReceita();
    }
}
