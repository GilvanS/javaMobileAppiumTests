package org.testes.paginas.swipe;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testes.paginas.home.HomeActions;

import java.io.IOException;

public class SwipeSteps {


    @When("deslizo para a direita na tela Swipe Horizontal")
    public void deslizoParaADireitaNaTelaSwipeHorizontal() throws IOException {
        SwipeActions.validarBtnSupportVideos();

    }
    @Then("valido a exibição da frase Support Videos na tela Swipe Horizontal")
    public void validoAExibicaoDaFraseGreatCommunityNaTelaSwipeHorizontal() throws IOException {
        SwipeActions.clicarBtnSupportVideos();
    }
    @When("deslizo para a esquerda na tela Swipe Horizontal")
    public void deslizoParaAEsquerdaNaTelaSwipeHorizontal() throws IOException {
        SwipeActions.validarLblGreatCommunity();
    }
    @Then("valido a exibição da frase Fully Open Source na tela Swipe Horizontal")
    public void validoAExibicaoDaFraseFullyOpenSourceNaTelaSwipeHorizontal() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
