package org.testes.paginas.login;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testes.utils.Context.acoes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.testes.manager.UsuarioManager;
import org.testes.utils.FakerApi;
import org.testes.utils.FakerJavaGenerator;
import org.testes.utils.Hooks;
import org.utilidades.dados.Usuario;
import org.utilidades.evidencia.PrintScreen;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoginActions {
    
	private static final FakerJavaGenerator faker = new FakerJavaGenerator();
	
    public static LoginPage loginPage() {
		return MasterPageFactory.getPage(LoginPage.class);
	}

    // Métodos de Login
    public static void validarTelaLogin() throws IOException, InterruptedException {
        log.info("Validando tela de login");
        Thread.sleep(3000);
        acoes().waitForVisibility(loginPage().getVldTxtEntreParaAproveitar());
        PrintScreen.screenshot("teste");
    }

    public static void preencherCampoEmail(String email) {
        log.info("Preenchendo email");
        acoes().click(loginPage().getCampoSeuEmail());
        acoes().sendKeys(loginPage().getCampoSeuEmail(), email);
    }

    public static void preencherCampoSenha(String senha) {
        log.info("Preenchendo senha");
        acoes().click(loginPage().getCampoSenha());
        acoes().sendKeys(loginPage().getCampoSenha(), senha);
    }

    // Métodos de Navegação
    public static void clicarBtnProximo() {
        log.info("Clicando no botao 'Proximo'");
        acoes().click(loginPage().getBtnProximo());
    }

    public static void clicarBtnEntrar() {
        log.info("Clicando no botao 'Entrar'");
        acoes().click(loginPage().getBtnEntrar());
    }

    public static void clicarBtnProfile() {
        log.info("Clicando no botao 'Profile'");
        acoes().click(loginPage().getBtnProfile());
    }

    public static void clicarBtnSignUp() {
        log.info("Clicando no botao 'Sign up'");
        acoes().click(loginPage().getBtnSignUp());
    }

    public static void clicarBtnCreate() {
        log.info("Clicando no botao 'Create'");
        acoes().click(loginPage().getBtnCreate());
    }

    // Métodos de Validação
    public static void validarTxtEbacStore() throws IOException {
//        log.info("Validando texto 'EBAC Store'");
        acoes().waitForVisibility(loginPage().getTxtEbacStore());
        PrintScreen.screenshot("validacao_ebac_store");
    }

    public static void validarTxtWelcomeEbacShop() throws IOException {
        log.info("Validando texto 'Welcome to EBAC Shop'");
        acoes().waitForVisibility(loginPage().getTxtWelcomeEbacShop());
        PrintScreen.screenshot("validacao_welcome_ebac_shop");
    }

    // Métodos de preenchimento de campos
    public static void preencherCampoFirstName() {
        String firstName = faker.getFirstName();
        log.info("Preenchendo First Name: {}", firstName);
        acoes().click(loginPage().getCampoFirstName());
        acoes().sendKeys(loginPage().getCampoFirstName(), firstName);
        UsuarioManager.setFirstName(firstName);
        faker.salvarDadosEmJson();
    }

    public static void preencherCampoLastName() {
        String lastName = faker.getLastName();
        log.info("Preenchendo Last Name: {}", lastName);
        acoes().click(loginPage().getCampoLastName());
        acoes().sendKeys(loginPage().getCampoLastName(), lastName);
        UsuarioManager.setLastName(lastName);
    }

    public static void preencherCampoPhoneNumber() {
        String phoneNumber = faker.getPhoneNumber();
        log.info("Preenchendo Phone Number: {}", phoneNumber);
        acoes().click(loginPage().getCampoPhoneNumber());
        acoes().sendKeys(loginPage().getCampoPhoneNumber(), phoneNumber);
        UsuarioManager.setPhoneNumber(phoneNumber);
    }

    public static void preencherCampoEmailAddress() {
        String email = faker.getEmailAddress();
        log.info("Preenchendo Email Address: {}", email);
        acoes().click(loginPage().getCampoEmailAddress());
        acoes().sendKeys(loginPage().getCampoEmailAddress(), email);
        UsuarioManager.setEmail(email);
    }

    public static void preencherCampoEmailLogin() {
        String email = Usuario.getEmail();
        log.info("Preenchendo campo Email: {}", email);
        acoes().click(loginPage().getCampoSeuEmail());
        acoes().sendKeys(loginPage().getCampoSeuEmail(), email);

    }
    public static void preencherCampoPasswordLogin() {
        String password = Usuario.getPassword();
        log.info("Preenchendo o campo Password: {}", password);
        acoes().click(loginPage().getCampoPassword());
        acoes().sendKeys(loginPage().getCampoPassword(), password);
    }

    public static void preencherCampoPassword() {
        String password = faker.getPassword();
        log.info("Preenchendo Password");
        acoes().click(loginPage().getCampoPassword());
        acoes().sendKeys(loginPage().getCampoPassword(), password);
        UsuarioManager.setPassword(password);
    }

    public static void reEnterPassword() {
        String rePassword = UsuarioManager.getPassword();
        log.info("Re-preenchendo Password");
        acoes().click(loginPage().getCampoReEnterPassword());
        acoes().sendKeys(loginPage().getCampoReEnterPassword(), rePassword);
    }

    public static void clicarBtnLogin() {
        log.info("Clicando no botao 'Login'");
        acoes().click(loginPage().getBtnLogin());

    }
    // Novos métodos para os steps adicionais
    public static void clicarBtnWishlist() {
        log.info("Clicando no botao 'Favorites'");
        acoes().click(loginPage().getBtnWishlist());
    }

    public static void clicarBtnVoltar() {
        log.info("Clicando no botao 'Voltar'");
        acoes().click(loginPage().getBtnVoltar());
    }

    public static void validarNomeUsuario() throws IOException {
        String nomeCompleto = UsuarioManager.getLastName() + " " + UsuarioManager.getFirstName();
        log.info("Validando nome do usuario " + nomeCompleto);
        acoes().waitForVisibility(loginPage().getTxtUserName(nomeCompleto));
        PrintScreen.screenshot("validar_nome_usuario");
    }

    public static void validarPhoneNumberUsuario() throws IOException {
        String userPhone = UsuarioManager.getPhoneNumber();
        log.info("Validando phone number do usuario: {}", userPhone);
        acoes().waitForVisibility(loginPage().getTxtUserPhone(userPhone));
        PrintScreen.screenshot("validacao_phone_usuario");
    }

    public static void validarEmailUsuario() throws IOException {
        String email = UsuarioManager.getEmail();
        log.info("Validando email do usuario: {}", email);
        acoes().waitForVisibility(loginPage().getTxtUserEmail(email));
        PrintScreen.screenshot("validacao_email_usuario");
    }

    public static void clicarBtnEditProfile() {
        log.info("Clicando no botao 'Edit Profile'");
        acoes().click(loginPage().getBtnEditProfile());
    }

    public static void validarFirstNameEditProfile() throws IOException {
        log.info("Validando First Name no Edit Profile");
        acoes().waitForVisibility(loginPage().getTxtEditFirstName());
        PrintScreen.screenshot("validacao_firstname_edit");
    }

    public static void validarLastNameEditProfile() throws IOException {
        log.info("Validando Last Name no Edit Profile");
        acoes().waitForVisibility(loginPage().getTxtEditLastName());
        PrintScreen.screenshot("validacao_lastname_edit");
    }

    public static void validarPhoneNumberEditProfile() throws IOException {
        log.info("Validando Phone Number no Edit Profile");
        acoes().waitForVisibility(loginPage().getTxtEditPhone());
        PrintScreen.screenshot("validacao_phone_edit");
    }

    public static void validarEmailEditProfile() throws IOException {
        log.info("Validando Email no Edit Profile");
        acoes().waitForVisibility(loginPage().getTxtEditEmail());
        PrintScreen.screenshot("validacao_email_edit");
    }

    public static void clicarBtnLogout() {
        log.info("Clicando no botao 'Logout'");
        acoes().click(loginPage().getBtnLogout());
    }

    public static void clicarBtnYes() {
        log.info("Clicando no botao 'Yes'");
        acoes().click(loginPage().getBtnYes());
    }

    // Métodos adicionais para validação de dados do usuário
    public static void validarNomeUsuarioProfile() throws IOException {
        log.info("Validando nome do usuario na tela Profile");
        String nomeCompleto = UsuarioManager.getFirstName() + " " + UsuarioManager.getLastName();
        String xpathNome = String.format("//android.widget.TextView[@text='%s']", nomeCompleto);
        WebElement nomeElement = Hooks.driver.findElement(By.xpath(xpathNome));
        log.info("Nome esperado: {}", nomeCompleto);
        log.info("Nome encontrado: {}", nomeElement.getText());
        acoes().waitForVisibility(nomeElement);
        PrintScreen.screenshot("validar_nome_usuario_profile");
        assertTrue(nomeElement.isDisplayed(), "Nome do usuário não está visível na tela");
    }

    public static void validarTelefoneUsuarioProfile() throws IOException {
        log.info("Validando telefone do usuario na tela Profile");
        String telefone = UsuarioManager.getPhoneNumber();
        String telefoneTela = loginPage().getTxtUserPhone(telefone).getText();
        log.info("Telefone esperado: {}", telefone);
        log.info("Telefone encontrado: {}", telefoneTela);
        PrintScreen.screenshot("validar_telefone_usuario_profile");
        assertEquals(telefoneTela, telefone, "Telefone do usuário não corresponde ao esperado");
    }

    public static void validarEmailUsuarioProfile() throws IOException {
        log.info("Validando email do usuario na tela Profile");
        String email = UsuarioManager.getEmail();
        String emailTela = loginPage().getTxtUserEmail(email).getText();
        log.info("Email esperado: {}", email);
        log.info("Email encontrado: {}", emailTela);
        PrintScreen.screenshot("validar_email_usuario_profile");
        assertEquals(emailTela, email, "Email do usuário não corresponde ao esperado");
    }

    public void clicarBotaoEditProfile() {
        log.info("Clicando no botao 'Edit Profile'");
        acoes().click(loginPage().getBtnEditProfile());
    }

    public static void validarDadosUsuario() throws IOException {
        log.info("Validando dados do usuario");
        String nomeCompleto = UsuarioManager.getLastName() + " " + UsuarioManager.getFirstName();
        String userPhone = UsuarioManager.getPhoneNumber();
        String email = UsuarioManager.getEmail();
        
        acoes().waitForVisibility(loginPage().getTxtUserName(nomeCompleto));
        acoes().waitForVisibility(loginPage().getTxtUserPhone(userPhone));
        acoes().waitForVisibility(loginPage().getTxtUserEmail(email));
        PrintScreen.screenshot("validacao_dados_usuario");
    }

    public static void validarDadosEditados() throws IOException {
        log.info("Validando dados editados do usuario");
        String nomeCompleto = UsuarioManager.getLastName() + " " + UsuarioManager.getFirstName();
        String userPhone = UsuarioManager.getPhoneNumber();
        String email = UsuarioManager.getEmail();
        
        String nomeTela = loginPage().getTxtUserName(nomeCompleto).getText();
        String telefoneTela = loginPage().getTxtUserPhone(userPhone).getText();
        String emailTela = loginPage().getTxtUserEmail(email).getText();
        
        assertTrue(nomeTela.equals(nomeCompleto), "Nome não confere");
        assertTrue(telefoneTela.equals(userPhone), "Telefone não confere");
        assertTrue(emailTela.equals(email), "Email não confere");
        PrintScreen.screenshot("validacao_dados_editados");
    }
}
