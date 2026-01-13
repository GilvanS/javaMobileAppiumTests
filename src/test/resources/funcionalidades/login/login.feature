@login @all
Feature: Validar tela de home

  @CT-01.1
  Scenario: Validar login com sucesso
    Given que estou na pagina inicial
    When valido o titulo da pagina como 'Olá!'
    And clico no botão 'Entre na conta' da conta na 'tela inicial'
    And preencho o campo CPF na 'tela inicial'
    And preencho o campo Senha na 'tela inicial'
    And clico no botao 'Entrar' na 'tela inicial'
    Then devo ver a mensagem 'Bem-vindo!' na 'tela Home'
    And clico no botao 'Começar a usar' na 'tela Home'