package org.br.com.mobile.pages.home;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import lombok.extern.log4j.Log4j2;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class HomeSteps {

    private static final Logger log = LoggerFactory.getLogger(HomeSteps.class);
    private HomePage homePage;
    private HomeActions homeActions;
    static PageBaseActions acoes = new PageBaseActions();

    public HomeSteps() {
        this.homePage = MasterPageFactory.getPage(HomePage.class);
        this.homeActions = new HomeActions();
    }

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    @Then("valido a exibição da tela 'Home'")
    public void validoAExibiçãoDaTela() {
        HomeActions.validarExibicaoTelaHome();
    }

    @Then("valido a exibição do texto 'One' na tela 'Home'")
    public void validarExibicaoDoTextoOneNaTelaHome() {
        homeActions.validarExibicaoLblDigioOne();
    }


    @When("clico no botão 'Menu' na tela 'Home'")
    public void clicoNoBotaoMenuNaTelaHome() {
        homeActions.clicarBtnMenu();
    }

    @Then("valido a exibição do texto 'Nome' na tela 'Menu'")
    public void validoAExibiçãoDoTextoNaTela() {
        homeActions.validarExibicaoTextoNomeMenu();
    }

    @Then("valido a exibição do texto 'Instituição' na tela 'Menu'")
    public void validoAExibiçãoDoTextoInstituicaoNaTela() {
        homeActions.validarExibicaoTextoInstituicaoMenu();
    }

    @Then("valido a exibição do texto 'Agência' na tela 'Menu'")
    public void validoAExibiçãoDoTextoAgenciaNaTela() {
        homeActions.validarExibicaoTextoAgenciaMenu();
    }

    @Then("valido a exibição do texto 'Conta' na tela 'Menu'")
    public void validoAExibiçãoDoTextoContaNaTela() {
        homeActions.validarExibicaoTextoContaMenu();
    }

    @When("clico no botão 'Widget' na tela 'Home'")
    public void clicoNoBotaoWidgetNaTelaHome() {
        homeActions.clicarBtnWidget();
    }

    @When("valido a exibição do botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'")
    public void validoAExibicaoDoBotaoNaoMostrarNovamenteEmAtiveSuaBiometriaNaTelaHome() {
        HomeActions.validarExibicaoBtnNaoMostrarNovamenteAtiveSuaBiometria();
    }

    @When("clico no botão 'Não mostrar novamente' em 'Ative sua biometria' na tela 'Home'")
    public void clicoNoBotaoNaoMostrarNovamenteEmAtiveSuaBiometriaNaTelaHome() {
        HomeActions.clicarBtnNaoMostrarNovamenteAtiveSuaBiometria();
    }

    @When("clico no botão 'Conta' na tela 'Home'")
    public void clicoNoBotaoContaNaTelaHome() {
        homeActions.clicarBtnConta();
    }

    @When("clico no botão 'Open finance' na tela 'Home'")
    public void clicoNoBotaoOpenFinanceNaTelaHome() {
        homeActions.clicarBtnOpenFinance();
    }

    @When("clico no botão 'Extrato' na tela 'Home'")
    public void clicoNoBotaoExtratoNaTelaHome() {
        homeActions.clicarBtnExtrato();
    }

    @When("clico no botão 'Futuros' em 'Extrato' na tela 'Home'")
    public void clicoNoBotaoFuturosNaTelaHome() {
        homeActions.clicarBtnFuturo();
    }

    // SALDO
    @When("clico no botão de visão para exibir o saldo na tela 'Home'")
    public void clicoNoBotaoDeVisaoParaExibirOSaldoNaTelaHome() {
        homeActions.clicarBtnVisaoParaExibirSaldo();
    }

    @Then("valido a exibição do saldo na tela 'Home'")
    public void validoAExibicaoDoSaldoNaTelaHome() {
        homeActions.validarExibicaoSaldo();
    }

    @Then("valido que o saldo seja maior que Dez reais na tela 'Home'")
    public void validoQueOSaldoSejaMaiorQueDezReaisNaTelaHome() {
        homeActions.validarExibicaoSaldoMaiorQueDezReais();
    }

    @Then("valido que o saldo esteja zerado na tela 'Home'")
    public void validoQueOSaldoEstejaZeradoNaTelaHome() {
        homeActions.validarExibicaoSaldoZerado();
    }

    @When("clico no botão de visão para ocultar o saldo na tela 'Home'")
    public void clicoNoBotaoDeVisaoParaOcultarOSaldoNaTelaHome() {
        homeActions.clicarBtnVisaoParaOcultarSaldo();
    }

    @Then("valido a exibição do saldo com máscara na tela 'Home'")
    public void validoAExibicaoDoSaldoComMascaraNaTelaHome() {
        homeActions.validarExibicaoSaldoComMascara();
    }

    @Then("clico no botão 'Pagar' na tela 'Home'")
    public void clicoNoBotaoPagarNaTelaHome() {
        homeActions.clicarBtnPagar();
    }

    @Then("clico no botão 'Trazer meu salário' na tela 'Home'")
    public void clicoNoBotaoTrazerMeuSalarioNaTelaHome() {
        homeActions.clicarBtnTrazerMeuSalario();
    }

    @Then("clico no botão 'Receber' na tela 'Home'")
    public void clicoNoBotaoReceberNaTelaHome() {
        homeActions.clicarBtnReceber();
    }

    @When("clico no botão 'Transferir' na tela 'Home'")
    public void clicoNoBotaoTransferirNaTelaHome() {
        homeActions.clicarBtnTransferir();
    }

    @When("clico no card 'Antecipar FGTS' na tela 'Home'")
    public void clicarBtnCardAnteciparFgtsNaTelaHome() {
        homeActions.clicarBtnCardAnteciparFgts();
    }

    @When("clico no card 'Grana Extra' na tela 'Home'")
    public void clicarBtnCardGranaExtraNaTelaHome() {
        homeActions.clicarBtnCardGranaExtra();
    }

    @When("clico no card 'Loja' na tela 'Home'")
    public void clicarBtnCardLojaNaTelaHome() {
        homeActions.clicarBtnCardLoja();
    }

    @When("clico no botão para 'Ver minhas compras' na tela 'Home'")
    public void clicoNoBotaoParaVerMinhasComprasNaTelaHome() {
        homeActions.clicarBtnVerMinhasCompras();
    }

    @When("verifico que o horário do celular seja após as 18h na tela 'Home'")
    public void verificoQueOHorarioDoCelularSejaAposAs18HNaTelaHome() {
        homeActions.validarHorarioCelularAposDezoito();
    }

    @When("clico no card 'Digio One toque aqui e peça o seu' na tela 'Home'")
    public void clicoNoCardDigioOneToqueAquiEPecaOSeuNaTelaHome() {
        homeActions.clicarBtnCardDigioOneToqueAquiPecaOSeu();
    }

    @When("clico no botão 'Débito automático' na tela 'Home'")
    public void clicoNoBotaoDebitoAutomaticoNaTelaHome() {
        homeActions.clicarBtnDebitoAutomatico();
    }

    @When("clico no botão 'Meus cartões' na tela 'Home'")
    public void clicoNoBotaoMeusCartoesNaTelaHome() {
        homeActions.clicarBtnMeusCartoes();
    }

    @When("clico no botão 'Rastrear' na tela 'Home'")
    public void clicoNoBotaoRastrearNaTelaHome() {
        homeActions.clicarBtnRastrear();
    }

    @When("clico no botão 'Recebi meu digio' na tela 'Home'")
    public void clicoNoBotaoRecebiMeuDigioNaTelaHome() {
        homeActions.clicarBtnRecebiMeuDigio();
    }

    @When("clico no botão 'Pagar fatura' na tela 'Home'")
    public void clicoNoBotaoPagarFaturaNaTelaHome() {
        homeActions.clicarBtnPagarFatura();
    }

    @When("clico no botão 'Cartões' na tela 'Home'")
    public void clicoNoBotaoCartoesNaTelaHome() {
        homeActions.clicarBtnCartoes();
    }

    @And("realizo um deslize para forçar a atualização do saldo na tela 'Home'")
    public void realizUmDeslizeParaForcarAAtualizacaoDoSaldoNaTelaHome() {
        homeActions.realizarDeslizeParaForcarAtualizacaoDoSaldo();
    }

    @And("realizo um deslize para forçar a atualização do saldo com saldo ocultado na tela 'Home'")
    public void realizUmDeslizeParaForcarAAtualizacaoDoSaldoComSaldoOcultadoNaTelaHome() {
        homeActions.realizarDeslizeParaForcarAtualizacaoDoSaldoComSaldoOcultado();
    }

    @Then("valido o desconto do valor da transação em 'Saldo disponível' na tela 'Home'")
    public void validoODescontoDoValorAleatorioEmSaldoDisponivelNaTelaExtrato() {
        homeActions.validarDescontoTransacaoLblSaldoDisponivel();
    }

    @Then("valido o resgate do valor da transação em 'Saldo disponível' na tela 'Home'")
    public void validoOResgateDoValorAleatorioEmSaldoDisponivelNaTelaExtrato() {
        homeActions.validarInclusaoResgateLblSaldoDisponivel();
    }

    @Then("valido que não houve desconto do valor da transferência em 'Saldo disponível' na tela 'Home'")
    public void validoQueNaoHouveDescontoDoValorEmSaldoDisponivelNaTelaHome() {
        homeActions.validarNaoDescontoLblSaldoDisponivel();
    }

    @When("valido a exibição do texto 'One' após a migração na tela 'Home'")
    public void validoAExibicaoDoTextoOneAposAMigracaoNaTelaHome() {
        homeActions.validarExibicaoLblDigioOneAposMigracao();
    }

    @When("clico no botão para 'Ver fatura' na tela 'Home'")
    public void clicoNoBotaoParaVerFaturaNaTelaHome() {
        homeActions.clicarBtnVerFatura();
    }

    @When("verifico que o horário do celular seja anterior as 16h na tela 'Home'")
    public void verificoQueOHorarioDoCelularSejaAnteriorAs16HNaTelaHome() {
        homeActions.validarHorarioCelularAteriorDezesseis();
    }

    @When("clico no botão 'Pix' na tela 'Home'")
    public void clicoNoBotaoPixNaTelaHome() {
        homeActions.clicarBtnPix();
    }

    @When("clico no banner DeepLink na tela 'Home'")
    public void clicoNoBannerDeepLinkNaTelaHome() {
        homeActions.clicarBtnDeeplink();
    }

    @When("valido o texto 'Ative sua conta Digio' na tela 'Conta'")
    public void validoOTextoAtiveSuaContaDigioNaTelaConta() {
        homeActions.validarTxtAtiveSuaContaDigio();
    }

    @When("valido a exibição da mensagem 'Rendendo 100% do CDI' na tela 'Home'")
    public void validoAExibicaoDaMensagemRendendoCemPorcentoDoCdiNaTelaHome() {
        homeActions.validarExibicaoLblRendendoCemPorCentoDoCdi();
    }

    @When("valido o status da fatura 'Aberta' na tela 'Home'")
    public void validoOStatusDaFaturaAbertaNaTelaHome() {
        homeActions.validarStatusDaFaturaAberta();
    }

    @When("valido o status da fatura 'Fechada' na tela 'Home'")
    public void validoOStatusDaFaturaFechadaNaTelaHome() {
        homeActions.validarStatusDaFaturaFechada();
    }

    @When("valido o status da fatura 'Vencida' na tela 'Home'")
    public void validoOStatusDaFaturaVencidaNaTelaHome() {
        homeActions.validarStatusDaFaturaVencida();
    }

    @When("valido o status da fatura 'Bloqueada' na tela 'Home'")
    public void validoOStatusDaFaturaBloqueadaNaTelaHome() {
        homeActions.validarStatusDaFaturaBloqueada();
    }

    @And("valido que o 'Valor da fatura' seja maior que dez reais na tela 'Home'")
    public void validoQueOValorDaFaturaSejaMaiorQueDezReaisNaTelaHome() {
        homeActions.validarValorFatura();
    }

    @And("valido que o valor do limite utilizado seja maior ou igual ao saldo da fatura na tela 'Home'")
    public void validoQueOValorDoLimiteUtilizadoSejaMaiorouIgualAoSaldoDaFaturaNaTelaHome() {
        homeActions.validarValorLimiteUtilizado();
    }

    @And("valido que o saldo seja maior ou igual ao valor da 'Fatura' na tela 'Home'")
    public void validoQueOSaldoSejaMaiorOuIgualAoValorDaFaturaNaTelaHome() {
        homeActions.validarSaldoMaiorFatura();
    }

    @And("valido o desconto do valor da fatura no 'Limite utilizado' na tela 'Home'")
    public void validoODescontoDoValorDaFaturaNoLimiteUtilizadoNaTelaHome() {
        homeActions.validarDescontoValorFaturaLimite();
    }

    @And("clico no botão visão para mostrar o valor da 'fatura' na tela 'Home'")
    public void clicoNoBotaoVisaoParaMostrarOValorDaFaturaNaTelaHome() {
        homeActions.clicarBtnVisaoExibirValorFaturaHome(true);
    }

    @When("clico no botão visao para exibir o valor da 'Fatura' na tela 'Home'")
    public void clicoNoBotaoVisaoParaExibirOValorDaFaturaNaTelaHome() {
        homeActions.clicarBtnVisaoExibirValorFaturaHome(true);
    }

    @When("clico no botão visao para ocultar o valor da 'Fatura' na tela 'Home'")
    public void clicoNoBotãoVisaoParaOcultarOValorDaNaTela() {
        homeActions.clicarBtnVisaoExibirValorFaturaHome(false);
    }

    @And("clico no botão 'Investimentos' na tela 'Home'")
    public void clicoNoBotaoInvestimentosNaTelaHome() {
        homeActions.clicarBtnInvestimentos();
    }

    @When("clico no botão 'Meu limite' na tela 'Home' do 'Cartões'")
    public void clicoNoBtnMeuLimite() {
        homeActions.clicarBtnMeuLimite();
    }

    @When("clico no card 'Investimentos' na tela 'Home'")
    public void clicoNoCardInvestimentosNaTelaHome() {
        homeActions.clicarBtnInvestimentos();
    }

    @When("clico no card 'CDB + Limite' na tela 'Home'")
    public void clicoNoCardCdbMaisLimiteNaTelaHome() {
        homeActions.clicarBtnCdbMaisLimite();
    }

    @Then("clico no botão 'Sacar' na tela 'Home'")
    public void clicoNoBotaoSacarNaTelaHome() {
        homeActions.clicarBtnSacar();
    }

    @When("clico no botão 'Open finance' pelo carrossel na tela 'Home'")
    public void clicoNoBotaoOpenFinancePeloCarrosselNaTelaHome() {
        homeActions.clicarBtnCardOpenFinance();
    }
}
