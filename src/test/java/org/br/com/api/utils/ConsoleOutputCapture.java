// src/main/java/org/br/com/api/utils/ConsoleOutputCapture.java
package org.br.com.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class ConsoleOutputCapture {
    // Mapa para armazenar o buffer de output por thread
    private static ThreadLocal<ByteArrayOutputStream> outputStreamThreadLocal = ThreadLocal.withInitial(ByteArrayOutputStream::new);
    private static PrintStream originalOut = System.out;
    private static PrintStream originalErr = System.err;

    public static void startCapture() {
        // Redireciona System.out e System.err para um PrintStream que escreve no buffer da thread atual
        System.setOut(new PrintStream(outputStreamThreadLocal.get()));
        System.setErr(new PrintStream(outputStreamThreadLocal.get()));
    }

    public static void stopCapture() {
        // Restaura os streams originais
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    public static String getCapturedOutput() {
        // Retorna o conteúdo do buffer da thread atual
        return outputStreamThreadLocal.get().toString();
    }

    public static void clearCapture() {
        // Limpa o buffer da thread atual
        outputStreamThreadLocal.get().reset();
    }

    public static void removeThreadBuffer() {
        // Remove o buffer da thread quando ela não for mais necessária (geralmente ao final do teste)
        outputStreamThreadLocal.remove();
    }
}