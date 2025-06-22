package org.testes.paginas.login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class LoginPage {

    @AndroidFindBy(accessibility = "input-email")
    private WebElement campoEmail;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement campoPassword;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement campoConfirmPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign up']")
    private WebElement btnSignUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']/android.view.ViewGroup")
    private WebElement btnLoginSign;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-SIGN UP']/android.view.ViewGroup")
    private WebElement btnSignLogin;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement lblSignedUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Success']")
    private WebElement lblSuccess;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private WebElement btnOk;

}
