Feature: Minhas chaves pix

  Background:
    Given que estou na pagina inicial
    When valido o titulo da pagina como 'Olá!'
    And clico no botão Entre na conta na 'tela inicial'
    And preencho o campo CPF na 'tela inicial'
    And preencho o campo Senha na 'tela inicial'
    And clico no botao 'Entrar' 'tela inicial'
    Then devo ver a mensagem de boas vindas 'Bem-vindo!' 'tela Home'
    And clico no botao 'Comecar a usar' na 'tela Home'

  @CT-02.1
   Scenario: Validar cadastro de chave PIX
    Given que estou na tela Home
    When clico no menu 'PIX' na 'tela Home'
    And clico no botao 'Minhas Chaves' na 'tela PIX'
    And clico no botao 'Cadastrar Nova Chave' na 'tela Minhas Chaves PIX'
    And seleciono o tipo de chave para cadastro na tela 'tela Minhas Chaves PIX'
    And preencho o campo chave com 'email' 'tela Minhas Chaves PIX'
    And clico no botao 'Cadastrar' na 'tela Minhas Chaves PIX'
    Then valido a mensagem de sucesso 'Chave cadastrada com sucesso!' na 'tela Minhas Chaves PIX'
    And valido a chave cadastrada na lista de chaves na 'tela Minhas Chaves PIX'

  @CT-02.2
  Scenario: Validar Exclusão da chave PIX Email
    Given que estou na tela Home
    When clico no menu 'PIX' na 'tela Home'
    And clico no botao 'Minhas Chaves' na 'tela PIX'
    And clico no botão excluir chave pix Email na 'tela Minhas Chaves PIX'
    Then valido a mensagem de sucesso 'Chave removida' na 'tela Minhas Chaves PIX'
    And valido a mensagem de sucesso 'Nenhuma chave PIX cadastrada.' na 'tela Minhas Chaves PIX'
