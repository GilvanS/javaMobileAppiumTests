# Plano de Migração e Melhoria: JUnit 5 + Cucumber

## Estratégia
A migração será dividida em 4 Sprints. Cada sprint entrega uma melhoria isolada e testável.

---

## Sprint 1: Otimização do POM (A Base)
**Objetivo**: Limpar redundâncias e configurar o poder do JUnit 5 (Paralelismo) diretamente no `pom.xml`.
**Status**: Concluído.

## Sprint 2: Limpeza do Runner (Configuração Java)
**Objetivo**: Padronizar a classe `CucumberTest.java` utilizando as anotações da JUnit Platform.
**Status**: Concluído.

---

## Sprint 3: O Código (Asserções Modernas & Dynamic Tests)
**Objetivo**: Substituir validações antigas por `Assertions` do JUnit Jupiter e introduzir Testes Dinâmicos.

### Exemplo Prático: Assertions (Soft Assertions)
**Cenário**: Validar múltiplos elementos na tela (ex: Título e Botão).

#### 🔴 Antes (JUnit 4 / Tradicional)
Se o título estiver errado, o teste falha e **não** verifica o botão.
```java
// HomeSteps.java
import org.junit.Assert;

public void validarTelaHome() {
    String titulo = homePage.getTitulo();
    String botao = homePage.getTextoBotao();

    Assert.assertEquals("Olá!", titulo);       // Se falhar aqui...
    Assert.assertEquals("Entrar", botao);      // ...nunca testa isso!
}
```

#### 🟢 Depois (JUnit 5 - assertAll)
Verifica **tudo** e reporta todos os erros de uma vez.
```java
// HomeSteps.java
import org.junit.jupiter.api.Assertions;

public void validarTelaHome() {
    String titulo = homePage.getTitulo();
    String botao = homePage.getTextoBotao();

    Assertions.assertAll("Validação da Home",
        () -> Assertions.assertEquals("Olá!", titulo, "Título incorreto"),
        () -> Assertions.assertEquals("Entrar", botao, "Texto do botão incorreto")
    );
}
```

---

### Exemplo Prático: Dynamic Tests (@TestFactory)
**Cenário**: Validar a leitura de dados do Excel (`Usuario.java`) para várias tags sem precisar rodar o Appium.

#### 🔴 Antes (Não existia / Manual)
Você teria que rodar o cenário Cucumber inteiro para ver se o dado vem null.

#### 🟢 Depois (JUnit 5 - DynamicTest)
Um teste unitário que roda em milissegundos e valida todas as tags.

```java
// src/test/java/org/testes/unitarios/UsuarioTest.java
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.utilidades.dados.Usuario;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class UsuarioTest {

    @TestFactory
    Stream<DynamicTest> validarLeituraDeDados() {
        // Lista de tags que DEVEM funcionar
        Stream<String> tags = Stream.of("CT-01.1", "CT-01.2", "CT-02.1");

        return tags.map(tag -> dynamicTest("Validar leitura para tag: " + tag, () -> {
            // Simula o comportamento (precisaria refatorar levemente o Usuario.java para aceitar tag por parametro ou mockar o Hook)
            // Aqui é um exemplo conceitual do poder do Dynamic Test
            String email = Usuario.obterInformacao(tag, 3); 
            assertNotNull(email, "Email não deveria ser nulo para a tag " + tag);
        }));
    }
}
```

---

## Sprint 4: Otimização (Hooks e Ciclo de Vida)
**Objetivo**: Garantir que o ciclo de vida (Hooks) esteja otimizado.
