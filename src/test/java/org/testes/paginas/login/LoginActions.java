package org.testes.paginas.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testes.driver.page.MasterPageFactory;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.testes.utils.JavaFakerGenerator;

import static org.testes.utils.Context.acoes;

@Getter
@Slf4j
public class LoginActions {
    private static final JavaFakerGenerator faker = new JavaFakerGenerator();

    private static LoginPage getLoginPage() {
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void campoEmail() {
        String email = faker.getEmailAddress();
        log.info("Preenchendo campo Email: {}", email);
        acoes().click(getLoginPage().getCampoEmail());
        acoes().sendKeys(getLoginPage().getCampoEmail(), email);
        acoes().hideKeyboard();
    }

    public static void campoPassword() {
        String password = faker.getPassword();
        log.info("Preenchendo campo Password: {}", password);
        acoes().click(getLoginPage().getCampoPassword());
        acoes().sendKeys(getLoginPage().getCampoPassword(), password);
        acoes().hideKeyboard();
    }

    public static void campoConfirmPassword() {
        String confirmPassword = faker.getPassword();
        log.info("Preenchendo campo Confirm Password: {}", confirmPassword);
        acoes().click(getLoginPage().getCampoConfirmPassword());
        acoes().sendKeys(getLoginPage().getCampoConfirmPassword(), confirmPassword);
        acoes().hideKeyboard();
    }

    public static void clicarBtnSignUp() {
        log.info("Clicando no botao 'Sign Up'");
        acoes().click(getLoginPage().getBtnSignUp());
    }

    public static void clicarBtnLogin() {
        log.info("Clicando no botao 'Login'");
        acoes().click(getLoginPage().getBtnLogin());
    }

    public static void validarLblSignedUp() {
        log.info("Validando texto 'Signed Up'");
        acoes().waitForElementToBeVisible(getLoginPage().getLblSignedUp(), 10);
        assertTrue(getLoginPage().getLblSignedUp().isDisplayed(),
                "Nao foi posivel validar o texto 'Signed Up'");
        acoes().sleep(2);
    }

    public static void validarLblSuccess() {
        log.info("Validando texto 'Success'");
        acoes().waitForElementToBeVisible(getLoginPage().getLblSuccess(), 10);
        assertTrue(getLoginPage().getLblSuccess().isDisplayed(),
                "Nao foi posivel validar o texto 'Success'");
        acoes().sleep(2);
    }
} 