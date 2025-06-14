package org.testes.paginas.ingressos;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.utilidades.evidencia.PrintScreen;
import org.testes.Hooks;

@Slf4j
public class IngressosActions {

    static PrintScreen printScreen = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    public static IngressosPage ingressosPage() {
        return MasterPageFactory.getPage(IngressosPage.class);
    }

    public static void clicarEPreencherCamoDestino(String destino) {
        log.info("Clicando no botão comprar ingresso");
        acoes.click(ingressosPage().getCampoParaQualDestino());
        acoes.sendKeys(ingressosPage().getCampoParaQualDestino(), destino);
        acoes.click(ingressosPage().getDestinoBetoCarreiro());
    }

}
