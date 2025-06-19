package org.br.com.mobile.pages.login;

import lombok.extern.slf4j.Slf4j;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.br.com.mobile.utils.dataUsers.Users;
import org.br.com.mobile.utils.evidence.PrintScreen;
import org.br.com.api.utils.LogFormatter;

import java.io.IOException;

@Slf4j
public class LoginActions {

    static PageBaseActions acoes = new PageBaseActions();

    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void vldTelaInicialApp() throws IOException, InterruptedException {
        PageBaseActions.waitElement(loginPage().getBtnAcessarMinhaConta());
        PrintScreen.screenshot("tela inicial");
    }

    public static void clicarBtnVamosLa() {
        LogFormatter.logStep("clico no botão 'Vamos lá' em login");
        acoes.click(loginPage().getBtnVamosLa());
    }

    public static void clickBtnEntrarNaConta() {
        log.info("clico no botao 'Entrar na conta' na tela 'Login'");
        acoes.click(loginPage().getBtnAcessarMinhaConta());
    }

    public static void clicarBtnContinuar() {
        log.info("clico no botao 'Continuar' na tela 'Login'");
        acoes.click(loginPage().getBtnContinuar());
    }

    public static void clickBtnProximo(){
        log.info("clico no botao 'Próximo' na tela 'Login'");
        acoes.click(loginPage().getBtnProximo());
    }

    public static void inserirCpf() throws IOException, InterruptedException {
        LogFormatter.logStep("preencho o campo 'CPF' na tela 'Login': " + Users.getCpf());
        acoes.clear(loginPage().getCampoCpf());
        loginPage().getCampoCpf().sendKeys(Users.getCpf());
        PrintScreen.screenshot("CPF");
    }

    public static void vldTextoCpfInvalido() throws IOException, InterruptedException {
        log.info("valido a exibicao da mensagem 'CPF invalido' na tela 'Login'");
        PageBaseActions.waitElement(loginPage().getTxtCpfInvalido());
        PrintScreen.screenshot("mensagem cpf invalido");
    }

    public static void inserirSenha(){
        log.info("preencho o campo 'Senha' na tela 'Login': {}", Users.getSenha());
        loginPage().getCampoSenha().sendKeys(Users.getSenha());

    }

    public static void clickBtnEntrar(){
        log.info("clico no botao 'Entrar' na tela 'Login'");
        acoes.click(loginPage().getBtnEntrar());
    }
}
