package org.br.com.api.controllers.usuarios;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.br.com.api.manager.TokenManager;
import org.br.com.api.manager.UsuarioManager;
import org.br.com.api.model.usuarios.UsuarioCms;
import org.br.com.api.utils.FakerApiData;
import org.br.com.api.utils.LogFormatter;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UsuarioCmsController {
    private Response response;
    private static final String BASE_URL = "http://localhost:3000";
    private static final String ENDPOINT_USUARIOS = "/usuarios";
    private static final String ENDPOINT_LOGIN = "/auth/login";

    public UsuarioCmsController() {
        response = null;
    }


    public void cadastrarNovoUsuario() {
        UsuarioCms usuarioGerado = FakerApiData.gerarUsuarioCmsFake();
        this.response = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(usuarioGerado)
                .when()
                .post(ENDPOINT_USUARIOS);

        UsuarioManager.setEmailUsuario(usuarioGerado.getEmail());
        UsuarioManager.setSenhaUsuario(usuarioGerado.getSenha());
        UsuarioManager.setIdUsuario(response.jsonPath().getString("id"));

    }

    public void realizarLogin() {
        String email = UsuarioManager.getEmailUsuario();
        String senha = UsuarioManager.getSenhaUsuario();

		UsuarioCms request = UsuarioCms.builder()
                .email(email)
                .senha(senha)
                .build();

        this.response = given()
                .contentType(ContentType.JSON)
                .baseUri(BASE_URL)
                .body(request)
                .when()
                .post(ENDPOINT_LOGIN);

        if (response.getStatusCode() == 200) {
            String token = response.jsonPath().getString("token");
            TokenManager.setToken(token);
        }
    }

    
    public void listarUsuariosComAutenticacao() {
        String token = TokenManager.getToken();
        this.response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .baseUri(BASE_URL)
                .when()
                .get(ENDPOINT_USUARIOS);
    }

    public void consultarUsuarioPorId() {
        String token = TokenManager.getToken();
        String id = UsuarioManager.getIdUsuario();
        this.response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .baseUri(BASE_URL)
                .when()
                .get(ENDPOINT_USUARIOS + "/" + id);
    }

    public void atualizarUsuarioPorId() {
        String token = TokenManager.getToken();
        String id = UsuarioManager.getIdUsuario();
        Map<String, String> dadosAtualizacao = FakerApiData.gerarDadosAtualizacaoUsuario();

        this.response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .baseUri(BASE_URL)
                .body(dadosAtualizacao)
                .when()
                .put(ENDPOINT_USUARIOS + "/" + id)
                .then()
                .extract().response();

        // Salva os dados atualizados no Manager para validações posteriores
        UsuarioManager.setEmailUsuario(dadosAtualizacao.get("email"));
    }

    public void excluirUsuarioPorId() {
        String token = TokenManager.getToken();
        String idUsuario = UsuarioManager.getIdUsuario();
        this.response = given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token)
                .baseUri(BASE_URL)
                .when()
                .delete(ENDPOINT_USUARIOS + "/" + idUsuario);
    }

    public void validarStatusCode(int expectedStatusCode) {
        try {
            assertEquals("StatusCode deve ser: " + expectedStatusCode, expectedStatusCode, response.getStatusCode());
        } catch (AssertionError e) {
            LogFormatter.logAssertionError(e);
            throw e;
        }
    }

    // MÉTODO DE VALIDAÇÃO PARA UM ÚNICO USUÁRIO (GET /usuarios/{id})
    public void validarDadosDoUsuarioConsultado() {
        // Pega os dados esperados que foram salvos no Manager
        String expectedId = UsuarioManager.getIdUsuario();
        String expectedEmail = UsuarioManager.getEmailUsuario();

        // Extrai os dados da resposta da API, que é um OBJETO, não uma lista.
        // Usamos getString() para pegar valores de chaves específicas.
        String actualId = response.jsonPath().getString("id");
        String actualEmail = response.jsonPath().getString("email");

    }

    // Este método está correto, mas apenas para a resposta de LISTA (GET /usuarios)
    public void validarNomeUsuario() {
        List<Map<String, Object>> usuarios = this.response.jsonPath().getList("$");
        boolean usuarioEncontrado = usuarios.stream()
                .anyMatch(usuario -> usuario.get("email").equals(UsuarioManager.getEmailUsuario()));

        assertTrue("Usuário não consta na lista de cadastrados",
                usuarioEncontrado);
    }

}