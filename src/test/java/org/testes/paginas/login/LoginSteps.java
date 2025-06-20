package org.testes.paginas.login;

import java.io.IOException;

import org.testes.paginas.home.HomeActions;
import org.testes.utils.FakerApi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSteps {

    private static final FakerApi faker = new FakerApi();

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

    @And("preencho o campo First Name na tela cadastro")
    public void preenchoCampoFirstName() {
        LoginActions.preencherCampoFirstName();
    }

    @And("preencho o campo Last Name na tela cadastro")
    public void preenchoCampoLastName() {
        LoginActions.preencherCampoLastName();
    }

    @And("preencho o campo Phone Number na tela cadastro")
    public void preenchoCampoPhoneNumber() {
        LoginActions.preencherCampoPhoneNumber();
    }

    @And("preencho o campo Email Address na tela cadastro")
    public void preenchoCampoEmailAddress() {
        LoginActions.preencherCampoEmailAddress();
    }

    @And("preencho o campo Password na tela Login")
    public void preenchoCampoPassword() {
        LoginActions.preencherCampoPasswordLogin();
    }

    @And("preencho o campo Password na tela cadastro")
    public void preenchoCampoPasswordNaTelaCadastro() {
        LoginActions.preencherCampoPassword();
    }

    @Given("preencho o campo Email na tela Login")
    public void preenchoOCampoEmailNaTelaLogin() {
        LoginActions.preencherCampoEmailLogin();
    }
    @Given("clico no botão Login na tela Login")
    public void clicoNoBotãoLoginNaTelaLogin() {
        LoginActions.clicarBtnLogin();
    }

    @And("preencho o campo ReEnter Password na tela cadastro")
    public void preenchoCampoReEnterPassword() {
        LoginActions.reEnterPassword();
    }

    @And("clico no botão Create na tela cadastro")
    public void clicoNoBotaoCreateNaTelaLogin() {
        LoginActions.clicarBtnCreate();
    }

    @And("clico no botão Wishlist na tela Home")
    public void clicoNoBotaoFavoritesNaTelaHome() {
        LoginActions.clicarBtnWishlist();
    }

    @And("clico no botão voltar na tela Wishlist")
    public void clicoNoBotaoVoltarNaTelaFavorites() {
        LoginActions.clicarBtnVoltar();
    }

    @And("valido o nome do usuário na tela Profile")
    public void validoONomeDoUsuarioNaTelaProfile() throws IOException {
        LoginActions.validarNomeUsuario();
    }

    @And("valido o Phone Number do usuário na tela Profile")
    public void validoOPhoneNumberDoUsuarioNaTelaProfile() throws IOException {
        LoginActions.validarPhoneNumberUsuario();
    }

    @And("valido o Email Address do usuário na tela Profile")
    public void validoOEmailAddressDoUsuarioNaTelaProfile() throws IOException {
        LoginActions.validarEmailUsuario();
    }

    @And("clico no botão Edit Profile na tela Profile")
    public void clicoNoBotaoEditProfileNaTelaProfile() {
        LoginActions.clicarBtnEditProfile();
    }

    @And("valido o First Name do usuário na tela Edit Profile")
    public void validoOFirstNameDoUsuarioNaTelaEditProfile() throws IOException {
        LoginActions.validarFirstNameEditProfile();
    }

    @And("valido o Last Name do usuário na tela Edit Profile")
    public void validoOLastNameDoUsuarioNaTelaEditProfile() throws IOException {
        LoginActions.validarLastNameEditProfile();
    }

    @And("valido o Phone Number do usuário na tela Edit Profile")
    public void validoOPhoneNumberDoUsuarioNaTelaEditProfile() throws IOException {
        LoginActions.validarPhoneNumberEditProfile();
    }

    @And("valido o Email Address do usuário na tela Edit Profile")
    public void validoOEmailAddressDoUsuarioNaTelaEditProfile() throws IOException {
        LoginActions.validarEmailEditProfile();
    }

    @And("clico no botão voltar na tela Edit Profile")
    public void clicoNoBotaoVoltarNaTelaEditProfile() {
        LoginActions.clicarBtnVoltar();
    }

    @And("clico no botão Logout na tela Profile")
    public void clicoNoBotaoLogoutNaTelaProfile() {
        LoginActions.clicarBtnLogout();
    }

    @Given("valido a exibição da frase Entre para aproveitar a melhor experiência na tela login")
    public void valido_a_exibição_da_frase_entre_para_aproveitar_a_melhor_experiência_na_tela_login() throws IOException, InterruptedException {
        LoginActions.validarTelaLogin();
    }

    @Given("clico no botão Entre na tela Login")
    public void clicar_no_botão_entre_na_tela_login() {
        LoginActions.clicarBtnProximo();
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

    @And("clico no botão Yes na tela Logout")
    public void clicoNoBotãoYesNaTelaLogout() {
        LoginActions.clicarBtnYes();
    }
}