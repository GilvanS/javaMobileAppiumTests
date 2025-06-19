package org.br.com.mobile.utils.evidence;

import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.br.com.mobile.hooks.Hooks;
import org.br.com.mobile.hooks.HooksEvidence;
import org.br.com.mobile.utils.dataUsers.Users;


import java.io.*;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorDocx {


    /**
     * Metodo responsavel por gerar um arquivo .docx com evidencias.
     *
     * @param scenarioName o nome do cenario para o qual as evidencias estao sendo geradas
     */
    public static void EvidenciasDocx(String scenarioName) {
        String dirImagens = "evidences/" + Hooks.getDriver().getCapabilities().getCapability("deviceUDID") + "/" + HooksEvidence.getNomeDaFeature() + "/" + HooksEvidence.getIdExecucao() + "/" + HooksEvidence.getNomeCenario() +"/" + "screenshot";
        String dirDocx = "evidences/" + Hooks.getDriver().getCapabilities().getCapability("deviceUDID") + "/" + HooksEvidence.getNomeDaFeature() + "/" + HooksEvidence.getIdExecucao() + "/" + "/" + HooksEvidence.getNomeCenario() + "/"+ HooksEvidence.getNomeCenario() + ".docx";
        List<String> arquivoImagens = pegarImagensDiretorio(dirImagens);

        try {
            criarDocx(dirDocx, arquivoImagens);

        } catch (IOException | InvalidFormatException e) {
            e.printStackTrace();
            System.out.println("Nao foi possivel criar o documento " + dirDocx);

        }
    }


    private static List<String> pegarImagensDiretorio(String diretorio) {
        List<String> arquivoImagens = new ArrayList<>();

        File dir = new File(diretorio);
        File[] arquivos = dir.listFiles();

        if (arquivos != null) {
            // Ordenar os arquivos alfanumericamente
            Arrays.sort(arquivos, new Comparator<File>() {
                public int compare(File f1, File f2) {
                    return extrairNumeroArquivo(f1.getName()) - extrairNumeroArquivo(f2.getName());
                }

                //Extrai o número de um nome de arquivo no formato "nome_numero.extensao"
                int extrairNumeroArquivo(String nomeArquivo) {
                    int cont = 0;
                    try {
                        int s = nomeArquivo.indexOf('_') + 1;
                        int e = nomeArquivo.lastIndexOf('.');
                        String numeroNomeArquivo = nomeArquivo.substring(s, e);
                        cont = Integer.parseInt(numeroNomeArquivo);
                    } catch (Exception e) {

                    }
                    return cont;
                }
            });

            // Adicionar os arquivos ordenados à lista
            for (File arquivo : arquivos) {
                if (arquivo.isFile() && extensaoImagemArquivo(arquivo.getName())) {
                    arquivoImagens.add(arquivo.getAbsolutePath());
                }
            }
        }

        return arquivoImagens;
    }

    /**
     * Metodo responsavel por verificar se um arquivo tem uma extensao de imagem valida.
     *
     * @param nomeArquivo o nome do arquivo a ser verificado
     * @return true se o arquivo for uma imagem, false caso contrario
     */
    private static boolean extensaoImagemArquivo(String nomeArquivo) {
        return nomeArquivo.toLowerCase().endsWith(".png") || nomeArquivo.toLowerCase().endsWith(".jpg") || nomeArquivo.toLowerCase().endsWith(".jpeg") || nomeArquivo.toLowerCase().endsWith(".gif");
    }

    /**
     * Metodo responsavel por criar o arquivo .docx e preenche-lo com informacoes e imagens.
     *
     * @param docxFilePath o caminho do arquivo .docx a ser criado
     * @param imageFiles   uma lista de caminhos de arquivos para imagens a serem adicionadas ao documento
     * @throws IOException            se ocorrer um erro de E/S ao criar o arquivo .docx
     * @throws InvalidFormatException se o formato do arquivo .docx for invalido
     */
    private static void criarDocx(String docxFilePath, List<String> imageFiles) throws IOException, InvalidFormatException {


        try (FileInputStream dirEvidenciaModelo = new FileInputStream("src/test/resources/Evidencia Modelo.docx"); XWPFDocument templateDoc = new XWPFDocument(dirEvidenciaModelo); FileOutputStream fos = new FileOutputStream(docxFilePath)) {
            List<String> listaEtapas = pegarEtapasCenario(HooksEvidence.getScenario());

            LocalDate dataAtual = LocalDate.now();
            String textoDataAtual = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//
            trocarTexto(templateDoc, "cen", HooksEvidence.getNomeCenario());
            trocarTexto(templateDoc, "data", textoDataAtual);
            trocarTexto(templateDoc, "feature", HooksEvidence.getNomeDaFeature());
            trocarTexto(templateDoc, "inicio", HooksEvidence.getDataHoraInicio());
            trocarTexto(templateDoc, "massa", Users.getCpf());
            trocarTexto(templateDoc, "senha", Users.getSenha());
            trocarTexto(templateDoc, "fim", HooksEvidence.getDataHoraTermino());
            trocarTexto(templateDoc, "idExec", HooksEvidence.getIdExecucao());
            trocarTextoStatus(templateDoc, String.valueOf(HooksEvidence.getStatusCenario()));
            trocarTextoCap(templateDoc, "deviceManufacturer", "deviceModel", "deviceUDID", "platformName", "platformVersion","appPackage");


            for (XWPFParagraph pegarParagrafo : templateDoc.getParagraphs()) {
                String pegarTexto = pegarParagrafo.getText();
                if (pegarTexto.contains("print")) {
                    pegarParagrafo.removeRun(0); //Remove todo o texto existente
                    for (String imageFile : imageFiles) {
                        File file = new File(imageFile);
                        FileInputStream fis = new FileInputStream(file);
                        XWPFRun run = pegarParagrafo.createRun();
                        run.addTab();
                        run.addPicture(fis, extensaoImagem(file.getName()), file.getName(), Units.toEMU(200), Units.toEMU(415));
                        run.addTab();
                        fis.close();
                    }
                }

                if (pegarTexto.contains("etapa")) {
                    pegarParagrafo.removeRun(0); // Remove todos os runs existentes
                    for (String etapas : listaEtapas) {
                        XWPFRun run = pegarParagrafo.createRun();
                        run.addTab();
                        run.setText(etapas);
                        run.setFontFamily("Courier New"); // Ajuste para a fonte desejada
                        run.setFontSize(8); // Ajuste para o tamanho da fonte desejado
                        run.addBreak(BreakType.TEXT_WRAPPING);
                    }
                }
            }
            templateDoc.write(fos);
        }

    }

    /**
     * Metodo privado auxiliar para substituir um texto especifico em um documento.
     *
     * @param doc         o documento no qual realizar a substituicao de texto
     * @param placeholder o texto a ser substituido
     * @param replacement o texto substituto
     */
    private static void trocarTexto(XWPFDocument doc, String placeholder, String replacement) {
        if (replacement == null) {

            return;
        }

        for (XWPFParagraph paragrafo : doc.getParagraphs()) {
            String texto = paragrafo.getText();
            if (texto.contains(placeholder)) {
                for (XWPFRun run : paragrafo.getRuns()) {
                    String runText = run.getText(0);
                    if (runText != null && runText.contains(placeholder)) {
                        run.setText(runText.replace(placeholder, replacement), 0);

                    }
                }
            }
        }

        for (XWPFParagraph paragrafo : doc.getParagraphs()) {
            String texto = paragrafo.getText();
            if (texto.contains(placeholder)) {
                for (XWPFRun run : paragrafo.getRuns()) {
                    String runText = run.getText(0);
                    if (runText != null && runText.contains(placeholder)) {
                        run.setText(runText.replace(placeholder, replacement), 0);
                    }
                }
            }
        }

        for (XWPFTable tabela : doc.getTables()) {
            for (XWPFTableRow linha : tabela.getRows()) {
                for (XWPFTableCell celula : linha.getTableCells()) {
                    for (XWPFParagraph paragrafo : celula.getParagraphs()) {
                        String textoCelula = paragrafo.getText();
                        if (textoCelula.contains(placeholder)) {
                            for (XWPFRun run : paragrafo.getRuns()) {
                                String runText = run.getText(0);
                                if (runText != null && runText.contains(placeholder)) {
                                    run.setText(runText.replace(placeholder, replacement), 0);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo privado auxiliar para substituir o status em um documento.
     *
     * @param doc    o documento no qual realizar a substituicao do status
     * @param status o status a ser inserido no documento
     */
    private static void trocarTextoStatus(XWPFDocument doc, String status) {
        for (XWPFTable table : doc.getTables()) {
            for (XWPFTableRow row : table.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        String cellText = paragraph.getText();
                        if (cellText.contains("status")) {
                            // Limpar o texto existente no paragrafo
                            for (int i = paragraph.getRuns().size() - 1; i >= 0; i--) {
                                paragraph.removeRun(i);
                            }
                            // Adicionar o STATUS final do teste apos execucao
                            XWPFRun run = paragraph.createRun();
                            run.setFontFamily("Arial");
                            run.setBold(true);
                            run.setText(status);
                            if (status.contains("PASSED")) {
                                run.setColor("2ea000");
                            } else {
                                run.setColor("ff0000");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo privado auxiliar para substituir os placeholders de capacidade em um documento.
     *
     * @param doc          o documento no qual realizar a substituicao dos placeholders
     * @param placeholders os placeholders a serem substituidos pelos valores das capacidades
     */
    private static void trocarTextoCap(XWPFDocument doc, String... placeholders) {
        for (String placeholder : placeholders) {
            for (XWPFTable table : doc.getTables()) {
                for (XWPFTableRow row : table.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph paragraph : cell.getParagraphs()) {
                            String cellText = paragraph.getText();
                            if (cellText.contains(placeholder)) {
                                paragraph.removeRun(0); // Remove todos os runs existentes
                                XWPFRun run = paragraph.createRun();
                                run.setFontFamily("Arial");
                                
                                // Obtem a capability e converte para String de forma segura
                                Object capability = Hooks.getDriver().getCapabilities().getCapability(placeholder);
                                String capabilityValue = (capability != null) ? capability.toString() : "N/A";
                                run.setText(capabilityValue); // Define o texto
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Metodo auxiliar para determinar o tipo de imagem com base na extensao do arquivo.
     *
     * @param fileName o nome do arquivo de imagem
     * @return o tipo de imagem correspondente
     */
    private static int extensaoImagem(String fileName) {
        String extensao = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        switch (extensao) {
            case "png":
                return XWPFDocument.PICTURE_TYPE_PNG;
            case "jpg":
            case "jpeg":
                return XWPFDocument.PICTURE_TYPE_JPEG;
            case "gif":
                return XWPFDocument.PICTURE_TYPE_GIF;
            default:
                return XWPFDocument.PICTURE_TYPE_PICT;
        }
    }

    static List<String> pegarEtapasCenario(Scenario scenario) {
        List<String> stepsList = new ArrayList<>();

        try {
            Field delegate = scenario.getClass().getDeclaredField("delegate");
            delegate.setAccessible(true);
            TestCaseState testCaseState = (TestCaseState) delegate.get(scenario);

            Field testCaseField = testCaseState.getClass().getDeclaredField("testCase");
            testCaseField.setAccessible(true);
            TestCase testCase = (TestCase) testCaseField.get(testCaseState);

            List<PickleStepTestStep> testSteps = testCase.getTestSteps().stream().filter(step -> step instanceof PickleStepTestStep).map(step -> (PickleStepTestStep) step).collect(Collectors.toList());

            for (PickleStepTestStep testStep : testSteps) {
                String stepText = testStep.getStep().getKeyword() + testStep.getStep().getText();
                stepsList.add(stepText);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return stepsList;
    }
}