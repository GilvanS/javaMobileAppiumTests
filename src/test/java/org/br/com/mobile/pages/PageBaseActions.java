package org.br.com.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.br.com.mobile.utils.Constants;
import org.br.com.mobile.hooks.Hooks;

import java.time.Duration;
import java.util.Collections;

public class PageBaseActions {

    public void sendKeys(WebElement element, String value){
        element.sendKeys(value);
        delay(Constants.SEND_KEYS_DELAY_IN_MILLISECONDS);
    }

    public void delay(){
        delay(Constants.DEFAULT_DELAY_IN_MILLISECONDS);
    }

    public void hideKeyboard(){
        if (Hooks.getDriver() instanceof AndroidDriver) {
            ((AndroidDriver) Hooks.getDriver()).hideKeyboard();
        }
    }

    public void swipeVertical(){
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height * 0.5);
        int endy = (int)(size.height * 0.2);
        int startx = (int)(size.width / 2);
        int endx = (int)(size.width / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endx, endy));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void swipeHorizontal(){
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height /2);
        int endy = (int)(size.height /2);
        int startx = (int)(size.width * 0.5);
        int endx = (int)(size.width * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), endx, endy));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void delay(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void validateElementPresence(String xpath){
        new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(Constants.TIMEOUT_PRESENCE_OF_ELEMENT_LOCATED_SECONDS))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(xpath)));
    }

    public static WebElement waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(Constants.TIMEOUT_PRESENCE_OF_ELEMENT_LOCATED_SECONDS));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOf(element));
        return elemento;
    }
    
    public void click(WebElement element) {
        waitElement(element).click();
    }
}