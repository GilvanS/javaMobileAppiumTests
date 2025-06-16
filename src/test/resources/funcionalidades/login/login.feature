@ATJ-148
Feature: Funcionalidades site de viagens CVC
  como
  quero
  para

  @CT-1001 @EBAC-Store @Login
  Scenario: Validar Cadastro de usuário com sucesso
    Given que estou na tela Home
    And valido a exibição da frase EBAC Store tela Home
    And clico no botão Profile na tela Home
    And valido a exibição da frase Welcome to EBAC Shop na tela Login
    And clico no botão Sign up na tela Login
    And preencho o campo First Name na tela Login
    And preencho o campo Last Name na tela Login
    And preencho o campo Phone Number na tela Login
    And preencho o campo Email Address na tela Login
    And preencho o campo Password na tela Login
    And preencho o campo ReEnter Password na tela Login
    And clico no botão Create na tela Login


