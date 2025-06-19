package org.br.com.web.utils.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import lombok.Getter;

import java.util.*;

public class HooksDados {

    @Getter
    private static Map<String, String> tagsCenario = new HashMap<>();

    @Before
    public void pegarTagsCenario(Scenario cenario) {
        tagsCenario.clear();
        tagsCenario.putAll(extrairTagsDoCenario(cenario.getSourceTagNames()));
    }

    private Map<String, String> extrairTagsDoCenario(Collection<String> sourceTagNames) {
        Map<String, String> tags = new HashMap<>();
        String ctTag = null;
        String specificTag = null;

        for (String tagName : sourceTagNames) {
            if (tagName.startsWith("@CT-")) {
                ctTag = tagName.substring(1); // Remove o "@"
            } else if (tagName.startsWith("@") && !tagName.equals("@all") && !tagName.equals("@Home")) {
                specificTag = tagName.substring(1); // Remove o "@"
            }
        }
        if (ctTag != null && specificTag != null) {
            tags.put(ctTag, specificTag);
        }
        return tags;
    }

    public static String getTagCenario() {
        return tagsCenario.keySet().stream().findFirst().orElse(null);
    }

}