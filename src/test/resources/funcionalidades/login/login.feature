
@ATJ-148
Feature: Funcionalidades site de viagens CVC
  como
  quero
  para

  @CT-1001 @CVC @ATJ-138
  Scenario Outline: Validar Login
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Entrar' na tela 'Home'
    And valido a exibição da frase Entre para aproveitar a melhor experiência na tela login
    And clico no botão Entre na tela Login
    And preencho o campo email "<EMAIL>" na tela Login
    And clico no botão Próximo na tela Login
    And preencho o campo Senha "<SENHA>" na tela Login
    And clico no botão Entrar na tela Login
    Then valido a exibição da frase 'Olá, 4Win' na tela 'Home'
    And clico no botão Explorar na tela Home

    Examples:
      | EMAIL                  | SENHA     |
      | teste15.4win@gmail.com | Teste15@4win |

  @CT-1002 @CVC @ATJ-131
  Scenario Outline: Validar pesquisar viagem
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Pacotes' na tela 'Home'
    When seleciono a cidade "<CIDADE_ORIGEM>" no campo Origem na tela Passagens
    And seleciono a cidade "<CIDADE_DESTINO>" no campo Destino na tela Passagens
    And clico no botão Continuar na tela Passagens
    And clico no botão Confirmar Detalhes na tela Passagens
    And seleciono a data "<DATA_INICIO>" no campo Início na tela Passagens
    And seleciono a data "<DATA_FIM>" no campo Fim na tela Passagens
    And clico no botão Confirmar datas na tela Passagens
    And clico no botão 'Detalhes do Hotel' na tela 'Pacote recomendado'
    And valido a exibição da mensagem 'Detalhes do Hotel' na tela 'Pacote recomendado'
    And clico no botão 'Voltar' na tela 'Pacote recomendado'
    And clico no botão 'Detalhes do valor' na tela 'Pacote recomendado'
    And clico no botão 'Fechar' na tela 'Pacote recomendado'
    And clico no botão 'Reservar Agora' na tela 'Pacote recomendado'
    And valido a exibição da mensagem 'Viaje com mais conforto!' na tela 'Pacote recomendado'
    And clico no botão 'Continuar' na tela 'Pacote recomendado'
    And valido a exibição da mensagem 'Atenção ao inicio da sua estadia' na 'Pacote recomendado'
    And clico no botão 'Estou ciente' na tela 'Pacote recomendado'
    And valido a exibição das mensagem 'Resumo da viagem' na tela 'Carrinho de compras'
    And valido a exibição das mensagem 'Hospedagem' na tela 'Carrinho de compras'
    And valido a exibição das mensagem 'Regras e condições' na tela 'Carrinho de compras'
    And clico no botão 'Ir para o pagamento' na tela 'Carrinho de compras'
    Then clico no botão 'Ver resumo' na tela 'Carrinho de compras'
#    And clico no botão Ver Resumo na tela Checkout

    Examples:
      | CIDADE_ORIGEM | CIDADE_DESTINO | DATA_INICIO | DATA_FIM |
      | Sao Paulo     | Foz do Iguaçu  | 30          | 28       |

  @CT-1007 @CVC
  Scenario Outline: Validar 'Aluguel de carros'
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    When clico no botão 'Carros' tela 'Home'
    And seleciono o "<LOCAL_DE_RETIRADA>" na tela 'Aluguel de carros'
    And clico no botão 'Continuar' na tela 'Aluguel de carros'
    And seleciono a data "<DATA_RETIRADA>" no campo Início na tela Passagens
    And seleciono a data "<DATA_DEVOLUCAO>" no campo Fim na tela Passagens
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
#    And valido a exibição da frase 'Características' na tela 'Aluguel de carros'

    Examples:
      | LOCAL_DE_RETIRADA | DATA_RETIRADA | DATA_DEVOLUCAO |
      | Sao Paulo         | 20            | 15             |


  @CT-1008 @CVC @ATJ-136
  Scenario Outline: Validar Ingressos
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Ingressos' na tela 'Home'
    And seleciono o "<DESTINO>" na tela 'Ingressos'
    And clicar no botão Escolha a data "<DATA>" na tela 'Ingressos'
    And clicar no botão 'Buscar' na tela 'Ingressos'
    And clicar no botão 'Conferir' detalhes na tela 'Ingressos'

    Examples:
      | DESTINO | DATA |
      | Beto    | 20   |

  @CT-1005 @CVC @ATJ-132
  Scenario Outline: Validar Hospedagens
    Given clico no botão 'Pular introdução'
    And valido a exibição da frase 'Olá' Pesquise na tela 'Home'
    And clico no botão 'Hotéis' na tela 'Home'
#    And valido a exibição da mensagem Sobre a hosedagem na tela Hoteis
    And valido a exibição da mensagem Ver Mapas na tela Hoteis
    And seleciono a data "<DATA_FIM>" no campo Fim na tela Hoteis
    And clico no botão Buscar na tela Hotel
    And clico no botão Ver detalhes na tela Hotel
    And valido a exibição da label Ver quartos disponiveis na tela Hoteis
    And clico no botão ver quartos disponiveis na tela Hotel
    And clico no botão reservar na tela Hotel

    Examples:
      | DATA_INICIO | DATA_FIM |
      | 20          | 30       |

