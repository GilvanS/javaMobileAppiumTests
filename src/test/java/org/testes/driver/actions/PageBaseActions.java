package org.testes.driver.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Map;

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
     * Realiza um swipe horizontal usando coordenadas específicas até encontrar o elemento.
     * Ajuste as coordenadas conforme necessário para cada caso de uso.
     */
    public void horizontalSwipeFingerAndSearch(int startX, int startY, int endX, int endY, WebElement element, int maxAttempts) {
        int attempts = 0;
        boolean elementFound = false;

        while (attempts < maxAttempts) {
            // Primeiro faz o swipe
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            
            driver.perform(Collections.singletonList(swipe));
            
            // Depois verifica se o elemento está visível
            try {
                delay(1000); // Aguarda a animação do swipe
                if (element.isDisplayed()) {
                    elementFound = true;
                    return;
                }
            } catch (Exception e) {
                // Elemento não encontrado, continua o loop
            }
            
            attempts++;
        }

		log.warn("Elemento não encontrado após {} tentativas de swipe", maxAttempts);
	}

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

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Erro ao pausar a execução: ", e);
        }
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
                .addAction(new Pause(finger, Duration.ofMillis(100)))
                .addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), x, endY))
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
            if (driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).hideKeyboard();
            } else if (driver instanceof IOSDriver) {
                ((IOSDriver) driver).hideKeyboard();
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
            driver.executeScript("mobile: doubleTap", Map.of("x", x, "y", y));
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
            } catch (Exception ignored) {}
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
            } catch (Exception ignored) {}
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
            } catch (Exception ignored) {}
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
            } catch (Exception ignored) {}
            if (!displayed) {
                verticalSwipe(anchorPercentage, startPercentage, endPercentage);
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeUpAndSearch(WebElement element) {
        return verticalSwipeUpAndSearch(element, 5);
    }

    public boolean verticalSwipeDownAndSearch(WebElement ref, WebElement element, int attempts) throws IOException {
        return verticalSwipeDownAndSearch(ref, element, 0.55, 0.15, attempts);
    }

    public boolean verticalSwipeDownAndSearch(WebElement element, int attempts) throws IOException {
        return verticalSwipeDownAndSearch(0.50, 0.55, 0.10, element, attempts);
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
        return verticalSwipeDownAndSearch(0.50, 0.55, 0.10, element, 5);
    }

    public boolean verticalSwipeUpAndSearch(WebElement element, int attempts) {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = element.isDisplayed();
            } catch (Exception ignored) {}
            if (!displayed) {
                swipeVerticalUp();
                swipe = true;
            }
            counter++;
        } while (!displayed && counter < attempts);
        if (swipe) delay(3000);
        return displayed;
    }

    public boolean verticalSwipeDownAndSearch(By by) throws IOException {
        return verticalSwipeDownAndSearch(by, 5);
    }

    /**
     * Realiza swipe vertical até encontrar um elemento visível.
     * Método utilitário para buscar elementos que podem estar fora da tela visível.
     * 
     * @param by Localizador do elemento a ser encontrado
     * @param maxAttempts Número máximo de tentativas de swipe
     * @return true se o elemento foi encontrado e está visível, false caso contrário
     */
    public boolean swipeUntilElementVisible(By by, int maxAttempts) {
        int attempts = 0;
        boolean elementFound = false;

        log.info("Inicio de busca - elemento com swipe vertical. Maximo de tentativas: {}", maxAttempts);

        while (attempts < maxAttempts && !elementFound) {
            try {
                WebElement element = driver.findElement(by);
                if (element.isDisplayed()) {
                    elementFound = true;
                    log.info("Elemento encontrado em {} tentativas de swipe", attempts + 1);
                    return true;
                }
            } catch (Exception e) {
                // Elemento não encontrado ou não visível, continua o loop
            }

            swipeVertical();
            delay(1000); // Aguarda a animação do swipe
            attempts++;
        }

        if (!elementFound) {
            log.warn("Elemento nao encontrado apos {} tentativas - swipe vertical", maxAttempts);
        }

        return elementFound;
    }

    /**
     * Realiza swipe vertical até encontrar um elemento visível (WebElement).
     * Versão sobrecarregada que aceita WebElement ao invés de By.
     *
     * @param element     Elemento a ser encontrado
     * @param maxAttempts Número máximo de tentativas de swipe
     */
    public void swipeUntilElementVisible(WebElement element, int maxAttempts) {
        int attempts = 0;
        boolean elementFound = false;

        log.info("Iniciando busca do elemento com swipe vertical. Maximo de tentativas: {}", maxAttempts);

        while (attempts < maxAttempts && !elementFound) {
            try {
                if (element.isDisplayed()) {
                    elementFound = true;
                    log.info("Elemento encontrado apos {} tentativas de swipe", attempts + 1);
                    return;
                }
            } catch (Exception e) {
                // Elemento não encontrado ou não visível, continua o loop
            }

            swipeVertical();
            delay(1000); // Aguarda a animação do swipe
            attempts++;
        }

        if (!elementFound) {
            log.warn("Elemento nao encontrado apos {} tentativas de swipe vertical", maxAttempts);
        }

    }

    /**
     * Realiza o gesto "pull-to-refresh" (puxar para baixo para recarregar a página).
     * Este gesto é comumente usado em aplicações mobile para atualizar o conteúdo.
     */
    public void pullToRefresh() {
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int startY = (int) (size.height * 0.2); // 20% da altura da tela
        int endY = (int) (size.height * 0.8);   // 80% da altura da tela

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger, Duration.ofMillis(200)))
                .addAction(finger.createPointerMove(Duration.ofMillis(1500), PointerInput.Origin.viewport(), x, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
        log.info("Executado pull-to-refresh na tela");
    }

    /**
     * Realiza o gesto "pull-to-refresh" com tempo de espera após o gesto.
     * @param waitSeconds Tempo de espera em segundos após executar o pull-to-refresh
     */
    public void pullToRefresh(int waitSeconds) {
        pullToRefresh();
        sleep(waitSeconds);
    }

    /**
     * Realiza o gesto "pull-to-refresh" e aguarda até que um elemento específico apareça.
     * @param element Elemento a ser aguardado após o pull-to-refresh
     * @param maxAttempts Número máximo de tentativas de pull-to-refresh
     * @return true se o elemento foi encontrado, false caso contrário
     */
    public boolean pullToRefreshAndWaitForElement(WebElement element, int maxAttempts) {
        int attempts = 0;
        boolean elementFound = false;

        while (attempts < maxAttempts && !elementFound) {
            try {
                if (element.isDisplayed()) {
                    elementFound = true;
                    log.info("Elemento encontrado apos pull-to-refresh na tentativa {}", attempts + 1);
                    return true;
                }
            } catch (Exception e) {
                // Elemento não encontrado, continua o loop
            }

            pullToRefresh();
            sleep(2); // Aguarda o carregamento
            attempts++;
        }

        if (!elementFound) {
            log.warn("Elemento nao encontrado apos {} tentativas de pull-to-refresh", maxAttempts);
        }

        return elementFound;
    }

    /**
     * Realiza o gesto "pull-to-refresh" e aguarda até que um elemento específico apareça (usando By).
     * @param by Localizador do elemento a ser aguardado
     * @param maxAttempts Número máximo de tentativas de pull-to-refresh
     * @return true se o elemento foi encontrado, false caso contrário
     */
    public boolean pullToRefreshAndWaitForElement(By by, int maxAttempts) {
        int attempts = 0;
        boolean elementFound = false;

        while (attempts < maxAttempts && !elementFound) {
            try {
                WebElement element = driver.findElement(by);
                if (element.isDisplayed()) {
                    elementFound = true;
                    log.info("Elemento encontrado após pull-to-refresh na tentativa {}", attempts + 1);
                    return true;
                }
            } catch (Exception e) {
                // Elemento não encontrado, continua o loop
            }

            pullToRefresh();
            sleep(2); // Aguarda o carregamento
            attempts++;
        }

        if (!elementFound) {
            log.warn("Elemento não encontrado apos {} tentativas de pull-to-refresh", maxAttempts);
        }

        return elementFound;
    }

    /**
     * Clica no meio da tela usando coordenadas específicas.
     * Útil para fechar popups de introdução que não são clicáveis diretamente.
     */
    public void clicarMeioTela() {
        try {
            final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            var tapPoint = new Point(515, 372);
            var tap = new Sequence(finger, 1);
            tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
            tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            tap.addAction(new Pause(finger, Duration.ofMillis(50)));
            tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(Collections.singletonList(tap));
            
            log.info("Clique no meio da tela executado com sucesso");
        } catch (Exception e) {
            log.error("Erro ao clicar no meio da tela: {}", e.getMessage());
        }
    }

    /**
     * Realiza swipe vertical com coordenadas específicas até encontrar um elemento.
     * Usado para fazer swipe dentro de elementos específicos como menus.
     * 
     * @param anchor Coordenada X do ponto de âncora (centro do swipe)
     * @param startPoint Coordenada Y inicial do swipe
     * @param endPoint Coordenada Y final do swipe
     * @param element Elemento a ser encontrado
     * @param attempts Número máximo de tentativas
     * @return true se o elemento foi encontrado, false caso contrário
     * @throws IOException se houver erro no swipe
     */
    public boolean verticalSwipeDownAndSearch(int anchor, int startPoint, int endPoint, WebElement element, int attempts) throws IOException {
        boolean displayed = false;
        boolean swipe = false;
        int counter = 0;
        do {
            try {
                delay(1000);
                displayed = element.isDisplayed();
            } catch (Exception ignored) {}
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