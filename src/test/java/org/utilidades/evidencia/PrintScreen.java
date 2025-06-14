package org.utilidades.evidencia;

import lombok.Getter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testes.Hooks;
import org.testes.HooksEvidencia;

import java.io.File;
import java.io.IOException;


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

        String filePath = "target/evidencias/" + Hooks.getDriver().getCapabilities().getCapability("deviceUDID") + "/" + HooksEvidencia.getNomeDaFeature() + "/" + HooksEvidencia.getIdExecucao() + "/" + HooksEvidencia.getNomeCenario() +"/" + "screenshot" + "/" + System.currentTimeMillis() + " - " + nomeArquivo +  ".png";
        File print = ((TakesScreenshot) Hooks.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(print, new File(filePath));
        File directory = new File(filePath);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }
}