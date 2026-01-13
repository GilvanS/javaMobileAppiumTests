package org.com.fintech.test.paginas.login;

import io.cucumber.java.en.*;
import org.com.fintech.test.paginas.home.HomeActions;

public class LoginSteps {

    private final LoginActions loginActions;
    
    public LoginSteps() {
        loginActions = new LoginActions();
    }
    
    @When("valido o titulo da pagina como {string}")
    public void validoOTituloDaPaginaComo(String texto) {
        LoginActions.validarMesagemPorChave(texto);
    }

    @And("clico no botão {string} da conta na {string}")
    public void clicoNoBotãoEntreNaContaNaTelaInicial(String nomeBotao, String tela) {
            LoginActions.btnPorNome(nomeBotao);
    }

    @And("preencho o campo CPF na {string}")
    public void preenchoOCampoCPFComTelaInicial(String tela) {
            LoginActions.preencherCampoPorNome("CPF");
    }

    @And("preencho o campo Senha na {string}")
    public void preenchoOCampoSenhaComAdminTelaInicial(String tela) {
            LoginActions.preencherCampoPorNome("Senha");
    }
}