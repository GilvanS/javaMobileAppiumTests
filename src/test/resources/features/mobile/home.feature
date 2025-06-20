@mobile @digio @home
Feature: Dados da Conta
  Como cliente Digio
  Gostaria de acessar os dados da conta
  Para verificar meus dados

  #@PRECOND
  Background: Realizar login com sucesso
    Given que estou na tela inicial do app Digio
    When clico no botão 'Vamos lá' na tela 'Login'
    And preencho o campo 'CPF' na tela 'Login'
    And clico no botão 'Continuar' na tela 'Login'
    And preencho o campo 'Senha' na tela 'Login'
    And clico no botão 'Entrar' na tela 'Login'
    And valido a exibição do botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'
    And clico no botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'
    Then valido a exibição da tela 'Home'

  @CT-2001 @dadosDaConta
  Scenario: Visualizar os dados da minha conta no menu
    When clico no botão 'Menu' na tela 'Home'
    Then valido a exibição do texto 'Nome' na tela 'Menu'
    And valido a exibição do texto 'Instituição' na tela 'Menu'
    And valido a exibição do texto 'Agência' na tela 'Menu'
    And valido a exibição do texto 'Conta' na tela 'Menu'