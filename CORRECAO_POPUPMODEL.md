# Correção PopupModel - Problema de Detecção de Elementos

## Problema Identificado

O PopupModel não estava encontrando os elementos do popup mesmo com os elementos aparecendo na tela:
- `lblEncontreSeuBanco`
- `vldTxtVoceJaTentouEncontrarEConectarSeuBanco`

## Causa Raiz

O método `toUnion()` no `PopupActions.java` estava com um placeholder e não funcionava corretamente:
```java
// CÓDIGO PROBLEMÁTICO
private By toUnion(WebElement[] elementos) {
    // ...
    xpathUnion.append("//*[@text='placeholder']"); // Placeholder
    return By.xpath(xpathUnion.toString());
}
```

## Correções Implementadas

### 1. PopupActions.java

#### Remoção do método toUnion problemático
- Removido o método `toUnion()` que não funcionava
- Alterado para trabalhar diretamente com arrays de `WebElement`

#### Atualização dos métodos principais
```java
// ANTES (com By)
private boolean verificarCliqueElementoAcaoVisivel(By elementoIdentificador, By elementoAcao, ...)

// DEPOIS (com WebElement[])
private boolean verificarCliqueElementoAcaoVisivel(WebElement[] elementosIdentificadores, WebElement[] elementosAcao, ...)
```

#### Novo método retornarElementoVisivel
```java
private WebElement retornarElementoVisivel(WebElement[] elementos) {
    if (elementos == null || elementos.length == 0) {
        return null;
    }
    
    for (WebElement elemento : elementos) {
        try {
            if (elemento.isDisplayed()) {
                return elemento;
            }
        } catch (Exception e) {
            // Elemento não está visível, continua para o próximo
        }
    }
    return null;
}
```

### 2. HomeActions.java

#### Atualização do getPopupModelHome()
```java
public static PopupModel getPopupModelHome() {
    log.info("Configurando PopupModel para tela Home");
    
    PopupModel popupModel = new PopupModel("Home");
    
    // Define os elementos esperados (elementos que indicam que a tela está carregada)
    popupModel.setElementosEsperados(homePage().getVldTxtInicio());
    
    // Define os elementos identificadores do popup (elementos que indicam que o popup está presente)
    // Incluindo todos os elementos que podem indicar a presença do popup
    popupModel.setElementosIdentificadores(
        homePage().getLblEncontreSeuBanco(),
        homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco()
    );
    
    // Define os elementos de ação (botões para fechar o popup)
    popupModel.setElementosDeAcao(homePage().getBtnFechar());
    
    // Configura delay (false por padrão, pode ser configurado via properties se necessário)
    popupModel.setDelay(false);
    
    log.info("PopupModel configurado com sucesso para tela Home");
    log.info("Elementos identificadores: lblEncontreSeuBanco, vldTxtVoceJaTentouEncontrarEConectarSeuBanco");
    log.info("Elementos de ação: btnFechar");
    log.info("Elementos esperados: vldTxtInicio");
    
    return popupModel;
}
```

### 3. LoginActions.java

#### Correção do getPopupModelLogin()
```java
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
    log.info("Elementos esperados: btnComeceAgora");
    
    return popupModel;
}
```

## Como Funciona Agora

### 1. Detecção de Popup
O PopupActions agora verifica se **qualquer um** dos elementos identificadores está visível:
- `lblEncontreSeuBanco`
- `vldTxtVoceJaTentouEncontrarEConectarSeuBanco`

### 2. Ação de Fechamento
Quando um popup é detectado, clica no elemento de ação:
- `btnFechar`

### 3. Validação de Sucesso
Aguarda até que o elemento esperado apareça:
- `vldTxtInicio` (indica que a tela Home está carregada)

### 4. Logs Detalhados
Adicionados logs para rastreabilidade:
```java
log.info("Elementos identificadores: lblEncontreSeuBanco, vldTxtVoceJaTentouEncontrarEConectarSeuBanco");
log.info("Elementos de ação: btnFechar");
log.info("Elementos esperados: vldTxtInicio");
```

## Benefícios das Correções

1. **Detecção Confiável**: Agora detecta corretamente os elementos do popup
2. **Múltiplos Identificadores**: Pode detectar o popup por diferentes elementos
3. **Logs Informativos**: Melhor rastreabilidade do processo
4. **Robustez**: Tratamento de exceções para elementos não visíveis
5. **Flexibilidade**: Fácil adição de novos elementos identificadores

## Teste da Correção

Para testar se a correção funcionou:

1. **Execute um teste que acessa a tela Home**
2. **Verifique os logs** para confirmar que o PopupModel está sendo configurado
3. **Observe se o popup é detectado e fechado automaticamente**
4. **Confirme que a tela Home carrega corretamente**

## Próximos Passos

1. **Testar em diferentes cenários** para garantir robustez
2. **Adicionar mais elementos identificadores** se necessário
3. **Configurar delay via properties** se precisar de pausas específicas
4. **Expandir para outras telas** que possam ter popups 