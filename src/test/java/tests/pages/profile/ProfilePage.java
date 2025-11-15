package tests.pages.profile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import tests.utils.MasterPageFactory;

@Getter
public class ProfilePage extends MasterPageFactory {

    @AndroidFindBy(xpath = "//android.widget.TextView[@text= 'Sign up']")
    private WebElement clicarBtnSignUp;

    @AndroidFindBy(accessibility = "firstNameInput")
    private WebElement campoFirstName;

    @AndroidFindBy(accessibility = "lastNameInput")
    private WebElement campoLastName;

    @AndroidFindBy(accessibility = "phoneInput")
    private WebElement campoPhone;

    @AndroidFindBy(accessibility = "emailInput")
    private WebElement campoEmail;

    @AndroidFindBy(accessibility = "passwordInput")
    private WebElement campoPassword;

    @AndroidFindBy(accessibility = "confirmPasswordInput")
    private WebElement campoConfirmPassword;

}
