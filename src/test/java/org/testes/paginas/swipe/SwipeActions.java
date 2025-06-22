package org.testes.paginas.swipe;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;

import java.io.IOException;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;

@Slf4j
public class SwipeActions {

    public static SwipePage swipePage() {
        return MasterPageFactory.getPage(SwipePage.class);
    }

    public static void validarBtnSupportVideos() throws IOException {
        log.info("Deslizando para a direita na tela Swipe Horizontal");
        acoes().verticalSwipeDownAndSearch(swipePage().getLblScrollView(), swipePage().getLblFullyOpenSource(), 5);
    }

    public static void clicarBtnSupportVideos() throws IOException {
        log.info("Deslizando para a esquerda na tela Swipe Horizontal");
        acoes().horizontalSwipeLeft(swipePage().getLblScrollView(), swipePage().getLblSupportVideos(), 5);
    }

    public static void validarLblGreatCommunity() throws IOException {
        log.info("Validando a exibicao da frase 'Great Community' na tela Swipe Horizontal");
        acoes().horizontalSwipeRight(swipePage().getLblScrollView(), swipePage().getLblFullyOpenSource(), 5);
    }

    public static void validarLblFullyOpenSource() {
        log.info("Validando a exibicao da frase 'Fully Open Source' na tela Swipe Horizontal");
        acoes().waitForElementToBeVisible(swipePage().getLblFullyOpenSource(), 10);
        assertTrue(swipePage().getLblFullyOpenSource().isDisplayed(),
                "Nao foi posivel validar o texto 'Fully Open Source'");
        acoes().sleep(2);
    }

    public static void validarLblYouFoundMe() throws IOException {
        log.info("Validando a exibicao da frase 'You found me!!!' na tela Swipe Horizontal");
        acoes().verticalSwipeDownAndSearch(swipePage().getLblYouFoundMe());
    }
}
