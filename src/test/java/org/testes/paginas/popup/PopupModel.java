package org.testes.paginas.popup;

import lombok.Getter;
import org.openqa.selenium.WebElement;

@Getter
public class PopupModel {

    private String nomePopUp;
    private WebElement[] elementosEsperados;
    private WebElement[] elementosIdentificadores;
    private WebElement[] elementosDeAcao;
    private boolean delay;

    /**
     * Invoque os métodos para atribuição dos elementos. No qual é necessário chamar
     * o {@link PopupModel#setElementosEsperados(WebElement...)},
     * {@link PopupModel#setElementosIdentificadores(WebElement...)} e opcionalmente
     * o {@link PopupModel#setElementosDeAcao(WebElement...)}.
     *
     * @param nomePopUp Nome dado ao popup para referência em log
     */
    public PopupModel(String nomePopUp) {
        this.nomePopUp = nomePopUp;
    }

    /**
     * Define os elementos de controle de parada da procura. Elementos que deseja
     * encontrar. Geralmente define-se os elementos em ordem de aparição ou regra de
     * visibilidade do DOM. Os elementos devem ser oriundos de expressões xpath
     * ({@link By.ByXPath}).
     *
     * @param elementosEsperados Um ou mais elementos do tipo {@link WebElement}
     */
    public void setElementosEsperados(WebElement... elementosEsperados) {
        this.elementosEsperados = elementosEsperados;
    }

    /**
     * Define os elementos identificadores de 'popups'. Geralmente define-se os
     * elementos em ordem de aparição ou regra de visibilidade do DOM. Os elementos
     * devem ser oriundos de expressões xpath ({@link By.ByXPath}).
     *
     * @param elementosIdentificadores Um ou mais elementos do tipo
     *                                 {@link WebElement}
     */
    public void setElementosIdentificadores(WebElement... elementosIdentificadores) {
        this.elementosIdentificadores = elementosIdentificadores;
    }

    /**
     * Define os elementos de ação de 'popups'. Quando não definido é atríbuido a
     * ele os elementos identificadores
     * ({@link PopupModel#setElementosIdentificadores(WebElement...)}). Geralmente
     * define-se os elementos em ordem de aparição ou regra de visibilidade do DOM.
     * Os elementos devem ser oriundos de expressões xpath ({@link By.ByXPath}).
     *
     * @param elementosDeAcao Um ou mais elementos do tipo {@link WebElement}
     */
    public void setElementosDeAcao(WebElement... elementosDeAcao) {
        this.elementosDeAcao = elementosDeAcao;
    }

    public void setDelay(boolean delay) {
        this.delay = delay;
    }

}
