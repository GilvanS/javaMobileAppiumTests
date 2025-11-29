package org.testes.paginas.home;

import java.io.IOException;

import io.cucumber.java.en.*;


public class HomeSteps {
    
    @Given("que estou na pagina inicial")
    public void queEstouNaPaginaInicial() {
        HomeActions.validarOTextoOla();
    }

    @When("valido o titulo da pagina como {string}")
    public void validoOTituloDaPaginaComoOlá(String arg0) {
        HomeActions.clicarNoBotaoEntreNaSuaConta();
    }

}
