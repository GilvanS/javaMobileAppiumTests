package org.br.com.api.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataUtils {

    public static String getDataAtualFormatada() {
        LocalDate dataAtual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dataAtual.format(formatter);
    }

    public static String getHoraAtual() {
        LocalDateTime horaAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmssSSS");
        return horaAtual.format(formatter);
    }
}
