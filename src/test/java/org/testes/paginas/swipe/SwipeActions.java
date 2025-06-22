package org.testes.paginas.swipe;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;

@Slf4j
public class SwipeActions {

    private static SwipePage getSwipePage() {
        return MasterPageFactory.getPage(SwipePage.class);
    }

    public static void clicarBtnSwipeHorizontal() {
        log.info("Clicando no botao 'Swipe Horizontal'");
        acoes().click(getSwipePage().getBtnSwipe());
    }

    public static void deslizarParaDireita() {
        log.info("Deslizando para a direita na tela Swipe Horizontal");
        acoes().swipeHorizontal(true);
    }

    public static void deslizarParaEsquerda() {
        log.info("Deslizando para a esquerda na tela Swipe Horizontal");
        acoes().swipeHorizontal(false);
    }

    public static void validarLblGreatCommunity() {
        log.info("Validando a exibicao da frase 'Great Community' na tela Swipe Horizontal");
        acoes().waitForElementToBeVisible(getSwipePage().getLblGreatCommunity(), 10);
        assertTrue(getSwipePage().getLblGreatCommunity().isDisplayed(),
                "Nao foi posivel validar o texto 'Great Community'");
        acoes().sleep(2);
    }

    public static void validarLblFullyOpenSource() {
        log.info("Validando a exibicao da frase 'Fully Open Source' na tela Swipe Horizontal");
        acoes().waitForElementToBeVisible(getSwipePage().getLblFullyOpenSource(), 10);
        assertTrue(getSwipePage().getLblFullyOpenSource().isDisplayed(),
                "Nao foi posivel validar o texto 'Fully Open Source'");
        acoes().sleep(2);
    }
}
