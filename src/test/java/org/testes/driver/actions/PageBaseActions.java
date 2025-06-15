package org.testes.driver.actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;

import static org.testes.adb.AdbActions.swipe;

/**
 * Classe base para ações comuns de páginas mobile.
 * Compatível com Appium Java Client 9.x e Selenium 4.x.
 * Centraliza waits, gestos e interações.
 */
public class PageBaseActions {

    private static final Logger log = LoggerFactory.getLogger(PageBaseActions.class);
    protected final AppiumDriver driver;
    protected final int DEFAULT_TIMEOUT_SECONDS = 10;

    /**
     * Construtor recebe o driver já instanciado.
     * @param driver Instância do AppiumDriver
     */
    public PageBaseActions(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Aguarda a visibilidade de um elemento.
     * @param element Elemento a ser aguardado
     * @return WebElement visível
     */
    public WebElement waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Aguarda o elemento ser clicável por um tempo customizável e clica.
     * @param element Elemento a ser clicado
     * @param seconds Tempo máximo de espera em segundos
     */
    public void click(WebElement element, int seconds) {
        waitForElementToBeClickable(element, seconds).click();
    }

    /**
     * Preenche um campo de texto.
     * @param element Campo de texto
     * @param value Valor a ser inserido
     */
    public void sendKeys(WebElement element, String value) {
        waitForVisibility(element).sendKeys(value);
    }

    /**
     * Realiza um swipe horizontal (esquerda para direita ou direita para esquerda).
     * @param toRight true para direita, false para esquerda
     */
    public void swipeHorizontal(boolean toRight) {
        Dimension size = driver.manage().window().getSize();
        int y = size.height / 2;
        int startX = toRight ? (int) (size.width * 0.10) : (int) (size.width * 0.80);
        int endX = toRight ? (int) (size.width * 0.80) : (int) (size.width * 0.10);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, y))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Realiza um swipe vertical (de baixo para cima).
     */
    public void swipeVertical() {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Aguarda a presença de um elemento localizado por By.
     * @param by Localizador By
     * @return WebElement presente no DOM
     */
    public WebElement waitForPresence(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    /**
     * Esconde o teclado virtual, se visível.
     */
    public void hideKeyboard() {
        try {
            if (driver instanceof io.appium.java_client.android.AndroidDriver) {
                ((io.appium.java_client.android.AndroidDriver) driver).hideKeyboard();
            } else if (driver instanceof io.appium.java_client.ios.IOSDriver) {
                ((io.appium.java_client.ios.IOSDriver) driver).hideKeyboard();
            } else {
                log.warn("hideKeyboard não suportado para o tipo de driver: " + driver.getClass().getSimpleName());
            }
        } catch (Exception e) {
            log.warn("Teclado não estava visível ou não pôde ser escondido.");
        }
    }

    /**
     * Delay explícito (evite usar, prefira waits explícitos).
     * @param millis Tempo em milissegundos
     */
    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Realiza swipe vertical (para cima ou para baixo) até encontrar o elemento ou atingir o número máximo de tentativas.
     * Inspirado no CustomMobileActions.
     *
     * @param by          Localizador do elemento
     * @param maxAttempts Número máximo de swipes
     * @param swipeUp     true para swipe para cima, false para baixo
     * @throws NoSuchElementException se não encontrar após as tentativas
     */
    public void swipeVerticalAndFind(By by, int maxAttempts, boolean swipeUp) {
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                WebElement el = driver.findElement(by);
                if (el.isDisplayed()) {
                    return;
                }
            } catch (NoSuchElementException e) {
                // Ignora e faz swipe
            }
            if (swipeUp) {
                swipeVerticalUp();
            } else {
                swipeVerticalDown();
            }
            delay(500); // Pequeno delay para animação do swipe
            attempts++;
        }
        throw new NoSuchElementException("Elemento não encontrado após " + maxAttempts + " swipes: " + by.toString());
    }

