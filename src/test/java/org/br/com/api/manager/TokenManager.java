package org.br.com.api.manager;

public class TokenManager {
    private static String token;
    private static String xrayToken;
    private static String jiraTestExecutionKey;

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        TokenManager.token = token;
    }

    public static String getXrayToken() {
        if (xrayToken == null) {
            throw new RuntimeException("Token do Xray não configurado");
        }
        return xrayToken;
    }

    public static void setXrayToken(String xrayToken) {
        TokenManager.xrayToken = xrayToken;
    }

    public static String getJiraTestExecutionKey() {
        if (jiraTestExecutionKey == null) {
            throw new RuntimeException("Chave de execução de teste do Jira não configurada");
        }
        return jiraTestExecutionKey;
    }

    public static void setJiraTestExecutionKey(String jiraTestExecutionKey) {
        TokenManager.jiraTestExecutionKey = jiraTestExecutionKey;
    }
}
