package org.testes.paginas.login;

import io.cucumber.java.en.*;
import org.testes.paginas.home.HomeActions;

import java.io.IOException;

public class LoginSteps {


    @Given("valido a exibição da frase Entre para aproveitar a melhor experiência na tela login")
    public void valido_a_exibição_da_frase_entre_para_aproveitar_a_melhor_experiência_na_tela_login() throws IOException, InterruptedException {
        LoginActions.vldTxtEntreParaAproveitar();
    }

    @Given("clico no botão Entre na tela Login")
    public void clicar_no_botão_entre_na_tela_login() {
        LoginActions.clickBtnEntreParaAproveitar();
    }

    @Given("preencho o campo email {string} na tela Login")
    public void preencho_o_campo_email_na_tela_login(String email) {
        LoginActions.preencherCampoEmail(email);
    }

    @Given("clico no botão Próximo na tela Login")
    public void clicar_no_botão_próximo_na_tela_login() {
        LoginActions.clicarBtnProximo();
    }

    @Given("preencho o campo Senha {string} na tela Login")
    public void preencho_o_campo_senha_na_tela_login(String senha) {
        LoginActions.preencherCampoSenha(senha);
    }

    @Given("clico no botão Entrar na tela Login")
    public void clico_no_botão_entrar_na_tela_login() {
        LoginActions.clicarBtnEntrar();
    }

    @Then("clico no botão Explorar na tela Home")
    public void clicar_no_botão_explorar_na_tela_home() {
        HomeActions.clicarBtnExplorar();
    }
}