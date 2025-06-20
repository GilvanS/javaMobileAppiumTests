package org.utilidades.evidencia;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testes.utils.Hooks;
import org.testes.utils.HooksEvidencia;


/**
 * Classe responsavel por capturar e salvar screenshots durante a execucao do teste.
 */
public class PrintScreen {

     /**
     * Metodo para capturar e salvar um screenshot com um nome de arquivo especifico.
     *
     * @param nomeArquivo O nome do arquivo para o screenshot.
     * @throws IOException Se ocorrer um erro ao salvar o screenshot.
     */
    public static void screenshot(String nomeArquivo) throws IOException {

        String deviceUDID = Hooks.getDriver().getCapabilities().getCapability("deviceUDID").toString().replace(":", "_").replace(".", "");
        String filePath = "target/evidencias/" + deviceUDID + "/" + HooksEvidencia.getNomeDaFeature() + "/" + HooksEvidencia.getIdExecucao() + "/" + HooksEvidencia.getNomeCenario() +"/" + "screenshot" + "/" + System.currentTimeMillis() + " - " + nomeArquivo +  ".png";
        
        // Criar diretórios pai se não existirem
        File screenshotFile = new File(filePath);
        File parentDir = screenshotFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }
        
        File print = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(print, screenshotFile);
    }
}