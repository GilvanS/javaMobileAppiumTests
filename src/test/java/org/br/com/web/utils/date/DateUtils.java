package org.br.com.web.utils.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static String proximoDia() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd");
        LocalDate date = LocalDate.now().plusDays(1);
        return date.format(formato);
    }

    public
    static String proximaSemana() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd");
        LocalDate date = LocalDate.now().plusWeeks(1);
        return date.format(formato);
    }

    public static void main(String[] args) {
        System.out.println(proximoDia());
        System.out.println(proximaSemana());

    }
}
