package org.br.com.api.utils;

import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Log4j2
public class LogFormatter {

    private static final String BRANCH = "| ";
    private static final String LAST_BRANCH = "'-- ";
    private static final String FIRST_BRANCH = "+-- ";


    public static void logScenario(String scenarioName) {
        log.info(FIRST_BRANCH + scenarioName);
    }

    public static void logStep(String stepDescription) {
        log.info(BRANCH + LAST_BRANCH + stepDescription);
    }

    public static void logError(String errorMessage) {
        log.error(BRANCH + LAST_BRANCH + "ERRO: " + errorMessage);
    }

    public static void logAssertionError(AssertionError error) {
        StringBuilder errorLog = new StringBuilder();
        errorLog.append(BRANCH).append(LAST_BRANCH).append("ASSERTION ERROR: ").append(error.getMessage()).append("\n");
        
        // Adiciona o stack trace formatado
        for (StackTraceElement element : error.getStackTrace()) {
            errorLog.append(BRANCH).append("                                         ").append(element.toString()).append("\n");
        }
        
        log.error(errorLog.toString());
    }
} 