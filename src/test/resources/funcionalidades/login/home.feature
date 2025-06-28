@all
Feature: Validar tela de home

  Background: Validar Login
    Given clico no botão 'COMECE AGORA' na tela 'Home'
    And clico no botão 'Conectar' com o Google na tela 'Login'
    And seleciono o 'Email' na tela 'Login'
    And clico no botão 'Concluir' na tela 'Login'

  @CT-1001 @wallet
  Scenario: Validar Saldo em conta
    Given visualizo o 'Valor' do saldo na tela 'Home'
    Then valido o valor do saldo no campo 'Tendencia do saldo' na tela 'Home'

  @CT-1002
  Scenario: Validar Detalhe da conta
    Given valido a exibição da frase 'Inicio' na tela 'Home'
    When clico no botão 'Detalhe da conta' na tela 'Home'
    And visualiso o 'Valor' do saldo na tela 'Detalhe da conta'
    And clico no botão 'Voltar' na tela 'Detalhe da conta'
    Given visualizo o 'Valor' do saldo na tela 'Home'
    Then valido o valor do saldo no campo 'Tendencia do saldo' na tela 'Home'



