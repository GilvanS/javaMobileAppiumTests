package org.testes.paginas.login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class LoginPage {

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='email']")
    private WebElement campoEmail;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='password']")
    private WebElement campoPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='confirmPassword']")
    private WebElement campoConfirmPassword;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Sign Up']")
    private WebElement btnSignUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Login']")
    private WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Signed Up']")
    private WebElement lblSignedUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Success']")
    private WebElement lblSuccess;
}
