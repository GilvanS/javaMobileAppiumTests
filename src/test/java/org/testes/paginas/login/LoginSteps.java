package org.testes.paginas.login;

import java.io.IOException;

import io.cucumber.java.en.When;
import org.testes.paginas.home.HomeActions;
import org.testes.utils.FakerApi;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginSteps {

    private static final FakerApi faker = new FakerApi();

    @Given("valido a exibição da frase MYDEMOAPP na tela Products")
    public void validoAExibiçãoDaFraseMYDEMOAPPNaTelaProducts() {
        LoginActions.validarLblMyDemoApp();
    }

    @Given("que estou na tela Products")
    public void queEstouNaTelaProducts() {
        LoginActions.validarLblProducts();
    }

    @Given("clico no botão menu Hamburguer na tela Products")
    public void clicoNoBotãoMenuHamburguerNaTelaProducts() {
        LoginActions.clicarBtnMenu();
    }
    @Given("clico no botão Log In na tela Menu")
    public void clicoNoBotãoLogInNaTelaMenu() {
        LoginActions.clicarBtnLogIn();
    }
    @Given("preencho o campo Username na tela Login")
    public void preenchoOCampoUsernameComNaTelaLogin() {
        LoginActions.campoUsername();
    }
    @Given("preencho o campo Password na tela Login")
    public void preenchoOCampoPasswordComNaTelaLogin() {
        LoginActions.campoPassword();
    }

    @Given("clico no botão Login na tela Login")
    public void clicoNoBotãoLoginNaTelaLogin() {
        LoginActions.clicarBtnLogin();
    }

    @Then("valido a exibição da frase Products na tela Products")
    public void validoAExibiçãoDaFraseProductsNaTelaProducts() {
        LoginActions.validarLblProducts();
    }

    @When("clico no produto 'Sauce Labs Backpack' na tela Products")
    public void clicoNoProdutoNaTelaProducts() {
        LoginActions.clicarBtnSauceLabsBackpack();
    }
    @When("clico no botão Add to cart na tela Product Detail")
    public void clicoNoBotãoAddToCartNaTelaProductDetail() {
        LoginActions.clicarBtnAddToCart();

    }
    @Then("valido a exibição do produto 'Sauce Labs Backpack' no carrinho de compras na tela Cart")
    public void validoAExibiçãoDoProdutoNoCarrinhoDeComprasNaTelaCart() {
    }

    @Then("clico no botão Cart na tela Products")
    public void clicoNoBotãoCartNaTelaProducts() {
        LoginActions.clicarBtnCart();
    }
    
    @Then("clico no botão Proceed to checkout na tela Cart")
    public void clicoNoBotãoProceedToCheckoutNaTelaCart() {
        LoginActions.clicarBtnProceedToCheckout();
    }
    
    @Then("preencho o campo Full Name na tela Checkout")
    public void preenchoOCampoFullNameNaTelaCheckout() {
        LoginActions.campoFullName();
    }
    
    @Then("preencho o campo Address Line 1 na tela Checkout")
    public void preenchoOCampoAddressLine1NaTelaCheckout() {
        LoginActions.campoAddressLine1();
    }

    @Then("preencho o campo Address Line 2 na tela Checkout")
    public void preenchoOCampoAddressLine2NaTelaCheckout() {
        LoginActions.campoAddressLine2();
    }
    
    @Then("preencho o campo City na tela Checkout")
    public void preenchoOCampoCityNaTelaCheckout() {
        LoginActions.campoCity();
    }
    
    @Then("preencho o campo State Region na tela Checkout")
    public void preenchoOCampoStateRegionNaTelaCheckout() {
        LoginActions.campoStateRegion();
    }
    
    @Then("preencho o campo Zip Code na tela Checkout")
    public void preenchoOCampoZipCodeNaTelaCheckout() {
        LoginActions.campoZipCode();
    }
    
    @Then("preencho o campo Country na tela Checkout")
    public void preenchoOCampoCountryNaTelaCheckout() {
        LoginActions.campoCountry();
    }
    
    @Then("clico no botão To Payment na tela Checkout")
    public void clicoNoBotãoToPaymentNaTelaCheckout() {
        LoginActions.clicarBtnToPayment();
    }
    
    @Then("preencho o campo Full Name na tela Payment")
    public void preenchoOCampoFullNameNaTelaPayment() {
        LoginActions.campoCardFullName();
    }
    
    @Then("preencho o campo Card Number na tela Payment")
    public void preenchoOCampoCardNumberNaTelaPayment() {
        LoginActions.campoCardNumber();
    }
    
    @Then("preencho o campo Expiration Date na tela Payment")
    public void preenchoOCampoExpirationDateNaTelaPayment() {
        LoginActions.campoExpiryDate();
    }
    
    @Then("preencho o campo CVV na tela Payment")
    public void preenchoOCampoCVVNaTelaPayment() {
        LoginActions.campoCVV();
    }
    
    @Then("clico no botão Review Order na tela Payment")
    public void clicoNoBotãoReviewOrderNaTelaPayment() {
        LoginActions.clicarBtnReviewOrder();
    }

}