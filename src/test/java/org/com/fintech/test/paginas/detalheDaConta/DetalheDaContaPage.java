package org.com.fintech.test.paginas.detalheDaConta;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.com.fintech.core.driver.actions.PageBaseActions;

@Getter
public class DetalheDaContaPage extends PageBaseActions {

	public DetalheDaContaPage(AppiumDriver driver) {
		super(driver);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Detalhe da conta']")
	private WebElement vldLblDetalheDaConta;

	@AndroidFindBy(xpath = "(//android.widget.ImageButton)[1]")
	private WebElement btnVoltar;

	public WebElement valorSaldoHoje(String valor) {
		return driver.findElement(By.xpath("//android.widget.TextView[@text= 'HOJE']/..//android.widget.TextView[@text= '" + valor + "']"));
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text= 'HOJE']/..//android.widget.TextView[contains(@text, 'R$')]")
	private WebElement valorSaldoHoje;
}
