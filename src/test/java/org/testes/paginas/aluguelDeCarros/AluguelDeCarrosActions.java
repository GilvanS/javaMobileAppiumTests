package org.testes.paginas.aluguelDeCarros;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testes.utils.Hooks.driver;

@Slf4j
public class AluguelDeCarrosActions {

    private static final Logger log = LoggerFactory.getLogger(AluguelDeCarrosActions.class);
    static PrintScreen printScreen = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());
    public static AluguelDeCarrosPage aluguelDeCarrosPage() {
        return MasterPageFactory.getPage(AluguelDeCarrosPage.class);
    }

    public static void clicarEPreencherCampoOndeVoceQuerRetirarSeuCarro(String retirar) throws InterruptedException {
        log.info("Retirar Seu Carro: " + retirar);
        acoes.click(aluguelDeCarrosPage().getBtnOndeVoceQuerRetirarSeuCarro());
        acoes.sendKeys(aluguelDeCarrosPage().getBtnOndeVoceQuerRetirarSeuCarro(), retirar);
        acoes.click (aluguelDeCarrosPage().getRetirarSaoPauloSP());
    }

    public static void clicarBtnCheckboxDevolverNoMesmoLocalDaRetirada() {
        log.info("Clicar no 'Checkbox' Devolver No Mesmo Local Da Retirada");
        acoes.click(aluguelDeCarrosPage().getBtnCheckboDevolverNoMesmoLocalDaRetirada());
    }

    public static void clicarEPreencherCampoOndeVoceQuerDevolcerSeuCarro(String devolver) {
        log.info("Destino " + devolver);
        acoes.click(aluguelDeCarrosPage().getBtnOndeVoceQuerDevolverSeuCarro ());
        acoes.sendKeys(aluguelDeCarrosPage().getBtnOndeVoceQuerDevolverSeuCarro(), devolver);
        acoes.click(aluguelDeCarrosPage().getDevolverFozDoIguacu());
    }

    public static void clicarBtnContinuar() {
        log.info("clicar no botão 'Continuar' na tela 'Aluguel de carros''");
        acoes.click(aluguelDeCarrosPage().getBtnContinuar());
    }

    public static void clicarBtnAlterarHorarioRetirada() {
        log.info("clico no botão 'Alterar Horario Retirada' na tela 'Aluguel de carros'");
        acoes.click(aluguelDeCarrosPage().getBtnRetiradaAlterarHorario());
    }

    public static void informoOHorarioRetirada() {
        log.info("clicar no botão 'Alterar Horario Retirada'");
        acoes.click(aluguelDeCarrosPage().getBtnSelecioneAsHoras());
    }

    public static void informoOsMinutosRetirada() {
        log.info("informoOsMinutosRetirada");
        acoes.click(aluguelDeCarrosPage().getBtnSelecioneOsMinutos());
    }

    public static void clicarBtnAlterarHorarioDevolucao() {
        log.info("clicar no botão 'Alterar Horario Devolucao'");
        acoes.click(aluguelDeCarrosPage().getBtnDevolucaoAlterarHorario());
    }

    public static void informoOHorarioDevolucao() {
        log.info("informoOHorarioDevolucao");
        acoes.click(aluguelDeCarrosPage().getBtnSelecioneAsHoras());
    }

    public static void clicarBtnOk() {
        log.info("clicar no botão 'Ok'");
        acoes.click(aluguelDeCarrosPage().getBtnOk());
    }

    public static void clicarBtnBuscarCarros() {
        log.info("clicar no botão 'Conferir' detalhes na tela 'Aluguel de carros'");
        acoes.click(aluguelDeCarrosPage().getBtnBuscarCarros());
    }

    public static void SelecionaroCarroToyota() throws InterruptedException {
        log.info("clicar no botão 'Conferir' detalhes na tela 'Aluguel de carros''");
        boolean found = swipeUntilElementVisible(
            org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Volkswagen Polo')]")
            , 7);
        if (!found) {
            throw new AssertionError("Elemento 'Volkswagen Polo' não encontrado após múltiplos swipes");
        }
        Thread.sleep(1000);
        acoes.click(driver.findElement(org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Volkswagen Polo')]")));
    }

    public static void validarLblVerRotas() throws InterruptedException {
        log.info("valido a exibição da frase 'Volkswagen Polo' na tela 'Aluguel de carros'");
        boolean found = swipeUntilElementVisible(
            aluguelDeCarrosPage().getBySelecionarOcarroVolkswagenPolo(), 7);
        if (!found) {
            throw new AssertionError("Elemento 'Volkswagen Polo' não encontrado após múltiplos swipes");
        }
    }

    public static void validarCarrosDisponiveis() {
        log.info("valido a exibição da frase 'Carros disponíveis' na tela 'Aluguel de carros'");
        boolean found = swipeUntilElementVisible(
            org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Ver detalhes')]")
            , 7);
        if (!found) {
            throw new AssertionError("Elemento 'Ver detalhes' não encontrado após múltiplos swipes");
        }
    }

    public static void validarLblVerDetalhes() throws InterruptedException {
        log.info("valido a exibição da frase 'Marcador do mapa' na tela 'Aluguel de carros'");
        boolean found = swipeUntilElementVisible(
            org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Ver detalhes')]")
            , 7);
        if (!found) {
            throw new AssertionError("Elemento 'Ver detalhes' não encontrado após múltiplos swipes");
        }
    }

    public static void validarLblVerMais() {
        log.info("validar a exibição da frase 'Ver mais' na tela 'Aluguel de carros'");
        boolean found = swipeUntilElementVisible(
            org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Ver mais')]")
            , 5);
        if (!found) {
            throw new AssertionError("Elemento 'Ver mais' não encontrado após múltiplos swipes");
        }
    }

    public static void clicarBtnVoltarAoTopo() {
        log.info("btnVoltarAoTopo");
        acoes.click(aluguelDeCarrosPage().getBtnVoltarAoTopo());
    }

    public static void clicarBtnReservar() {
        log.info("clico no botão 'Reservar' na tela 'Aluguel de carros'");
        acoes.click(aluguelDeCarrosPage().getBtnReservar());
    }

    public static void clicarBtnVerDetalhes() {
        log.info("btnVerDetalhes");
        acoes.click(aluguelDeCarrosPage().getLblVerDetalhes());
    }

    public static void btnCaracteristicas() throws InterruptedException {
        log.info("btnContinuar");
        Thread.sleep(500);
        acoes.click(aluguelDeCarrosPage().getBtnCaracteristicas());
    }

    public static void validarLblEscolherCarro() {
        log.info("validar a exibição da frase 'Escolher carro' na tela 'Aluguel de carros'");
        boolean found = swipeUntilElementVisible(
            org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Escolher carro')]")
            , 5);
        if (!found) {
            throw new AssertionError("Elemento 'Escolher carro' não encontrado após múltiplos swipes");
        }
    }

    public static void validarLblCarroEscolhido() {
        log.info("validar a exibição da frase 'Carro escolhido' na tela 'Aluguel de carros'");
        boolean found = swipeUntilElementVisible(
            org.openqa.selenium.By.xpath("//*[contains(@content-desc, 'Carro escolhido')]")
            , 5);
        if (!found) {
            throw new AssertionError("Elemento 'Carro escolhido' não encontrado após múltiplos swipes");
        }
    }

    // Método utilitário local para swipeUntilElementVisible
    public static boolean swipeUntilElementVisible(By by, int maxSwipes) {
        int swipes = 0;
        while (swipes < maxSwipes) {
            try {
                WebElement element = Hooks.getDriver().findElement(by);
                if (element.isDisplayed()) {
                    return true;
                }
            } catch (Exception e) {}
            acoes.swipeVertical();
            swipes++;
        }
        return false;
    }

}
