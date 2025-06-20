@mobile @digio @sacar

Feature: Minhas Compras
  Como cliente Digio
  Gostaria de acessar minhas compras
  Para verificar ter acesso ao meu histórico de compras efetuadas

  Background:Realizar login com sucesso
    Given que estou na tela inicial do app Digio
    When clico no botão 'Vamos lá' na tela 'Login'
    And preencho o campo 'CPF' na tela 'Login'
    And clico no botão 'Continuar' na tela 'Login'
    And preencho o campo 'Senha' na tela 'Login'
    And clico no botão 'Entrar' na tela 'Login'
    And valido a exibição do botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'
    And clico no botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'
    Then valido a exibição da tela 'Home'

  @CT-2002
  Scenario: Tela da home validar botão SACAR
    When clico no botão 'Conta' na tela 'Home'
    And clico no botão 'Sacar' na tela 'Home'
    And selecionar o valor desejado de saque na tela 'Saque digital'
    And clico no botão 'Continuar' na tela 'Saque digital'
    Then Deve ser apresentado a tela para escanear o QR Code