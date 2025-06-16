package org.testes.paginas.login;

import io.cucumber.java.en.*;
import org.testes.paginas.home.HomeActions;

import java.io.IOException;

public class LoginSteps {

    @Given("que estou na tela Home")
    public void queEstouNaTelaHome() throws IOException {
        LoginActions.validarTxtEbacStore();
    }

    @And("valido a exibição da frase EBAC Store tela Home")
    public void validoAExibicaoDaFraseEBACStoreTelaHome() throws IOException {
        LoginActions.validarTxtEbacStore();
    }

    @And("clico no botão Profile na tela Home")
    public void clicoNoBotaoProfileNaTelaHome() {
        LoginActions.clicarBtnProfile();
    }

    @And("valido a exibição da frase Welcome to EBAC Shop na tela Login")
    public void validoAExibicaoDaFraseWelcomeToEBACShopNaTelaLogin() throws IOException {
        LoginActions.validarTxtWelcomeEbacShop();
    }

    @And("clico no botão Sign up na tela Login")
    public void clicoNoBotaoSignUpNaTelaLogin() {
        LoginActions.clicarBtnSignUp();
    }

    @And("preencho o campo First Name na tela Login")
    public void preenchoOCampoFirstNameNaTelaLogin() {
        LoginActions.preencherCampoFirstName("Teste");
    }

    @And("preencho o campo Last Name na tela Login")
    public void preenchoOCampoLastNameNaTelaLogin() {
        LoginActions.preencherCampoLastName("Automacao");
    }

    @And("preencho o campo Phone Number na tela Login")
    public void preenchoOCampoPhoneNumberNaTelaLogin() {
        LoginActions.preencherCampoPhoneNumber("11999999999");
    }

    @And("preencho o campo Email Address na tela Login")
    public void preenchoOCampoEmailAddressNaTelaLogin() {
        LoginActions.preencherCampoEmailAddress("teste@teste.com");
    }

    @And("preencho o campo Password na tela Login")
    public void preenchoOCampoPasswordNaTelaLogin() {
        LoginActions.preencherCampoPassword("Teste@123");
    }

    @And("preencho o campo ReEnter Password na tela Login")
    public void preenchoOCampoReEnterPasswordNaTelaLogin() {
        LoginActions.preencherCampoReEnterPassword("Teste@123");
    }

    @And("clico no botão Create na tela Login")
    public void clicoNoBotaoCreateNaTelaLogin() {
        LoginActions.clicarBtnCreate();
    }

    @Given("valido a exibição da frase Entre para aproveitar a melhor experiência na tela login")
    public void valido_a_exibição_da_frase_entre_para_aproveitar_a_melhor_experiência_na_tela_login() throws IOException, InterruptedException {
        LoginActions.vldTxtEntreParaAproveitar();
    }

    @Given("clico no botão Entre na tela Login")
    public void clicar_no_botão_entre_na_tela_login() {
        LoginActions.clickBtnEntreParaAproveitar();
    }

    @Given("preencho o campo email {string} na tela Login")
    public void preencho_o_campo_email_na_tela_login(String email) {
        LoginActions.preencherCampoEmail(email);
    }

    @Given("clico no botão Próximo na tela Login")
    public void clicar_no_botão_próximo_na_tela_login() {
        LoginActions.clicarBtnProximo();
    }

    @Given("preencho o campo Senha {string} na tela Login")
    public void preencho_o_campo_senha_na_tela_login(String senha) {
        LoginActions.preencherCampoSenha(senha);
    }

    @Given("clico no botão Entrar na tela Login")
    public void clico_no_botão_entrar_na_tela_login() {
        LoginActions.clicarBtnEntrar();
    }

    @Then("clico no botão Explorar na tela Home")
    public void clicar_no_botão_explorar_na_tela_home() {
        HomeActions.clicarBtnExplorar();
    }
}