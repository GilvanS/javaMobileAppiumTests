package org.utilidades.dados;

import org.apache.poi.ss.usermodel.*;
import org.testes.utils.HooksDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Usuario {

    public static String getTag() {
        return HooksDados.getTagCenario();
    }

    public static String getEmail() {
        return obterInformacao(getTag(), 3);
    }

    public static String getSenha() {
        return obterInformacao(getTag(), 4);
    }

    public static String getCidadeOrigem() {
        return obterInformacao(getTag(), 5);
    }

    public static String getCidadeDestino() {
        return obterInformacao(getTag(), 6);
    }

    public static String getDataInicio() {
        return obterInformacao(getTag(), 7);
    }

    public static String getDataFim() { return obterInformacao(getTag(), 8); }

    public static String getHotelSelecionado() {
        return obterInformacao(getTag(), 9);
    }

    protected static String obterInformacao(String tag, int coluna) {
        String informacao = null;

        try {
            FileInputStream arquivo = new FileInputStream("src/test/resources/dados/MassaDados.xlsx");
            Workbook workbook = WorkbookFactory.create(arquivo);

            int numberOfSheets = workbook.getNumberOfSheets();

            for (int sheetIndex = 0; sheetIndex < numberOfSheets; sheetIndex++) {
                Sheet abaTabela = workbook.getSheetAt(sheetIndex);
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
                                    break;
                                }
                            }
                        }
                    }
                }

                if (informacao != null) {
                    break;
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