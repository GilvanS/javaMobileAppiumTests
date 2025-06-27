# Solução Final - Popup de Introdução

## Implementação

### 1. PageBaseActions.java
```java
public void clicarMeioTela() {
    try {
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(515, 372);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
            PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
        
        log.info("Clique no meio da tela executado com sucesso");
    } catch (Exception e) {
        log.error("Erro ao clicar no meio da tela: {}", e.getMessage());
    }
}
```

### 2. HomeActions.java
```java
public static void fecharPopupBancoComPopupModel() {
    try {
        popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome(), 5);
        
        // Após fechar o popup de banco, verifica se o popup de introdução apareceu
        fecharPopupIntroducao();
        
    } catch (Exception e) {
        fecharPopups();
    }
}

public static void fecharPopupIntroducao() {
    try {
        if (homePage().getLblIntroducaoUm().isDisplayed()) {
            log.info("Popup de introdução detectado, fechando...");
            
            // Clica 3 vezes no meio da tela
            for (int i = 1; i <= 3; i++) {
                acoes().clicarMeioTela();
            }
            
            log.info("Popup de introdução fechado");
        }
    } catch (Exception e) {
        log.info("Popup de introdução nao encontrado");
    }
}
```

## Fluxo Correto
1. PopupModel fecha o popup de banco
2. **Após** fechar o popup de banco, verifica se o popup de introdução apareceu
3. Popup de introdução → Detectado por `lblIntroducaoUm`
4. Sistema → Clica 3x no meio da tela (coordenadas 515, 372)
5. Popup desaparece → Teste continua

## Benefícios
- ✅ Código mínimo e direto
- ✅ Sem verbosidade
- ✅ Método reutilizável no PageBaseActions
- ✅ Coordenadas específicas para clique preciso
- ✅ **Ordem correta**: primeiro banco, depois introdução 