package org.br.com.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void click(WebElement element) {
        waitElement(element).click();
    }

    public void clear(WebElement element) {
        element.clear();
    }

    /**
     * Sleep for current thread
     *
     * @param seconds
     */
    public void sleep(int seconds) {
        try {
            Thread.sleep(1_000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Métodos adicionais necessários para HomeActions

    public void verticalSwipeUp(double startPercentage, double endPercentage) {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height * startPercentage);
        int endy = (int)(size.height * endPercentage);
        int startx = (int)(size.width / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), startx, endy));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void verticalSwipeDown() {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height * 0.2);
        int endy = (int)(size.height * 0.8);
        int startx = (int)(size.width / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(2), PointerInput.Origin.viewport(), startx, endy));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void verticalSwipe(double startPercentage, double endPercentage, double duration) {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height * startPercentage);
        int endy = (int)(size.height * endPercentage);
        int startx = (int)(size.width / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds((long)duration), PointerInput.Origin.viewport(), startx, endy));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void horizontalSwipeLeft(WebElement fromElement, WebElement toElement, int duration) {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int startx = (int)(size.width * 0.8);
        int endx = (int)(size.width * 0.2);
        int starty = (int)(size.height / 2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(duration), PointerInput.Origin.viewport(), endx, starty));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void horizontalSwipeLeft(int anchor, WebElement toElement, int duration) {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int startx = (int)(size.width * 0.8);
        int endx = (int)(size.width * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0);
        
        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, anchor));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofSeconds(duration), PointerInput.Origin.viewport(), endx, anchor));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public void verticalSwipeDownAndSearch(WebElement element) {
        for (int i = 0; i < 5; i++) {
            if (isDisplayed(element, 1)) {
                break;
            }
            verticalSwipeDown();
            sleep(1);
        }
    }

    public void verticalSwipeDownAndSearch(WebElement element, int maxAttempts) {
        for (int i = 0; i < maxAttempts; i++) {
            if (isDisplayed(element, 1)) {
                break;
            }
            verticalSwipeDown();
            sleep(1);
        }
    }

    public void verticalSwipeUpAndSearch(WebElement element, int maxAttempts) {
        for (int i = 0; i < maxAttempts; i++) {
            if (isDisplayed(element, 1)) {
                break;
            }
            verticalSwipeUp(0.8, 0.2);
            sleep(1);
        }
    }

    public void waitForElementToBeDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeEnabled(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementToBeEnabled(WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean waitUntilElementIsDisplayed(WebElement element, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDisplayed(WebElement element, int timeoutSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Dimension getDimension() {
        return Hooks.getDriver().manage().window().getSize();
    }

    public void tapOn(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 0);
        
        tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        Hooks.getDriver().perform(Collections.singletonList(tap));
    }

    public boolean isAndroid() {
        return Hooks.getDriver() instanceof AndroidDriver;
    }

    public boolean isIOS() {
        return Hooks.getDriver() instanceof IOSDriver;
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getDeviceTime(String format) {
        java.time.LocalTime now = java.time.LocalTime.now();
        if ("HH".equals(format)) {
            return String.valueOf(now.getHour());
        }
        return now.toString();
    }
} 