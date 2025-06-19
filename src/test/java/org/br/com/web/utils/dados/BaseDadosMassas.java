package org.br.com.web.utils.dados;

import org.apache.poi.ss.usermodel.*;
import org.br.com.web.utils.hooks.HooksDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class BaseDadosMassas {

    public static String getTag() {
        return HooksDados.getTagCenario();
    }

    public static String getMensagem() {
        return obterInformacao(getTag(), 3);
    }

    public static String getFornecimento() {
        return obterInformacao(getTag(), 4);
    }

    public static String getNumeroImovel() {
        return obterInformacao(getTag(), 5);
    }

    public static String getCpf() {
        return obterInformacao(getTag(), 6);
    }

    public static String getNomeCompleto() {
        return obterInformacao(getTag(), 7);
    }

    public static String getVldPrimeiraFrase() {
        return obterInformacao(getTag(), 8);
    }

    public static String getVldSegundaFrase() {
        return obterInformacao(getTag(), 9);
    }

    public static String getVldTerceiraFrase() {
        return obterInformacao(getTag(), 10);
    }

    public static String getVldQuartaFrase() {
        return obterInformacao(getTag(), 11);
    }

    public static String getVldQuintaFrase() {
        return obterInformacao(getTag(), 12);
    }

    public static String getVldSextaFrase() {
        return obterInformacao(getTag(), 13);
    }

    public static String getVldSetimaFrase() {
        return obterInformacao(getTag(), 14);
    }

    public static String getVldOitavaFrase() {
        return obterInformacao(getTag(), 15);
    }

    public static String getVldNonaFrase() {
        return obterInformacao(getTag(), 16);
    }

    public static String getVldDecimaFrase() {
        return obterInformacao(getTag(), 17);
    }

    public static String getVldDecimaPrimeiraFrase() {
        return obterInformacao(getTag(), 18);
    }

    public static String getVldDecimaSegundaFrase() {
        return obterInformacao(getTag(), 19);
    }

    public static String getVldDecimaTerceiraFrase() {
        return obterInformacao(getTag(), 20);
    }

    public static String getVldDecimaQuartaFrase() {
        return obterInformacao(getTag(), 21);
    }

    public static String getVldDecimaQuintaFrase() {
        return obterInformacao(getTag(), 22);
    }

    public static String getVldDecimaSextaFrase() {
        return obterInformacao(getTag(), 23);
    }

    public static String getVldDecimaSetimaFrase() {
        return obterInformacao(getTag(), 24);
    }

    public static String getVldDecimaOitavaFrase() {
        return obterInformacao(getTag(), 25);
    }

    public static String getVldDecimaNonaFrase() {
        return obterInformacao(getTag(), 26);
    }

    public static String getVldVigesimaFrase() {
        return obterInformacao(getTag(), 27);
    }

    public static String getVldVigesimaPrimeiraFrase() {
        return obterInformacao(getTag(), 28);
    }

    public static String getVldVigesimaSegundaFrase() {
        return obterInformacao(getTag(), 29);
    }

    public static String getVldVigesimaTerceiraFrase() {
        return obterInformacao(getTag(), 30);
    }

    public static String getVldVigesimaQuartaFrase() {
        return obterInformacao(getTag(), 31);
    }

    public static String getVldVigesimaQuintaFrase() {
        return obterInformacao(getTag(), 32);
    }


    private static String obterInformacao(String tag, int coluna) {
        String informacao = null;

        try {
            FileInputStream arquivo = new FileInputStream("src/test/resources/MassaDados.xlsx");
            Workbook workbook = WorkbookFactory.create(arquivo);
            Sheet abaTabela = workbook.getSheetAt(0);

            int rowCount = abaTabela.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) {
                Row row = abaTabela.getRow(i);
                if (row != null) {
                    Cell tagCell = row.getCell(0);
                    if (tagCell != null) {
                        String tagValue = tagCell.getStringCellValue();

                        if (tagValue.equals(tag)) {
                            Cell cell = row.getCell(coluna);
                            if (cell != null) {
                                informacao = cell.getStringCellValue();
                            } else {
                            }
                            break;
                        }
                    } else {
                    }
                } else {
                }
            }

            arquivo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (informacao == null) {
            System.out.println("Informação não encontrada para a tag " + tag + " na coluna " + coluna);
        }

        return informacao;
    }

}