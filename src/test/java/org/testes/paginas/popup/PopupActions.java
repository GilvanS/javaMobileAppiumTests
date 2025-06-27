package org.testes.paginas.popup;

import org.openqa.selenium.WebElement;
import static org.testes.utils.Context.acoes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PopupActions {
    private static final int DEFAULT_DELAY_SECONDS = 10;
    private static final int MINIMUM_SECONDS = 1;

    /**
     * Clica nos elementos de ação para fechar os popups a partir de seus
     * identificadores até que os elementos esperados sejam encontrados e os
     * elementos identificadores não sejam mais visíveis dentro de aproximadamente
     * 10 segundos.
     *
     * @param popupModel PopUpModel
     * @return boolean
     */
    public boolean verificarPopUpsAteEncontrarElementoEsperado(PopupModel popupModel) {
        return verificarPopUpsAteEncontrarElementoEsperado(popupModel, 10);
    }

    /**
     * Clica nos elementos de ação para fechar os popups a partir de seus
     * identificadores até que os elementos esperados sejam encontrados e os
     * elementos identificadores não sejam mais visíveis dentro aproximadamente do
     * tempo limite (em segundos) definido.
     *
     * @param popUpModel           PopUpModel
     * @param segundosEsperaLimite
     * @return boolean
     */
    public boolean verificarPopUpsAteEncontrarElementoEsperado(PopupModel popUpModel, int segundosEsperaLimite) {
        return verificarPopUpsAteEncontrarElementoEsperado( //
                popUpModel.getElementosEsperados(), //
                popUpModel.getElementosIdentificadores(), //
                popUpModel.getElementosDeAcao(), //
                popUpModel.getNomePopUp(), //
                popUpModel.isDelay(), segundosEsperaLimite);
    }

    /**
     * Clica nos elementos de ação para fechar os popups a partir de seus
     * identificadores até que os elementos esperados sejam encontrados e os
     * elementos identificadores não sejam mais visíveis.
     *
     * @param elementosEsperados
     * @param popupsIdentificadores
     * @param popupsAcao
     * @param nomePopUp
     * @param segundosEsperaLimite
     * @return boolean
     */
    public boolean verificarPopUpsAteEncontrarElementoEsperado( //
                                                                WebElement[] elementosEsperados, //
                                                                WebElement[] popupsIdentificadores, //
                                                                WebElement[] popupsAcao, //
                                                                String nomePopUp, //
                                                                boolean delay, //
                                                                int segundosEsperaLimite) {

        log.info("verificando popups '" + nomePopUp + "'");

        int cont = 1;
        int tempo = segundosEsperaLimite;
        while (tempo > 0) {
            if (verificarCliqueElementoAcaoVisivel(popupsIdentificadores, popupsAcao, cont, nomePopUp))
                cont++;

            if (verificarElementoEsperadoVisivel(elementosEsperados, popupsIdentificadores)) {
                if (delay) {
                    log.info("delay esta habilitado para esse popup, aguardando " + DEFAULT_DELAY_SECONDS + " segundos");
                    acoes().sleep(DEFAULT_DELAY_SECONDS);
                    if (retornarElementoVisivel(popupsIdentificadores) == null) {
                        return true;
                    }

                } else {
                    return true;
                }
            }

            acoes().sleep(MINIMUM_SECONDS);
            tempo--;
        }
        return false;
    }

    private boolean verificarCliqueElementoAcaoVisivel( //
         WebElement[] elementosIdentificadores, //
         WebElement[] elementosAcao, //
         int cont, //
         String nomePopUp) {

        if (retornarElementoVisivel(elementosIdentificadores) != null) {

            WebElement elemento = retornarElementoVisivel(elementosAcao);
            if (elemento != null) {
                log.info(String.format("clico no %dº popup%sem '%s'", cont, retornarTextoElemento(elemento), nomePopUp));
                elemento.click();
                return true;
            }
        }
        return false;
    }

    private boolean verificarElementoEsperadoVisivel(WebElement[] elementosEsperados, WebElement[] popupsIdentificadores) {
        WebElement elemento = retornarElementoVisivel(elementosEsperados);
        if (elemento != null && retornarElementoVisivel(popupsIdentificadores) == null) {
            log.info(String.format("elemento esperado%sencontrado", retornarTextoElemento(elemento)));
            return true;
        }
        return false;
    }

    private WebElement retornarElementoVisivel(WebElement[] elementos) {
        if (elementos == null || elementos.length == 0) {
            return null;
        }
        
        for (WebElement elemento : elementos) {
            try {
                if (elemento.isDisplayed()) {
                    return elemento;
                }
            } catch (Exception e) {
                // Elemento não está visível, continua para o próximo
            }
        }
        return null;
    }

    private String retornarTextoElemento(WebElement elemento) {
        String textoElemento = null;

        try {
            textoElemento = elemento.getText();
        } catch (Exception e) {
            // Não foi possível retornar o texto do elemento
        }

        return textoElemento = textoElemento == null || textoElemento.length() <= 0 ? //
                " " : String.format(" '%s' ", textoElemento);
    }
}
