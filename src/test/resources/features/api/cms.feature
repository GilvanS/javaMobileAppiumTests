@UsuarioCms @API @ATJ-334 @all
Feature: Gerenciamento de usuarios CMS
  Como um administrador de sistema
  Eu quero gerenciar usuarios CMS
  Para que eu possa controlar o acesso ao sistema

  @CT-3001 @ATJ-332 @API
  Scenario: Criar um novo usuario CMS com sucesso
    Given que envio uma requisicao de registro de usuario CMS
    When o sistema processa a requisicao
    Then a API deve retornar o codigo de status 201

  @CT-3002 @ATJ-331 @API
  Scenario: Realizar login com usuario CMS
    Given eu envio a requisicao de login com as credenciais do usuario
    Then a API deve retornar o codigo de status 200
    And o token de autenticacao deve ser retornado
#
#  @CT-3003 @ATJ-329 @API
#  Scenario: Buscar a lista de usuarios CMS com autenticaçao
#    When eu envio a requisicao de listar de usuarios com autenticacao
#    Then a API deve retornar o codigo de status 200
#    And os dados do usuario devem ser retornados na resposta
#
#
#  @CT-3004
#  Scenario: Busca de usuario por ID
#    Given eu envio a requisicao de busca de usuario por ID
#    Then a API deve retornar o codigo de status 200
#    And os dados do usuario consultado devem ser retornados na resposta
#
#  @CT-3005
#  Scenario: Validar alteraçao de usuario
#    Given que envio a solicitacao de PUT com ID
#    Then valido o retorno usuario atualizado com status code 200 e mensagem 'usuario atualizado ou sem alterações'
#
#  @CT-3006 @ATJ-330 @API
#  Scenario: Validar exclusao de usuario
#    When envio uma solicitacao de DELETE para o ID
#    Then deve retornar o status code 204 para exclusao