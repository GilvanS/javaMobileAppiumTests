package org.com.fintech.test.paginas.pix;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.com.fintech.core.driver.page.MasterPageFactory;
import org.com.fintech.test.utils.Usuario;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.com.fintech.test.utils.Context.acoes;

@Slf4j
public class PixActions {

    public static org.com.fintech.test.paginas.pix.PixPage pixPage() {
        return MasterPageFactory.getPage(org.com.fintech.test.paginas.pix.PixPage.class);
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
        String email = Usuario.getEmail();
        log.info("Preenchendo chave com email: ");
        acoes().click(pixPage().getInputChave());
        acoes().sendKeys(pixPage().getInputChave(), "jean@test.com");
    }

    public static void clicarBtnCadastrar() {
        log.info("Clicando no botão 'Cadastrar'");
        acoes().click(pixPage().getBtnCadastrar());
    }

    public static void validarMensagemSucesso() {
        log.info("Validando mensagem de sucesso");
        Assertions.assertAll("Validação de Cadastro de Chave",
                () -> assertTrue(acoes().waitForVisibility(pixPage().getMsgSucessoCadastro()).isDisplayed(),
                        "Mensagem de sucesso não exibida"));
    }

    public static void validarChaveNaLista() {
        log.info("Validando chave na lista");
        Assertions.assertAll("Validação de Lista de Chaves",
                () -> assertTrue(acoes().waitForVisibility(pixPage().getListaChaves()).isDisplayed(),
                        "Chave não encontrada na lista"));
    }
}
