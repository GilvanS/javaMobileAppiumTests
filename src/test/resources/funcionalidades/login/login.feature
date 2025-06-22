@WebDriverIO
Feature: Funcionalidades app MyDemoApp
  como
  quero
  para

  @CT-1001 @Home
  Scenario: Validar tela home
    Given que estou na tela home
    Then valido a exibição da frase WEBDRIVERIO na tela Home

  @CT-1002
  Scenario: Validar tela Webview
    Given que estou na tela home
    Given clico no botão Webview na tela Home
    Then valido a exibição da frase Next-gen browser na tela Webview

  @CT-1003
  Scenario: Validar tela login e Sign Up
    Given que estou na tela home
    And clico no botão Login na tela login
    And clico no botão Sign Up na tela Login
    And preencho o campo email na tela Login
    And preencho o campo password na tela Login
    And preencho o campo confirm password na tela Login
    And clico no botão Sign Up Login
    Then valido a exibição da frase Signed Up na tela Login

  @CT-1004
  Scenario: Validar tela login e Sign Up
    Given que estou na tela home
    And clico no botão Login na tela login
    When preencho o campo email na tela Login
    And preencho o campo password na tela Login
    And clico no botão Login na tela Login Sign up Form
    Then valido a exibição da frase Success na tela Login
    And clico no botão OK no popup Login

  @CT-1006
  Scenario: Validar Swipe Horizontal
    Given que estou na tela home
    And clico no botão Swipe na tela Home
    When valido a exibição da frase Support Videos na tela Swipe Horizontal
    When valido a exibição da frase Fully Open Source na tela Swipe Horizontal

