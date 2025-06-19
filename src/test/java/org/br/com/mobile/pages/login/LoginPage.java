package org.br.com.mobile.pages.login;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.br.com.mobile.pages.PageBaseActions;


@Getter
public class LoginPage extends PageBaseActions {

    @AndroidFindBy(xpath = "//*[@text='0']")
    @iOSXCUITFindBy (xpath = "?")
    private WebElement btnDormir;

}
