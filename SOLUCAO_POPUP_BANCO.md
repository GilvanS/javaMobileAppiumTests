# Solução para Popup de Banco na Tela Home

## Problema Identificado

O `PopupModel.java` estava comentado/inativo, e elementos de popup de banco estavam aparecendo na tela Home impedindo a execução dos steps:
- `Given visualizo o valor do saldo na tela Home`
- `Given valido a exibição da frase Inicio na tela Home`

## Elementos do Popup Identificados

Na `HomePage.java` foram encontrados os seguintes elementos relacionados ao popup de banco:

```java
@AndroidFindBy(xpath = "//android.widget.ScrollView[@resource-id='com.droid4you.application.wallet:id/scroll_view']")
private WebElement lblEncontreSeuBanco;

@AndroidFindBy(xpath = "//android.widget.TextView[@text='Você já tentou encontrar e conectar seu banco?']")
private WebElement vldTxtVoceJaTentouEncontrarEConectarSeuBanco;

@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.droid4you.application.wallet:id/image_view_close']")
private WebElement btnFechar;
```

## Solução Implementada

### 1. Método Simples para Fechar Popup (`HomeActions.java`)

```java
/**
 * Fecha o popup de banco se estiver visível na tela Home
 */
public static void fecharPopupBanco() {
    try {
        // Verifica se o popup está visível de forma segura
        if (isPopupBancoVisivel()) {
            log.info("Popup de banco detectado, fechando...");
            acoes().click(homePage().getBtnFechar());
            acoes().sleep(2); // Aguarda o popup fechar
            log.info("Popup de banco fechado com sucesso");
        }
    } catch (Exception e) {
        log.info("Popup de banco nao encontrado ou ja foi fechado");
    }
}

/**
 * Verifica se o popup de banco está visível de forma segura
 */
private static boolean isPopupBancoVisivel() {
    try {
        return homePage().getLblEncontreSeuBanco().isDisplayed();
    } catch (Exception e) {
        return false;
    }
}
```

### 2. Método Avançado usando PopupModel e PopupActions

```java
/**
 * Fecha o popup de banco usando PopupModel e PopupActions
 */
public static void fecharPopupBancoComPopupModel() {
    try {
        // Cria o modelo do popup
        PopupModel popupModel = new PopupModel("Popup Banco");
        
        // Define os elementos identificadores do popup (elementos que indicam que o popup está presente)
        popupModel.setElementosIdentificadores(homePage().getLblEncontreSeuBanco());
        
        // Define os elementos de ação (botões para fechar o popup)
        popupModel.setElementosDeAcao(homePage().getBtnFechar());
        
        // Define os elementos esperados (elementos que indicam que o popup foi fechado)
        popupModel.setElementosEsperados(homePage().getVldTxtInicio());
        
        // Configura delay se necessário
        popupModel.setDelay(false);
        
        // Executa a verificação e fechamento do popup
        PopupActions popupActions = new PopupActions();
        boolean popupFechado = popupActions.verificarPopUpsAteEncontrarElementoEsperado(popupModel, 5);
        
        if (popupFechado) {
            log.info("Popup de banco fechado com sucesso usando PopupModel");
        } else {
            log.info("Popup de banco nao foi encontrado ou nao foi possivel fechar");
        }
        
    } catch (Exception e) {
        log.info("Erro ao fechar popup de banco com PopupModel: {}", e.getMessage());
        // Fallback para o método simples
        fecharPopupBanco();
    }
}
```

### 3. Integração Automática nos Métodos Existentes

Os métodos `validarLblInicio()` e `visualizarValorSaldo()` foram atualizados para fechar automaticamente o popup antes de executar suas validações:

