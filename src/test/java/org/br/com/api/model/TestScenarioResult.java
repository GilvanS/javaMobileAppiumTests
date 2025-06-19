package org.br.com.api.model;

public class TestScenarioResult {
    private String scenarioName;
    private String status;
    private long durationMillis;
    private String capturedOutput;
    private String tags;

    public TestScenarioResult(String scenarioName, String status, long durationMillis, String capturedOutput, String tags) {
        this.scenarioName = scenarioName;
        this.status = status;
        this.durationMillis = durationMillis;
        this.capturedOutput = capturedOutput;
        this.tags = tags;
    }

    // Getters
    public String getScenarioName() { return scenarioName; }
    public String getStatus() { return status; }
    public long getDurationMillis() { return durationMillis; }
    public String getCapturedOutput() { return capturedOutput; }
    public String getTags() { return tags; }
}