package org.com.fintech.test.utils;
import java.util.Collection;

import org.com.fintech.core.support.Context;
import org.com.fintech.test.sheets.login.LoginDataSheet;
import org.com.fintech.test.sheets.login.LoginModel;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.Setter;



public class HooksDados {


    @Getter
    private static String tagCenario;

    @Getter
    @Setter
    private static String deviceName;

    @Before
    public void pegarTagCenario(Scenario cenario) {
        tagCenario = extrairTagDoCenario(cenario.getSourceTagNames());
        carregarDadosDoCenario();
    }

    /**
     * Carrega os dados do cenário a partir da planilha e define no Context.
     */
    private void carregarDadosDoCenario() {
        if (tagCenario != null) {
            try {
                // Extrai o ID do cenário (ex: "CT-02.1" -> "02.1")
                String idCenario = tagCenario.replace("CT-", "");
                LoginDataSheet loginDataSheet = new LoginDataSheet(idCenario);
                LoginModel loginModel = loginDataSheet.getData();
                
                // Validação básica
                if (loginModel == null) {
                    System.err.println("ERRO: LoginModel é null após carregar dados do cenário: " + tagCenario);
                } else {
                    System.out.println("INFO: Dados carregados para cenário " + tagCenario + 
                        " - CPF: " + (loginModel.getCpf() != null ? "***" : "null") +
                        ", Email: " + (loginModel.getEmail() != null && !loginModel.getEmail().isEmpty() ? loginModel.getEmail() : "vazio/null"));
                }
                
                Context.setData(loginModel);
            } catch (Exception e) {
                System.err.println("Erro ao carregar dados do cenário: " + tagCenario);
                e.printStackTrace();
            }
        } else {
            System.err.println("AVISO: tagCenario é null. Não foi possível carregar dados.");
        }
    }


    /**
     * Metodo privado para extrair a TAG do cenario atual a partir da lista de nomes de tags.
     *
     * @param sourceTagNames A colecao de nomes de tags do cenario atual.
     * @return A TAG do cenario, sem o prefixo "@".
     */
    private String extrairTagDoCenario(Collection<String> sourceTagNames) {
        for (String tagName : sourceTagNames) {
            if (tagName.startsWith("@") && tagName.contains("CT-") && !tagName.equals("@feature")) {
                return tagName.substring(1); // Remove o "@" da TAG
            }
        }
        return null;
    }
}