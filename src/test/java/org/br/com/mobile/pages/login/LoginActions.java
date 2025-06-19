package org.br.com.mobile.pages.login;

import lombok.extern.slf4j.Slf4j;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.br.com.mobile.utils.evidence.PrintScreen;

import java.io.IOException;

@Slf4j
public class LoginActions {

    private static PageBaseActions acoes = new PageBaseActions();

    public static LoginPage loginPage() {
        return MasterPageFactory.getPage(LoginPage.class);
    }

    public static void vldTelaInicialApp() throws IOException, InterruptedException {

        acoes.waitElement(loginPage().getBtnDormir());
        PrintScreen.screenshot("tela inicial");
    }
}
