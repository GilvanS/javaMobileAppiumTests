package org.br.com.api.utils;

/**
 * Classe responsável por definir o tema e formatação do relatório de testes.
 * Baseado no padrão Maven Surefire Report.
 */
public class TestReportTheme {

    private static final String PASSED = " [OK] ";
    private static final String FAILED = " [XX] ";
    private static final String SKIPPED = " [??] ";
    private static final String ERROR = "[*] ";
    
    public static String formatTestResult(String testName, String status, long duration, String[] steps, long[] stepDurations, String[] stepStatuses, String[] stepErrors) {
        StringBuilder result = new StringBuilder();
        result.append("+-- ").append(testName).append("\n");
        
        for (int i = 0; i < steps.length; i++) {
            String step = steps[i];
            String stepStatus = stepStatuses[i];
            long stepDuration = stepDurations[i];
            String stepError = stepErrors[i];
            
            result.append("|  '-- [").append(stepStatus).append("] ").append(step);
            result.append("  - ").append(String.format("%.1fs", stepDuration / 1000.0)).append("\n");
            
            if (stepStatus.equals("FAILED") && stepError != null && !stepError.isEmpty()) {
                result.append("|  |\n"); // Adiciona linha com pipe e traço
                String[] errorLines = stepError.split("\n");
                boolean isFirstLine = true;
                for (String line : errorLines) {
                    if (isFirstLine) {
                        result.append("|  '------").append(line).append("\n");
                        isFirstLine = false;
                    } else {
                        result.append("|           ").append(line).append("\n");
                    }
                }
                result.append("|\n"); // Adiciona linha com pipe após a exceção
            }
        }
        
        result.append("|\n");
        result.append("|**").append(status).append("**\n");
        result.append("|Duration: ").append(String.format("%.1fs", duration / 1000.0)).append("\n");
        result.append("|_________\n");
        
        return result.toString();
    }
    
    private static String getStatusSymbol(String status) {
        switch (status.toUpperCase()) {
            case "PASSED":
            case "PASS":
                return PASSED;
            case "FAILED":
            case "FAIL":
                return FAILED;
            case "SKIPPED":
            case "SKIP":
                return SKIPPED;
            default:
                return ERROR;
        }
    }
    
    private static String formatDuration(long duration) {
        if (duration < 1000) {
            return duration + "ms";
        }
        return String.format("%.3fs", duration / 1000.0);
    }
    
    private static String formatTotalDuration(long duration) {
        if (duration < 60000) { // menos de 1 minuto
            return String.format("%.2fs", duration / 1000.0);
        } else {
            long minutes = duration / 60000;
            long seconds = (duration % 60000) / 1000;
            return String.format("%dm %ds", minutes, seconds);
        }
    }
    
    public static String formatHeader(String title) {
        return String.format("================== %s ==================\n", title);
    }
    
    public static String formatFooter(long totalDuration) {
        return String.format("\nTOTAL DURATION: %s\n\n===================================== Fim ======================================\n\n",
            formatTotalDuration(totalDuration));
    }
    
    public static String formatFeatureHeader(String featureName) {
        return String.format("\nFeature: %s\n", featureName);
    }
    
    public static String formatTags(String[] tags) {
        if (tags == null || tags.length == 0) {
            return "";
        }
        return "Tags: " + String.join(", ", tags) + "\n";
    }
} 