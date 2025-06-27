# Adição do Popup de Introdução ao PopupModel

## Problema Identificado

Após fechar o popup de banco, aparece um segundo popup de introdução que impede o prosseguimento dos testes:

```java
@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
private WebElement lblIntroducaoUm;
```

## Fluxo dos Popups

```
1. Tela Home carrega
   ↓
2. Popup de banco aparece
   ↓
3. Popup de banco é fechado
   ↓
4. Popup de introdução aparece (lblIntroducaoUm)
   ↓
5. Popup de introdução precisa ser clicado para continuar
   ↓
6. Tela Home fica disponível para os testes
```

## Correções Implementadas

### 1. HomePage.java
O elemento já estava definido:
```java
@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='android:id/text1']")
private WebElement lblIntroducaoUm;
```

### 2. HomeActions.java - Atualização do getPopupModelHome()

#### Elementos Identificadores Atualizados
```java
popupModel.setElementosIdentificadores(
    homePage().getLblEncontreSeuBanco(),
    homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco(),
    homePage().getLblIntroducaoUm()  // Popup de introdução que aparece após fechar o popup de banco
);
```

#### Elementos de Ação Atualizados
```java
popupModel.setElementosDeAcao(
    homePage().getBtnFechar(),      // Para popup de banco
    homePage().getLblIntroducaoUm() // Para popup de introdução (próprio elemento é clicável)
);
```

### 3. HomeActions.java - Novo método isPopupVisivel()

```java
/**
 * Verifica se qualquer popup está visível de forma segura
 */
private static boolean isPopupVisivel() {
    try {
        // Verifica popup de banco
        if (homePage().getLblEncontreSeuBanco().isDisplayed()) {
            return true;
        }
        // Verifica popup de introdução
        if (homePage().getLblIntroducaoUm().isDisplayed()) {
            return true;
        }
        return false;
    } catch (Exception e) {
        return false;
    }
}
```

### 4. HomeActions.java - Novo método fecharPopups()

```java
/**
 * Fecha os popups se estiverem visíveis na tela Home
 */
public static void fecharPopups() {
    try {
        // Verifica se qualquer popup está visível de forma segura
        if (isPopupVisivel()) {
            log.info("Popup detectado, fechando...");
            
            // Tenta fechar popup de banco
            try {
                if (homePage().getLblEncontreSeuBanco().isDisplayed()) {
                    acoes().click(homePage().getBtnFechar());
                    log.info("Popup de banco fechado");
                }
            } catch (Exception e) {
                // Popup de banco não está visível
            }
            
            // Tenta fechar popup de introdução
            try {
                if (homePage().getLblIntroducaoUm().isDisplayed()) {
                    acoes().click(homePage().getLblIntroducaoUm());
                    log.info("Popup de introdução fechado");
                }
            } catch (Exception e) {
                // Popup de introdução não está visível
            }
            
            acoes().sleep(2); // Aguarda os popups fecharem
            log.info("Popups fechados com sucesso");
        }
    } catch (Exception e) {
        log.info("Nenhum popup encontrado ou ja foram fechados");
    }
}
```

### 5. HomeActions.java - Atualização do fecharPopupBancoComPopupModel()

```java
/**
 * Fecha os popups usando PopupModel e PopupActions
 */
public static void fecharPopupBancoComPopupModel() {
    try {
        log.info("Fechando popups usando PopupModel");
        boolean popupFechado = popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome(), 5);
        
        if (popupFechado) {
            log.info("Popups fechados com sucesso usando PopupModel");
        } else {
            log.info("Popups nao foram encontrados ou nao foi possivel fechar");
        }
        
    } catch (Exception e) {
        log.info("Erro ao fechar popups com PopupModel: {}", e.getMessage());
        // Fallback para o método simples
        fecharPopups();
    }
}
```

## Como Funciona Agora

### 1. Detecção Sequencial
O PopupModel agora detecta e fecha os popups em sequência:
1. **Popup de banco** → Clica no `btnFechar`
2. **Popup de introdução** → Clica no próprio `lblIntroducaoUm`

### 2. Logs Detalhados
```java
log.info("Elementos identificadores: lblEncontreSeuBanco, vldTxtVoceJaTentouEncontrarEConectarSeuBanco, lblIntroducaoUm");
log.info("Elementos de ação: btnFechar, lblIntroducaoUm");
log.info("Elementos esperados: vldTxtInicio");
```

### 3. Métodos que Usam o PopupModel
- **`validarLblInicio()`** - Fecha popups antes de validar frase "Início"
- **`visualizarValorSaldo()`** - Fecha popups antes de visualizar saldo
- **`validarExibicaoTelaHome()`** - Valida tela Home usando PopupModel

## Benefícios da Implementação

1. **Detecção Completa**: Agora detecta e fecha ambos os popups
2. **Sequência Correta**: Fecha popup de banco primeiro, depois introdução
3. **Robustez**: Fallback para método simples se PopupModel falhar
4. **Logs Informativos**: Rastreabilidade completa do processo
5. **Automático**: Não precisa de steps manuais na feature

## Fluxo de Execução

```
1. Teste executa step da tela Home
   ↓
2. PopupModel detecta popup de banco
   ↓
3. Clica no btnFechar
   ↓
4. PopupModel detecta popup de introdução
   ↓
5. Clica no lblIntroducaoUm
   ↓
6. Aguarda vldTxtInicio aparecer
   ↓
7. Continua com o teste
```

## Teste da Implementação

Para testar se a correção funcionou:

1. **Execute um teste que acessa a tela Home**
2. **Verifique os logs** para confirmar que ambos os popups são detectados
3. **Observe se os popups são fechados automaticamente**
4. **Confirme que a tela Home carrega corretamente**

Agora o PopupModel detecta e fecha automaticamente tanto o popup de banco quanto o popup de introdução, permitindo que os testes prossigam sem interrupções. 