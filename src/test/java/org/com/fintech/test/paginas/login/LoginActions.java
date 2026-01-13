package org.com.fintech.test.paginas.login;

import static java.lang.Thread.sleep;

import org.com.fintech.core.driver.page.MasterPageFactory;
import org.com.fintech.core.support.Context;
import static org.com.fintech.core.support.Context.acoes;
import org.com.fintech.test.sheets.login.LoginModel;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BooleanSupplier;

@Slf4j
public class LoginActions {

    private static LoginModel loginModel;
    private static Map<String, String> dadosLogin;

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

    private static void iniciarDadosLogin() {
        if (dadosLogin == null) {
            dadosLogin = new HashMap<>();
            dadosLogin.put("CPF", getLoginModel().getCpf());
            dadosLogin.put("Senha", getLoginModel().getSenha());
        }
    }

    public static String getDadoLogin(String chave) {
        iniciarDadosLogin();
        return dadosLogin.get(chave);
    }

    public static LoginPage loginPage(){
        getLoginModel(); // Garante inicialização
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void validarMesagemPorChave(String chaveMensagem) {
        log.info("Validando mensagem: {}", chaveMensagem);
        WebElement elemento = loginPage().getElementoPorTexto(chaveMensagem);

        assertAll("Validação da Mensagem: " + chaveMensagem,
                () -> assertNotNull(elemento, "Mensagem não encontrada no HashMap: " + chaveMensagem),
                () -> assertTrue(acoes().waitForVisibility(elemento).isDisplayed(),
                        "Elemento não está visível na tela para a mensagem: " + chaveMensagem)
        );
    }

    public static void validarTextoPorChave(String chaveMensagem) {
        log.info("Validando texto: {}", chaveMensagem);
        WebElement elemento = loginPage().getElementoPorTexto(chaveMensagem);
        assertTrue((BooleanSupplier) acoes().waitForVisibility(elemento), "Elemento não está visível na tela");
    }

    public static void btnPorNome(String nomeBotao) {
        log.info("Validando botão: {}", nomeBotao);
        WebElement elemento = loginPage().getBtnPorAcao(nomeBotao);
        assertNotNull(elemento, "Botão não encontrado na LoginPage: " + nomeBotao);
        acoes().click(elemento);
    }

    public static void preencherCampoPorNome(String nomeCampo) {
        String valor = getDadoLogin(nomeCampo);
        log.info("Preenchendo o campo '{}' com o valor '{}'", nomeCampo, valor);
        WebElement elemento = loginPage().getBtnPorAcao(nomeCampo);
        acoes().waitForVisibility(elemento);
        elemento.clear();
        elemento.sendKeys(valor);
    }

    public static void validarOTextoOla() {
        log.info("Validando que estou na tela inicial");
        Assertions.assertAll("Validação da Home",
                () -> assertTrue(acoes().waitForVisibility(loginPage().getTextoOla()).isDisplayed(),
                        "Texto 'Olá' não está visível"),
                () -> assertTrue(acoes().waitForVisibility(loginPage().getBtnEntreNaConta()).isDisplayed(),
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



}
