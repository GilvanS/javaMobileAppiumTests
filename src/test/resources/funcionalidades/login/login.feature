@MyDemoApp
Feature: Funcionalidades app MyDemoApp
  como
  quero
  para

  @CT-1001 @Login
  Scenario: Validar Cadastro de usuário com sucesso
    Given que estou na tela Products
    And valido a exibição da frase MYDEMOAPP na tela Products
    And clico no botão menu Hamburguer na tela Products
    And clico no botão Log In na tela Menu
    And preencho o campo Username na tela Login
    And preencho o campo Password na tela Login
    And clico no botão Login na tela Login
    Then valido a exibição da frase Products na tela Products

  @CT-1002 @Compras
  Scenario: Validar Compra de produto com sucesso
    Given que estou na tela Products
    And valido a exibição da frase MYDEMOAPP na tela Products
    And clico no botão menu Hamburguer na tela Products
    And clico no botão Log In na tela Menu
    And preencho o campo Username na tela Login
    And preencho o campo Password na tela Login
    And clico no botão Login na tela Login
    And valido a exibição da frase Products na tela Products
    When clico no produto 'Sauce Labs Backpack' na tela Products
    And clico no botão Add to cart na tela Product Detail
    Then valido a exibição do produto 'Sauce Labs Backpack' no carrinho de compras na tela Cart
    And clico no botão Cart na tela Products
    And clico no botão Proceed to checkout na tela Cart
    And preencho o campo Full Name na tela Checkout
    And preencho o campo Address Line 1 na tela Checkout
    And preencho o campo Address Line 2 na tela Checkout
    And preencho o campo City na tela Checkout
    And preencho o campo State Region na tela Checkout
    And preencho o campo Zip Code na tela Checkout
    And preencho o campo Country na tela Checkout
    And clico no botão To Payment na tela Checkout
    And preencho o campo Full Name na tela Payment
    And preencho o campo Card Number na tela Payment
    And preencho o campo Expiration Date na tela Payment
    And preencho o campo CVV na tela Payment
    And clico no botão Review Order na tela Payment



