package org.br.com.mobile.utils;

import java.util.regex.Pattern;

public class SaldoUtils {
    
    /**
     * Verifica se o saldo é maior que dez reais
     * @param saldo String contendo o valor do saldo (ex: "R$ 15,50")
     * @return true se o saldo for maior que R$ 10,00
     */
    public static boolean saldoMaiorQueDez(String saldo) {
        if (saldo == null || saldo.trim().isEmpty()) {
            return false;
        }
        
        // Remove caracteres não numéricos exceto vírgula e ponto
        String saldoLimpo = saldo.replaceAll("[^0-9,.]", "");
        
        // Converte vírgula para ponto para parsing
        saldoLimpo = saldoLimpo.replace(",", ".");
        
        try {
            double valor = Double.parseDouble(saldoLimpo);
            return valor > 10.0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    /**
     * Verifica se o saldo está zerado
     * @param saldo String contendo o valor do saldo
     * @return true se o saldo for R$ 0,00 ou similar
     */
    public static boolean saldoZerado(String saldo) {
        if (saldo == null || saldo.trim().isEmpty()) {
            return true;
        }
        
        // Remove caracteres não numéricos exceto vírgula e ponto
        String saldoLimpo = saldo.replaceAll("[^0-9,.]", "");
        
        // Converte vírgula para ponto para parsing
        saldoLimpo = saldoLimpo.replace(",", ".");
        
        try {
            double valor = Double.parseDouble(saldoLimpo);
            return valor == 0.0;
        } catch (NumberFormatException e) {
            return true;
        }
    }
} 