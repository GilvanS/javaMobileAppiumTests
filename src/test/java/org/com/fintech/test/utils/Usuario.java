package org.com.fintech.test.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.DateUtil;
import org.com.fintech.test.utils.HooksDados;

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

    public static String getDataFim() {
        return obterInformacao(getTag(), 8);
    }

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
                            String tagValue = getCellValueAsString(tagCell);

                            if (tagValue != null && tagValue.equals(tag)) {
                                Cell cell = row.getCell(coluna);
                                if (cell != null) {
                                    informacao = getCellValueAsString(cell);
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

    /**
     * Converte o valor de uma célula Excel para String, tratando diferentes tipos de células.
     * 
     * @param cell A célula a ser convertida
     * @return O valor da célula como String, ou null se a célula estiver vazia
     */
    private static String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return null;
        }

        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            
            case NUMERIC:
                // Verifica se é uma data formatada
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    // Converte número para string, removendo decimais desnecessários
                    double numericValue = cell.getNumericCellValue();
                    if (numericValue == (long) numericValue) {
                        return String.valueOf((long) numericValue);
                    } else {
                        return String.valueOf(numericValue);
                    }
                }
            
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            
            case FORMULA:
                // Para fórmulas, obtém o valor calculado baseado no tipo de resultado
                try {
                    switch (cell.getCachedFormulaResultType()) {
                        case STRING:
                            return cell.getStringCellValue().trim();
                        case NUMERIC:
                            if (DateUtil.isCellDateFormatted(cell)) {
                                return cell.getDateCellValue().toString();
                            } else {
                                double numericValue = cell.getNumericCellValue();
                                if (numericValue == (long) numericValue) {
                                    return String.valueOf((long) numericValue);
                                } else {
                                    return String.valueOf(numericValue);
                                }
                            }
                        case BOOLEAN:
                            return String.valueOf(cell.getBooleanCellValue());
                        default:
                            return cell.getCellFormula();
                    }
                } catch (Exception e) {
                    return cell.getCellFormula();
                }
            
            case BLANK:
                return "";
            
            case ERROR:
                return "";
            
            default:
                return "";
        }
    }

}