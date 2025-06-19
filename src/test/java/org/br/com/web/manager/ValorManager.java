package org.br.com.web.manager;

public class ValorManager {

    private static ThreadLocal<String> valor = new ThreadLocal<String>();

    public static void setValor(String v){
        valor.set(v);
    }

    public static String getValor(){
        return valor.get();
    }

}
