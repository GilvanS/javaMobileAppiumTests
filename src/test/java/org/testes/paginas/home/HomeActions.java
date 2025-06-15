package org.testes.paginas.home;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Slf4j
public class HomeActions {
    private static final Logger log = LoggerFactory.getLogger(HomeActions.class);
    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    public static HomePage homePage(){
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void clicarBtnPularIntroducao() {
        log.info("clicar no botão pular introdução");
        acoes.click(homePage().getBtnPularIntroducao());
    }

    public static void vldTxtOla() throws IOException {
        log.info("valido a exibicao da tela 'Home'");
        acoes.waitForVisibility(homePage().getVldTxtOla());
        print.screenshot("tela home");
    }

    public static void clicarBtnEntrar() {
        log.info("Clicar no botão Entrar na tela 'Home'");
        acoes.click(homePage().getBtnEntrar());
    }

    public static void vldTxtOla4Win() throws IOException {
        log.info("Valido o perfil 4Win logado");
        acoes.waitForVisibility(homePage().getVldTxtOla4Win());
        print.screenshot("tela home");
    }

    public static void clicarBtnExplorar() {
        acoes.click(homePage().getBtnExplorar());
    }

    public static void clicarBtnPacotes() {
        log.info("clicar no botão pacotes");
        acoes.click(homePage().getBtnPacotes());
    }

    public static void clicarBtnCarros() {
        log.info("clicar no botão 'Carros' tela 'Home'");
        acoes.click(homePage().getBtnCarros());
    }

    public static void clicarBtnIngressos() {
        log.info("clicar no botão 'Ingressos' na tela 'Home'");
        acoes.horizontalSwipeLeft(homePage().getBtnCarros(), homePage().getBtnIngressos(), 5);
        acoes.click(homePage().getBtnIngressos());
    }

    public static void clicarBtnHoteis() {
        log.info("clicar no botão 'Hotéis' na tela 'Home'");
        acoes.swipeVertical();
        acoes.click(homePage().getBtnHoteis());
    }

    /**
     * Realiza swipe left no carrossel até o botão 'Ingressos' aparecer e clica no elemento [3] (clicável).
     * Usa o HorizontalScrollView com scrollable='true' como referência para swipe.
     * @return true se conseguiu clicar, false caso contrário.
     */
    public static boolean swipeCarrosselAteIngressosEClicarView3() {
        int maxTentativas = 7;
        try {
            org.openqa.selenium.WebDriver driver = Hooks.getDriver();
            org.openqa.selenium.WebElement carrossel = driver.findElement(org.openqa.selenium.By.xpath("//android.widget.HorizontalScrollView[@scrollable='true']"));
            for (int i = 0; i < maxTentativas; i++) {
                // Verifica se 'Ingressos' está visível
                java.util.List<org.openqa.selenium.WebElement> ingressos = driver.findElements(org.openqa.selenium.By.xpath("//android.view.View[@content-desc='Ingressos']"));
                for (org.openqa.selenium.WebElement ingresso : ingressos) {
                    if (ingresso.isDisplayed()) {
                        // Clica no elemento [3] do carrossel
                        org.openqa.selenium.WebElement btnClicavel = driver.findElement(org.openqa.selenium.By.xpath("//android.widget.HorizontalScrollView/android.view.View[3]"));
                        btnClicavel.click();
                        log.info("Clique realizado no botão [3] após {} tentativas de swipe", i);
                        return true;
                    }
                }
                // Se não encontrou, faz swipe no carrossel
                acoes.horizontalSwipeLeft(carrossel, carrossel, 1);
            }
            log.warn("Botão 'Ingressos' não encontrado/clicável após {} tentativas de swipe", maxTentativas);
        } catch (Exception e) {
            log.warn("Erro ao tentar realizar swipe/click no carrossel: {}", e.getMessage());
        }
        return false;
    }
}
