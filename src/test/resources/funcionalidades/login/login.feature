@ATJ-148
Feature: Funcionalidades site de viagens CVC
  como
  quero
  para

  @CT-1001 @CVC @ATJ-138
  Scenario: Validar Login
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Entrar' na tela 'Home'
    And valido a exibição da frase Entre para aproveitar a melhor experiência na tela login
    And clico no botão Entre na tela Login
    And preencho o campo email na tela Login
    And clico no botão Próximo na tela Login
    And preencho o campo Senha na tela Login
    And clico no botão Entrar na tela Login
    Then valido a exibição da frase 'Olá, 4Win' na tela 'Home'
    And clico no botão Explorar na tela Home

  @CT-1002 @CVC @ATJ-131
  Scenario: Validar pesquisar viagem
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Pacotes' na tela 'Home'
    When seleciono a cidade no campo Origem na tela Passagens
    And seleciono a cidade no campo Destino na tela Passagens
    And clico no botão Continuar na tela Passagens
    And clico no botão Confirmar Detalhes na tela Passagens
    And seleciono a data no campo Início na tela Passagens
    And seleciono a data no campo Fim na tela Passagens
    And clico no botão Confirmar datas na tela Passagens
    And clico no botão 'Detalhes do Hotel' na tela 'Pacote recomendado'
    And valido a exibição da mensagem 'Detalhes do Hotel' na tela 'Pacote recomendado'
    And clico no botão 'Voltar' na tela 'Pacote recomendado'
    And clico no botão 'Detalhes do valor' na tela 'Pacote recomendado'
    And clico no botão 'Fechar' na tela 'Pacote recomendado'
    And clico no botão 'Reservar Agora' na tela 'Pacote recomendado'
    And valido a exibição da mensagem 'Viaje com mais conforto!' na tela 'Pacote recomendado'
    And clico no botão 'Continuar' na tela 'Pacote recomendado'
    And valido a exibição das mensagem 'Resumo da viagem' na tela 'Carrinho de compras'
    And valido a exibição das mensagem 'Hospedagem' na tela 'Carrinho de compras'
    And valido a exibição das mensagem 'Regras e condições' na tela 'Carrinho de compras'
    And clico no botão 'Ir para o pagamento' na tela 'Carrinho de compras'
    Then clico no botão 'Ver resumo' na tela 'Carrinho de compras'
    And clico no botão Ver Resumo na tela Checkout


  @CT-1005 @CVC @ATJ-132
  Scenario: Validar Hospedagens
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Hotéis' na tela 'Home'
    And seleciono Onde você irá se hospedar? na tela Hoteis
    And clico no botão Confirmar destino na tela Hoteis
    And clico no botão Continuar na tela Defina os detalhes
    And seleciono a data no campo Início na tela Hoteis
    And seleciono a data no campo Fim na tela Hoteis
    And clico no botão Continuar na tela Hoteis
    And valido a exibição da frase 'Escolha uma estadia' na tela Hoteis
    And clico no botão Marcador do mapa na tela Hoteis
    And valido os Hotel para selecionar na tela Hoteis
#    And valido a exibição da frase Ler mais na tela Hoteis
#    And valido a exibição da frase Ver mais na tela Hoteis
#    And valido a exibição da frase Quartos disponíveis na tela Hoteis
#    And clico no botão 'Voltar ao topo' na tela de Hoteis
    And clico no botão 'Reservar' na tela de Hoteis
    And clico no botão Ver resumo na tela 'Checkout'
    And valido o Resumo do pedido na tela 'Checkout'

#    And clico no botão Ver detalhes na tela Hotel
#    And valido a exibição da label Ver quartos disponiveis na tela Hoteis
#    And clico no botão ver quartos disponiveis na tela Hotel
#    And clico no botão reservar na tela Hotel

#    Examples:
#      | CIDADE       | DATA_INICIO | DATA_FIM | HOTEL_SELECIONAVEL                   |
#      | Barcelona    | 29          | 15       | Arcelona Hotel                       |
##    |               |             |         | Villa Olímpic @ Suites Hotel & Spa   |
##    |               |             |         | Villa Olímpic @ Suites Hotel & Spa   |



  @CT-1007 @CVC
  Scenario: Validar Aluguel de carros
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    When clico no botão 'Carros' tela 'Home'
    And seleciono o na tela 'Aluguel de carros'
    And clico no botão 'Continuar' na tela 'Aluguel de carros'
    And seleciono a data no campo Início na tela Passagens
    And seleciono a data no campo Fim na tela Passagens
    And clico no botão 'Continuar' na tela 'Aluguel de carros'
    And clico no botão 'Alterar Horario Retirada' na tela 'Aluguel de carros'
    And seleciono o horario na tela 'Aluguel de carros'
    And clico no botão 'Alterar Horario Devolução' na tela 'Aluguel de carros'
    And seleciono o horario na tela 'Aluguel de carros'
    And clico no botão 'Buscar carros' na tela 'Aluguel de carros'
    Then clico no botão 'Conferir' detalhes na tela 'Aluguel de carros'
    And valido a exibição da frase 'Ver Rotas' na tela 'Aluguel de carros'
    And valido a exibição da frase 'Carro escolhido' na tela 'Aluguel de carros'
    And valido a exibição da frase 'Escolher carro' na tela 'Aluguel de carros'
    And clico no botão 'Voltar ao topo' na tela 'Aluguel de carros'
    And clico no botão 'Reservar' na tela 'Aluguel de carros'
    Then clico no botão 'Ver resumo' na tela 'Carrinho de compras'
#    And clico no botão 'Ver detalhes' na tela 'Aluguel de carros'
#    And valido a exibição da frase 'Características' na tela 'Aluguel de carros'

#    Examples:
#      | LOCAL_DE_RETIRADA | DATA_RETIRADA | DATA_DEVOLUCAO |
#      | Sao Paulo         | 29            | 15             |


  @CT-1008 @CVC @ATJ-136
  Scenario: Validar Ingressos
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Ingressos' na tela 'Home'
    And valido a exibição da frase Escolhar um parque na tela 'Ingressos'
    And seleciono o Destino na tela 'Ingressos'
    And clico no botão Confirmar parque na tela Ingressos
    And clicar no botão Escolha a data na tela 'Ingressos'
    And clico no botão Confirmar datas na tela Ingressos
    And clico no botão Conferir detalhes na tela Ingressos
    And clico o botão Reservar na tela Ingressos
    And clico no botão Ver Resumo na tela 'Checkout'
    And valido a exibição da frase Resumo de Pedido tela 'Checkout'


#    Examples:
#      | DESTINO         | DATA_INICIO | DATA_FIM |
#      | Beto            | 29          | 15       |

