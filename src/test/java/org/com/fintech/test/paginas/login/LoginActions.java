package org.com.fintech.test.paginas.login;

import static java.lang.Thread.sleep;

import org.com.fintech.core.driver.page.MasterPageFactory;
import org.com.fintech.core.support.Context;
import static org.com.fintech.core.support.Context.acoes;
import org.com.fintech.test.sheets.login.LoginModel;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginActions {

    private static LoginModel loginModel;

    /**
     * Garante que o loginModel está inicializado.
     * @return LoginModel inicializado
     */
    private static LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = (LoginModel) Context.getData();
        }
        return loginModel;
    }

    public static LoginPage loginPage(){
        getLoginModel(); // Garante inicialização
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
        String cpf = getLoginModel().getCpf();
        clicarCampoCpf(cpf);
    }

    public static void clicarCampoCpf(String cpf) {
        log.info("Clicando no campo CPF: " + cpf);
        acoes().click(loginPage().getBtnCampoCpf());
        acoes().sendKeys(loginPage().getBtnCampoCpf(), cpf);
    }

    public static void clicarCampoSenha() {
        String senha = getLoginModel().getSenha();
        clicarCampoSenha(senha);
    }

    public static void clicarCampoSenha(String senha) {
        log.info("Clicando no campo Senha: " + senha + " na tela inicial");
        acoes().click(loginPage().getBtnCampoSenha());
        acoes().sendKeys(loginPage().getBtnCampoSenha(), senha);
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
