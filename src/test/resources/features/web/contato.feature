#@contato
#Feature: Formulario de Contato
#  Como usuario do sistema
#  Eu quero preencher o formulario de contato
#  Para enviar uma mensagem para a equipe de suporte
#
#  @formularioContatoTimeDeVendas
#  Scenario: Validar formulario para contato
#    Given que estou na pagina inicial
#    When clico no botao 'Contato'
#    Then valido a exibicao da mensagem 'Entre em Contato'
#    When preencho o campo 'Nome' com 'Teste Automatizado'
#    And preencho o campo 'Email' com 'teste@teste.com'
#    And preencho o campo 'Documento' com '12345678900'
#    And preencho o campo 'Telefone' com '11999999999'
#    And seleciono a opcao 'Contato com time de vendas' no campo 'assunto'
#    And preencho o campo 'Mensagem' com 'Esta é uma mensagem de teste automatizado'
#    And marco o checkbox de concordo
#    And valido o reCAPTCHA
#    Then valido que o formulario foi preenchido corretamente
#
#  @fomularioContatoTimeDeSuporte
#  Scenario: Preencher formulario de contato com sucesso
#    Given que estou na pagina inicial
#    When clico no botao 'Contato'
#    Then valido a exibicao da mensagem 'Entre em Contato'
#    When preencho o campo 'Nome' com 'Joao Silva'
#    And preencho o campo 'Email' com 'joao.silva@email.com'
#    And preencho o campo 'Documento' com '12345678900'
#    And preencho o campo 'Telefone' com '11999999999'
#    And seleciono a opcao 'Contato com time de suporte' no campo 'assunto'
#    And preencho o campo 'Mensagem' com 'Esta é uma mensagem de teste automatizado'
#    And marco o checkbox de concordo
#    And valido o reCAPTCHA
#    Then valido que o formulario foi preenchido corretamente
#
#  @camposObrigatorios
#  Scenario: Validar campos obrigatorios do formulario
#    Given que estou na pagina inicial
#    When clico no botao 'Contato'
#    Then valido a exibicao da mensagem 'Entre em Contato'
#    When clico no botao 'Enviar'
#    And valido que o campo 'Nome' retorna "Preencha este campo"
#
#
#  @emailInvalido
#  Scenario: Validar formato de email invalido
#    Given que estou na pagina inicial
#    When clico no botao 'Contato'
#    Then valido a exibicao da mensagem 'Entre em Contato'
#    When preencho o campo 'Nome' com 'Joao Silva'
#    And preencho o campo 'Email' com 'email.invalido'
#    And preencho o campo 'Documento' com '12345678900'
#    And preencho o campo 'Telefone' com '11999999999'
#    And seleciono a opcao 'Contato com time de vendas' no campo 'assunto'
#    And preencho o campo 'Mensagem' com 'Esta é uma mensagem de teste automatizado'
#    And marco o checkbox de concordo
#    And valido o reCAPTCHA
#    Then valido que o formulario foi preenchido corretamente
#    And clico no botao 'Enviar'
#    Then valido a mensagem nativa do navegador "Inclua um \"@\" no endereço de email. \"email.invalido\" não contém um \"@\""