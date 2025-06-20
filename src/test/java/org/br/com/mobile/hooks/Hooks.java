package org.br.com.mobile.hooks;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.br.com.api.utils.LogFormatter;
import org.br.com.mobile.appium_driver.AppiumDriverHelper;

import java.time.Instant;

import org.br.com.core.Context;

@Slf4j
public class Hooks {

    private static AppiumDriverLocalService server;
    @Getter
    private static AppiumDriver driver;
    private Context context = new Context();
    private static Instant startTime = Instant.now();

    public Hooks() {
        context = new Context();
    }

    //    @BeforeAll
    public static void setUpServer() {
        log.info("Inicializando o servidor do Appium");
        server = new AppiumServiceBuilder()
                .usingPort(4723)
                .withArgument(() -> "--base-path", "/wd/hub")
                .build();
        server.start();
    }

//    @AfterAll
    public static void tearDownServer() {
        log.info("Finalizando o servidor do Appium");
        if (server != null) server.stop();
        server = null;
    }

    @Before
    public void setUpDriver(Scenario scenario) {
        startTime = Instant.now();
        context.startContext(scenario);
        LogFormatter.logStep("Inicializando o driver");
        driver = AppiumDriverHelper.getDriver();
    }

    @After
    public void tearDownDriver(Scenario scenario) {
        if (driver != null) driver.quit();
        driver = null;
        String status = scenario.getStatus().name();
        LogFormatter.logStep(status + "\n");
        Context.scenarioResult(status);
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}
