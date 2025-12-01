package org.com.fintech.test.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.cucumber.java.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.com.fintech.core.support.Context;

import java.io.File;
import java.io.IOException;
import java.net.Socket;

@Slf4j
public class Hooks {

    private static AppiumDriverLocalService server;
    @Getter
    public static AppiumDriver driver;

    // Controle: 'true' inicia o Appium automaticamente em outro terminal
    private static final boolean GERENCIAR_SERVIDOR_AUTOMATICAMENTE = true;

    @BeforeAll
    public static void setUpServer() {
        if (GERENCIAR_SERVIDOR_AUTOMATICAMENTE) {
            if (isServerRunning(4723)) {
                log.info("Servidor Appium ja esta em execucao na porta 4723. Utilizando instancia existente.");
            } else {
                log.info("Servidor Appium nao detectado. Inicializando em novo terminal...");
                try {
                    File batFile = new File("run_appium.bat");
                    // Remove /min to let user see the window. Added title "Appium Server"
                    String command = "cmd /c start \"Appium Server\" \"" + batFile.getAbsolutePath() + "\"";
                    Runtime.getRuntime().exec(command);

                    waitForServer(4723, 20); // Wait up to 20 seconds
                } catch (Exception e) {
                    log.error("Falha ao iniciar o Appium: " + e.getMessage());
                }
            }
        }
    }

    private static boolean isServerRunning(int port) {
        try (Socket socket = new Socket("127.0.0.1", port)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private static void waitForServer(int port, int timeoutSeconds) {
        log.info("Aguardando servidor Appium na porta " + port + "...");
        long endTime = System.currentTimeMillis() + (timeoutSeconds * 1000);
        while (System.currentTimeMillis() < endTime) {
            if (isServerRunning(port)) {
                log.info("Servidor Appium detectado!");
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
        log.error("Timeout: Servidor Appium nao respondeu na porta " + port + " apos " + timeoutSeconds + " segundos.");
    }

    @AfterAll
    public static void tearDownServer() {
        if (GERENCIAR_SERVIDOR_AUTOMATICAMENTE) {
            log.info("Mantendo servidor Appium em execucao para proximos testes (Conforme solicitado).");
        }
    }

    @Before
    public void setUpDriver(Scenario scenario) {
        log.info(scenario.getName());
        log.info(scenario.getId());
        log.info("Inicializando o driver");
        driver = org.com.fintech.test.utils.AppiumDriverHelper.getDriver();
        Context.inicializar(driver);
        String deviceName = driver.getCapabilities().getCapability("deviceName").toString();
        org.com.fintech.test.utils.HooksDados.setDeviceName(deviceName.replace(".", "").replace(":", "_"));
    }

    @After
    public void tearDownDriver(Scenario scenario) {
        if (driver != null) driver.quit();
        driver = null;
    }

}
