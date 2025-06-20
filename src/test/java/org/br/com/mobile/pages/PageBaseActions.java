package org.br.com.mobile.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.br.com.mobile.utils.Constants;
import org.br.com.mobile.hooks.Hooks;

import java.io.IOException;
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

    // Métodos de swipe verticais
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

    // Métodos de swipe horizontais
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

    /**
     * Método mais preciso para swipe horizontal usando coordenadas dos elementos
     * @param fromElement Elemento de origem (ponto de partida)
     * @param toElement Elemento de destino (ponto final)
     * @param duration Duração do swipe em segundos
     */
    public void horizontalSwipeLeftPrecise(WebElement fromElement, WebElement toElement, int duration) {
        try {
            // Obter as coordenadas dos elementos
            Rectangle fromRect = fromElement.getRect();
            Rectangle toRect = toElement.getRect();
            
            // Calcular pontos de início e fim baseados nos elementos
            int startX = fromRect.getX() + fromRect.getWidth() - 10; // 10px da borda direita
            int endX = toRect.getX() + 10; // 10px da borda esquerda
            int centerY = fromRect.getY() + (fromRect.getHeight() / 2); // Centro vertical do elemento
            
            // Garantir que o swipe seja da direita para a esquerda
            if (startX <= endX) {
                // Se o elemento de destino está à direita, ajustar as coordenadas
                startX = (int)(Hooks.getDriver().manage().window().getSize().width * 0.8);
                endX = (int)(Hooks.getDriver().manage().window().getSize().width * 0.2);
            }

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);
            
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, centerY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofSeconds(duration), PointerInput.Origin.viewport(), endX, centerY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            Hooks.getDriver().perform(Collections.singletonList(swipe));
            
        } catch (Exception e) {
            // Fallback para o método original se houver erro
            horizontalSwipeLeft(fromElement, toElement, duration);
        }
    }

    /**
     * Método para swipe horizontal com busca do elemento de destino
     * @param fromElement Elemento de origem
     * @param toElement Elemento de destino a ser encontrado
     * @param maxAttempts Número máximo de tentativas
     * @return true se o elemento foi encontrado, false caso contrário
     */
    public boolean horizontalSwipeLeftAndSearch(WebElement fromElement, WebElement toElement, int maxAttempts) {
        for (int i = 0; i < maxAttempts; i++) {
            try {
                if (toElement.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {
                // Elemento não encontrado, continuar
            }
            
            // Realizar swipe
            horizontalSwipeLeftPrecise(fromElement, toElement, 2);
            sleep(1);
        }
        return false;
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

    // Métodos de busca com swipe
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

    // Métodos de espera
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

    // Métodos de swipe com IOException (versões mais robustas)
    public void verticalSwipeUpWithException(double startPercentage, double endPercentage) throws IOException {
        double anchorPercentage = 0.5;
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        swipe(anchor, startPoint, anchor, endPoint);
    }

    public void verticalSwipeWithException(double anchorPercentage, double startPercentage, double endPercentage) throws IOException {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        swipe(anchor, startPoint, anchor, endPoint);
    }

    public void horizontalSwipe(WebElement element, double startPercentage, double endPercentage) throws IOException {
        Rectangle rect = element.getRect();
        double anchorPercentage = 0.5;
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int anchor = (int) (rect.getY() + (rect.height * anchorPercentage));
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        swipe(startPoint, anchor, endPoint, anchor);
    }

    public void horizontalSwipe(int anchor, double startPercentage, double endPercentage) throws IOException {
        Dimension size = Hooks.getDriver().manage().window().getSize();
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        swipe(startPoint, anchor, endPoint, anchor);
    }

    public boolean horizontalSwipeRight(WebElement ref, WebElement expected, int attempts) throws IOException {
        return horizontalSwipe(ref, expected, 0.20, 0.80, attempts);
    }

    public boolean horizontalSwipe(WebElement ref, WebElement expected, double startPercentage, double endPercentage, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                displayed = expected.isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                horizontalSwipe(ref, startPercentage, endPercentage);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean horizontalSwipe(int anchor, WebElement expected, double startPercentage, double endPercentage, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                displayed = expected.isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                horizontalSwipe(anchor, startPercentage, endPercentage);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeDownAndSearch(double anchorPercentage, double startPercentage, double endPercentage, By element, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = Hooks.getDriver().findElement(element).isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                verticalSwipeWithException(anchorPercentage, startPercentage, endPercentage);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeDownAndSearch(By element, int attempts) throws IOException {
        return verticalSwipeDownAndSearch(0.50, 0.55, 0.15, element, attempts);
    }

    public boolean verticalSwipeDownAndSearch(double anchorPercentage, double startPercentage, double endPercentage, WebElement element, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = element.isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                verticalSwipeWithException(anchorPercentage, startPercentage, endPercentage);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeDownAndSearch(WebElement ref, WebElement element, double startPercentage, double endPercentage, int attempts) throws IOException {
        Rectangle rect = ref.getRect();
        Dimension size = Hooks.getDriver().manage().window().getSize();
        double anchorPercentage = 0.50;
        int anchor = (int) (rect.getY() + (rect.width * anchorPercentage));
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        return verticalSwipeDownAndSearch(anchor, startPoint, endPoint, element, attempts);
    }

    public boolean verticalSwipeDownAndSearch(By by) throws IOException {
        return verticalSwipeDownAndSearch(by, 5);
    }

    // Swipe auxiliar
    private void swipe(int startX, int startY, int endX, int endY) throws IOException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        Hooks.getDriver().perform(Collections.singletonList(swipe));
    }

    public boolean verticalSwipeDownAndSearch(int anchor, int startPoint, int endPoint, WebElement element, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = element.isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                swipe(anchor, startPoint, anchor, endPoint);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }
} 