    /**
     * Swipe vertical para cima usando porcentagem da tela (inspirado no CustomMobileActions).
     */
    public void swipeVerticalUp() {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.7);
        int endY = (int) (size.height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    /**
     * Swipe vertical para baixo usando porcentagem da tela (inspirado no CustomMobileActions).
     */
    public void swipeVerticalDown() {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.3);
        int endY = (int) (size.height * 0.7);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), x, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    // ELEMENTS

    /**
     * Aguarda o tempo padrão para o elemento ser clicável e clica (By).
     * @param by Localizador By
     */
    public void click(By by) {
        click(by, DEFAULT_TIMEOUT_SECONDS);
    }

    /**
     * Aguarda o tempo customizável para o elemento ser clicável e clica (By).
     * @param by Localizador By
     * @param seconds Tempo máximo de espera
     */
    public void click(By by, int seconds) {
        waitVisibilityOf(by, seconds).click();
    }

    /**
     * Aguarda o tempo padrão para o elemento ser clicável e clica (WebElement).
     * @param element WebElement
     */
    public void click(WebElement element) {
        click(element, DEFAULT_TIMEOUT_SECONDS);
    }

    /**
     * Aguarda o tempo padrão para o elemento ser visível e clica (WebElement).
     * @param element WebElement
     */
    public void clickWaitVisibilityOf(WebElement element) {
        clickWaitVisibilityOf(element, DEFAULT_TIMEOUT_SECONDS);
    }

    /**
     * Aguarda o tempo customizável para o elemento ser visível e clica (WebElement).
     * @param element WebElement
     * @param seconds Tempo máximo de espera
     */
    public void clickWaitVisibilityOf(WebElement element, int seconds) {
        waitForElementToBeVisible(element, seconds).click();
    }

