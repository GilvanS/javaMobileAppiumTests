package org.br.com.api.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerar o relatório de execução dos testes
 * no formato Maven Surefire Report.
 */
public class TestReportGenerator {
    
    private final List<TestResult> testResults;
    private final String reportPath;
    private final TestReportTheme theme;
    
    public TestReportGenerator() {
        // Gera o nome do arquivo com a data atual
        String currentDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.reportPath = "log/" + currentDate + "_log_.txt";
        this.testResults = new ArrayList<>();
        this.theme = new TestReportTheme();
        
        // Cria o diretório log se não existir
        File logDir = new File("log");
        if (!logDir.exists()) {
            logDir.mkdirs();
        }
    }
    
    public void addTestResult(String testName, String status, long duration, String[] tags, String[] steps, String featureName, long[] stepDurations, String[] stepStatuses, String[] stepErrors) {
        testResults.add(new TestResult(testName, status, duration, tags, steps, featureName, stepDurations, stepStatuses, stepErrors));
    }
    
    public void generateReport() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(reportPath, true))) {
            // Cabeçalho
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.println("\n" + TestReportTheme.formatHeader(" Execução: " + timestamp));
            
            // Agrupa resultados por feature
            String currentFeature = null;
            int featureScenarioCount = 0;
            long totalDuration = 0;
            
            for (TestResult result : testResults) {
                String featureName = result.featureName != null ? result.featureName : "Feature não identificada";
                if (!featureName.equals(currentFeature)) {
                    if (currentFeature != null) {
                        writer.println();
                    }
                    currentFeature = featureName;
                    featureScenarioCount = 0;
                    writer.println(TestReportTheme.formatFeatureHeader(currentFeature));
                    writer.println("Total de cenários executados: " + countScenariosForFeature(featureName) + "\n");
                }
                
                writer.println(TestReportTheme.formatTestResult(
                    result.testName,
                    result.status,
                    result.duration,
                    result.steps,
                    result.stepDurations,
                    result.stepStatuses,
                    result.stepErrors
                ));
                
                featureScenarioCount++;
                totalDuration += result.duration;
            }
            
            // Rodapé com duração total
            writer.println(TestReportTheme.formatFooter(totalDuration));
            
        } catch (IOException e) {
            throw new RuntimeException("Erro ao gerar relatório: " + e.getMessage(), e);
        }
    }
    
    private int countScenariosForFeature(String featureName) {
        return (int) testResults.stream()
            .filter(result -> result != null && result.featureName != null && result.featureName.equals(featureName))
            .count();
    }
    
    private static class TestResult {
        final String testName;
        final String status;
        final long duration;
        final String[] tags;
        final String[] steps;
        final String featureName;
        final long[] stepDurations;
        final String[] stepStatuses;
        final String[] stepErrors;
        
        TestResult(String testName, String status, long duration, String[] tags, String[] steps, String featureName, long[] stepDurations, String[] stepStatuses, String[] stepErrors) {
            this.testName = testName;
            this.status = status;
            this.duration = duration;
            this.tags = tags;
            this.steps = steps;
            this.featureName = featureName;
            this.stepDurations = stepDurations;
            this.stepStatuses = stepStatuses;
            this.stepErrors = stepErrors;
        }
    }
} 