```java
public static void validarLblInicio() throws IOException {
    // Fecha popup antes de validar usando PopupModel
    fecharPopupBancoComPopupModel();
    
    log.info("valido a exibição da frase 'Inicio' na tela 'Home'");
    acoes().waitForVisibility(homePage().getVldTxtInicio());
    PrintScreen.screenshot("validacao_frase_inicio");
}

public static void visualizarValorSaldo() throws IOException {
    // Fecha popup antes de visualizar o saldo usando PopupModel
    fecharPopupBancoComPopupModel();
    
    log.info("Visualizando valor do saldo na tela Home");
    acoes().waitForVisibility(homePage().getTxtValorSaldo());
    // ... resto do código
}
```

### 4. PopupActions Corrigido

O `PopupActions.java` foi corrigido para funcionar com o framework atual:

```java
@Slf4j
public class PopupActions {
    private static final int DEFAULT_DELAY_SECONDS = 10;
    private static final int MINIMUM_SECONDS = 1;

    /**
     * Clica nos elementos de ação para fechar os popups a partir de seus
     * identificadores até que os elementos esperados sejam encontrados
     */
    public boolean verificarPopUpsAteEncontrarElementoEsperado(PopupModel popupModel) {
        return verificarPopUpsAteEncontrarElementoEsperado(popupModel, 10);
    }

    // ... outros métodos implementados com Context.acoes() e tratamento de exceções
}
```

### 5. Cenários Limpos (`home.feature`)

Os cenários permanecem limpos, sem menção ao popup, pois o tratamento é automático:

```gherkin
@CT-1001 @wallet
Scenario: Validar Saldo em conta
  Given visualizo o valor do saldo na tela Home
  Then valido o valor do saldo no campo Tendencia do saldo na tela Home

@CT-1002
Scenario: Validar Detalhe da conta
  Given valido a exibição da frase Inicio na tela Home
  When clico no botão Detalhe da conta na tela Home
  # ... resto dos steps
```

## Benefícios da Solução

1. **Transparência**: O popup é tratado automaticamente sem aparecer nos cenários
2. **Robustez**: Verificação segura da visibilidade do popup com tratamento de exceções
3. **Automatização**: Fechamento automático do popup nos métodos críticos
4. **Logging**: Logs informativos para rastreabilidade
5. **Não-intrusivo**: Não afeta o funcionamento quando o popup não está presente
6. **Cenários Limpos**: Os testes focam na funcionalidade real, não em popups
7. **Reutilização**: Usa a estrutura existente do `PopupModel` e `PopupActions`
8. **Fallback**: Se o PopupModel falhar, usa o método simples como backup

## Como Funciona

### Tratamento Automático
- Os métodos `validarLblInicio()` e `visualizarValorSaldo()` verificam automaticamente se o popup está presente
- Se o popup estiver visível, ele é fechado antes de executar a validação
- Se o popup não estiver presente, o método continua normalmente
- Logs informam quando o popup é detectado e fechado

### PopupModel e PopupActions
- **PopupModel**: Define a estrutura do popup (elementos identificadores, de ação e esperados)
- **PopupActions**: Executa a lógica de verificação e fechamento do popup
- **Fallback**: Se houver erro, usa o método simples como backup

### Cenários
- Os cenários permanecem focados na funcionalidade real
- Não há necessidade de adicionar steps para fechar popups
- O tratamento é transparente para quem escreve os testes

## Vantagens do PopupModel

1. **Configurável**: Permite definir diferentes tipos de popup
2. **Flexível**: Suporta múltiplos elementos identificadores e de ação
3. **Robusto**: Aguarda elementos esperados para confirmar o fechamento
4. **Reutilizável**: Pode ser usado para outros popups no futuro
5. **Logging**: Registra todas as ações realizadas

## Observações

- O `PopupModel.java` original foi mantido e corrigido para funcionar com o framework atual
- A solução é específica para o popup de banco identificado, mas pode ser expandida
- O popup não faz parte do teste, apenas é evitado durante as etapas
- A implementação usa tanto o método simples quanto o avançado para máxima robustez 