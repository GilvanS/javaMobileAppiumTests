package org.testes.paginas.login;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class LoginActions {

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }


    public static void vldTxtEntreParaAproveitar() throws IOException, InterruptedException {
        log.info("Validat texto 'Entre para aproveitar'");
        Thread.sleep(3000);
        acoes.waitForVisibility(loginPage().getVldTxtEntreParaAproveitar());
        PrintScreen.screenshot("teste");
    }

    public static void clickBtnEntreParaAproveitar(){
        log.info("clico no botao 'Entrar' na tela 'Login'");
        acoes.click(loginPage().getBtnEntreParaAproveitar());
    }

    public static void preencherCampoEmail(String email) {
        log.info("Preencher o campo Email: " + email);
        acoes.click(loginPage().getCampoSeuEmail());
        acoes.sendKeys(loginPage().getCampoSeuEmail(), email);
    }

    public static void clicarBtnProximo() {
        acoes.click(loginPage().getBtnProximo());
    }

    public static void preencherCampoSenha(String senha) {
        log.info("Preencher o campo Senha: " + senha);
        acoes.click(loginPage().getCampoSenha());
        acoes.sendKeys(loginPage().getCampoSenha(), senha);
    }

    public static void clicarBtnEntrar() {
        acoes.click(loginPage().getBtnEntrar());
    }



}
