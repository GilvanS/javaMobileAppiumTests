@all
Feature: Validar tela de home

  @CT01.1
  Scenario: Validar acesso a tela home
    Given que estou na pagina inicial
    When valido o titulo da pagina como 'Olá!'
    And clico no botão Entre na conta na 'tela inicial'
    And preencho o campo CPF com '11111111111' 'tela inicial'
    And preencho o campo Senha com 'admin999' 'tela inicial'
    And clico no botao 'Entrar' 'tela inicial'
    Then devo ver a mensagem de boas vindas 'Acesso minha conta' 'tela Home'
