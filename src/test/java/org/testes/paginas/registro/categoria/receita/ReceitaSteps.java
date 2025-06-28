package org.testes.paginas.registro.categoria.receita;

import io.cucumber.java.en.When;

public class ReceitaSteps {

    @When("clico no botão Salário faturas na tela Receita")
    public void clicoNoBotãoSalárioFaturasNaTelaReceita() {
        ReceitaActions.clicarBtnSalariosFatura();
    }
}
