package org.br.com.web.utils.hooks;


import io.cucumber.java.*;
import lombok.Getter;


import io.cucumber.core.backend.TestCaseState;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;


import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.extern.log4j.Log4j2;
import org.br.com.web.driver.Driver;
import org.br.com.web.manager.ValorManager;
import org.br.com.web.utils.evidence.PrintScreen;
import org.br.com.web.utils.evidence.GeradorDocx;

@Log4j2
/**
 * Classe responsavel por gerenciar e fornecer funcionalidades para captura de evidencias durante a execucao dos testes.
 */
public class HooksEvidencias {

    @Getter
    private static Scenario scenario;

    @Getter
    private static Status statusCenario;

    @Getter
    private static String dataHoraInicio;

    @Getter
    private static String dataHoraTermino;

    @Getter
    private static String nomeDaFeature;

    @Getter
    private static String nomeCenario;

    @Getter
    private static String nomeEtapas;

    @Getter
    private static String IdEvidencia;


    public static List<String> pegarEtapasCenario(Scenario scenario) {
        List<String> stepsList = new ArrayList<>();

        try {
            Field delegate = scenario.getClass().getDeclaredField("delegate");
            delegate.setAccessible(true);
            TestCaseState testCaseState = (TestCaseState) delegate.get(scenario);

            Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
            testCaseField.setAccessible(true);
            TestCase testCase = (TestCase) testCaseField.get(testCaseState);

            List<PickleStepTestStep> testSteps = testCase.getTestSteps().stream().filter(step -> step instanceof PickleStepTestStep).map(step -> (PickleStepTestStep) step).collect(Collectors.toList());

            for (PickleStepTestStep testStep : testSteps) {
                String stepText = testStep.getStep().getKeyword() + testStep.getStep().getText();
                stepsList.add(stepText);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return stepsList;
    }

    /**
     * Metodo executado antes de cada teste para inicializar o cenario e excluir evidencias existentes.
     *
     * @param scenario O objeto Scenario que representa o cenario atual.
     */
    @Before
    public static void antesDoTeste(Scenario scenario) {
        nomeDaFeature = extrairNomeFeature(scenario);
        HooksEvidencias.scenario = scenario;
        nomeEtapas = String.valueOf(pegarEtapasCenario(scenario));
        nomeCenario = scenario.getName();
        IdEvidencia = scenario.getId();
        dataHoraInicio = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    }

    /**
     * Metodo executado apos a execucao de cada cenario para capturar e anexar evidencias ao relatorio.
     *
     * @param scenario O objeto Scenario que representa o cenario atual.
     */
    @After
    public void anexarEvidencias(Scenario scenario) {
        boolean isApiScenario = scenario.getSourceTagNames().stream()
                .anyMatch(tag -> tag.toUpperCase().contains("API"));

        if (isApiScenario) {
            return;
        }

        statusCenario = scenario.getStatus();

        try {
            if (scenario.isFailed()) {
                dataHoraTermino = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                GeradorDocx.EvidenciasDocx(getNomeCenario());
                Path dirDocx = Paths.get("evidences/" + Driver.caps().getBrowserName() + "/" +  HooksEvidencias.getNomeDaFeature() + "/" + HooksEvidencias.getNomeCenario() + "/" + HooksEvidencias.getIdEvidencia() + "/" + nomeCenario + ".docx");
                byte[] docx = Files.readAllBytes(dirDocx);
                scenario.attach(docx, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", getNomeCenario());

            } else {
                dataHoraTermino = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                GeradorDocx.EvidenciasDocx(getNomeCenario());
                Path dirDocx = Paths.get("evidences/" + Driver.caps().getBrowserName() + "/" +  HooksEvidencias.getNomeDaFeature() + "/" + HooksEvidencias.getNomeCenario() + "/" + HooksEvidencias.getIdEvidencia() + "/" + nomeCenario + ".docx");
                byte[] docx = Files.readAllBytes(dirDocx);
                scenario.attach(docx, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", getNomeCenario());
            }

        } catch (IOException e) {
        }
    }


    @AfterStep
    public void print(Scenario scenario) throws IOException, InterruptedException {
        boolean isApiScenario = scenario.getSourceTagNames().stream()
                .anyMatch(tag -> tag.toUpperCase().contains("API"));

        if (!isApiScenario) {
            PrintScreen.screenshot("teste");
        }
    }



    /**
     * Metodo privado para extrair o nome da feature associada ao cenario.
     *
     * @param scenario O objeto Scenario que representa o cenario atual.
     * @return O nome da feature.
     */
    public static String extrairNomeFeature(Scenario scenario) {
        String featureUri = String.valueOf(scenario.getUri());
        int lastSlashIndex = featureUri.lastIndexOf("/");
        String featureFileName = featureUri; // Começa com a URI completa por segurança

        if (lastSlashIndex != -1) {
            featureFileName = featureUri.substring(lastSlashIndex + 1);
        }

        if (featureFileName.endsWith(".feature")) {
            featureFileName = featureFileName.substring(0, featureFileName.lastIndexOf(".feature"));
        }

        return featureFileName;
    }
}
