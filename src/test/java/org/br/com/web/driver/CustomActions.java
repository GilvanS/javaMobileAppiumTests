package org.br.com.web.driver;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

@Log4j2
public class CustomActions {
    private static final Duration TIMEOUT = Duration.ofSeconds(10);
    private static WebDriverWait wait;
    private final WebDriver driver;

    public CustomActions() {
        this.driver = Driver.getDriver();
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public boolean waitElementDisplayed(WebElement element) {
        try {
            // Tenta primeiro sem scroll
            try {
                wait.until(ExpectedConditions.visibilityOf(element));
                return true;
            } catch (TimeoutException e) {
                // Se não encontrou, tenta com scroll
                scrollElemento(element);
                wait.until(ExpectedConditions.visibilityOf(element));
                return true;
            }
        } catch (TimeoutException e) {
            throw new TimeoutException(String.format(
                    "Elemento '%s' não está visível após %d segundos\n" +
                            "Motivo: %s",
                    element.toString(),
                    TIMEOUT.getSeconds(),
                    e.getMessage()
            ));
        }
    }

    public void waitPopupDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void sendKeys(WebElement element, String text) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            element.clear();
            element.sendKeys(text);
        } catch (TimeoutException e) {
            throw new TimeoutException(String.format(
                "Elemento '%s' não está clicável após %d segundos\n" +
                "Motivo: %s", 
                element.toString(), 
                TIMEOUT.getSeconds(),
                e.getMessage()
            ));
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException(String.format(
                "Elemento '%s' não está interagível\n" +
                "Motivo: %s", 
                element.toString(),
                e.getMessage()
            ));
        }
    }

    public void click(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        } catch (TimeoutException e) {
            throw new TimeoutException(String.format(
                "Elemento '%s' não está clicável após %d segundos\n" +
                "Motivo: %s", 
                element.toString(), 
                TIMEOUT.getSeconds(),
                e.getMessage()
            ));
        } catch (ElementNotInteractableException e) {
            throw new ElementNotInteractableException(String.format(
                "Elemento '%s' não está interagível\n" +
                "Motivo: %s", 
                element.toString(),
                e.getMessage()
            ));
        } catch (StaleElementReferenceException e) {
            throw new StaleElementReferenceException(String.format(
                "Elemento '%s' está obsoleto (Stale)\n" +
                "Motivo: %s", 
                element.toString(),
                e.getMessage()
            ));
        }
    }

    public void scrollElemento(WebElement element) {
        try {
            ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format(
                "Elemento '%s' não encontrado na página\n" +
                "Motivo: %s", 
                element.toString(),
                e.getMessage()
            ));
        }
    }

    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread interrompida durante o sleep", e);
        }
    }

    /**
     * Força a validação do reCAPTCHA usando JavaScript.
     * Este método manipula o iframe do reCAPTCHA e força a validação
     * tanto no iframe quanto no frame principal.
     *
     * @param iframeRecaptcha O elemento iframe do reCAPTCHA
     */
    public void forcarValidacaoRecaptcha(WebElement iframeRecaptcha) {
        //log.info("Forçando validação do reCAPTCHA");
        scrollElemento(iframeRecaptcha);
        
        // Mudar para o iframe do reCAPTCHA
        driver.switchTo().frame(iframeRecaptcha);
        
        // Forçar a validação do reCAPTCHA usando JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = 
            "var callback = function() {" +
            "  var iframe = document.querySelector('iframe[src*=\"recaptcha\"]');" +
            "  if (iframe) {" +
            "    var iframeDoc = iframe.contentDocument || iframe.contentWindow.document;" +
            "    var checkbox = iframeDoc.querySelector('.recaptcha-checkbox-border');" +
            "    if (checkbox) {" +
            "      checkbox.click();" +
            "      var token = 'FORCE_VALIDATION_TOKEN';" +
            "      window.parent.postMessage({" +
            "        'source': 'recaptcha'," +
            "        'token': token," +
            "        'action': 'verify'" +
            "      }, '*');" +
            "      return true;" +
            "    }" +
            "  }" +
            "  return false;" +
            "};" +
            "callback();";
        
        js.executeScript(script);
        
        // Aguardar um momento para a validação ser processada
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        // Voltar para o frame principal
        driver.switchTo().defaultContent();
        
        // Forçar a validação no frame principal
        String mainScript = 
            "var response = document.querySelector('#g-recaptcha-response');" +
            "if (response) {" +
            "  response.value = 'FORCE_VALIDATION_TOKEN';" +
            "  var event = new Event('change', { bubbles: true });" +
            "  response.dispatchEvent(event);" +
            "}";
        
        js.executeScript(mainScript);

    }

    /**
     * Troca para a próxima aba aberta no navegador.
     * Útil quando um clique abre uma nova aba e precisamos interagir com ela.
     */
    public void trocarParaNovaAba() {
        String abaAtual = driver.getWindowHandle();
        Set<String> todasAbas = driver.getWindowHandles();

        for (String aba : todasAbas) {
            if (!aba.equals(abaAtual)) {
                driver.switchTo().window(aba);
                break;
            }
        }
    }

    /**
     * Volta para a aba original do navegador.
     * Útil após interagir com uma nova aba e precisar voltar para a aba principal.
     */
    public void voltarParaAbaOriginal() {
        String abaAtual = driver.getWindowHandle();
        Set<String> todasAbas = driver.getWindowHandles();
        
        for (String aba : todasAbas) {
            if (!aba.equals(abaAtual)) {
                driver.switchTo().window(aba);
                break;
            }
        }
    }
    /**
     * Verifica e lida com o popup de cookies, se presente.
     * Se o popup for encontrado, clica no botão de permitir cookies.
     *
     * @param btnPermitirCookies O elemento do botão de permitir cookies
     */
    public void lidarComPopupCookies(WebElement btnPermitirCookies) {
        try {
            if (waitElementDisplayed(btnPermitirCookies)) {
                click(btnPermitirCookies);
                // Aguarda um momento para garantir que o popup foi fechado
                sleep(500);
            }
        } catch (Exception e) {
            // Ignora exceções pois o popup pode não estar presente
        }
    }
}