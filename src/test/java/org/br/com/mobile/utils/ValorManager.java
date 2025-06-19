package org.br.com.mobile.utils;

import lombok.Getter;

/**
 * Classe utilitária para gerenciar valores durante a execução dos testes
 */
public class ValorManager {

    /**
     * -- GETTER --
     *  Obtém o valor atual
     *
     * @return String com o valor
     */
    @Getter
    private static String valor;
    /**
     * -- GETTER --
     *  Obtém o saldo atual
     *
     * @return String com o saldo
     */
    @Getter
    private static String saldo;
    /**
     * -- GETTER --
     *  Obtém o valor do limite atual
     *
     * @return String com o valor do limite
     */
    @Getter
    private static String valorLimite;

    /**
     * Define o valor atual
     * @param valor String com o valor
     */
    public static void setValor(String valor) {
        ValorManager.valor = valor;
    }

    /**
     * Define o saldo atual
     * @param saldo String com o saldo
     */
    public static void setSaldo(String saldo) {
        ValorManager.saldo = saldo;
    }

    /**
     * Define o valor do limite atual
     * @param valorLimite String com o valor do limite
     */
    public static void setValorLimite(String valorLimite) {
        ValorManager.valorLimite = valorLimite;
    }
    
    /**
     * Limpa todos os valores armazenados
     */
    public static void clear() {
        valor = null;
        saldo = null;
        valorLimite = null;
    }
} 