package org.br.com.mobile.pages.login;

import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.br.com.mobile.utils.dataUsers.Users;
import org.br.com.mobile.utils.evidence.PrintScreen;
import org.br.com.api.utils.LogFormatter;

import java.io.IOException;

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
        LogFormatter.logStep("clico no botao 'Entrar na conta' na tela 'Login'");
        acoes.click(loginPage().getBtnAcessarMinhaConta());
    }

    public static void clicarBtnContinuar() {
        LogFormatter.logStep("clico no botao 'Continuar' na tela 'Login'");
        acoes.click(loginPage().getBtnContinuar());
    }

    public static void clickBtnProximo(){
        LogFormatter.logStep("clico no botao 'Próximo' na tela 'Login'");
        acoes.click(loginPage().getBtnProximo());
    }

    public static void inserirCpf() throws IOException, InterruptedException {
        LogFormatter.logStep("preencho o campo 'CPF' na tela 'Login': " + Users.getCpf());
        acoes.clear(loginPage().getCampoCpf());
        loginPage().getCampoCpf().sendKeys(Users.getCpf());
        PrintScreen.screenshot("CPF");
    }

    public static void vldTextoCpfInvalido() throws IOException, InterruptedException {
        LogFormatter.logStep("valido a exibicao da mensagem 'CPF invalido' na tela 'Login'");
        PageBaseActions.waitElement(loginPage().getTxtCpfInvalido());
        PrintScreen.screenshot("mensagem cpf invalido");
    }

    public static void inserirSenha(){
        LogFormatter.logStep("preencho o campo 'Senha' na tela 'Login': " + Users.getSenha());
        loginPage().getCampoSenha().sendKeys(Users.getSenha());
    }

    public static void clickBtnEntrar(){
        LogFormatter.logStep("clico no botao 'Entrar' na tela 'Login'");
        acoes.click(loginPage().getBtnEntrar());
    }
}
