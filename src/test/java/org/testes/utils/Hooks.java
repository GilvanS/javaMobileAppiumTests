package org.testes.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hooks {

    private static AppiumDriverLocalService server;
    @Getter
    public static AppiumDriver driver;

    // Controle: Mude para 'false' se quiser iniciar o Appium manualmente em outro
    // terminal
    private static final boolean GERENCIAR_SERVIDOR_AUTOMATICAMENTE = true;

    @BeforeAll
    public static void setUpServer() {
        if (GERENCIAR_SERVIDOR_AUTOMATICAMENTE) {
            log.info("Inicializando o servidor do Appium (Logs em target/appium_server.log)");
            server = new AppiumServiceBuilder()
                    .usingPort(4723)
                    .withArgument(() -> "--base-path", "/wd/hub")
                    .withLogFile(new java.io.File("target/appium_server.log")) // Oculta logs do console
                    .build();
            server.start();
        }
    }

    @AfterAll
    public static void tearDownServer() {
        if (GERENCIAR_SERVIDOR_AUTOMATICAMENTE && server != null) {
            log.info("Finalizando o servidor do Appium");
            server.stop();
            server = null;
        }
    }

    @Before
    public void setUpDriver(Scenario scenario) {
        log.info(scenario.getName());
        log.info(scenario.getId());
        log.info("Inicializando o driver");
        driver = AppiumDriverHelper.getDriver();
        Context.inicializar(driver);
        String deviceName = driver.getCapabilities().getCapability("deviceName").toString();
        HooksDados.setDeviceName(deviceName.replace(".", "").replace(":", "_"));
    }

    @After
    public void tearDownDriver(Scenario scenario) {
        if (driver != null) driver.quit();
        driver = null;
    }

}
