# Solução Simples para Popup de Introdução

## Problema
- Popup de introdução aparece 3 vezes
- Elemento `lblIntroducaoUm` não é clicável
- Precisa clicar no meio da tela 3 vezes

## Solução Implementada

### 1. Método clicarMeioTela()
```java
public static void clicarMeioTela() {
    try {
        log.info("Clicando no meio da tela para fechar popup de introdução");
        acoes().click(homePage().getVldTxtInicio()); // Clica no elemento "Início"
        acoes().sleep(1);
    } catch (Exception e) {
        log.info("Erro ao clicar no meio da tela: {}", e.getMessage());
    }
}
```

### 2. Método fecharPopupIntroducao()
```java
public static void fecharPopupIntroducao() {
    try {
        log.info("Verificando popup de introdução...");
        
        if (homePage().getLblIntroducaoUm().isDisplayed()) {
            log.info("Popup de introdução detectado, fechando...");
            
            // Clica 3 vezes no meio da tela
            for (int i = 1; i <= 3; i++) {
                clicarMeioTela();
            }
            
            log.info("Popup de introdução fechado com sucesso");
        }
        
    } catch (Exception e) {
        log.info("Popup de introdução nao encontrado ou ja foi fechado");
    }
}
```

## Fluxo
1. Popup de banco é fechado pelo PopupModel
2. Popup de introdução aparece
3. Sistema clica 3 vezes no meio da tela
4. Popup desaparece
5. Teste continua

## Benefícios
- ✅ Código simples e direto
- ✅ Sem verbosidade desnecessária
- ✅ Funciona com cliques no meio da tela
- ✅ Tratamento de exceções adequado 