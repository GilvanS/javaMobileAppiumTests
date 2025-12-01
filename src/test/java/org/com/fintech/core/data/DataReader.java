package org.com.fintech.core.data;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import lombok.extern.log4j.Log4j2;
import org.com.fintech.core.exceptions.DataException;


/**
 * Classe responsável por ler dados de arquivos Excel usando a biblioteca Fillo.
 * Implementa {@link AutoCloseable} para garantir o fechamento da conexão.
 * 
 */
@Log4j2
public class DataReader implements AutoCloseable {

	private final Fillo fillo;
	private Connection connection;

	/**
	 * Construtor da classe DataReader.
	 * Inicializa o objeto Fillo e estabelece a conexão com o arquivo Excel.
	 * 
	 *
	 * @param excelFilePath O caminho completo do arquivo Excel a ser lido.
	 */
	public DataReader(String excelFilePath) {
		synchronized (fillo = new Fillo()) {
			setConnection(excelFilePath);
		}
	}

	/**
	 * Estabelece a conexão com o arquivo Excel especificado.
	 * 
	 *
	 * @param excelFilePath O caminho completo do arquivo Excel.
	 * @throws DataException Se ocorrer um erro ao tentar obter a conexão com o arquivo.
	 */
	private void setConnection(String excelFilePath) {
		try {
			connection = fillo.getConnection(excelFilePath);
		} catch (FilloException e) {
			String message = "Erro ao obter conexão com arquivo: " + excelFilePath;
			log.error(message, e);
			throw new DataException(message, e);
		}
	}

	/**
	 * Executa uma consulta no arquivo Excel e retorna um Recordset.
	 * 
	 *
	 * @param query A consulta Fillo a ser executada (ex: "SELECT * FROM Sheet1").
	 * @return Um objeto Recordset contendo os resultados da consulta.
	 * @throws DataException Se ocorrer um erro durante a execução da consulta.
	 */
	public Recordset executeQuery(String query) {
		try {
			return connection.executeQuery(query);
		} catch (FilloException e) {
			String message = "Erro ao executar com consulta: " + query;
			log.error(message, e);
			
			throw new DataException(message, e);
		}
	}

	/**
	 * Executa uma operação de atualização no arquivo Excel e retorna o número de linhas afetadas.
	 * 
	 * @param query A consulta Fillo de atualização a ser executada (ex: "UPDATE Sheet1 SET Column1 = 'NewValue' WHERE ID = 1").
	 * @return O número de linhas afetadas pela operação de atualização.
	 * @throws DataException Se ocorrer um erro durante a execução da atualização.
	 */
	public int updateQuery(String query) {
		try {
			return connection.executeUpdate(query);
		} catch (FilloException e) {
			String message = "Erro na consulta de atualização com: " + query;
			log.error(message, e);
			throw new DataException(message, e);
		}
	}

	/**
	 * Fecha a conexão com o arquivo Excel.
	 * Este método é automaticamente chamado quando a classe é usada em um bloco try-with-resources.
	 * 
	 * @throws Exception Se ocorrer um erro ao tentar fechar a conexão.
	 */
	@Override
	public void close() throws Exception {
		
		connection.close();
	}
}
