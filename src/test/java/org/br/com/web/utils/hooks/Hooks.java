package org.br.com.web.utils.hooks;

import org.br.com.api.utils.LogFormatter;
import org.br.com.core.Context;
import org.br.com.web.driver.Driver;
import io.cucumber.java.*;
import lombok.extern.log4j.Log4j2;

import java.time.Instant;

@Log4j2
public class Hooks {
    private Context context = new Context();
    private static Instant startTime = Instant.now();

    public Hooks() {
        context = new Context();
    }

    @Before
    public void setUp(Scenario scenario) {
        startTime = Instant.now();
        context.startContext(scenario);
        Driver.abrirNav();
    }

    @After
    public void tearDown(Scenario scenario) {
        Driver.fecharNav();
        String status = scenario.getStatus().name();
        LogFormatter.logStep(status + "\n");
        Context.scenarioResult(status);
    }
}

