package org.com.fintech.test.sheets.login;

import org.com.fintech.test.sheets.ExcelDataReader;
import org.com.fintech.test.utils.GeradorDeCpf;
import org.com.fintech.test.utils.support.data.DataResource;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

public class LoginDataSheet {

    private static final String EXCEL_FILE_NAME = "MassaDados.xlsx";
    private static final String SHEET_NAME_CENARIOS = "TBL_CENARIOS";
    private static final String FIELD_ID_CENARIO = "ID_CENARIO";
    private static final String FIELD_ID_MASSA = "ID_MASSA";
    private static final String FIELD_CPF = "CPF";
    private static final String FIELD_SENHA = "SENHA";
    private static final String FIELD_ID_USUARIO_NA_PLANILHA = "ID";
    private static final String FIELD_EMAIL = "EMAIL";


    private final Map<String, String> scenarioData;

    public LoginDataSheet(String idScenario) {
        this.scenarioData = loadScenarioData("CT-" + idScenario);
    }

    private Map<String, String> loadScenarioData(String idCenarioCompleto) {
        String excelFilePath = DataResource.getPath(EXCEL_FILE_NAME);

        try (ExcelDataReader reader = new ExcelDataReader(excelFilePath, SHEET_NAME_CENARIOS)) {
            Map<String, String> data = reader.getRowData(FIELD_ID_CENARIO, idCenarioCompleto);
            if (data.isEmpty()) {
                throw new RuntimeException("Cenário não encontrado: Nenhuma linha na TBL_CENARIOS para o ID_CENARIO: " + idCenarioCompleto);
            }
            return data;
        } catch (IOException e) {
            System.err.println("ERRO: Não foi possível carregar dados do Excel para o cenário: " + idCenarioCompleto);
            e.printStackTrace();
            return Collections.emptyMap();
        }
    }

    public LoginModel getData() {
        String cpf = random(getField(FIELD_CPF));
        String senha = getField(FIELD_SENHA);
        String idUsuario = getField(FIELD_ID_USUARIO_NA_PLANILHA);
        String email = getField(FIELD_EMAIL);

        return LoginModel.builder()
                .cpf(cpf)
                .senha(senha)
                .idUsuario(idUsuario)
                .email(email)
                .build();
    }

    public String getEmail() {
        return getField(FIELD_EMAIL);
    }

    /**
     * Expõe o ID_MASSA para que outras classes DataSheet possam buscar dados relacionados.
     * Ex: new CadastroDataSheet(loginSheet.getIdMassa());
     */
    public String getIdMassa() {
        return getField(FIELD_ID_MASSA);
    }

    private String getField(String fieldName) {
        // Busca case-insensitive (ExcelDataReader converte tudo para maiúsculas)
        String fieldNameUpper = fieldName.toUpperCase();
        String value = scenarioData.get(fieldNameUpper);
        
        if (value == null || value.isEmpty()) {
            // Tenta buscar com o nome exato também
            value = scenarioData.get(fieldName);
        }
        
        return value != null ? value : "";
    }

    private String random(String field) {
        if ("RANDOM".equalsIgnoreCase(field)) {
            return GeradorDeCpf.gerar(); // Ou um gerador de e-mail aleatório
        }
        return field;
    }
}
