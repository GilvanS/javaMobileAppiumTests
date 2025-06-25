package org.testes.paginas.passagens;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.testes.utils.Hooks;
import org.utilidades.dados.Usuario;

@Slf4j
public class PassagensActions {

	static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());


	public static PassagensPage passagensPage() {
		return MasterPageFactory.getPage(PassagensPage.class);
	}

	public static void clicarBtnIdaEVolta() {
		log.info("clicar no botão Ida e volta na tela 'Passagens'");
		acoes.click(passagensPage().getBtnIdaEVolta());
	}

	public static void clicarBtnSoIda() {
		log.info("clicar no botão Só ida na tela 'Passagens'");
		acoes.click(passagensPage().getBtnSoIda());
	}

	public static void selecionarDataRetorno() {
		String dia = Usuario.getDataFim();
		log.info("seleciono a data no campo Escolha a data na tela 'Passagens'");
		acoes.click(passagensPage().dataVolta(dia));
	}

	public static void clicarLblEscolhaDeIda() {
		log.info("Seleciono o voo de ida na tela Passagens");
		acoes.sleep(10);
		acoes.click(passagensPage().getLblEscolhaDeIda());
	}

	public static void clicarBtnEscolhaDeIda() {
		log.info("clicar no botão Escolher ida na tela 'Passagens'");
		acoes.click(passagensPage().getBtnEscolherIda());
	}

	public static void clicatLblEscolhaDeVolta() {
		log.info("Seleciono o voo de volta na tela Passagens");
		acoes.sleep(10);
		acoes.click(passagensPage().getLblEscolhaDeVolta());
	}

	public static void clicarBtnEscolhaDeVolta() {
		log.info("clicar no botão Escolher volta na tela 'Passagens'");
		acoes.click(passagensPage().getBtnEscolherVolta());
	}

}
