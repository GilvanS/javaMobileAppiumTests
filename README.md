# Projeto de Testes Automatizados Mobile com Appium

## Estrutura do Projeto

### Diretório `/src/test/java/org/testes`
- **`/adb`**: Utilitários para execução de comandos ADB
  - `AdbActions.java`: Classe com métodos para executar comandos ADB shell
- **`/driver`**: Configurações do driver Appium
- **`/paginas`**: Implementação do padrão Page Object
  - Cada feature possui seu próprio pacote com:
    - `{FeatureName}Elements.java`: Elementos da página
    - `{FeatureName}Logic.java`: Lógica de negócio
    - `{FeatureName}Steps.java`: Implementação dos steps
- **`/utils`**: Classes utilitárias
  - `Hooks.java`: Configuração do ciclo de vida dos testes
  - `CustomActions.java`: Ações customizadas para interação com elementos
  - `LogFormatter.java`: Formatação de logs
  - `Screenshot.java`: Captura de screenshots

### Diretório `/src/test/java/org/utilidades`
- **`/dados`**: Classes para gerenciamento de dados de teste
- **`/evidencia`**: Utilitários para geração de evidências

### Diretório `/src/test/resources`
- **`/dados`**: Arquivos de dados para testes
- **`/funcionalidades`**: Features Cucumber
- **`/xml`**: Arquivos XML de configuração
- **`logback.xml`**: Configuração de logs

## Tecnologias Utilizadas
- Java 21
- Appium
- Cucumber
- JUnit
- Selenium
- Lombok
- Logback

## Configuração do Ambiente

### Pré-requisitos
- Java 21
- Node.js
- Appium Server
- Android SDK
- ADB

### Configuração do Appium
```bash
npm install -g appium
appium driver install uiautomator2
```

### Configuração do Android
1. Instalar Android SDK
2. Configurar variáveis de ambiente:
   - ANDROID_HOME
   - PATH (incluir platform-tools)

## Executando os Testes

### Via Maven
```bash
mvn clean test
```

### Via IDE
1. Executar a classe `CucumberTest.java`
2. Ou executar as features diretamente

## Padrões e Convenções

### Nomenclatura
- Features: `nome_da_feature.feature`
- Classes: `{FeatureName}{Elements|Logic|Steps}.java`
- Métodos: camelCase em português
- Elementos: camelCase com prefixo descritivo (btn, lbl, etc)

### Logs
- Usar `LogFormatter.logStep()` para logs de steps
- Evitar acentos nas mensagens de log
- Manter logs informativos e concisos

### Screenshots
- Capturados automaticamente em caso de falha
- Salvos no diretório de evidências

## Boas Práticas
1. Manter steps simples e diretos
2. Usar Page Objects para encapsular elementos
3. Implementar tratamento de exceções
4. Seguir princípios SOLID
5. Manter código limpo e documentado

## Suporte
Para dúvidas ou sugestões, abra uma issue no repositório. 