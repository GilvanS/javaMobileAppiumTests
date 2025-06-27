# Atualização PopupModel - HomeActions e LoginActions

## Exemplo Base

Seguindo o exemplo fornecido:
```java
public PopupModel getPopupModelHome() {
    // verificando pelo arquivo digio.properties se deve ou não aplicar o delay na home
    DigioProperty digioProperty = new DigioProperty();
    boolean isFlagDelayHomePopup = digioProperty.isFlagDelayHomePopup();
    if (isFlagDelayHomePopup) {
        log.info("flag delay home popup LIGADA, para desligar alterar o arquivo digio.properties");
    } else {
        log.info("flag delay home popup DESLIGADA, para ligar alterar o arquivo digio.properties");
    }

    PopupModel popupModel = new PopupModel("Home");
    popupModel.setElementosEsperados(homePage.getLblOla());
    popupModel.setElementosIdentificadores(homePage.getBtnNaoMostrarNovamente(),
            homePage.getBtnConfiraAsMudancasFechar(), homePage.getBtnFecharNegociacao(), homePage.getBtnFechar(),
            homePage.getBtnFecharPromocaoJogaNoDigio());
    popupModel.setElementosDeAcao(homePage.getBtnNaoMostrarNovamente(), homePage.getBtnConfiraAsMudancasFechar(),
            homePage.getBtnFecharNegociacao(), homePage.getBtnFechar(), homePage.getBtnFecharPromocaoJogaNoDigio());
    popupModel.setDelay(isFlagDelayHomePopup);
    return popupModel;
}

public void validarExibicaoTelaHome() {
    log.info("valido a exibição da home");
    popupLogic.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
    assertTrue("Tela home do Digio não foi apresentada",
            actions().waitForElementToBeDisplayed(homePage.getLblOla()));
}
```

## Atualizações Implementadas

### 1. HomeActions.java

#### Método getPopupModelHome()
```java
/**
 * Configura o PopupModel para a tela Home
 */
public static PopupModel getPopupModelHome() {
    log.info("Configurando PopupModel para tela Home");
    
    PopupModel popupModel = new PopupModel("Home");
    
    // Define os elementos esperados (elementos que indicam que a tela está carregada)
    popupModel.setElementosEsperados(homePage().getVldTxtInicio());
    
    // Define os elementos identificadores do popup (elementos que indicam que o popup está presente)
    popupModel.setElementosIdentificadores(homePage().getLblEncontreSeuBanco());
    
    // Define os elementos de ação (botões para fechar o popup)
    popupModel.setElementosDeAcao(homePage().getBtnFechar());
    
    // Configura delay (false por padrão, pode ser configurado via properties se necessário)
    popupModel.setDelay(false);
    
    log.info("PopupModel configurado com sucesso para tela Home");
    return popupModel;
}
```

#### Método validarExibicaoTelaHome()
```java
/**
 * Valida a exibição da tela Home
 */
public static void validarExibicaoTelaHome() {
    log.info("Valido a exibição da tela Home");
    popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
    assertTrue(acoes().waitForElementToBeVisible(homePage().getVldTxtInicio(), 10).isDisplayed(), 
              "Tela home não foi apresentada corretamente");
    log.info("Tela Home apresentada com sucesso");
}
```

#### Atualização do fecharPopupBancoComPopupModel()
```java
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
        fecharPopupBanco();
    }
}
```

### 2. LoginActions.java

#### Método getPopupModelLogin()
```java
/**
 * Configura o PopupModel para a tela Login
 */
public static PopupModel getPopupModelLogin() {
    log.info("Configurando PopupModel para tela Login");
    
    PopupModel popupModel = new PopupModel("Login");
    
    // Define os elementos esperados (elementos que indicam que a tela está carregada)
    popupModel.setElementosEsperados(loginPage().getBtnComeceAgora());
    
    // Define os elementos identificadores do popup (se houver popups na tela de login)
    // Por enquanto vazio, pode ser expandido conforme necessário
    
    // Define os elementos de ação (botões para fechar o popup)
    // Por enquanto vazio, pode ser expandido conforme necessário
    
    // Configura delay (false por padrão, pode ser configurado via properties se necessário)
    popupModel.setDelay(false);
    
    log.info("PopupModel configurado com sucesso para tela Login");
    return popupModel;
}
```

#### Método validarExibicaoTelaLogin()
```java
/**
 * Valida a exibição da tela Login
 */
public static void validarExibicaoTelaLogin() {
    log.info("Valido a exibição da tela Login");
    popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelLogin());
    assertTrue(acoes().waitForElementToBeVisible(loginPage().getBtnComeceAgora(), 10).isDisplayed(), 
              "Tela login não foi apresentada corretamente");
    log.info("Tela Login apresentada com sucesso");
}
```

## Melhorias Implementadas

### 1. Organização do Código
- **Métodos Separados**: `getPopupModelHome()` e `getPopupModelLogin()` para configuração
- **Reutilização**: PopupModel configurado uma vez e reutilizado
- **Manutenibilidade**: Fácil alteração da configuração do popup

### 2. Validação de Tela
- **Métodos de Validação**: `validarExibicaoTelaHome()` e `validarExibicaoTelaLogin()`
- **Assertions**: Validação explícita de que a tela foi carregada
- **Logs Informativos**: Confirmação de sucesso da validação

### 3. Instância Única
- **PopupActions**: Instância única como campo estático
- **Performance**: Evita criação desnecessária de objetos
- **Consistência**: Mesma instância em todas as operações

### 4. Configuração Flexível
- **Delay Configurável**: Preparado para configuração via properties
- **Elementos Expansíveis**: Fácil adição de novos popups
- **Logs de Configuração**: Rastreabilidade da configuração

## Como Usar

### Validação de Tela
```java
// Validar tela Home
HomeActions.validarExibicaoTelaHome();

// Validar tela Login
LoginActions.validarExibicaoTelaLogin();
```

### Fechamento de Popup
```java
// Fechar popup usando PopupModel (já implementado nos métodos existentes)
HomeActions.fecharPopupBancoComPopupModel();
```

### Configuração Manual
```java
// Obter PopupModel configurado
PopupModel popupModel = HomeActions.getPopupModelHome();

// Usar com PopupActions
PopupActions popupActions = new PopupActions();
popupActions.verificarPopUpsAteEncontrarElementoEsperado(popupModel);
```

## Benefícios

1. **Organização**: Código mais limpo e organizado
2. **Reutilização**: PopupModel configurado uma vez
3. **Manutenibilidade**: Fácil alteração de configurações
4. **Validação**: Métodos específicos para validação de tela
5. **Performance**: Instância única de PopupActions
6. **Flexibilidade**: Preparado para expansão futura

## Próximos Passos

1. **Configuração via Properties**: Implementar leitura de configurações de delay
2. **Expansão de Popups**: Adicionar mais tipos de popup conforme necessário
3. **Validações Adicionais**: Implementar validações específicas para cada tela
4. **Testes**: Criar testes para os novos métodos de validação 