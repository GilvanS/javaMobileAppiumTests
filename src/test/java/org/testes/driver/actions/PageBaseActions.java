package org.testes.driver.actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.Pause;

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
     * Clica em um elemento após aguardar sua visibilidade.
     * @param element Elemento a ser clicado
     */
    public void click(WebElement element) {
        waitForVisibility(element).click();
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
}