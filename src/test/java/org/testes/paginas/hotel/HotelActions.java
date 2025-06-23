package org.testes.paginas.hotel;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.WebElement;
import org.testes.utils.Hooks;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.utilidades.dados.Usuario;


public class HotelActions {

    private static final Logger log = LoggerFactory.getLogger(HotelActions.class);

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());

    public static HotelPage hotelPage() {
        return MasterPageFactory.getPage(HotelPage.class);
    }

    public static void campoOndeVoceIraSeHospedar() {
        String hospedar = Usuario.getCidadeOrigem();
        log.info("Preencho o campo Onde você irá se hospedar?");
        acoes.click(hotelPage().getCampoOndeVoceIraSeHospedar());
        acoes.sendKeys(hotelPage().getCampoOndeVoceIraSeHospedar(), hospedar);
    }

    public static void selecionarDestino() {
        String destino = Usuario.getCidadeOrigem();
        log.info("Seleciono o destino: {}", destino);
        acoes.waitForElementToBeClickable(hotelPage().getDestinoBarcelona(), 5);
        acoes.click(hotelPage().getDestinoBarcelona(), 5);
    }

    public static void clicarBtnConfirmarDestino() {
        log.info("clico no botão Confirmar destino na tela Hoteis");
        acoes.click(hotelPage().getBtnConfirmarDestino());
    }

    public static void clicarBtnContinuar() {
        log.info("clico no botão Continuar na tela Defina os detalhes");
        acoes.click(hotelPage().getBtnContinuar());
    }

    public static void validarLblEscolhaAEstadia() {
        log.info("valido a exibição da frase Escolhar um parque na tela Ingressos");
        acoes.waitForVisibility(hotelPage().getLblEscolha());
        acoes.click(hotelPage().getLblEscolha());
    }

    @SneakyThrows
    public static void clicarBtnMarcadorDoMapa() {
        log.info("clico no botão Marcador do mapa na tela Hoteis");
        acoes.verticalSwipeDownAndSearch(hotelPage().getBtnMarcadorDoMapa(), 5);
        acoes.click(hotelPage().getBtnMarcadorDoMapa());
        clicarBtnFechar();
    }

    @SneakyThrows
    public static void validarHotelArcelon() {
        log.info("Validando exibicao do hotel Arcelon");
        acoes.verticalSwipeDownAndSearch(hotelPage().getBtnHotelArcelon(), 10);
        acoes.click(hotelPage().getBtnHotelArcelon());
    }

    public static void clicarBtnFechar() {
        log.info("clico no botão Fechar na tela Hotel");
        acoes.click(hotelPage().getBtnFechar());
    }

    public static void validarHotelByName() {
        String hotel = Usuario.getHotelSelecionado();
        log.info("Validando exibicao do hotel {}", hotel);
        acoes.waitForVisibility(hotelPage().getHotelByName(hotel));
        acoes.click(hotelPage().getHotelByName(hotel));
    }

    public static void swipeLeftParaProximoHotel() {
        log.info("Deslizando para o próximo hotel");
        acoes.swipeHorizontal(false); // false = para a esquerda
        acoes.delay(1000);
    }

    @SneakyThrows
    public static void validarLblLerMais() {
        log.info("valido a exibição da frase Ler mais na tela Hoteis");
        acoes.verticalSwipeDownAndSearch(hotelPage().getLblLerMais(), 5);
    }

    @SneakyThrows
    public static void validarLblVerMais() {
        log.info("valido a exibição da frase Ver mais na tela Hoteis");
        acoes.verticalSwipeDownAndSearch(hotelPage().getLblVerMais(), 5);
    }

    @SneakyThrows
    public static void validarLblQuartosEscolhido() {
        log.info("valido a exibição da frase Quartos Escolhido na tela Hoteis");
        acoes.verticalSwipeDownAndSearch(hotelPage().getLblQuartoEscolhido(), 5);
    }

    @SneakyThrows
    public static void clicarBtnVoltarAoTopo() {
        log.info("clico no botão Voltar ao topo na tela Hoteis");
        acoes.verticalSwipeDownAndSearch(hotelPage().getBtnVoltarAoTopo(), 5);
        acoes.click(hotelPage().getBtnVoltarAoTopo());
    }

    @SneakyThrows
    public static void clicarBtnReservar() {
        log.info("clico no botão Reservar na tela Hoteis");
        acoes.verticalSwipeDownAndSearch(hotelPage().getBtnReservar(), 5);
        acoes.click(hotelPage().getBtnReservar());
        Thread.sleep(5000);
    }

    public static void clicarBtnVerResumo() {
        log.info("clico no botão Ver resumo na tela Checkout");
        acoes.click(hotelPage().getBtnVerResumo());
    }

    public static void clicarBtnCheckout() {
        acoes.click(hotelPage().getBtnCheckout(), 10);
    }
    // Swipe vertical até o elemento ficar visível ou atingir o máximo de tentativas
    public static void validarLblSobreAHosedagem() {
        log.info("valido a exibicao da mensagem Sobre a hospedagem na tela Hoteis");
        WebElement target =  hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais();
        int maxAttempts = 5;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                if (target.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                // Ignora se não está visível
            }
            acoes.swipeVertical();
            attempts++;
        }
    }

    // Swipe horizontal (exemplo: pode ser adaptado conforme necessidade real)
    public static void validarLblVerMapas() {
        log.info("valido a exibicao da mensagem Ver Mapas na tela Hoteis");
        // Exemplo: swipe para a direita até o elemento ficar visível
        WebElement target = hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais();
        int maxAttempts = 5;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                if (target.isDisplayed()) {
                    return;
                }
            } catch (Exception e) {
                // Ignora se não está visível
            }
            acoes.swipeHorizontal(true); // true = para a direita
            attempts++;
        }
    }

    public static void selecionarDatasCalendario(String dataInicio, String dataFim) {
        log.info("Selecionando data de início: " + dataInicio);
        acoes.waitForVisibility(hotelPage().getBtnDataInicio(dataInicio));
        acoes.click(hotelPage().getBtnDataInicio(dataInicio));
        acoes.delay(500);

        log.info("Selecionando data de fim: " + dataFim);
        acoes.waitForVisibility(hotelPage().getBtnDataFim(dataFim));
        acoes.click(hotelPage().getBtnDataFim(dataFim));
        acoes.delay(500);
    }

    public static void clicarNoDiaDoCalendario(String dia) {
        log.info("Clicando no dia '{}' no calendário de datas", dia);
        acoes.click(hotelPage().getBtnDataInicio(dia));
    }

    public static void selecionarDataInicio() {
        String data = Usuario.getDataInicio();
        log.info("Selecionando data de início {}", data);
        acoes.waitForVisibility(hotelPage().getBtnDataInicio(data));
        acoes.click(hotelPage().getBtnDataInicio(data));
        acoes.delay(500);
    }

    public static void selecionarDataFim() {
        String dataFim = Usuario.getDataFim();
        log.info("Selecionando data de fim: {}", dataFim);
        acoes.waitForVisibility(hotelPage().getBtnDataFim(dataFim));
        acoes.click(hotelPage().getBtnDataFim(dataFim));
        acoes.delay(500);
    }

}