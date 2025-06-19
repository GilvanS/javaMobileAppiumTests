package org.br.com.mobile.pages.home;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.br.com.web.pages.home.HomeLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class HomeSteps {

    private static final Logger log = LoggerFactory.getLogger(HomeSteps.class);
    private HomePage homePage;
    static PageBaseActions acoes = new PageBaseActions();

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    @Then("valido a exibição da tela {string}")
    public void validoAExibiçãoDaTela(String string) {
        HomeActions.validarExibicaoTelaHome();
    }

    @When("valido a exibição do botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'")
    public void validoAExibicaoDoBotaoNaoMostrarNovamenteEmAtiveSuaBiometriaNaTelaHome() {
        HomeActions.validarExibicaoBtnNaoMostrarNovamenteAtiveSuaBiometria();
    }

    @When("clico no botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'")
    public void clicoNoBotaoNaoMostrarNovamenteEmAtiveSuaBiometriaNaTelaHome() {
        HomeActions.clicarBtnNaoMostrarNovamenteAtiveSuaBiometria();
    }
}
