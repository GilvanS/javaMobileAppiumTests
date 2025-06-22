package org.testes.paginas.swipe;

import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class SwipePage {

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Swipe']")
    private WebElement btnSwipe;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FULLY OPEN SOURCE']")
    private WebElement lblFullyOpenSource;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='GREAT COMMUNITY']")
    private WebElement lblGreatCommunity;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='JS.FOUNDATION']")
    private WebElement lblJsFoundation;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SUPPORT VIDEOS']")
    private WebElement lblSupportVideos;

}
