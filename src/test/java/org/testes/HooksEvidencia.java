package org.testes;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.utilidades.evidencia.GeradorDocx;
import org.utilidades.evidencia.PrintScreen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class HooksEvidencia {

    @Getter
    private static Scenario scenario;
    @Getter
    private static String nomeDaFeature;
    @Getter
    private static String nomeCenario;
    @Getter
    private static String idExecucao;
    @Getter
    private static Status statusCenario;
    @Getter
    private static String dataHoraInicio;
    @Getter
    private static String dataHoraTermino;

    @Before
    public static void coletarDadosCenario(Scenario scenario){

        nomeDaFeature = extrairNomeFeature(scenario);
        nomeCenario = scenario.getName();
        idExecucao = scenario.getId();
        HooksEvidencia.scenario = scenario;
        dataHoraInicio = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));

    }

    @After
    public void anexarEvidencias(Scenario scenario) {
        statusCenario = scenario.getStatus();
        String diretorioDocx = "target/evidencias/" + Hooks.getDriver().getCapabilities().getCapability("deviceUDID") + "/" + HooksEvidencia.getNomeDaFeature() + "/" + HooksEvidencia.getIdExecucao() + "/" + "/" + HooksEvidencia.getNomeCenario() + "/"+ HooksEvidencia.getNomeCenario() + ".docx";

        try {
            if (scenario.isFailed()) {
                dataHoraTermino = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                PrintScreen.screenshot("falhou");
                log.info(String.valueOf(HooksEvidencia.getStatusCenario()));
                GeradorDocx.EvidenciasDocx(getNomeCenario());
                Path dirDocx = Paths.get(diretorioDocx);
                byte[] docx = Files.readAllBytes(dirDocx);
                scenario.attach(docx, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", getNomeCenario());
            } else {
                dataHoraTermino = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
                log.info(String.valueOf(HooksEvidencia.getStatusCenario()));
                GeradorDocx.EvidenciasDocx(getNomeCenario());
                Path caminho = Paths.get(diretorioDocx);
                byte[] pdf = Files.readAllBytes(caminho);
                scenario.attach(pdf, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", getNomeCenario());
            }

        } catch (IOException e) {
        }

    }

    private static String extrairNomeFeature(Scenario scenario) {
        String featureName = String.valueOf(scenario.getUri());

        // Extraindo o nome do arquivo sem o caminho completo
        String fileName = featureName.substring(featureName.lastIndexOf("/") + 1);

        // Removendo a extensão usando expressão regular
        Pattern pattern = Pattern.compile("(.*)\\.(feature)");
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.matches()) {
            return matcher.group(1);
        } else {
            // Caso não encontre o padrão, retorna o nome do arquivo completo
            return fileName;
        }
    }
}
