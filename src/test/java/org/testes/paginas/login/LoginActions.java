package org.testes.paginas.login;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class LoginActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void vldTxtEntreParaAproveitar() throws IOException, InterruptedException {
        log.info("Validar texto 'Entre para aproveitar'");
        Thread.sleep(3000);
        acoes.waitForVisibility(loginPage().getVldTxtEntreParaAproveitar());
        PrintScreen.screenshot("teste");
    }

    public static void clickBtnEntreParaAproveitar(){
        log.info("clico no botao 'Entrar' na tela 'Login'");
        acoes.click(loginPage().getBtnEntreParaAproveitar());
    }

    public static void preencherCampoEmail(String email) {
        log.info("Preencher o campo Email: " + email);
        acoes.click(loginPage().getCampoSeuEmail());
        acoes.sendKeys(loginPage().getCampoSeuEmail(), email);
    }

    public static void clicarBtnProximo() {
        acoes.click(loginPage().getBtnProximo());
    }

    public static void preencherCampoSenha(String senha) {
        log.info("Preencher o campo Senha: " + senha);
        acoes.click(loginPage().getCampoSenha());
        acoes.sendKeys(loginPage().getCampoSenha(), senha);
    }

    public static void clicarBtnEntrar() {
        acoes.click(loginPage().getBtnEntrar());
    }

    public static void validarTxtEbacStore() throws IOException {
        log.info("Validando texto 'EBAC Store'");
        acoes.waitForVisibility(loginPage().getTxtEbacStore());
        PrintScreen.screenshot("validacao_ebac_store");
    }

    public static void clicarBtnProfile() {
        log.info("Clicando no botao 'Profile'");
        acoes.click(loginPage().getBtnProfile());
    }

    public static void validarTxtWelcomeEbacShop() throws IOException {
        log.info("Validando texto 'Welcome to EBAC Shop'");
        acoes.waitForVisibility(loginPage().getTxtWelcomeEbacShop());
        PrintScreen.screenshot("validacao_welcome_ebac_shop");
    }

    public static void clicarBtnSignUp() {
        log.info("Clicando no botao 'Sign up'");
        acoes.click(loginPage().getBtnSignUp());
    }

    public static void preencherCampoFirstName(String firstName) {
        log.info("Preenchendo campo 'First Name': " + firstName);
        acoes.click(loginPage().getCampoFirstName());
        acoes.sendKeys(loginPage().getCampoFirstName(), firstName);
    }

    public static void preencherCampoLastName(String lastName) {
        log.info("Preenchendo campo 'Last Name': " + lastName);
        acoes.click(loginPage().getCampoLastName());
        acoes.sendKeys(loginPage().getCampoLastName(), lastName);
    }

    public static void preencherCampoPhoneNumber(String phoneNumber) {
        log.info("Preenchendo campo 'Phone Number': " + phoneNumber);
        acoes.click(loginPage().getCampoPhoneNumber());
        acoes.sendKeys(loginPage().getCampoPhoneNumber(), phoneNumber);
    }

    public static void preencherCampoEmailAddress(String email) {
        log.info("Preenchendo campo 'Email Address': " + email);
        acoes.click(loginPage().getCampoEmailAddress());
        acoes.sendKeys(loginPage().getCampoEmailAddress(), email);
    }

    public static void preencherCampoPassword(String password) {
        log.info("Preenchendo campo 'Password'");
        acoes.click(loginPage().getCampoPassword());
        acoes.sendKeys(loginPage().getCampoPassword(), password);
    }

    public static void preencherCampoReEnterPassword(String password) {
        log.info("Preenchendo campo 'ReEnter Password'");
        acoes.click(loginPage().getCampoReEnterPassword());
        acoes.sendKeys(loginPage().getCampoReEnterPassword(), password);
    }

    public static void clicarBtnCreate() {
        log.info("Clicando no botao 'Create'");
        acoes.click(loginPage().getBtnCreate());
    }
}
