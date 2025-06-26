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

   @CT-1003 @CVC @ATJ-137
  Scenario: Validar fluxo Selecionar voo Só Ida para 1 viajante
     Given clico no botão 'Pular introdução'
     And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
     When clico no botão 'Passagens' na tela 'Home'
     And clicar no botão Só ida na tela Passagens
     And seleciono a cidade no campo Origem na tela Passagens
     And seleciono a cidade no campo Destino na tela Passagens
     And clico no botão Continuar na tela Passagens
     And clico no botão Continuar na tela Defina os detalhes
     And seleciono a data no campo Escolha a data na tela Passagens
     And clico no botão Continuar na tela Passagens
     And Seleciono o voo de ida na tela Passagens
     And clico no botão Continuar sem upgrade na tela Passagens
     And clico no botão Confirmar na tela Passagens
     Then clico no botão 'Ver resumo' na tela 'Carrinho de compras'
     And clico no botão Ver Resumo na tela Checkout

#  @CT-1004 @CVC @ATJ-139
#  Scenario Outline: Validar Circuitos
#    Given esteja na tela inicial do site CVC
#    And clicar no botão Circuitos na tela 'Passagens'
#    And seleciono o Destino "<DESTINO_UM>" na tela 'Tours'
#    And seleciono a data "<DATA_INICIO>" no campo 'Início' na tela 'Tours'
#    And clicar no botão 'Buscar' na tela 'Tours'
#    And clicar no botão 'Ver itinerario' na tela 'Tours'
#    And clicar no botão 'Ver hotéis' previstos na tela 'Tours'
#    When clicar no botão 'Conferir' Detalhes na tela 'Tours'

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
    And valido a exibição da frase Ler mais na tela Hoteis
    And valido a exibição da frase Ver mais na tela Hoteis
    And valido a exibição da frase Quartos disponíveis na tela Hoteis
    And clico no botão 'Voltar ao topo' na tela de Hoteis
    And clico no botão 'Reservar' na tela de Hoteis
    And clico no botão Ver resumo na tela 'Checkout'
    And valido o Resumo do pedido na tela 'Checkout'

#  @CT-1006 @CVC @ATJ-140
#  Scenario Outline: Validar Pacotes
#    Given esteja na tela inicial do site CVC
#    And clicar no botão 'Pacotes' na tela 'Passagens'
#    When seleciono a cidade "<CIDADE_ORIGEM>" no campo 'Origem' na tela 'Pacotes turisticos'
#    And seleciono a cidade "<CIDADE_DESTINO>" no campo 'Destino' na tela 'Pacotes turisticos'
#    And seleciono a data "<DATA_INICIO>" no campo 'Início' na tela 'Pacotes turisticos'
#    And seleciono a data "<DATA_FIM>" no campo 'Fim' na tela 'Pacotes turisticos'
#    When clicar no botão Buscar na tela 'Pacotes turisticos'
#    And valido a exibição do pacote "<PACOTES>" selecionado na tela 'Pacotes turisticos'
#    And clicar no botão 'Reservar Agora' na tela 'Pacotes turisticos'
#    And clicar no botão 'Estou ciente' na tela 'Pacotes turisticos'
#    And valido a exibição da Hospedagem na tela Carrinho
#    When clicar no botão Ir para o pagamento na tela 'Carrinho'
#    Then valido a exibição da mensagem 'Resumo do seu pacote'

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
    And clico no botão 'Ver detalhes' na tela 'Aluguel de carros'


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

#  @CT-1009 @CVC @ATJ-133
#  Scenario Outline: Validar Onibus - Pacote Rodoviario
#    Given esteja na tela inicial do site CVC
#    And clicar no botão Onibus na tela 'Passagens'
#    When seleciono a cidade "<CIDADE_ORIGEM>" no campo 'Origem' na tela 'Rodoviario'
#    And seleciono a cidade "<CIDADE_DESTINO>" no campo 'Destino' na tela 'Rodoviario'
#    And seleciono a data "<DATA_INICIO>" no campo 'Ida' na tela 'Rodoviario'
#    And seleciono a data "<DATA_FIM>" no campo 'Volta' na tela 'Rodoviario'
#    And clicar no botão Selecionar no campo 'Volta' na tela 'Rodoviario'
#    And clicar no botão Buscar passagem na tela 'Rodoviario'
#    And clicar no botão conferir detalhes na tela 'Rodoviario'
#
#    Examples:
#      | CIDADE_ORIGEM | CIDADE_DESTINO | DATA_INICIO | DATA_FIM |
#      | Tiete         | Santos         | 20          | 30       |

  @CT-1010 @CVC @ATJ-135
    Scenario: Validar Cruzeiros
        Given clico no botão 'Pular introdução'
        And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
        And clico no botão 'Cruzeiros' na tela 'Home'
        And clico no campo destinos na tela 'Cruzeiros'
        And clico no campo Datas na tela 'Cruzeiros'
        And clico no campo Embarque na tela 'Cruzeiros'
        And clico no campo Desembarque na tela 'Cruzeiros'
        And clico no botão Buscar Cruzeiros na tela 'Cruzeiros'
        And clico no botão Selecionar na tela 'Cruzeiros'
        And clico no botão Confirmar na tela 'Cruzeiros'
        And valido a exibição da frase 'Escolha o tipo da cabine' na tela 'Checkout'
        And valido a exibição da frase 'Preferência da cabine' na tela 'Checkout'
        And clico no botão 'Continuar' na tela 'Checkout'
        And seleciono o Deck na tela 'Checkout'
        And clico no botão 'Continuar' na tela 'Checkout'
        And valido a exibição da frase 'Cabine' na tela 'Checkout'

