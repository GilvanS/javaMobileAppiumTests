package org.com.fintech.test.paginas.popup;

import org.openqa.selenium.WebElement;
import static org.com.fintech.test.utils.Context.acoes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PopupActions {
    private static final int DEFAULT_DELAY_SECONDS = 10;
    private static final int MINIMUM_SECONDS = 1;

    /**
     * Fecha todos os popups de forma simplificada
     * 
     * @param elementoIdentificadorBanco Elemento que identifica o popup de banco
     * @param elementoAcaoBanco Elemento de ação para fechar o popup de banco
     */
    public void fecharTodosPopups(WebElement elementoIdentificadorBanco, WebElement elementoAcaoBanco) {
        log.info("Fechando popups na tela");
        
        // Fecha popup de banco e verifica se foi fechado
        boolean popupBancoFechado = fecharPopupBanco(elementoIdentificadorBanco, elementoAcaoBanco);
        
        // Só fecha popup de introdução se o popup de banco foi fechado
        if (popupBancoFechado) {
            fecharPopupIntroducao();
        }
        
        log.info("Popups fechados");
    }

    /**
     * Clica nos elementos de ação para fechar os popups a partir de seus
     * identificadores até que os elementos esperados sejam encontrados e os
     * elementos identificadores não sejam mais visíveis dentro de aproximadamente
     * 10 segundos.
     *
     * @param popupModel PopUpModel configurado
     * @return boolean - true se os popups foram fechados com sucesso
     */
    public boolean verificarPopUpsAteEncontrarElementoEsperado(PopupModel popupModel) {
        return verificarPopUpsAteEncontrarElementoEsperado(popupModel, 10);
    }

    // ============================================================================
    // MÉTODOS PRIVADOS - USO INTERNO
    // ============================================================================

    /**
     * Fecha popup de banco de forma direta
     */
    private boolean fecharPopupBanco(WebElement elementoIdentificador, WebElement elementoAcao) {
        try {
            if (elementoIdentificador.isDisplayed()) {
                log.info("Fechando popup de banco");
                elementoAcao.click();
                acoes().sleep(2);
                return true;
            }
        } catch (Exception e) {
            // Popup de banco não está visível
        }
        return false;
    }

    /**
     * Fecha popup de introdução com cliques no meio da tela
     */
    private void fecharPopupIntroducao() {
        try {
            acoes().sleep(1);
            log.info("Fechando popup de introdução");
            
            // Sempre força 3 cliques para avançar o popup de introdução
            for (int i = 1; i <= 3; i++) {
                acoes().clicarMeioTela();
                acoes().sleep(1);
            }
            
            log.info("Introdução finalizada, prosseguindo para proxima etapa");
            
            // Verifica se precisa de cliques adicionais
            try {
                // Aqui precisaria do elemento de introdução, mas como é genérico, vamos fazer os cliques adicionais
                log.info("Fazendo cliques adicionais para garantir fechamento");
                for (int i = 1; i <= 2; i++) {
                    acoes().clicarMeioTela();
                    acoes().sleep(1);
                }
            } catch (Exception e) {
                // Popup fechado com sucesso
            }
        } catch (Exception e) {
            log.info("Erro ao fechar popup de introdução: {}", e.getMessage());
        }
    }

    /**
     * Clica nos elementos de ação para fechar os popups a partir de seus
     * identificadores até que os elementos esperados sejam encontrados e os
     * elementos identificadores não sejam mais visíveis dentro aproximadamente do
     * tempo limite (em segundos) definido.
     *
     * @param popUpModel           PopUpModel configurado
     * @param segundosEsperaLimite Tempo limite em segundos
     * @return boolean - true se os popups foram fechados com sucesso
     */
    private boolean verificarPopUpsAteEncontrarElementoEsperado(PopupModel popUpModel, int segundosEsperaLimite) {
        return verificarPopUpsAteEncontrarElementoEsperado( //
                popUpModel.getElementosEsperados(), //
                popUpModel.getElementosIdentificadores(), //
                popUpModel.getElementosDeAcao(), //
                popUpModel.getNomePopUp(), //
                popUpModel.isDelay(), segundosEsperaLimite);
    }

    /**
     * Método principal para verificar e fechar popups usando arrays de elementos
     * 
     * @param elementosEsperados Elementos que indicam que a tela está carregada
     * @param popupsIdentificadores Elementos que identificam os popups
     * @param popupsAcao Elementos de ação para fechar os popups
     * @param nomePopUp Nome do popup para logs
     * @param delay Se deve aguardar delay após fechar
     * @param segundosEsperaLimite Tempo limite em segundos
     * @return boolean - true se os popups foram fechados com sucesso
     */
    private boolean verificarPopUpsAteEncontrarElementoEsperado( //
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

    // ============================================================================
    // MÉTODOS REMOVIDOS - DOCUMENTAÇÃO PARA USO FUTURO
    // ============================================================================
    
    /*
     * MÉTODOS REMOVIDOS POR NÃO ESTAREM SENDO UTILIZADOS:
     * 
     * 1. fecharPopupBanco(WebElement, WebElement) - Movido para método privado
     * 2. fecharPopupIntroducao() - Movido para método privado
     * 3. verificarPopUpsAteEncontrarElementoEsperado(PopupModel, int) - Movido para método privado
     * 
     * SE PRECISAR REUTILIZAR NO FUTURO:
     * 
     * // Para fechar apenas popup de banco:
     * public boolean fecharPopupBanco(WebElement elementoIdentificador, WebElement elementoAcao) {
     *     // Implementação aqui
     * }
     * 
     * // Para fechar apenas popup de introdução:
     * public void fecharPopupIntroducao() {
     *     // Implementação aqui
     * }
     * 
     * // Para usar timeout customizado:
     * public boolean verificarPopUpsAteEncontrarElementoEsperado(PopupModel popUpModel, int segundosEsperaLimite) {
     *     // Implementação aqui
     * }
     */
}
