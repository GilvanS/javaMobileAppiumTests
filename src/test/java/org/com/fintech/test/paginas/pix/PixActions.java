package org.com.fintech.test.paginas.pix;


import lombok.extern.slf4j.Slf4j;
import org.com.fintech.core.support.Context;
import org.com.fintech.test.sheets.login.LoginModel;
import org.junit.jupiter.api.Assertions;
import org.com.fintech.core.driver.page.MasterPageFactory;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;
import static org.com.fintech.core.support.Context.*;

@Slf4j
public class PixActions {

    private static LoginModel loginModel;

    private static LoginModel getLoginModel() {
        if (loginModel == null) {
            loginModel = (LoginModel) Context.getData();
        }
        return loginModel;
    }

    public static PixPage pixPage() {
        getLoginModel();
        return MasterPageFactory.getPage(PixPage.class);
    }

    public static void clicarMinhasChaves() {
        log.info("Clicando em 'Minhas chaves'");
        acoes().click(pixPage().getBtnMinhasChaves());
    }

    public static void clicarCadastrarNovaChave() {
        log.info("Clicando em 'Cadastrar nova chave'");
        acoes().click(pixPage().getBtnCadastrarNovaChave());
    }

    public static void selecionarTipoChaveEmail() {
        log.info("Selecionando tipo de chave 'E-mail'");
        acoes().click(pixPage().getBtnTipoChaveEmail());
    }

    public static void preencherChaveEmail() {
        String email = getLoginModel().getEmail();
        if (email == null || email.isEmpty()) {
            throw new RuntimeException("Email não encontrado no LoginModel. Verifique se a coluna EMAIL está preenchida na planilha para o cenário.");
        }
        preencherChaveEmail(email);
    }

    public static void preencherChaveEmail(String email) {
        log.info("Preenchendo chave com email: " + email);
        acoes().click(pixPage().getInputChave());
        acoes().sendKeys(pixPage().getInputChave(), email);
    }

    public static void clicarBtnCadastrar() {
        log.info("Clicando no botão 'Cadastrar'");
        acoes().click(pixPage().getBtnCadastrar());
    }

    public static void validarMensagemSucesso() throws InterruptedException {
        log.info("Validando mensagem de sucesso");
        sleep(5000);
        Assertions.assertAll("Validação de Cadastro de Chave",
                () -> assertTrue(acoes().waitForVisibility(pixPage().getMsgSucessoCadastro()).isDisplayed(),
                        "Mensagem de sucesso não exibida"));
        acoes().click(pixPage().getBtnOk());
    }

    public static void validarChaveNaLista() {
        log.info("Validando chave na lista");
        Assertions.assertAll("Validação de Lista de Chaves",
                () -> assertTrue(acoes().waitForVisibility(pixPage().getListaChaves()).isDisplayed(),
                        "Chave não encontrada na lista"));
    }

    public static void btnExcluirChavePixEmail() {
        log.info("Clicando no botão 'Excluir Chave'");
        acoes().click(pixPage().getBtnExcluirChave());
        acoes().click(pixPage().getBtnOk());
    }

    public static void btnSimRemoverChavePix() {
        log.info("Clicando no botão 'Sim, remover'");
        acoes().click(pixPage().getBtnSimRemoverChave());
    }

    public static void validarMensagemChaveRemovida() {
        log.info("Validando mensagem de chave removida");
        Assertions.assertAll("Validação de Mensagem de Chave Removida",
                () -> assertTrue(acoes().waitForVisibility(pixPage().getMsgChaveRemovida()).isDisplayed(),
                        "Mensagem de chave removida não exibida"));
    }

    public static void validarMensagemNenhumaChavePixCadastrada() {
        log.info("Validando mensagem de nenhuma chave cadastrada");
        Assertions.assertAll("Validação de Mensagem de Nenhuma Chave Cadastrada",
                () -> assertTrue(acoes().waitForVisibility(pixPage().getMsgChaveRemovida()).isDisplayed(),
                        "Mensagem de nenhuma chave cadastrada não exibida"));
    }
}
