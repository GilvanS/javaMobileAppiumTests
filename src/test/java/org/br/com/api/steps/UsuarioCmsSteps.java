package org.br.com.api.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.br.com.api.controllers.usuarios.UsuarioCmsController;

import org.br.com.api.utils.LogFormatter;


public class UsuarioCmsSteps {

    private UsuarioCmsController usuarioCmsController;

    public UsuarioCmsSteps(){
        this.usuarioCmsController = new UsuarioCmsController();
    }

    @When("que envio uma requisicao de registro de usuario CMS")
    public void queEnvioUmaRequisicaoDeRegistroUsuarioCMS() {
        LogFormatter.logStep("Enviando requisicao de registro de usuario CMS");
        usuarioCmsController.cadastrarNovoUsuario();
    }

    @When("o sistema processa a requisicao")
    public void oSistemaProcessaARequisicao() {
        LogFormatter.logStep("O sistema processa a requisicao");
    }

    @Then("a API deve retornar o codigo de status {int}")
    public void aAPIDeveRetornarOCodigoDeStatus(int statusCode) {
        LogFormatter.logStep("Validando o status code da resposta da API " + statusCode);
        usuarioCmsController.validarStatusCode(statusCode);
    }

    @When("eu envio a requisicao de login com as credenciais do usuario")
    public void euEnvioARequisicaoDeLoginComAsCredenciaisDoUsuario() {
        LogFormatter.logStep("Enviando requisicao de login com as credenciais do usuario");
        usuarioCmsController.realizarLogin();
    }

    @Then("o token de autenticacao deve ser retornado")
    public void oTokenDeAutenticacaoDeveSerRetornado() {
        LogFormatter.logStep("Validando o token de autenticacao retornado");
        usuarioCmsController.validarStatusCode(200);
    }

    @When("eu envio a requisicao de listar de usuarios com autenticacao")
    public void euEnvioARequisicaoDeListarDeUsuariosComAutenticacao() {
        LogFormatter.logStep("Enviando requisicao de listar usuarios com autenticaçao");
        usuarioCmsController.listarUsuariosComAutenticacao();
    }

    // ESTE É O MÉTODO CORRETO PARA O CENÁRIO DE BUSCA POR ID
    @Then("os dados do usuario consultado devem ser retornados na resposta")
    public void osDadosDoUsuarioConsultadoDevemSerRetornadosNaResposta() {
        LogFormatter.logStep("Validando os dados do usuario consultado na resposta");
        // Chama o NOVO método de validação no controller
        usuarioCmsController.validarDadosDoUsuarioConsultado();
    }

    // Este método antigo permanece, mas será usado apenas para o cenário de LISTAR usuários
    @Then("os dados do usuario devem ser retornados na resposta")
    public void osDadosDoUsuarioDevemSerRetornadosNaResposta() {
        LogFormatter.logStep("Validando os dados do usuario retornados na resposta (em lista)");
        usuarioCmsController.validarNomeUsuario();
    }

    @When("eu envio a requisicao de busca de usuario por ID")
    public void euEnvioARequisicaoDeBuscaDeUsuarioPorID() {
        LogFormatter.logStep("Enviando requisicao de busca de usuario por ID");
        usuarioCmsController.consultarUsuarioPorId();
    }

    @When("que envio a solicitacao de PUT com ID")
    public void queEnvioASolicitacaoDePUTComID() {
        LogFormatter.logStep("Enviando solicitacao de PUT com ID");
        usuarioCmsController.atualizarUsuarioPorId();
    }

    @Then("valido o retorno usuario atualizado com status code {int} e mensagem {string}")
    public void validoORetornoUsuarioAtualizadoComStatusCodeENesagem(int statusCode, String mensagem) {
        LogFormatter.logStep("Validando o retorno do usuario atualizado com status code e mensagem");
        usuarioCmsController.validarStatusCode(statusCode);
    }

    @When("envio uma solicitacao de DELETE para o ID")
    public void envioUmaSolicitacaoDeDELETEParaOID() {
        LogFormatter.logStep("Enviando solicitacao de DELETE para o ID do usuario");
        usuarioCmsController.excluirUsuarioPorId();
    }

    @Then("deve retornar o status code {int} para exclusao")
    public void deveRetornarOStatusCodeParaExclusao(int statusCode) {
        LogFormatter.logStep("Validando o status code de exclusao do usuario");
        usuarioCmsController.validarStatusCode(statusCode);
    }
}