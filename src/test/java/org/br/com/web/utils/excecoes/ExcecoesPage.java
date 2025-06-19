package org.br.com.web.utils.excecoes;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
public class ExcecoesPage {

    public boolean tratarExcecao(WebElement element) {
        String elementoStr = element.toString().replace("Proxy element for: DefaultElementLocator ", "ELEMENTO: ");
        List<String> linhasElemento = quebrarTextoEmLinhas(elementoStr, 67);

        String mensagem =
                """
                +---------------------------------------------------------------------+
                | MOTIVO..: Não foi possível interagir com o elemento                 |
                +---------------------------------------------------------------------+
                """;

        for (String linha : linhasElemento) {
            // Remove espaços em branco extras no final da linha
            String linhaFormatada = String.format("| %-67s |\n", linha.trim());
            mensagem += linhaFormatada;
        }

        mensagem += "+---------------------------------------------------------------------+\n";
        System.err.println(mensagem);
        return true;
    }

    private List<String> quebrarTextoEmLinhas(String texto, int larguraMaxima) {
        if (texto == null || texto.isEmpty()) {
            return Arrays.asList("");
        }

        return Arrays.stream(texto.split("(?<=\\G.{"+larguraMaxima+"})"))
                .map(String::trim) // Remove espaços em branco extras no início e no fim de cada linha.
                .collect(Collectors.toList());
    }

}
