package org.testes.paginas.swipe;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class SwipePage {

    @AndroidFindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup")
    private WebElement lblScrollView;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FULLY OPEN SOURCE']")
    private WebElement lblFullyOpenSource;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GREAT COMMUNITY']")
    private WebElement lblGreatCommunity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='JS.FOUNDATION']")
    private WebElement lblJsFoundation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='The community around WebdriverIO is actively speaking on various user groups or conferences about specific topics around automated testing with WebdriverIO.']")
    private WebElement lblSupportVideos;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='EXTENDABLE']")
    private WebElement lblExtendable;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='COMPATIBLE']")
    private WebElement lblCompatible;



}
