@all
Feature: Funcionalidade Login
  como
  quero
  para

  @login
  Scenario: Validar Login
    Given clico no botão 'COMECE AGORA' na tela 'Home'
    And clico no botão 'Conectar' com o Google na tela 'Login'
    And seleciono o 'Email' na tela 'Login'
    And clico no botão 'Concluir' na tela 'Login'
