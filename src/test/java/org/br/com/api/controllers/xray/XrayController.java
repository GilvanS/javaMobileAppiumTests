package org.br.com.api.controllers.xray;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.br.com.api.manager.TokenManager;
import org.br.com.api.utils.DataUtils;
import org.br.com.api.utils.LogFormatter;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static io.restassured.RestAssured.given;

public class XrayController {
    private static final Log log = LogFactory.getLog(XrayController.class);
    private Response response;
    private static final String XRAY_BASE_URL = "https://xray.cloud.getxray.app";
    private static final String XRAY_JUNIT_ENDPOINT = "/api/v2/import/execution/junit";
    private static final String XRAY_CUCUMBER_ENDPOINT = "/api/v2/import/execution/cucumber";

    public XrayController() {
        response = null;
    }

    public void uploadReportToXray(String filePath) {
        if (filePath.toLowerCase().endsWith(".json")) {
            uploadJsonReportToXray(filePath);
        } else if (filePath.toLowerCase().endsWith(".xml")) {
            uploadXmlReportToXray(filePath);
        } else {
            throw new IllegalArgumentException("Formato de arquivo nao suportado. Use .json ou .xml");
        }
    }

    public void uploadJsonReportToXray(String jsonFilePath) {
        try {
            String token = TokenManager.getXrayToken();
            String testExecKey = TokenManager.getJiraTestExecutionKey().trim();
            File jsonFile = new File(jsonFilePath);

            String jsonContent = Files.readString(jsonFile.toPath(), java.nio.charset.StandardCharsets.UTF_8);

            this.response = given()
                    .contentType(ContentType.JSON)
                    .baseUri(XRAY_BASE_URL)
                    .header("Authorization", "Bearer " + token)
                    .header("Accept", "application/json")
                    .queryParam("testExecKey", testExecKey)
                    .body(jsonContent)
                    .when()
                    .post(XRAY_CUCUMBER_ENDPOINT)
                    .then()
                    .extract()
                    .response();

            if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
                LogFormatter.logStep("Xray: " + response.getBody().asString() + "\n");
                moveToBackup(jsonFilePath);
            } else {
                throw new RuntimeException("Falha ao enviar relatorio JSON para Xray. Status: " + response.getStatusCode() +
                        "\nResposta: " + response.getBody().asString());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar relatorio JSON para Xray: " + e.getMessage(), e);
        }
    }

    private void uploadXmlReportToXray(String xmlFilePath) {
        try {
            String token = TokenManager.getXrayToken();
            String testExecKey = TokenManager.getJiraTestExecutionKey().trim();
            File xmlFile = new File(xmlFilePath);

            String xmlContent = Files.readString(xmlFile.toPath(), java.nio.charset.StandardCharsets.UTF_8);

            this.response = given()
                    .contentType(ContentType.XML)
                    .baseUri(XRAY_BASE_URL)
                    .header("Authorization", "Bearer " + token)
                    .header("Accept", "application/json")
                    .queryParam("testExecKey", testExecKey)
                    .body(xmlContent)
                    .when()
                    .post(XRAY_JUNIT_ENDPOINT)
                    .then()
                    .extract()
                    .response();

            if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
                log.info("Relatório XML enviado com sucesso para o Xray. Status: " + response.getStatusCode());
                moveToBackup(xmlFilePath);
            } else {
                throw new RuntimeException("Falha ao enviar relatório XML para Xray. Status: " + response.getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar relatório XML para Xray: " + e.getMessage(), e);
        }
    }

    private void moveToBackup(String filePath) {
        try {
            Path sourcePath = Paths.get(filePath);
            Path backupBaseDir = Paths.get(sourcePath.getParent().toString(), "backup");
            Path backupDateDir = backupBaseDir.resolve(DataUtils.getDataAtualFormatada());

            if (!Files.exists(backupBaseDir)) {
                Files.createDirectory(backupBaseDir);
            }

            if (!Files.exists(backupDateDir)) {
                Files.createDirectory(backupDateDir);
            }

            Path backupPath = backupDateDir.resolve(sourcePath.getFileName());
            Files.move(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao mover arquivo para backup: " + e.getMessage(), e);
        }
    }

    public void validarStatusCode(int statusCode) {
        if (this.response.getStatusCode() != statusCode) {
            String errorMessage = String.format("StatusCode esperado: %d, recebido: %d. Resposta: %s",
                    statusCode, this.response.getStatusCode(), this.response.getBody().asString());
            throw new RuntimeException(errorMessage);
        }
    }
} 