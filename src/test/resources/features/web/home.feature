@all @home @ATJ-334
Feature: Home
  Como usuario do sistema
  Eu quero acessar a pagina inicial
  Para visualizar as informacoes principais do sistema


  @user @ATJ-426
  Scenario: Validar acesso do usuario na pagina inicial
    Given que estou na pagina inicial
    When clico no botao 'Acesso do usuario'
    Then valido a exibicao da mensagem 'Seja bem-vindo ao portal do usuario Orizon.'

  @homeContato @ATJ-427
  Scenario: Validar botao contato na pagina inicial
    Given que estou na pagina inicial
    When clico no botao 'Contato'
    Then valido a exibicao da mensagem 'Para saber mais sobre as soluções'

#  @trabalhe_conosco @ATJ-424
#  Scenario: Validar botao Trabalhe Conosco
#    Given que estou na pagina inicial
#    When clico no botao 'Trabalhe Conosco'
#    And troco para a nova aba
#    Then valido a exibicao da mensagem 'Sobre a Orizon'
#
#  @solucoes
#  Scenario: Validar botao Solucoes
#    Given que estou na pagina inicial
#    When clico no botao 'Soluções'
#    Then valido a exibicao das mensagens 'Frente', 'Automatizada', 'Apoio', 'Consultoria'
#
#  @frente_automatizada
#  Scenario: Validar sub botao Frente Automatizada de Solucoes
#    Given que estou na pagina inicial
#    When clico no botao 'Soluções'
#    And clico no botao 'Frente Automatizada'
#    Then valido a exibicao da mensagem 'FRENTE AUTOMATIZADA'
#
#  @consultoria
#  Scenario: Validar sub botao Consultoria de Solucoes
#    Given que estou na pagina inicial
#    When clico no botao 'Soluções'
#    And clico no botao 'Consultoria'
#    Then valido a exibicao da mensagem 'Inteligência médica, inteligência'
#
#  @lgpd
#  Scenario: Validar sub botao LGPD na Orizon de Quem somos
#    Given que estou na pagina inicial
#    When clico no botao 'Quem somos'
#    And clico no botao 'LGPD na Orizon'
#    Then valido a exibicao da mensagem 'LGPD NA ORIZON'