package org.testes.paginas.login;

import java.io.IOException;

import org.testes.driver.page.MasterPageFactory;
import static org.testes.utils.Context.acoes;

import org.testes.paginas.home.HomePage;
import org.utilidades.dados.Usuario;
import org.utilidades.evidencia.PrintScreen;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginActions {



    public static LoginPage loginPage(){
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void clicarBtnComeceAgora() {
        log.info("Clico no botão 'COMECE AGORA' na tela 'Home'");
        acoes().click(loginPage().getBtnComeceAgora());
    }

    public static void clicarBtnConectarComOGoogle() {
        log.info("Clico no botão 'Conectar com o Google' na tela 'Login'");
        acoes().click(loginPage().getBtnConectarComGoogle());
    }

    public static void selecionarEmail() {
        log.info("Seleciono o email na tela 'Login'");
        acoes().waitForVisibility(loginPage().getBtnContaGoogle());
        acoes().click(loginPage().getBtnContaGoogle());
    }

    public static void vldTxtSincronizacaoEmAndamento() throws IOException, InterruptedException {
        log.info("Validar texto 'Sincronização em andamento'");
        acoes().sleep(5);
        acoes().waitForVisibility(loginPage().getVldTxtSincronizacaoEmAndamento());
        PrintScreen.screenshot("teste");
    }

    public static void vldTxtHabilitarBiometriaFace() throws IOException, InterruptedException {
        log.info("Validar texto 'Habilitar Biometria Face'");
        acoes().sleep(5);
        acoes().waitForVisibility(loginPage().getVldTxtHabilitarBiometriaFace());
        PrintScreen.screenshot("teste");
    }

    public static void habilitarBiometriaFace() {
        log.info("Habilitar Biometria Face");
        acoes().click(loginPage().getBtnHabilitarBiometriaFace());
    }

    public static void clicarBtnConcluir() {
        log.info("Clico no botão 'Continuar' na tela 'Login'");
        acoes().sleep(5);
        acoes().click(loginPage().getBtnConcluir());
    }

    public static void vldTxtEntreParaAproveitar() throws IOException, InterruptedException {
        log.info("Validat texto 'Entre para aproveitar'");
        Thread.sleep(3000);
        acoes().waitForVisibility(loginPage().getVldTxtEntreParaAproveitar());
        PrintScreen.screenshot("teste");
    }

    public static void clickBtnEntreParaAproveitar(){
        log.info("clico no botao 'Entrar' na tela 'Login'");
        acoes().click(loginPage().getBtnEntreParaAproveitar());
    }

    public static void preencherCampoEmail() {
        String email = Usuario.getEmail();
        log.info("Preencher o campo Email: {}", email);
        acoes().click(loginPage().getCampoSeuEmail());
        acoes().sendKeys(loginPage().getCampoSeuEmail(), email);
    }

    public static void clicarBtnProximo() {
        acoes().click(loginPage().getBtnProximo());
    }

    public static void preencherCampoSenha() {
        String senha = Usuario.getSenha();
        log.info("Preencher o campo Senha: " + senha);
        acoes().click(loginPage().getCampoSeuEmail());
        acoes().sendKeys(loginPage().getCampoSenha(), senha);
    }

    public static void clicarBtnEntrar() {
        acoes().click(loginPage().getBtnEntrar());
    }

}
