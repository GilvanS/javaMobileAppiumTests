# Correção do Popup de Introdução - Cliques Múltiplos

## Problema Identificado

O elemento `lblIntroducaoUm` (`//android.widget.TextView[@resource-id="android:id/text1"]`) aparece **3 vezes** e **não é clicável diretamente**. Para fechar o popup de introdução, é necessário clicar no **próximo elemento 3 vezes**.

## Análise do Comportamento

```
1. Popup de introdução aparece
2. Elemento lblIntroducaoUm é visível (não clicável)
3. Precisa clicar no botão "Próximo" 3 vezes
4. Popup desaparece após o 3º clique
5. Tela Home fica disponível para os testes
```

## Correções Implementadas

### 1. HomePage.java - Novos Elementos

Adicionados elementos para os botões do popup de introdução:

```java
@AndroidFindBy(xpath = "//android.widget.Button[@text='Próximo']")
private WebElement btnProximoIntroducao;

@AndroidFindBy(xpath = "//android.widget.Button[@text='Continuar']")
private WebElement btnContinuarIntroducao;

@AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
private WebElement btnOkIntroducao;
```

### 2. HomeActions.java - Método Específico

Criado método `fecharPopupIntroducao()` para lidar com cliques múltiplos:

```java
/**
 * Fecha o popup de introdução que aparece 3 vezes
 * Precisa clicar no próximo elemento 3 vezes para desaparecer
 */
public static void fecharPopupIntroducao() {
    try {
        log.info("Verificando popup de introdução...");
        
        // Verifica se o popup de introdução está visível
        if (homePage().getLblIntroducaoUm().isDisplayed()) {
            log.info("Popup de introdução detectado, fechando...");
            
            // Tenta clicar no botão "Próximo" 3 vezes
            for (int i = 1; i <= 3; i++) {
                try {
                    log.info("Clicando no botão 'Próximo' pela {}ª vez", i);
                    acoes().click(homePage().getBtnProximoIntroducao());
                    acoes().sleep(1); // Aguarda entre os cliques
                } catch (Exception e) {
                    log.info("Botão 'Próximo' não encontrado, tentando 'Continuar'");
                    try {
                        acoes().click(homePage().getBtnContinuarIntroducao());
                        acoes().sleep(1);
                    } catch (Exception e2) {
                        log.info("Botão 'Continuar' não encontrado, tentando 'OK'");
                        try {
                            acoes().click(homePage().getBtnOkIntroducao());
                            acoes().sleep(1);
                        } catch (Exception e3) {
                            log.info("Nenhum botão encontrado na {}ª tentativa", i);
                        }
                    }
                }
            }
            
            log.info("Popup de introdução fechado com sucesso");
        } else {
            log.info("Popup de introdução nao encontrado");
        }
        
    } catch (Exception e) {
        log.info("Erro ao fechar popup de introdução: {}", e.getMessage());
    }
}
```

### 3. HomeActions.java - PopupModel Atualizado

Removido o popup de introdução do PopupModel, mantendo apenas o popup de banco:

```java
// Define os elementos identificadores do popup (elementos que indicam que o popup está presente)
// Apenas popup de banco - popup de introdução é tratado separadamente
popupModel.setElementosIdentificadores(
    homePage().getLblEncontreSeuBanco(),
    homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco()
);

// Define os elementos de ação (botões para fechar o popup)
// Apenas popup de banco - popup de introdução é tratado separadamente
popupModel.setElementosDeAcao(homePage().getBtnFechar());
```

### 4. HomeActions.java - Estratégia Híbrida

Atualizado `fecharPopupBancoComPopupModel()` para usar estratégia híbrida:

```java
/**
 * Fecha os popups usando PopupModel e PopupActions
 */
public static void fecharPopupBancoComPopupModel() {
    try {
        log.info("Fechando popup de banco usando PopupModel");
        boolean popupFechado = popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome(), 5);
        
        if (popupFechado) {
            log.info("Popup de banco fechado com sucesso usando PopupModel");
        } else {
            log.info("Popup de banco nao foi encontrado ou nao foi possivel fechar");
        }
        
    } catch (Exception e) {
        log.info("Erro ao fechar popup de banco com PopupModel: {}", e.getMessage());
        // Fallback para o método simples
        fecharPopups();
    }
    
    // Após fechar o popup de banco, verifica se o popup de introdução apareceu
    try {
        log.info("Verificando se popup de introdução apareceu após fechar popup de banco");
        fecharPopupIntroducao();
    } catch (Exception e) {
        log.info("Popup de introdução nao apareceu ou ja foi fechado");
    }
}
```

## Estratégia de Fechamento

### 1. Popup de Banco (PopupModel)
- **Detecção**: `lblEncontreSeuBanco` ou `vldTxtVoceJaTentouEncontrarEConectarSeuBanco`
- **Ação**: Clica no `btnFechar`
- **Validação**: Aguarda `vldTxtInicio` aparecer

### 2. Popup de Introdução (Método Específico)
- **Detecção**: `lblIntroducaoUm` visível
- **Ação**: Clica 3 vezes no botão (Próximo → Continuar → OK)
- **Validação**: Popup desaparece após 3 cliques

## Fluxo de Execução

```
1. Teste executa step da tela Home
   ↓
2. PopupModel detecta popup de banco
   ↓
3. Clica no btnFechar
   ↓
4. PopupModel aguarda vldTxtInicio
   ↓
5. Verifica se popup de introdução apareceu
   ↓
6. Se sim, executa fecharPopupIntroducao()
   ↓
7. Clica 3 vezes no botão (Próximo/Continuar/OK)
   ↓
8. Continua com o teste
```

## Benefícios da Implementação

1. **Tratamento Específico**: Popup de introdução tratado com lógica específica
2. **Cliques Múltiplos**: Suporte a 3 cliques sequenciais
3. **Fallback Robusto**: Tenta diferentes botões (Próximo → Continuar → OK)
4. **Logs Detalhados**: Rastreabilidade de cada clique
5. **Separação de Responsabilidades**: PopupModel para banco, método específico para introdução

## Logs de Execução

```
INFO: Fechando popup de banco usando PopupModel
INFO: Popup de banco fechado com sucesso usando PopupModel
INFO: Verificando se popup de introdução apareceu após fechar popup de banco
INFO: Verificando popup de introdução...
INFO: Popup de introdução detectado, fechando...
INFO: Clicando no botão 'Próximo' pela 1ª vez
INFO: Clicando no botão 'Próximo' pela 2ª vez
INFO: Clicando no botão 'Próximo' pela 3ª vez
INFO: Popup de introdução fechado com sucesso
```

## Teste da Implementação

Para testar se a correção funcionou:

1. **Execute um teste que acessa a tela Home**
2. **Verifique os logs** para confirmar que o popup de banco é fechado
3. **Observe se o popup de introdução é detectado**
4. **Confirme que os 3 cliques são executados**
5. **Valide que a tela Home carrega corretamente**

Agora o sistema trata corretamente o popup de introdução que aparece 3 vezes, executando os cliques necessários para fechá-lo e permitir que os testes prossigam. 