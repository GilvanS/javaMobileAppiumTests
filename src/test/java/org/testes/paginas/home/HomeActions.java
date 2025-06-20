package org.testes.paginas.home;

import lombok.SneakyThrows;
import org.testes.driver.page.MasterPageFactory;
import org.testes.driver.actions.PageBaseActions;
import org.utilidades.evidencia.PrintScreen;
import org.testes.utils.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


public class HomeActions {

    private static final Logger log = LoggerFactory.getLogger(HomeActions.class);

    static PageBaseActions acoes = new PageBaseActions(Hooks.getDriver());



}
