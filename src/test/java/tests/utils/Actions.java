package tests.utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Actions {

    private Actions element;

    public static void click(WebElement element) {
        waitElement(element).click();
    }
    public static void sendKeys(String value){
        element.sendKeys(value);
        delay(Constants.SEND_KEYS_DELAY_IN_MILLISECONDS);
    }

    public void delay(){
        delay(Constants.DEFAULT_DELAY_IN_MILLISECONDS);
    }

    /**lic void delay(int seconds, int milliseconds){
        delay(seconds * 1000 + milliseconds);
    }
     * Sleep for current thread
     *
     * @param seconds
     */
    public static void sleep(int seconds) {
        try {
            Thread.sleep(1_000 * seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hideKeyboard(){
        Hooks.getDriver().hideKeyboard();
    }

    public void swipeVertical(){

        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height * 0.5);
        int endy = (int)(size.height * 0.2);
        int startx = (int)(size.width / 2);
        int endx = (int)(size.width / 2);

        new TouchAction(Hooks.getDriver())
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();

    }

    public void swipeHorizontal(){

        Dimension size = Hooks.getDriver().manage().window().getSize();
        int starty = (int)(size.height /2);
        int endy = (int)(size.height /2);
        int startx = (int)(size.width * 0.5);
        int endx = (int)(size.width * 0.2);

        new TouchAction(Hooks.getDriver())
                .press(PointOption.point(startx, starty))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endx, endy))
                .release().perform();

    }

    public void delay(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void validateElementPresence(String xpath){

        new WebDriverWait(Hooks.getDriver(), Constants.TIMEOUT_PRESENCE_OF_ELEMENT_LOCATED_SECONDS)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(xpath)));

    }

    public static WebElement waitElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(Hooks.getDriver(), Constants.TIMEOUT_PRESENCE_OF_ELEMENT_LOCATED_SECONDS);
        WebElement elemento = wait.until(ExpectedConditions.visibilityOf(element));
        return elemento;
    }


}