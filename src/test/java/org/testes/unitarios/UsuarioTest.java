package org.testes.unitarios;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.utilidades.dados.Usuario;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class UsuarioTest extends Usuario {

    @TestFactory
    Stream<DynamicTest> validarLeituraDeDados() {
        // Tags para teste dinâmico
        Stream<String> tags = Stream.of("CT-01.1");

        return tags.map(tag -> dynamicTest("Validar leitura para tag: " + tag, () -> {
            // Acesso ao método protegido via herança
            String email = obterInformacao(tag, 3);
            assertNotNull(email, "Email não deveria ser nulo para a tag " + tag);
        }));
    }
}
