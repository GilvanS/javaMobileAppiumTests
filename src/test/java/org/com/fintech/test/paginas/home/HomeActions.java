package org.com.fintech.test.paginas.home;


import org.junit.jupiter.api.Assertions;
import org.com.fintech.core.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.com.fintech.core.support.Context.acoes;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.function.BooleanSupplier;


@Slf4j
public class HomeActions {

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void validarMesagemPorChave(String chaveMensagem) {
        log.info("Validando mensagem na Home: {}", chaveMensagem);
        WebElement elemento = homePage().getElementoPorTexto(chaveMensagem);

        assertAll("Validação da Mensagem na Home: " + chaveMensagem,
                () -> assertNotNull(elemento, "Mensagem não encontrada no HashMap da Home: " + chaveMensagem),
                () -> assertTrue(acoes().waitForVisibility(elemento).isDisplayed(),
                        "Elemento não está visível na tela Home para a mensagem: " + chaveMensagem)
        );
    }

    public static void validarTextoPorChave(String chaveMensagem) {
        log.info("Validando texto na Home: {}", chaveMensagem);
        WebElement elemento = homePage().getElementoPorTexto(chaveMensagem);
        assertNotNull(elemento, "Elemento não encontrado no mapa da Home: " + chaveMensagem);
        assertTrue(acoes().waitForVisibility(elemento).isDisplayed(), "Elemento não está visível na tela Home");
    }

    public static void btnPorNome(String nomeBotao) {
        log.info("Clicando no botão na Home: {}", nomeBotao);
        WebElement elemento = homePage().getBtnPorNome(nomeBotao);
        assertNotNull(elemento, "Botão não encontrado na HomePage: " + nomeBotao);
        acoes().click(elemento);
    }

    public static void preencherCampoPorNome(String nomeCampo, String valor) {
        log.info("Preenchendo o campo '{}' na Home com o valor '{}'", nomeCampo, valor);
        // Assumindo que na Home os campos também podem ser acessados por getBtnPorNome ou similar
        // Se não tiver campos de input na Home mapeados assim, isso precisará de ajuste
        WebElement elemento = homePage().getBtnPorNome(nomeCampo); 
        if (elemento == null) {
             elemento = homePage().getElementoPorTexto(nomeCampo);
        }
        assertNotNull(elemento, "Campo não encontrado na HomePage: " + nomeCampo);

        acoes().waitForVisibility(elemento);
        elemento.clear();
        elemento.sendKeys(valor);
    }


    public static void validarAcessoMinhaConta() {
        log.info("Validando a mensagem de boas vindas");
        acoes().sleep(5);
        Assertions.assertAll("Validação da Tela Home",
                () -> assertTrue(acoes().waitForVisibility(homePage().getVldBemVindo()).isDisplayed(),
                        "Texto 'Bem-vindo!' não está visível"),
                () -> assertTrue(homePage().getVldBemVindo().isDisplayed(),
                        "Texto 'Bem-vindo!' não está visível"));
    }

}