package org.testes.paginas.passagens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testes.utils.Hooks.driver;

@Getter
public class PassagensPage extends PassagensActions {

		public PassagensPage(AppiumDriver driver) {
		super();
	}

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Só ida')]")
	private WebElement btnSoIda;

	@AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Ida e volta')]")
	private WebElement btnIdaEVolta;

	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[1]")
	private WebElement campoDeOndeVoceVaiSair;

	@AndroidFindBy(xpath = "(//android.view.View/android.widget.EditText)[2]")
	private WebElement campoParaOndeVoceVai;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='São Paulo - SP, Brasil']")
	private WebElement selecionarSaoPauloSP;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='Roma - Lácio , Itália']")
	private WebElement selecionarRomaLacioItalia;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continuar']")
	private WebElement btnContinuar;

	@AndroidFindBy(xpath = "(//android.view.View[contains(@content-desc, 'eembolsável') or contains(@content-desc, 'voo direto') or contains(@content-desc, 'parada') and (@clickable='true')])[2]")
	private WebElement lblEscolhaDeIda;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Escolher ida']")
	private WebElement btnEscolherIda;

	@AndroidFindBy(xpath = "//android.view.View[@content-desc='+2']")
	private WebElement lblEscolhaDeVolta;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Escolher volta']")
	private WebElement btnEscolherVolta;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Pular']")
	private WebElement btnPular;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Continuar sem upgrade']")
	private WebElement btnContinuarSemUpgrade;

	@AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Confirmar']")
	private WebElement btnConfirmar;

	public WebElement dataIda(String dia) {
		return driver.findElement(By.xpath("(//android.view.View[@content-desc='"+ dia +"'])[1]"));
	}

	public WebElement dataVolta(String dia) {
		return driver.findElement(By.xpath("(//android.view.View[@content-desc='"+ dia +"'])[2]"));
	}
}