    /**
     * Aguarda o elemento localizado por By ser visível.
     * @param by Localizador By
     * @param seconds Tempo máximo de espera
     * @return WebElement visível
     */
    public WebElement waitVisibilityOf(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Aguarda o elemento ser visível.
     * @param element WebElement
     * @param seconds Tempo máximo de espera
     * @return WebElement visível
     */
    public WebElement waitForElementToBeVisible(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Aguarda o elemento ser clicável.
     * @param element WebElement
     * @param seconds Tempo máximo de espera
     * @return WebElement clicável
     */
    public WebElement waitForElementToBeClickable(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Aguarda o tempo padrão para o elemento ser clicável e limpa o campo.
     * @param element WebElement
     */
    public void clear(WebElement element) {
        clear(element, DEFAULT_TIMEOUT_SECONDS);
    }

    /**
     * Aguarda o tempo customizável para o elemento ser clicável e limpa o campo.
     * @param element WebElement
     * @param seconds Tempo máximo de espera
     */
    public void clear(WebElement element, int seconds) {
        waitForElementToBeClickable(element, seconds).clear();
    }

    /**
     * Limpa o campo múltiplas vezes, aguardando ser clicável.
     * @param element WebElement
     * @param seconds Tempo máximo de espera
     * @param attempts Número de tentativas de clear
     */
    public void clearAttempts(WebElement element, int seconds, int attempts) {
        WebElement e = waitForElementToBeClickable(element, seconds);
        for (int i = 0; i < attempts; i++) {
            e.clear();
        }
    }

    /**
     * Realiza double tap no elemento usando coordenadas.
     * @param element WebElement
     * @param seconds Tempo máximo de espera
     */
    public void doubleTap(WebElement element, int seconds) {
        Point point = element.getLocation();
        int x = point.getX();
        int y = point.getY();
        // Appium 9.x: usar executeScript para mobile: doubleTap
        try {
            driver.executeScript("mobile: doubleTap", java.util.Map.of("x", x, "y", y));
        } catch (Exception e) {
            log.warn("Falha ao executar doubleTap: " + e.getMessage());
        }
    }

    /**
     * Swipe vertical para cima usando porcentagem customizada da tela.
     */
    public void verticalSwipeUp(double startPercentage, double endPercentage) throws IOException {
        double anchorPercentage = 0.5;
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        swipe(anchor, startPoint, anchor, endPoint);
    }

    /**
     * Swipe vertical customizado por porcentagem e âncora.
     */
    public void verticalSwipe(double anchorPercentage, double startPercentage, double endPercentage) throws IOException {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        swipe(anchor, startPoint, anchor, endPoint);
    }

    /**
     * Swipe horizontal em um elemento por porcentagem.
     */
    public void horizontalSwipe(WebElement element, double startPercentage, double endPercentage) throws IOException {
        Rectangle rect = element.getRect();
        double anchorPercentage = 0.5;
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (rect.getY() + (rect.height * anchorPercentage));
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        swipe(startPoint, anchor, endPoint, anchor);
    }

    /**
     * Swipe horizontal por âncora e porcentagem.
     */
    public void horizontalSwipe(int anchor, double startPercentage, double endPercentage) throws IOException {
        Dimension size = driver.manage().window().getSize();
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);
        swipe(startPoint, anchor, endPoint, anchor);
    }

    /**
     * Swipe horizontal para a direita.
     */
    public boolean horizontalSwipeRight(WebElement ref, WebElement expected, int attempts) throws IOException {
        return horizontalSwipe(ref, expected, 0.20, 0.80, attempts);
    }

    /**
     * Swipe horizontal para a esquerda.
     */
    public boolean horizontalSwipeLeft(WebElement ref, WebElement expected, int attempts) throws IOException {
        return horizontalSwipe(ref, expected, 0.80, 0.20, attempts);
    }

    /**
     * Swipe horizontal para a esquerda por âncora.
     */
    public boolean horizontalSwipeLeft(int anchor, WebElement expected, int attempts) throws IOException {
        return horizontalSwipe(anchor, expected, 0.80, 0.20, attempts);
    }

    /**
     * Swipe horizontal com busca de elemento.
     */
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

    /**
     * Swipe vertical com busca de elemento (By).
     */
    public boolean verticalSwipeDownAndSearch(double anchorPercentage, double startPercentage, double endPercentage, By element, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = driver.findElement(element).isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                verticalSwipe(anchorPercentage, startPercentage, endPercentage);
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
                verticalSwipe(anchorPercentage, startPercentage, endPercentage);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeUpAndSearch(WebElement element, int attempts) {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = element.isDisplayed();
            } catch (Exception e) {}
            if (!displayed) {
                swipeVerticalUp();
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeDownAndSearch(WebElement element, int attempts) throws IOException {
        return verticalSwipeDownAndSearch(0.50, 0.55, 0.15, element, attempts);
    }

    public boolean verticalSwipeDownAndSearch(WebElement ref, WebElement element, double startPercentage, double endPercentage, int attempts) throws IOException {
        Rectangle rect = ref.getRect();
        Dimension size = driver.manage().window().getSize();
        double anchorPercentage = 0.50;
        int anchor = (int) (rect.getY() + (rect.width * anchorPercentage));
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        return verticalSwipeDownAndSearch(anchor, startPoint, endPoint, element, attempts);
    }

    public boolean verticalSwipeDownAndSearch(WebElement element) throws IOException {
        return verticalSwipeDownAndSearch(element, 5);
    }

    public boolean verticalSwipeUpAndSearch(WebElement element) {
        return verticalSwipeUpAndSearch(element, 5);
    }

    public boolean verticalSwipeDownAndSearch(By by) throws IOException {
        return verticalSwipeDownAndSearch(by, 5);
    }

    public void swipeHorizontalWithCoordinates(int startX, int startY, int endX, int endY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
            PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
            PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
        driver.perform(Collections.singletonList(swipe));
    }

}