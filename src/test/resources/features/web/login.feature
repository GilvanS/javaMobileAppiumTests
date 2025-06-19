#@login
#Feature: Login do Sistema
#  Como um usuario do sistema
#  Eu quero realizar login
#  Para acessar as funcionalidades do sistema
#
#  @loginInvalido
#  Scenario: Validar login invalido
#    Given que estou na pagina inicial
#    When clico no botao 'Acesso do usuario'
#    And valido a exibicao da opcao 'AUTORIZE' na tela de login
#    And clico no botao 'Efetuar login' na tela login
#    And preencho o campo login e senha com dados invalidos
#    When clico no botao 'Entrar'
#    Then valido a mensagem 'Usuario ou senha invalidos'