package org.testes.paginas.login;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;
import org.testes.manager.UsuarioManager;


@Getter
public class LoginPage extends PageBaseActions {

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[@content-desc= 'Entre para aproveitar a melhor experiência']")
    private WebElement vldTxtEntreParaAproveitar;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Entre')]")
    private WebElement btnEntreParaAproveitar;

    @AndroidFindBy(xpath = "//android.widget.EditText")
    private WebElement CampoSeuEmail;

    @AndroidFindBy(xpath = "//*[@content-desc= 'Próximo']")
    private WebElement btnProximo;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.EditText")
    private WebElement campoSenha;

    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Entrar')]")
    private WebElement btnEntrar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EBAC Store']")
    private WebElement txtEbacStore;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Profile']")
    private WebElement btnProfile;

    @AndroidFindBy(xpath = "//*[@text='Welcome to EBAC Shop']")
    private WebElement txtWelcomeEbacShop;

    @AndroidFindBy(xpath = "//*[@content-desc='Sign up']")
    private WebElement btnSignUp;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='First Name']")
    private WebElement campoFirstName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Last Name']")
    private WebElement campoLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Phone Number']")
    private WebElement campoPhoneNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Email Address']")
    private WebElement campoEmailAddress;

    @AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
    private WebElement campoPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='repassword']")
    private WebElement campoReEnterPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Create']")
    private WebElement btnCreate;

    // Novos elementos para os steps adicionais
    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='wishlist']")
    private WebElement btnWishlist;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id='back']")
    private WebElement btnVoltar;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Edit Profile']")
    private WebElement btnEditProfile;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Logout']")
    private WebElement btnLogout;

    // Elementos para validação do Profile
    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Lynch Hazel']")
    private WebElement txtUserName;

//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Email']/following-sibling::android.widget.TextView")
//    private WebElement txtUserEmail;

    // Elementos para validação do Edit Profile
    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Firstname']")
    private WebElement txtEditFirstName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Lastname']")
    private WebElement txtEditLastName;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Enter your phone number']")
    private WebElement txtEditPhone;

    @AndroidFindBy(xpath = "//android.widget.EditText[@hint='Enter you Email address']")
    private WebElement txtEditEmail;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Edit']")
    private WebElement btnSaveEdit;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Add Photo']")
    private WebElement btnAddPhoto;

//    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, '+14049678963')]")
//    private WebElement txtUserPhone;

    public WebElement getTxtUserName(String nomeCompleto) {
        String xpathNome = String.format("//android.widget.TextView[@text='%s']", nomeCompleto);
        return driver.findElement(By.xpath(xpathNome));
    }

    public WebElement getTxtUserPhone(String userPhone) {
        String xpathPhone = String.format("//android.widget.TextView[@text='%s']", userPhone);
        return driver.findElement(By.xpath(xpathPhone));
    }

    public WebElement getTxtUserEmail(String userEmail) {
        String xpathEmail = String.format("//android.widget.TextView[@text='%s']", userEmail);
        return driver.findElement(By.xpath(xpathEmail));
    }
}
