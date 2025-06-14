package org.testes.paginas.hotel;

import lombok.extern.slf4j.Slf4j;
import org.testes.driver.actions.PageBaseActions;
import org.testes.driver.page.MasterPageFactory;
import org.utilidades.evidencia.PrintScreen;

@Slf4j
public class HotelActions {

    static PrintScreen print = new PrintScreen();
    static PageBaseActions acoes = new PageBaseActions();
    public static HotelPage hotelPage(){
        return MasterPageFactory.getPage(HotelPage.class);
    }

    public static void validarLblSobreAHosedagem(){
        log.info("valido a exibição da mensagem Sobre a hosedagem na tela Hoteis");
        acoes.swipeDown(hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais(), hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais(), 5);
    }

    public static void validarLblVerMapas(){
        log.info("valido a exibição da mensagem Ver Mapas na tela Hoteis");
        acoes.swipeDown(hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais(), hotelPage().getLblEsteHotelEstaNoProgramaDeParceirosPreferenciais(), 5);
    }

}
