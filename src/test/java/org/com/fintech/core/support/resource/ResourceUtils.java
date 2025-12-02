package org.com.fintech.core.support.resource;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceUtils {

	/**
	 * Encontra o caminho absoluto de um arquivo de recurso, procurando em vários locais comuns.
	 * Isso torna o framework mais robusto e menos dependente da configuração de execução do IDE.
	 *
	 * @param resourceName O nome do arquivo a ser encontrado (ex: "MassaDadosCMS.xlsx").
	 * @return O caminho absoluto do arquivo.
	 * @throws RuntimeException se o arquivo não for encontrado em nenhum dos locais.
	 */
	public static String getPath(String resourceName) {
		// 1. Tenta carregar diretamente do ClassLoader (método padrão)
		URL resourceUrl = ResourceUtils.class.getClassLoader().getResource(resourceName);
		if (resourceUrl != null) {
			try {
				// Usa toURI() para lidar melhor com espaços e caracteres especiais em Windows
				return new File(resourceUrl.toURI()).getAbsolutePath();
			} catch (URISyntaxException e) {
				// Se toURI() falhar, tenta com getPath() (pode ter problemas com espaços)
				String path = resourceUrl.getPath();
				// Remove o prefixo "/" no Windows se necessário
				if (path.startsWith("/") && System.getProperty("os.name").toLowerCase().contains("win")) {
					path = path.substring(1);
				}
				return new File(path).getAbsolutePath();
			}
		}

		// 2. Se falhar, tenta caminhos relativos comuns a partir da raiz do projeto
		String[] possiblePaths = {
				"src/main/resources/",
				"src/test/resources/",
				"src/test/resources/dados/",
				"src/main/resources/dados/",
				"data/",
				"dados/",
				"" // Raiz do projeto
		};

		for (String path : possiblePaths) {
			File file = new File(path + resourceName);
			if (file.exists() && !file.isDirectory()) {
				System.out.println("INFO: Recurso '" + resourceName + "' encontrado em: " + file.getAbsolutePath());
				return file.getAbsolutePath();
			}
		}

		// 3. Se tudo falhar, lança um erro claro.
		throw new RuntimeException("FALHA CRÍTICA AO CARREGAR RECURSO: O arquivo '" + resourceName + "' não foi encontrado no classpath ou em diretórios comuns do projeto.");
	}
}