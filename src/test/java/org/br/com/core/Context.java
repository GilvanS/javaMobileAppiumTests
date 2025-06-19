package org.br.com.core;

import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.br.com.api.utils.LogFormatter;
import org.br.com.web.utils.hooks.HooksEvidencias;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Context {

    private static int totalScenarios = 0;
    private static int passedScenarios = 0;
    private static int failedScenarios = 0;
    private static int skippedScenarios = 0;

    public void startContext(Scenario scenario) {

        System.out.println("\n\n==================================== Execucao: " + getCurrentDateTime() + " ====================================");
        String nomeDaFeature = HooksEvidencias.extrairNomeFeature(scenario);
        System.out.println("\nFeatue: " + nomeDaFeature);
        System.out.println(scenario.getId() + "\n");

        String scenarioName = scenario.getName();
        LogFormatter.logScenario(scenarioName);
    }

    public void finishedContext(long totalDuration) {
        System.out.println("\n");
        System.out.println("========================================== Resumo da Execucao ==========================================\n");
        System.out.printf("Scenario(s): " + totalScenarios + "\n" +
                "Passed(s): " + passedScenarios + "\n" +
                "Failure(s): " + failedScenarios + "\n" +
                "Skipped(s): " + skippedScenarios + "\n" +
                "Duration: " + formatDuration(totalDuration)
        + "\n\n");
    }

    private static String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private static String formatDuration(long duration) {
        if (duration < 1000) {
            return "0s";
        }
        return String.format("%.3fs", duration / 1000.0).replace(".", ",");
    }

    public static void scenarioResult(String status) {
        if (status.equalsIgnoreCase("FAILED")) {
            failedScenarios++;
        } else if (status.equalsIgnoreCase("PASSED")) {
            passedScenarios++;
        } else {
            skippedScenarios++;
        }
    }

}
