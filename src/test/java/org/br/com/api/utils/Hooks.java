package org.br.com.api.utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.extern.log4j.Log4j2;
import org.br.com.core.Context;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class Hooks {
    private static final List<String> scenarioResults = new ArrayList<>();
    Context context = new Context();
    private static Instant startTime = Instant.now();

    public Hooks() {
        this.context = new Context();
    }

    @Before
    public void setUp(Scenario scenario) {
        context.startContext(scenario);
    }

    @After
    public void tearDown(Scenario scenario) {
        String status = scenario.getStatus().name();
        LogFormatter.logStep(status + "\n");
        Context.scenarioResult(status);
    }
}

