package org.testes.paginas.home;


import org.junit.jupiter.api.Assertions;
import org.testes.driver.page.MasterPageFactory;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class HomeActions {

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    public static void validarOTextoOla() {
        log.info("Validando que estou na tela inicial");
        Assertions.assertAll("Validação da Home",
                () -> assertTrue(acoes().waitForVisibility(homePage().getTextoOla()).isDisplayed(),
                        "Texto 'Olá' não está visível"),
                () -> assertTrue(homePage().getBtnEntreNaConta().isDisplayed(),
                        "Botão 'Entre na conta' não está visível"));
    }

    public static void clicarNoBotaoEntreNaSuaConta() {
        log.info("Clicando no botão 'Entre na sua conta'");
        acoes().click(homePage().getBtnEntreNaConta());
    }

    public static void clicarCampoCpf() {
        log.info("Clicando no campo 'CPF'");
        acoes().click(homePage().getBtnCampoCpf());
        acoes().sendKeys(homePage().getBtnCampoCpf(), "11111111111");
    }

    public static void clicarCampoSenha() {
        log.info("Clicando no campo 'Senha'");
        acoes().click(homePage().getBtnCampoSenha());
        acoes().sendKeys(homePage().getBtnCampoSenha(), "admin999");
    }

    public static void clicarBrnEntrar() {
        log.info("Clicando no botão 'Entrar'");
        acoes().click(homePage().getBtnEntrar());
    }

    public static void validarAcessoMinhaConta() {
        log.info("Validando a mensagem de boas vindas");
        Assertions.assertAll("Validação da Tela Home",
                () -> assertTrue(acoes().waitForVisibility(homePage().getVldBemVindo()).isDisplayed(),
                        "Texto 'Bem-vindo!' não está visível"),
                () -> assertTrue(homePage().getVldBemVindo().isDisplayed(),
                        "Texto 'Bem-vindo!' não está visível"));
    }

}