package org.testes.paginas.home;

import org.testes.paginas.home.HomeActions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class HomeSteps {

    @Given("que estou na tela home")
    public void queEstouNaTelaHome() {
        HomeActions.clicarBtnHome();
    }

    @Then("valido a exibição da frase WEBDRIVERIO na tela Home")
    public void validoAExibicaoDaFraseWEBDRIVERIONaTelaHome() {
        HomeActions.validarLblWebDriveIo();
    }

    @Given("clico no botão Webview na tela Home")
    public void clicoNoBotaoWebviewNaTelaHome() {
        HomeActions.clicarBtnWebview();
    }

    @Then("valido a exibição da frase Next-gen browser na tela Webview")
    public void validoAExibicaoDaFraseNextGenBrowserNaTelaWebview() {
        HomeActions.validarLblNextGenBrowser();
    }
}
