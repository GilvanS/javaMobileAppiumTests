package org.testes.paginas.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;



@Getter
public class LoginPage extends PageBaseActions {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(accessibility = "longpress reset app")
    private WebElement lblMyDemoApp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Products']")
    private WebElement lblProducts;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='open menu']/android.widget.ImageView")
    private WebElement btnMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In']")
    private WebElement btnLogInMenu;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
    private WebElement btnLogOut;

    @AndroidFindBy(accessibility = "Username input field")
    private WebElement campoUsername;

    @AndroidFindBy(accessibility = "Login button")
    private WebElement btnLogin;

    @AndroidFindBy(accessibility = "Password input field")
    private WebElement campoPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='store item text' and @text='Sauce Labs Backpack']")
    private WebElement btnSauceLabsBackpack;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Add To Cart']")
    private WebElement btnaddToCart;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='cart badge']/android.widget.ImageView")
    private WebElement btnCart;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Proceed To Checkout']")
    private WebElement btnProceedToCheckout;

    @AndroidFindBy(accessibility = "Full Name* input field")
    private WebElement campoFullName;

    @AndroidFindBy(accessibility = "Address Line 1* input field")
    private WebElement campoAddressLine1;

    @AndroidFindBy(accessibility = "Address Line 2 input field")
    private WebElement campoAddressLine2;

    @AndroidFindBy(accessibility = "City* input field")
    private WebElement campoCity;

    @AndroidFindBy(accessibility = "State/Region input field")
    private WebElement campoStateRegion;

    @AndroidFindBy(accessibility = "Zip Code* input field")
    private WebElement campoZipCode;

    @AndroidFindBy(accessibility = "Country* input field")
    private WebElement campoCountry;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='To Payment']")
    private WebElement btnToPayment;

    @AndroidFindBy(accessibility = "Full Name* input field")
    private WebElement campoCardFullName;

    @AndroidFindBy(accessibility = "Card Number* input field")
    private WebElement campoCardNumber;

    @AndroidFindBy(accessibility = "Expiration Date* input field")
    private WebElement campoExpiryDate;

    @AndroidFindBy(accessibility = "Security Code* input field")
    private WebElement campoCVV;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='checkbox for My billing address is the same as my shipping address.']/android.view.ViewGroup/android.widget.ImageView")
    private WebElement btnCheckbox;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Review Order']")
    private WebElement btnReviewOrder;

    @AndroidFindBy(accessibility = "product price")
    private WebElement lblPreco;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Place Order']")
    private WebElement btnPlaceOrder;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Checkout Complete']")
    private WebElement lblCheckoutComplete;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Continue Shopping']")
    private WebElement btnContinueShopping;

    public WebElement getTxtUserName(String nomeCompleto) {
        String xpathNome = String.format("//android.widget.TextView[@text='%s']", nomeCompleto);
        return driver.findElement(By.xpath(xpathNome));
    }

    public WebElement getTxtUserPhone(String userPhone) {
        String xpathPhone = String.format("//android.widget.TextView[contains(@text, '+91 %s')]", userPhone);
        return driver.findElement(By.xpath(xpathPhone));
    }

    public WebElement getTxtUserEmail(String userEmail) {
        String xpathEmail = String.format("//android.widget.TextView[@text='%s']", userEmail);
        return driver.findElement(By.xpath(xpathEmail));
    }

}
