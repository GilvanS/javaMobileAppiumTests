@ATJ-148
Feature: Funcionalidades site de viagens CVC
  como
  quero
  para

  @CT-1001 @EBAC-Store @CadastroDeUsuario
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
    And clico no botão Wishlist na tela Home
    And clico no botão voltar na tela Wishlist
    And clico no botão Profile na tela Home
    And valido o nome do usuário na tela Profile
    And valido o Phone Number do usuário na tela Profile
    And valido o Email Address do usuário na tela Profile
    And clico no botão Edit Profile na tela Profile
    And valido o First Name do usuário na tela Edit Profile
    And valido o Last Name do usuário na tela Edit Profile
    And valido o Phone Number do usuário na tela Edit Profile
    And valido o Email Address do usuário na tela Edit Profile
    And clico no botão voltar na tela Edit Profile
    And clico no botão Logout na tela Profile



