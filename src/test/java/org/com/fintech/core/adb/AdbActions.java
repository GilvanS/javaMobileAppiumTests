package org.com.fintech.core.adb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utilitário para executar comandos adb diretamente do Java.
 */
public class AdbActions {

    /**
     * Executa um comando adb shell genérico.
     * @param command comando a ser executado após 'adb shell'
     * @throws IOException se houver erro de execução
     */
    public static void runAdbShellCommand(String command) throws IOException {
        List<String> cmd = new ArrayList<>();
        cmd.add("adb");
        cmd.add("shell");
        cmd.addAll(Arrays.asList(command.split(" ")));
        ProcessBuilder pb = new ProcessBuilder(cmd);
        Process process = pb.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    /**
     * Executa um swipe via adb shell input swipe.
     * @param x1 coordenada inicial x
     * @param y1 coordenada inicial y
     * @param x2 coordenada final x
     * @param y2 coordenada final y
     * @throws IOException se houver erro de execução
     */
    public static void swipe(int x1, int y1, int x2, int y2) throws IOException {
        String cmd = String.format("input swipe %d %d %d %d", x1, y1, x2, y2);
        runAdbShellCommand(cmd);
    }

    /**
     * Executa um tap via adb shell input tap.
     * @param x coordenada x
     * @param y coordenada y
     * @throws IOException se houver erro de execução
     */
    public static void tap(int x, int y) throws IOException {
        String cmd = String.format("input tap %d %d", x, y);
        runAdbShellCommand(cmd);
    }
} 