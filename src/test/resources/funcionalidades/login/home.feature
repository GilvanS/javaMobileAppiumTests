@all
Feature: Validar tela de home

  @CT01.1
  Scenario: Validar acesso a tela home
    Given que estou na pagina inicial
    When valido o titulo da pagina como 'Olá!'
