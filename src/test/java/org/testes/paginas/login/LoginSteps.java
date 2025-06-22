package org.testes.paginas.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSteps {

    @Given("que estou na tela login")
    public void queEstouNaTelaLogin() {
        log.info("Navegando para a tela de login");
        // Implementar navegação para a tela de login se necessário
    }

    @When("preencho o campo email na tela Login")
    public void preenchoOCampoEmailNaTelaLogin() {
        LoginActions.campoEmail();
    }

    @And("preencho o campo password na tela Login")
    public void preenchoOCampoPasswordNaTelaLogin() {
        LoginActions.campoPassword();
    }

    @And("preencho o campo confirm password na tela Login")
    public void preenchoOCampoConfirmPasswordNaTelaLogin() {
        LoginActions.campoConfirmPassword();
    }

    @And("clico no botão Sign Up na tela Login")
    public void clicoNoBotaoSignUpNaTelaLogin() {
        LoginActions.clicarBtnSignUp();
    }

    @Then("valido a exibição da frase Signed Up na tela Login")
    public void validoAExibicaoDaFraseSignedUpNaTelaLogin() {
        LoginActions.validarLblSignedUp();
    }

    @And("clico no botão Login na tela Login")
    public void clicoNoBotaoLoginNaTelaLogin() {
        LoginActions.clicarBtnLogin();
    }

    @Then("valido a exibição da frase Success na tela Login")
    public void validoAExibicaoDaFraseSuccessNaTelaLogin() {
        LoginActions.validarLblSuccess();
    }
}