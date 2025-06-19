package org.br.com.web.utils.evidence;


import org.br.com.web.utils.hooks.HooksEvidencias;
import org.br.com.web.driver.Driver;
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
        String filePath = "evidences/" + Driver.caps().getBrowserName() + "/" +  HooksEvidencias.getNomeDaFeature() + "/" + HooksEvidencias.getNomeCenario() + "/" + HooksEvidencias.getIdEvidencia() + "/" + "screenshots" + "/" + System.currentTimeMillis() + "-" + fileName + ".png";
        File print = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(print, new File(filePath));
        File directory = new File(FileUtils.getTempDirectoryPath());
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}