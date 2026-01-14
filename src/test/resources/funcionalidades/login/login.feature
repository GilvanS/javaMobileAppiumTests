@login @all
Feature: Validar tela de home


  @CT-01.1
  Scenario: Validar acesso a tela inicial
    Given que estou na pagina inicial
    When valido a exibicao da mensagem 'Olá!' na 'tela inicial'
    Then valido a exibicao da mensagem 'Entre na conta' na 'tela inicial'
    And clico no botão 'Entre na conta' na 'tela Login'
    And valido a exibicao da mensagem 'Não tem uma conta? Cadastre-se' 'na tela Login'
    
  @CT-01.2
  Scenario: Validar login com sucesso
    Given que estou na pagina inicial
    When valido o titulo da pagina como 'Olá!'
    And clico no botão 'Entre na conta' da conta na 'tela inicial'
    And preencho o campo CPF na 'tela inicial'
    And preencho o campo Senha na 'tela inicial'
    And clico no botão 'Entrar' na 'tela inicial'
    Then devo ver a mensagem 'Bem-vindo!' na 'tela Home'
    And clico no botão 'Começar a usar' na 'tela Home'

  @CT-01.3
  Scenario: Validar mensagem 'Campo SENHA obrigatorio'
    And clico no botão 'Entre na conta' da conta na 'tela inicial'
    And preencho o campo CPF na 'tela inicial'
    Then clico no botão 'Entrar' na 'tela login'
    And valido a exibicao da mensagem 'CPF ou senha inválidos.' na 'tela Login'

  @CT-01.4
  Scenario: Validar mensagem 'Campo CPF obrigatorio'
    And clico no botão 'Entre na conta' da conta na 'tela inicial'
    And preencho o campo Senha na 'tela login'
    Then clico no botão 'Entrar' na 'tela login'
    And valido a exibicao da mensagem 'CPF deve ter 11 numeros' na 'tela Login'
