package org.testes.paginas.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.utils.JavaFakerGenerator;
import org.testes.utils.Hooks;
import org.utilidades.dados.Usuario;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class LoginActions extends PageBaseActions {
    private static final JavaFakerGenerator faker = new JavaFakerGenerator();

    static LoginActions acoes = new LoginActions(Hooks.getDriver());

    private final LoginPage loginPage;

    public LoginActions(AppiumDriver driver) {
        super(driver);
        loginPage = new LoginPage();
    }

    private static LoginPage loginPage() {
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void campoEmail() {
        String email = faker.getEmailAddress();
        log.info("Preenchendo campo Email: {}", email);
        acoes.click(loginPage().getCampoEmail());
        acoes.sendKeys(loginPage().getCampoEmail(), email);
        acoes.hideKeyboard();
    }

    public static void campoPassword() {
        String password = faker.getPassword();
        log.info("Preenchendo campo Password: {}", password);
        acoes.click(loginPage().getCampoPassword());
        acoes.sendKeys(loginPage().getCampoPassword(), password);
        acoes.hideKeyboard();
    }

    public static void campoConfirmPassword() {
        String confirmPassword = faker.getPassword();
        log.info("Preenchendo campo Confirm Password: {}", confirmPassword);
        acoes.click(loginPage().getCampoConfirmPassword());
        acoes.sendKeys(loginPage().getCampoConfirmPassword(), confirmPassword);
        acoes.hideKeyboard();
    }

    public static void clicarBtnSignUp() {
        log.info("Clicando no botao 'Sign Up'");
        acoes.click(loginPage().getBtnSignUp());
    }

    public static void clicarBtnLogin() {
        log.info("Clicando no botao 'Login'");
        acoes.click(loginPage().getBtnLogin());
    }

    public static void validarLblSignedUp() {
        log.info("Validando texto 'Signed Up'");
        acoes.waitForElementToBeVisible(loginPage().getLblSignedUp(), 10);
        assertTrue(loginPage().getLblSignedUp().isDisplayed(),
                "Nao foi posivel validar o texto 'Signed Up'");
        acoes.sleep(2);
    }

    public static void validarLblSuccess() {
        log.info("Validando texto 'Success'");
        acoes.waitForElementToBeVisible(loginPage().getLblSuccess(), 10);
        assertTrue(loginPage().getLblSuccess().isDisplayed(),
                "Nao foi posivel validar o texto 'Success'");
        acoes.sleep(2);
    }
} 