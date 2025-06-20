package org.br.com.mobile.utils;

public class UsuarioManager {

    public static ThreadLocal<String> nomeMenu = new ThreadLocal<>();

    public static String getNomeMenu() {
        return nomeMenu.get();
    }

    public void setNomeMenu(String nome) {
        nomeMenu.set(nome);
    }

    public void clear() {
        nomeMenu.remove();
    }
}
