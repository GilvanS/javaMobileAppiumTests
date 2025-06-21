package org.testes.paginas.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.utils.FakerApi;
import org.testes.utils.Hooks;
import org.utilidades.dados.Usuario;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
public class LoginActions extends PageBaseActions {
    private static final FakerApi faker = new FakerApi();

    static LoginActions acoes = new LoginActions(Hooks.driver);

    private final LoginPage loginPage;

    public LoginActions(AppiumDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }

    private static LoginPage loginPage() {
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void validarLblMyDemoApp() {
        log.info("Validando texto 'MYDEMOAPP'");
        acoes.waitForElementToBeVisible(loginPage().getLblMyDemoApp(), 10);
        assertTrue(loginPage().getLblMyDemoApp().isDisplayed(),
                "Não foi posivel validar o texto 'MYDEMOAPP'");
        acoes.sleep(2);
    }

    public static void validarLblProducts() {
        log.info("Validando texto 'Products'");
        acoes.waitForElementToBeVisible(loginPage().getLblProducts(), 10);
        assertTrue(loginPage().getLblProducts().isDisplayed(),
                "Não foi posivel validar o texto 'Products'");
        acoes.sleep(2);
    }

    public static void clicarBtnMenu() {
        log.info("Clicando no botao 'Menu'");
        acoes.click(loginPage().getBtnMenu());
    }

    public static void clicarBtnLogIn() {
        log.info("Clicando no botao 'Log In'");
        acoes.click(loginPage().getBtnLogInMenu());
    }

    public static void campoUsername() {
        String username = Usuario.getEmail();
        log.info("Preenchendo campo Username: {}", username);
        acoes.click(loginPage().getCampoUsername());
        acoes.sendKeys(loginPage().getCampoUsername(), username);
        acoes.hideKeyboard();
    }

    public static void campoPassword() {
        String password = Usuario.getPassword();
        log.info("Preenchendo campo Password: {}", password);
        acoes.click(loginPage().getCampoPassword());
        acoes.sendKeys(loginPage().getCampoPassword(), password);
        acoes.hideKeyboard();
    }

    public static void clicarBtnLogin() {
        log.info("Clicando no botao 'Login'");
        acoes.click(loginPage().getBtnLogin());
    }

    public static void clicarBtnSauceLabsBackpack() {
        log.info("Clicando no botao 'Sauce Labs Backpack'");
        acoes.click(loginPage().getBtnSauceLabsBackpack());
    }

    public static void clicarBtnAddToCart() {
        log.info("Clicando no botao 'Add To Cart'");
        acoes.click(loginPage().getBtnaddToCart());
    }

    public static void clicarBtnCart() {
        log.info("Clicando no botao 'Cart'");
        acoes.click(loginPage().getBtnCart());
    }

    public static void clicarBtnProceedToCheckout() {
        log.info("Clicando no botao 'Proceed To Checkout'");
        acoes.click(loginPage().getBtnProceedToCheckout());
    }

    public static void campoFullName() {
        String fullName = faker.getFullName();
        log.info("Full Name {}", fullName);
        acoes.click(loginPage().getCampoFullName());
        acoes.sendKeys(loginPage().getCampoFullName(), fullName);
//        acoes.hideKeyboard();
    }

    public static void campoAddressLine1() {
        String addressLine = faker.getAddressLine();
        log.info("Address Line 1: {}", addressLine);
        acoes.click(loginPage().getCampoAddressLine1());
        acoes.sendKeys(loginPage().getCampoAddressLine1(), addressLine);

    }

    public static void campoAddressLine2() {
        String addressLine2 = faker.getAddressLine2();
        log.info("Address Line 2: {}", addressLine2);
        acoes.click(loginPage().getCampoAddressLine2());
        acoes.sendKeys(loginPage().getCampoAddressLine2(), addressLine2);

    }

    public static void campoCity() {
        String city = faker.getCity();
        log.info("City: {}", city);
        acoes.click(loginPage().getCampoCity());
        acoes.sendKeys(loginPage().getCampoCity(), city);

    }

    public static void campoStateRegion() {
        String stateRegion = faker.getStateRegion();
        log.info("State/Region: {}", stateRegion);
        acoes.click(loginPage().getCampoStateRegion());
        acoes.sendKeys(loginPage().getCampoStateRegion(), stateRegion);

    }

    public static void campoZipCode() {
        String zipCode = faker.getZipCode();
        log.info("Zip Code: {}", zipCode);
        acoes.click(loginPage().getCampoZipCode());
        acoes.sendKeys(loginPage().getCampoZipCode(), zipCode);

    }

    public static void campoCountry() {
        String country = faker.getCountry();
        log.info("Country: {}", country);
        acoes.click(loginPage().getCampoCountry());
        acoes.sendKeys(loginPage().getCampoCountry(), country);
    }

    public static void clicarBtnToPayment() {
        log.info("Clicando no botao 'To Payment'");
        acoes.click(loginPage().getBtnToPayment());
    }

    public static void campoCardFullName() {
        String cardFullName = faker.getCardFullName();
        log.info("Card Full Name: {}", cardFullName);
        acoes.click(loginPage().getCampoCardFullName());
        acoes.sendKeys(loginPage().getCampoCardFullName(), cardFullName);

    }

    public static void campoCardNumber() {
        String cardNumber = faker.getCardNumber();
        log.info("Card Number: {}", cardNumber);
        acoes.click(loginPage().getCampoCardNumber());
        acoes.sendKeys(loginPage().getCampoCardNumber(), cardNumber);

    }

    public static void campoExpiryDate() {
        String expiryDate = faker.getExpiryDate();
        log.info("Expiry Date: {}", expiryDate);
        acoes.click(loginPage().getCampoExpiryDate());
        acoes.sendKeys(loginPage().getCampoExpiryDate(), expiryDate);

    }

    public static void campoCVV() {
        String cvv = faker.getCvv();
        log.info("CVV: {}", cvv);
        acoes.click(loginPage().getCampoCVV());
        acoes.sendKeys(loginPage().getCampoCVV(), cvv);

    }

    public static void clicarBtnReviewOrder() {
        log.info("Clicando no botao 'Review Order'");
        acoes.click(loginPage().getBtnReviewOrder());
    }
}
