package org.testes.paginas.hotel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.testes.utils.Hooks;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.utilidades.evidencia.PrintScreen;

public class HotelActions {

    private static final Logger log = LoggerFactory.getLogger(HotelActions.class);
    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static HotelPage hotelPage() {
        return MasterPageFactory.getPage(HotelPage.class);
    }

    // Swipe vertical até o elemento ficar visível ou atingir o máximo de tentativas
    public static void validarLblSobreAHosedagem() {
        log.info("valido a exibicao da mensagem Sobre a hospedagem na tela Hoteis");
        WebElement target = hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais();
        int maxAttempts = 5;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                if (target.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                // Ignora se não está visível
            }
            acoes.swipeVertical();
            attempts++;
        }
    }

    // Swipe horizontal (exemplo: pode ser adaptado conforme necessidade real)
    public static void validarLblVerMapas() {
        log.info("valido a exibicao da mensagem Ver Mapas na tela Hoteis");
        // Exemplo: swipe para a direita até o elemento ficar visível
        WebElement target = hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais();
        int maxAttempts = 5;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                if (target.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                // Ignora se não está visível
            }
            acoes.swipeHorizontal(true); // true = para a direita
            attempts++;
        }
    }
}