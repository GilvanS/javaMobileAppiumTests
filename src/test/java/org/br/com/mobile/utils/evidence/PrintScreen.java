package org.br.com.mobile.utils.evidence;

import org.br.com.mobile.hooks.Hooks;
import org.br.com.mobile.hooks.HooksEvidence;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;


/**
 * Classe responsavel por capturar e salvar screenshots durante a execucao do teste.
 */
public class PrintScreen {

    /**
     * Metodo para capturar e salvar um screenshot com um nome de arquivo especifico.
     *
     * @param fileName O nome do arquivo para o screenshot.
     * @throws IOException Se ocorrer um erro ao salvar o screenshot.
     */
    public static void screenshot(String fileName) throws IOException, InterruptedException {
        Thread.sleep(1000);
        String filePath = "evidences/" + Hooks.getDriver().getCapabilities().getCapability("deviceUDID") + "/" + HooksEvidence.getNomeDaFeature() + "/" + HooksEvidence.getIdExecucao() + "/" + HooksEvidence.getNomeCenario() +"/" + "screenshot" + "/" + System.currentTimeMillis() + " - " + fileName +  ".png";
        File print = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(print, new File(filePath));
        File directory = new File(FileUtils.getTempDirectoryPath());
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}