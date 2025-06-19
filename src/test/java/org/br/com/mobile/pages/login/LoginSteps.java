package org.br.com.mobile.pages.login;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class LoginSteps {


    @Given("que estou na tela inicial do app Digio")
    public void que_estou_na_tela_inicial_do_app_uber() throws IOException, InterruptedException {
        LoginActions.vldTelaInicialApp();
    }

    @When("clico no botão 'Vamos lá' na tela 'Login'")
    public void clicoNoBotaoVamosLaNaTelaLogin() {
        LoginActions.clicarBtnVamosLa();
    }

    @When("preencho o campo 'CPF' na tela 'Login'")
    public void preencho_o_campo_cpf_na_tela_login() throws IOException, InterruptedException {
        LoginActions.inserirCpf();
    }

    @When("clico no botão 'Continuar' na tela 'Login'")
    public void clicoNoBotaoContinuarNaTelaLogin() {
        LoginActions.clicarBtnContinuar();
    }

    @When("preencho o campo 'Senha' na tela 'Login'")
    public void preencho_o_campo_senha_na_tela_login() throws IOException {
        LoginActions.inserirSenha();
    }

    @When("clico no botão 'Entrar' na tela 'Login'")
    public void clicoNoBotaoEntrarNaTelaLogin() {
        LoginActions.clickBtnEntrar();
    }

    @When("clico no botao 'Próximo' na tela 'Login'")
    public void clico_no_botao_proximo_na_tela_login() {
        LoginActions.clickBtnProximo();
    }



    @When("clico no botao 'Entrar' na tela 'Login'")
    public void clico_no_botao_entrar_na_tela_login() {
        LoginActions.clickBtnEntrar();
    }

    @When("valido a exibicao da mensagem 'CPF invalido' na tela 'Login'")
    public void valido_a_exibicao_da_mensagem_cpf_invalido_na_tela_login() throws IOException, InterruptedException {
        LoginActions.vldTextoCpfInvalido();

    }


}
