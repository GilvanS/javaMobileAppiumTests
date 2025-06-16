package org.testes.paginas.login;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.testes.utils.FakerApi;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class LoginActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    static FakerApi faker = new FakerApi();

    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void vldTxtEntreParaAproveitar() throws IOException, InterruptedException {
        log.info("Validando texto 'Entre para aproveitar'");
        Thread.sleep(3000);
        acoes.waitForVisibility(loginPage().getVldTxtEntreParaAproveitar());
        PrintScreen.screenshot("teste");
    }

    public static void clickBtnEntreParaAproveitar(){
        log.info("Clicando no botao 'Entrar'");
        acoes.click(loginPage().getBtnEntreParaAproveitar());
    }

    public static void preencherCampoEmail(String email) {
        log.info("Preenchendo email: {}", email);
        acoes.click(loginPage().getCampoSeuEmail());
        acoes.sendKeys(loginPage().getCampoSeuEmail(), email);
    }

    public static void clicarBtnProximo() {
        log.info("Clicando no botao 'Proximo'");
        acoes.click(loginPage().getBtnProximo());
    }

    public static void preencherCampoSenha(String senha) {
        log.info("Preenchendo senha");
        acoes.click(loginPage().getCampoSenha());
        acoes.sendKeys(loginPage().getCampoSenha(), senha);
    }

    public static void clicarBtnEntrar() {
        log.info("Clicando no botao 'Entrar'");
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

    public static void clicarBtnCreate() {
        log.info("Clicando no botao 'Create'");
        acoes.click(loginPage().getBtnCreate());
    }

    // Métodos base para preenchimento de campos
    private static void preencherCampoFirstName(String firstName) {
        acoes.click(loginPage().getCampoFirstName());
        acoes.sendKeys(loginPage().getCampoFirstName(), firstName);
    }

    private static void preencherCampoLastName(String lastName) {
        acoes.click(loginPage().getCampoLastName());
        acoes.sendKeys(loginPage().getCampoLastName(), lastName);
    }

    private static void preencherCampoPhoneNumber(String phoneNumber) {
        acoes.click(loginPage().getCampoPhoneNumber());
        acoes.sendKeys(loginPage().getCampoPhoneNumber(), phoneNumber);
    }

    private static void preencherCampoEmailAddress(String email) {
        acoes.click(loginPage().getCampoEmailAddress());
        acoes.sendKeys(loginPage().getCampoEmailAddress(), email);
    }

    private static void preencherCampoPassword(String password) {
        acoes.click(loginPage().getCampoPassword());
        acoes.sendKeys(loginPage().getCampoPassword(), password);
    }

    private static void preencherCampoReEnterPassword(String password) {
        acoes.click(loginPage().getCampoReEnterPassword());
        acoes.sendKeys(loginPage().getCampoReEnterPassword(), password);
    }

    // Métodos que usam FakerApi para gerar dados
    public static void preencherCampoFirstNameComFaker() {
        log.info("Preenchendo First Name");
        preencherCampoFirstName(faker.getFirstName());
    }

    public static void preencherCampoLastNameComFaker() {
        log.info("Preenchendo Last Name");
        preencherCampoLastName(faker.getLastName());
    }

    public static void preencherCampoPhoneNumberComFaker() {
        log.info("Preenchendo Phone Number");
        preencherCampoPhoneNumber(faker.getPhoneNumber());
    }

    public static void preencherCampoEmailAddressComFaker() {
        log.info("Preenchendo Email Address");
        preencherCampoEmailAddress(faker.getEmailAddress());
    }

    public static void preencherCampoPasswordComFaker() {
        log.info("Preenchendo Password e ReEnter Password");
        String password = faker.getPassword();
        preencherCampoPassword(password);
        preencherCampoReEnterPassword(password);
    }
}
