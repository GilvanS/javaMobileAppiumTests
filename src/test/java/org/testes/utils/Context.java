package org.testes.utils;

import org.testes.driver.actions.PageBaseActions;

public class Context {

    private static final ThreadLocal<PageBaseActions> acoes = new ThreadLocal<>();

    public static PageBaseActions acoes() {
        return acoes.get();
    }

    public static void tearDown() {
        acoes.remove();
    }
}
