package org.testes.paginas.swipe;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testes.paginas.home.HomeActions;

import java.io.IOException;

public class SwipeSteps {


    @Then("valido a exibição da frase Support Videos na tela Swipe Horizontal")
    public void validoAExibicaoDaFraseGreatCommunityNaTelaSwipeHorizontal() throws IOException {
        SwipeActions.validarBtnSupportVideos();
        SwipeActions.clicarBtnSupportVideos();
    }

    @Then("valido a exibição da frase Fully Open Source na tela Swipe Horizontal")
    public void validoAExibicaoDaFraseFullyOpenSourceNaTelaSwipeHorizontal() throws IOException {
        SwipeActions.validarLblGreatCommunity();
        SwipeActions.validarLblFullyOpenSource();
        SwipeActions.validarLblYouFoundMe();

    }
}
