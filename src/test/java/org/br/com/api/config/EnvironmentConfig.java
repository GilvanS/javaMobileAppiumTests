package org.br.com.api.config;

import org.br.com.api.manager.TokenManager;
import org.br.com.api.utils.LogFormatter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentConfig {
    private static final String CONFIG_FILE = "src/test/resources/config.properties";

    public static void loadConfig() {
        try {

            Properties props = new Properties();
            FileInputStream file = new FileInputStream(CONFIG_FILE);
            props.load(file);
            file.close();

            String xrayToken = props.getProperty("xray.token");
            String testExecutionKey = props.getProperty("xray.test.execution.key");

            if (xrayToken == null || xrayToken.trim().isEmpty()) {
                throw new RuntimeException("Token do Xray nao encontrado no arquivo de configuracao");
            }

            if (testExecutionKey == null || testExecutionKey.trim().isEmpty()) {
                throw new RuntimeException("Chave de execucao de teste do Jira nao encontrada no arquivo de configuracao");
            }

            TokenManager.setXrayToken(xrayToken);
            TokenManager.setJiraTestExecutionKey(testExecutionKey);

        } catch (IOException e) {
            String errorMessage = "Erro ao carregar arquivo de configuracao: " + e.getMessage();
            LogFormatter.logStep(errorMessage);
            throw new RuntimeException(errorMessage, e);
        } catch (RuntimeException e) {
            LogFormatter.logStep("Erro na configuracao: " + e.getMessage());
            throw e;
        }
    }
} 