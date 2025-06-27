# Correção da Lógica do PopupModel - Home vs Login

## Problema Identificado

O PopupModel estava sendo configurado incorretamente:
- **LoginActions** tinha configuração de PopupModel (incorreto)
- **HomeActions** tinha configuração de PopupModel (correto)
- Os popups aparecem na **tela Home**, não na tela Login

## Fluxo Correto do Aplicativo

```
1. Tela Login (inicial)
   ↓
2. Clica em "COMECE AGORA"
   ↓
3. Tela Home (principal)
   ↓
4. Popups aparecem aqui (banco, etc.)
   ↓
5. PopupModel deve fechar os popups
```

## Correções Implementadas

### 1. LoginActions.java - Removido PopupModel

#### Removido:
- `getPopupModelLogin()` - método desnecessário
- `validarExibicaoTelaLogin()` - método desnecessário
- `PopupActions` e `PopupModel` imports
- Campo estático `popupActions`

#### Resultado:
```java
// ANTES (incorreto)
public static PopupModel getPopupModelLogin() {
    // Configuração desnecessária para tela Login
}

// DEPOIS (correto)
// Removido completamente - popups não aparecem na tela Login
```

### 2. HomeActions.java - Mantido PopupModel (Correto)

#### Mantido:
- `getPopupModelHome()` - configuração correta
- `fecharPopupBancoComPopupModel()` - método funcional
- `validarExibicaoTelaHome()` - validação da tela Home

#### Configuração Correta:
```java
public static PopupModel getPopupModelHome() {
    PopupModel popupModel = new PopupModel("Home");
    
    // Elementos esperados (tela Home carregada)
    popupModel.setElementosEsperados(homePage().getVldTxtInicio());
    
    // Elementos identificadores do popup (popup presente)
    popupModel.setElementosIdentificadores(
        homePage().getLblEncontreSeuBanco(),
        homePage().getVldTxtVoceJaTentouEncontrarEConectarSeuBanco()
    );
    
    // Elementos de ação (fechar popup)
    popupModel.setElementosDeAcao(homePage().getBtnFechar());
    
    return popupModel;
}
```

## Fluxo de Execução Correto

### 1. Teste de Login (login.feature)
```gherkin
@login
Scenario: Validar Login
  Given clico no botão 'COMECE AGORA' na tela 'Home'
  And clico no botão 'Conectar' com o Google na tela 'Login'
  And seleciono o 'Email' na tela 'Login'
  And clico no botão 'Concluir' na tela 'Login'
```

### 2. Teste de Home (home.feature)
```gherkin
@CT-1001 @wallet
Scenario: Validar Saldo em conta
  Given visualizo o valor do saldo na tela Home  # ← PopupModel usado aqui
  Then valido o valor do saldo no campo Tendencia do saldo na tela Home

@CT-1002
Scenario: Validar Detalhe da conta
  Given valido a exibição da frase Inicio na tela Home  # ← PopupModel usado aqui
  When clico no botão Detalhe da conta na tela Home
  # ...
```

### 3. Execução dos Steps

#### LoginSteps.java
```java
@Given("clico no botão 'COMECE AGORA' na tela 'Home'")
public void clicoNoBotaoCOMECEAGORANaTelaHome() {
    LoginActions.clicarBtnComeceAgora(); // Sem PopupModel
}
```

#### HomeSteps.java
```java
@Given("visualizo o valor do saldo na tela Home")
public void visualizoOValorDoSaldoNaTelaHome() throws IOException {
    HomeActions.visualizarValorSaldo(); // Com PopupModel
}

@Given("valido a exibição da frase Inicio na tela Home")
public void validoAExibicaoDaFraseInicioNaTelaHome() throws IOException {
    HomeActions.validarLblInicio(); // Com PopupModel
}
```

## Métodos que Usam PopupModel

### HomeActions.java
1. **`visualizarValorSaldo()`**
   ```java
   public static void visualizarValorSaldo() throws IOException {
       // Fecha popup antes de visualizar o saldo usando PopupModel
       fecharPopupBancoComPopupModel();
       // ... resto da lógica
   }
   ```

2. **`validarLblInicio()`**
   ```java
   public static void validarLblInicio() throws IOException {
       // Fecha popup antes de validar usando PopupModel
       fecharPopupBancoComPopupModel();
       // ... resto da lógica
   }
   ```

3. **`validarExibicaoTelaHome()`**
   ```java
   public static void validarExibicaoTelaHome() {
       // Valida a tela Home usando PopupModel
       popupActions.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
       // ... resto da lógica
   }
   ```

## Benefícios da Correção

1. **Lógica Correta**: PopupModel usado apenas onde os popups aparecem
2. **Código Limpo**: Remoção de código desnecessário do LoginActions
3. **Performance**: Não há overhead desnecessário na tela Login
4. **Manutenibilidade**: Lógica centralizada no HomeActions
5. **Clareza**: Separação clara de responsabilidades

## Resumo

- ✅ **LoginActions**: Sem PopupModel (correto)
- ✅ **HomeActions**: Com PopupModel (correto)
- ✅ **Fluxo**: Login → Home → PopupModel ativo
- ✅ **Elementos**: Popup detectado e fechado automaticamente na tela Home

Agora o PopupModel está sendo usado corretamente apenas na tela Home, onde os popups realmente aparecem. 