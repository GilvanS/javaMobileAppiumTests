@mobile @digio @login

Feature: Login
  Como cliente Digio
  Gostaria de acessar minha conta digital
  Para realizar login com sucesso

  @CT-1001 @ATJ-53
  Scenario: Realizar login com sucesso
    Given que estou na tela inicial do app Digio
    When clico no botão 'Vamos lá' na tela 'Login'
    And preencho o campo 'CPF' na tela 'Login'
    And clico no botão 'Continuar' na tela 'Login'
    And preencho o campo 'Senha' na tela 'Login'
    And clico no botão 'Entrar' na tela 'Login'
    Then valido a exibição da tela 'Home'
