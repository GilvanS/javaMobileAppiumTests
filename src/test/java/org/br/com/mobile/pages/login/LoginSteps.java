package org.br.com.mobile.pages.login;

import io.cucumber.java.en.Given;

import java.io.IOException;

public class LoginSteps {


    @Given("que estou na tela inicial do app")
    public void que_estou_na_tela_inicial_do_app() throws IOException, InterruptedException {
        LoginActions.vldTelaInicialApp();
    }



}
