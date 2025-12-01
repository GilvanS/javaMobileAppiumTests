package org.testes.paginas.login;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.testes.driver.page.MasterPageFactory;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;
import org.utilidades.dados.Usuario;
import org.utilidades.evidencia.PrintScreen;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginActions {



    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void validarOTextoOla() {
        log.info("Validando que estou na tela inicial");
        Assertions.assertAll("Validação da Home",
                () -> assertTrue(acoes().waitForVisibility(loginPage().getTextoOla()).isDisplayed(),
                        "Texto 'Olá' não está visível"),
                () -> assertTrue(loginPage().getBtnEntreNaConta().isDisplayed(),
                        "Botão 'Entre na conta' não está visível"));
    }

    public static void clicarNoBotaoEntreNaSuaConta() throws InterruptedException {
        log.info("Clicando no botão 'Entre na sua conta'");
        sleep(5000);
        acoes().click(loginPage().getBtnEntreNaConta());
    }

    public static void clicarCampoCpf() {
        log.info("Clicando no campo 'CPF'");
        acoes().click(loginPage().getBtnCampoCpf());
        acoes().sendKeys(loginPage().getBtnCampoCpf(), "11111111111");
    }

    public static void clicarCampoSenha() {
        log.info("Clicando no campo 'Senha'");
        acoes().click(loginPage().getBtnCampoSenha());
        acoes().sendKeys(loginPage().getBtnCampoSenha(), "admin999");
    }

    public static void clicarBrnEntrar() {
        log.info("Clicando no botão 'Entrar'");
        acoes().click(loginPage().getBtnEntrar());
    }

    public static void clicarBtnComeceAgora() {
        log.info("Clico no botão 'COMECE AGORA' na tela 'Home'");
        acoes().click(loginPage().getBtnComeceAgora());
    }

}
