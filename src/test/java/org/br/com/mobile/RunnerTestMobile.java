package org.br.com.mobile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.br.com.api.config.EnvironmentConfig;
import org.br.com.api.controllers.xray.XrayController;
import org.br.com.api.utils.DataUtils;
import org.br.com.core.Context;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.time.Instant;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/mobile",
        glue = {"org.br.com.mobile"},
        tags = "@CT-2001",
        plugin = {
                "json:reports/reports.json",
        },
        publish = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        monochrome = true
)
public class RunnerTestMobile {
    private static String data;
    private static Instant startTime = Instant.now();
    private static Context context = new Context();

    @BeforeClass
    public static void setup() {
        EnvironmentConfig.loadConfig();
        data = DataUtils.getHoraAtual();
        context = new Context();
    }

    @AfterClass
    public static void after() {
//        long totalDuration = Duration.between(startTime, Instant.now()).toMillis();
//        context.finishedContext(totalDuration);
//        try {
//            renameFile("reports/reports.json", "reports/" + data + ".json");
//            XrayController xrayController = new XrayController();
//            xrayController.uploadReportToXray("reports/" + data + ".json");
//        } catch (Exception e) {
//            throw new RuntimeException("Erro ao processar relatorios: " + e.getMessage(), e);
//        }
    }

    private static void renameFile(String oldPath, String newPath) throws Exception {
        Path source = Paths.get(oldPath);
        Path target = Paths.get(newPath);
        Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}