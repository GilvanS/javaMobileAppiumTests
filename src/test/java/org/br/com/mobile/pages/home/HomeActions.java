package org.br.com.mobile.pages.home;

import lombok.extern.log4j.Log4j2;
import org.br.com.mobile.pages.MasterPageFactory;
import org.br.com.mobile.pages.PageBaseActions;
import org.br.com.mobile.utils.SaldoUtils;
import org.br.com.mobile.utils.ValorManager;
import org.br.com.api.utils.LogFormatter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertTrue;

public class HomeActions {

    private static final Logger log = LoggerFactory.getLogger(HomeActions.class);
    static PageBaseActions acoes = new PageBaseActions();

    public static HomePage homePage() {
        return MasterPageFactory.getPage(HomePage.class);
    }

    private PageBaseActions actions() {
        return acoes;
    }

    public static void validarExibicaoTelaHome() {
        LogFormatter.logStep("valido a exibição da home");
//        popupLogic.verificarPopUpsAteEncontrarElementoEsperado(getPopupModelHome());
        PageBaseActions.waitElement(homePage().getLblOla());
        assertTrue("Tela home do Digio não foi apresentada",
                homePage().getLblOla().isDisplayed());
    }

    public void clicarBtnMenu() {
        LogFormatter.logStep("clico no menu");
        acoes.click(homePage().getBtnMenu());
        acoes.sleep(3);
    }

    public void validarExibicaoLblOla() {
        LogFormatter.logStep("valido a exibição da mensagem 'Olá' em home");
        PageBaseActions.waitElement(homePage().getLblOla());
        assertTrue("Não exibiu o texto Ola na tela home",
                homePage().getLblOla().isDisplayed());
    }

    public void validarExibicaoLblDigioOne() {
        LogFormatter.logStep("valido a exibição do texto 'One' em home");
        PageBaseActions.waitElement(homePage().getLblDigioOne());
        assertTrue("Nao foi possivel validar se o cliente é Digio One",
                homePage().getLblDigioOne().isDisplayed());
        acoes.sleep(3);
    }

    public void validarExibicaoLblDigioOneAposMigracao() {
        LogFormatter.logStep("valido a exibição do texto 'One' em home");
        boolean exibiuDigioOne = false;
        double startPercentage = 0.50;
        double endPercentage = 0.85;

        acoes.verticalSwipeUp(startPercentage, endPercentage);
        acoes.sleep(3);

        int tentativas = 18;
        for (int i = 1; i <= tentativas; i++) {
            LogFormatter.logStep("tentativa: " + i + " de " + tentativas);
            if (actions().isDisplayed(homePage().getLblDigioOne(), 10)) {
                exibiuDigioOne = true;
                break;
            }
            actions().verticalSwipeUp(startPercentage, endPercentage);
        }
        assertTrue("Nao foi possivel validar se o cliente é Digio One", exibiuDigioOne);
    }

    public void clicarBtnWidget() {
        LogFormatter.logStep("clico no botão 'Widget' em home");
        actions().click(homePage().getBtnWidget());
    }

    public static void validarExibicaoBtnNaoMostrarNovamenteAtiveSuaBiometria() {
        LogFormatter.logStep("valido a exibição do botao 'nao mostrar novamente' em 'ative sua biometria'");
        PageBaseActions.waitElement(homePage().getBtnNaoMostrarNovamente());
        assertTrue("Nao foi possivel validar o botão 'nao mostrar novamente' em 'ative sua biometria'",
                homePage().getBtnNaoMostrarNovamente().isDisplayed());
    }

    public static void clicarBtnNaoMostrarNovamenteAtiveSuaBiometria() {
        LogFormatter.logStep("clico no botao 'nao mostrar novamente' em 'ative sua biometria'");
        acoes.click(homePage().getBtnNaoMostrarNovamente());
    }

    public void clicarBtnConta() {
        LogFormatter.logStep("clico no botao 'Conta'");
        actions().click(homePage().getBtnConta());
    }

    public void clicarBtnOpenFinance() {
        LogFormatter.logStep("clico no botão 'Open finance'");
        actions().verticalSwipeDownAndSearch(homePage().getBtnOpenFinance());
        actions().click(homePage().getBtnOpenFinance());
    }
    public void clicarBtnExtrato() {
        LogFormatter.logStep("clico no botao 'Extrato'");
        actions().click(homePage().getBtnExtrato());
    }

    public void clicarBtnFuturo() {
        LogFormatter.logStep("clico no botão 'Futuros' na tela 'Home'");
        actions().click(homePage().getBtnFuturos());
    }

    // SALDO
    private void clicarBtnVisaoSaldo(boolean exibir) {
        actions().waitForElementToBeDisplayed(homePage().getLblSaldoDisponivel());

        if ((exibir && actions().isDisplayed(homePage().getLblSaldoOculto(), 1))
                || (!exibir && actions().isDisplayed(homePage().getLblSaldoExibido(), 1))) {

            actions().click(homePage().getBtnVisao());
        } else {
            LogFormatter.logStep("não houve necessidade de clicar no botão de visão do saldo");
        }
    }

    // TODO: Lógica temporária - Ajustar maepeamento do iOS quando disponível
    // Método alternativo/temporário para atender a plataforma iOS (devido a não
    // acessibilidade)
    private void clicarBtnVisaoSaldoIOS(boolean exibir) {
        actions().waitForElementToBeDisplayed(homePage().getLblSaldoDisponivel());
        actions().sleep(1);

        Dimension dimensoesTela = actions().getDimension();
        int x;
        int y = (int) (dimensoesTela.getHeight() * 0.24407);

        if (exibir && validarTelaContas() && !actions().isDisplayed(homePage().getLblSaldoExibido(), 1)) {
            // x (largura) - baseado no tamanho da tela - escala padrão
            x = (int) (dimensoesTela.getWidth() * 0.26410);
            actions().tapOn(x, y);

        } else if (!exibir && validarTelaContas() && actions().isDisplayed(homePage().getLblSaldoExibido(), 1)) {
            // x baseado na adição em % à direita do elemento de saldo exibido
            Rectangle rectElemento = homePage().getLblSaldoExibido().getRect();
            int x2Elemento = rectElemento.getX() + rectElemento.getWidth();

            x = (int) (x2Elemento + (dimensoesTela.getWidth() * 0.0512));
            actions().tapOn(x, y);
        }
    }

    // TODO: Lógica temporária - Remover método após ajuste no iOS
    private boolean validarTelaContas() {
        boolean visivel = actions().isDisplayed(homePage().getLblSaldoDisponivel(), 1)
                && actions().isDisplayed(homePage().getLblOla(), 1);

        if (!visivel)
            throw new RuntimeException("Não foi possível validar que a tela corrente é a de contas no dispositivo iOS");

        return visivel;
    }

    // TODO: Lógica temporária - Ajustar quando o mapeamento estiver disponível no
    // iOS
    public void clicarBtnVisaoParaExibirSaldo() {
        LogFormatter.logStep("clico no botão de visão para exibir o saldo");
        if (actions().isAndroid())
            clicarBtnVisaoSaldo(true);
        else
            clicarBtnVisaoSaldoIOS(true);
    }

    public void validarExibicaoSaldo() {
        LogFormatter.logStep("valido a exibição do saldo");
        actions().waitForElementToBeDisplayed(homePage().getLblSaldoExibido());
        assertTrue("Não foi exibido o saldo após clicar no botão de visão para exibi-lo",
                homePage().getLblSaldoExibido().isDisplayed());
    }

    public void validarExibicaoSaldoMaiorQueDezReais() {
        LogFormatter.logStep("valido a exibição do saldo maior que dez reais");

        String saldo = actions().getText(homePage().getLblSaldoExibido());
        LogFormatter.logStep("saldo: " + saldo);
        Assert.assertTrue("Massa está com saldo menor que 10 reais, favor adicionar mais. ",
                SaldoUtils.saldoMaiorQueDez(saldo));
        ValorManager.setValor(saldo);
    }

    public void validarExibicaoSaldoZerado() {
        LogFormatter.logStep("valido a exibição do saldo zerado");

        String saldo = actions().getText(homePage().getLblSaldoExibido());
        LogFormatter.logStep("saldo: " + saldo);
        Assert.assertTrue("Massa não esta com saldo zerado", SaldoUtils.saldoZerado(saldo));
    }

    // TODO: Lógica temporária - Ajustar quando o mapeamento estiver disponível no
    // iOS
    public void clicarBtnVisaoParaOcultarSaldo() {
        LogFormatter.logStep("clico no botão de visão para ocultar o saldo");
        if (actions().isAndroid())
            clicarBtnVisaoSaldo(false);
        else
            clicarBtnVisaoSaldoIOS(false);
    }

    // TODO: Lógica temporária - Ajustar quando o mapeamento estiver disponível no
    // iOS
    public void validarExibicaoSaldoComMascara() {
        LogFormatter.logStep("valido a exibição do saldo com máscara");

        if (actions().isAndroid()) {
            actions().waitForElementToBeDisplayed(homePage().getLblSaldoOculto());
            assertTrue("Foi exibido o saldo após clicar no botão de visão para ocultá-lo",
                    homePage().getLblSaldoOculto().isDisplayed());
        } else {
            assertTrue("Foi exibido o saldo após clicar no botão de visão para ocultá-lo",
                    validarTelaContas() && !actions().isDisplayed(homePage().getLblSaldoExibido(), 3));
        }
    }

    public void clicarBtnPagar() {
        LogFormatter.logStep("clico no botão 'Pagar'");
        actions().click(homePage().getBtnPagar());
    }

    public void clicarBtnTrazerMeuSalario() {
        LogFormatter.logStep("clico no botão 'Trazer meu salário'");
        if (actions().isIOS()) {
            actions().horizontalSwipeLeft(homePage().getBtnPagar(), homePage().getBtnTrazerMeuSalario(), 5);
            actions().click(homePage().getBtnTrazerMeuSalario());
        } else {
            actions().horizontalSwipeLeft(homePage().getCarrosselConta(), homePage().getBtnTrazerMeuSalario(), 5);
            actions().click(homePage().getBtnTrazerMeuSalario());
        }
    }

    public void clicarBtnReceber() {
        LogFormatter.logStep("clico no botão 'Receber'");
        actions().sleep(2);
        if (actions().isIOS()) {
            actions().horizontalSwipeLeft(homePage().getBtnPagar(), homePage().getBtnReceber(), 5);
            actions().click(homePage().getBtnReceber());
        } else {
            actions().horizontalSwipeLeft(homePage().getCarrosselConta(), homePage().getBtnReceber(), 5);
            actions().click(homePage().getBtnReceber());
        }
    }

    public void clicarBtnTransferir() {
        LogFormatter.logStep("clico no botão 'Transferir'");

        if (actions().isAndroid()) {
            actions().horizontalSwipeLeft(homePage().getCarrosselConta(), homePage().getBtnTransferir(), 5);
            actions().click(homePage().getBtnTransferir());
        } else {
            Rectangle rect = homePage().getBtnPagar().getRect();
            int anchor = (int) (rect.getY() + (rect.height * 0.50));
            actions().horizontalSwipeLeft(anchor, homePage().getBtnTransferir(), 5);
            if (actions().isDisplayed(homePage().getBtnTransferir())) {
                actions().click(homePage().getBtnTransferir());
            } else {
                LogFormatter.logStep("botão transferir nao encontrado no XML , tentando clique por posição");
                Rectangle rectReceber = homePage().getBtnReceber().getRect();
                int x = (int) (rectReceber.getX() - rectReceber.getWidth() * 1.50);
                int y = (int) (rectReceber.getY() + (rectReceber.height * 0.50));
                actions().tapOn(x, y);
            }
        }
    }

    public void clicarBtnCardAnteciparFgts() {
        LogFormatter.logStep("clico no card 'Antecipar FGTS' na tela 'Home'");
        actions().verticalSwipeDown();
        actions().click(homePage().getBtnCardAnteciparFgts());
    }

    public void clicarBtnCardGranaExtra() {
        LogFormatter.logStep("clico no card 'Grana Extra' na tela 'Home'");
        actions().verticalSwipeDown();
        actions().click(homePage().getBtnCardGranaExtra());
    }

    public void clicarBtnCardLoja() {
        LogFormatter.logStep("clico no card 'Loja' na tela 'Home'");
        actions().waitForElementToBeDisplayed(homePage().getCarrosselProdutosDigio());
        actions().verticalSwipeDown();
        actions().horizontalSwipeLeft(homePage().getCarrosselProdutosDigio(), homePage().getBtnCardLoja(), 5);
        actions().click(homePage().getBtnCardLoja());
    }

    public void clicarBtnCdbMaisLimite() {
        LogFormatter.logStep("clico no card 'CDB + Limite' na tela 'Home'");
        actions().horizontalSwipeLeft(homePage().getCarrosselProdutosDigio(), homePage().getBtnCdbMaisLimite(), 5);
        actions().click(homePage().getBtnCdbMaisLimite());
    }

    public void clicarBtnInvestimentos() {
        LogFormatter.logStep("clico no card 'Investimentos' na tela 'Home'");
        actions().verticalSwipeUpAndSearch(homePage().getBtnInvestimentos(), 5);
        actions().horizontalSwipeLeft(homePage().getCarrosselProdutosDigio(), homePage().getBtnInvestimentos(), 5);
        actions().click(homePage().getBtnInvestimentos());
    }

    public void clicarBtnVerMinhasCompras() {
        LogFormatter.logStep("clico no botão para ver 'minhas compras'");
        actions().verticalSwipeDownAndSearch(homePage().getBtnVerMinhasCompras(), 5);
        actions().click(homePage().getBtnVerMinhasCompras());
    }

    public void validarHorarioCelularAposDezoito() {
        LogFormatter.logStep("valido que o horário do celular seja após as 18h");
        int horaAtual = Integer.parseInt(actions().getDeviceTime("HH"));
        LogFormatter.logStep("hora atual: " + horaAtual);
        boolean validacaoHorario = horaAtual >= 18;
        assertTrue("horário do celular não está apos as 18h, hora atual: " + horaAtual, validacaoHorario);
    }

    public void clicarBtnCardDigioOneToqueAquiPecaOSeu() {
        LogFormatter.logStep("clico no card 'Digio One toque aqui e peça o seu'");
        actions().verticalSwipeDown();
        actions().verticalSwipeDownAndSearch(homePage().getBtnCardDigioOneToqueAquiPecaOSeu());
        actions().click(homePage().getBtnCardDigioOneToqueAquiPecaOSeu());
    }

    public void clicarBtnDebitoAutomatico() {
        LogFormatter.logStep("clico no botão 'Débito automático'");
        actions().waitForElementToBeDisplayed(homePage().getBtnPagarFatura());
        if (actions().isAndroid()) {
            actions().horizontalSwipeLeft(homePage().getCarrosselCartoes(), homePage().getBtnDebitoAutomatico(), 5);
        } else {
            Rectangle rect = homePage().getBtnPagarFatura().getRect();
            int anchor = (int) (rect.getY() + (rect.height * 0.50));
            actions().horizontalSwipeLeft(anchor, homePage().getBtnDebitoAutomatico(), 5);
        }
        actions().click(homePage().getBtnDebitoAutomatico());
    }

    public void clicarBtnMeusCartoes() {
        LogFormatter.logStep("clico no botão 'Meus cartões'");
        actions().click(homePage().getBtnMeusCartoes());
    }

    public void clicarBtnRastrear() {
        LogFormatter.logStep("clico no botão 'Rastrear'");
        actions().click(homePage().getBtnRastrear());
    }

    public void clicarBtnRecebiMeuDigio() {
        LogFormatter.logStep("clico no botão 'Recebi meu digio'");
        actions().click(homePage().getBtnRecebiMeuDigio());
    }

    public void clicarBtnPagarFatura() {
        LogFormatter.logStep("clico no botão 'Pagar fatura'");
        actions().sleep(3);
        actions().verticalSwipe(0.50, 0.65, 1.05);
        actions().sleep(7);
        actions().click(homePage().getBtnPagarFatura());
    }

    public void clicarBtnCartoes() {
        LogFormatter.logStep("clico no botao 'Cartões'");
        actions().click(homePage().getBtnCartoes());
    }

    public void realizarDeslizeParaForcarAtualizacaoDoSaldo() {
        LogFormatter.logStep("realizo um deslize para forçar a atualização do saldo");
        actions().sleep(1);
        actions().verticalSwipe(0.50, 0.50, 0.85);

        actions().sleep(3);

        if (ValorManager.getSaldo() == null) {
            ValorManager.setSaldo(actions().getText(homePage().getLblSaldoExibido()));
        }
    }

    public void realizarDeslizeParaForcarAtualizacaoDoSaldoComSaldoOcultado() {
        LogFormatter.logStep("realizo um deslize para forçar a atualização do saldo com saldo ocultado");
        actions().sleep(1);
        actions().verticalSwipe(0.50, 0.50, 0.85);

        actions().sleep(3);

    }

    /**
     * Realiza algumas tentativas para atualizar saldo e validar o desconto do valor
     * da transferêcia. Atualmetne temos 30 tentativas em que cada uma leva
     * aproximadamente 10 segundos, resultando em um limite de 5 minutos para esta
     * validação.
     *
     * @param valor Valor da transferência
     */
    public void validarDescontoLblSaldoDisponivel(String valor) {
        LogFormatter.logStep(String.format("valido o desconto do valor '%s' da transferência em 'Saldo disponível' na tela 'Home'",
                valor));

        int saldoAnterior = converterSaldoEmInteiro(ValorManager.getSaldo());
        int tentativas = 30;
        int contador = 1;
        boolean desconto = false;

        actions().sleep(5);
        while (tentativas > 0) {
            LogFormatter.logStep(contador + "º tentativa para atualização do saldo");

            String saldoExibido = actions().getText(homePage().getLblSaldoExibido());
            LogFormatter.logStep("saldo exibido: " + saldoExibido);

            int saldoAtual = converterSaldoEmInteiro(saldoExibido);
            desconto = (saldoAtual + converterSaldoEmInteiro(valor)) == saldoAnterior;

            if (desconto)
                break;

            realizarDeslizeParaForcarAtualizacaoDoSaldo();
            actions().sleep(7);
            tentativas--;
            contador++;
        }
        assertTrue("Não foi possível validar se houve o desconto do valor da transferência no saldo", desconto);
    }

    public void validarResgateLblSaldoDisponivel(String valor) {
        LogFormatter.logStep(String.format("valido o desconto do valor '%s' da transferência em 'Saldo disponível' na tela 'Home'",
                valor));

        int saldoAnterior = converterSaldoEmInteiro(ValorManager.getSaldo());
        int tentativas = 30;
        int contador = 1;
        boolean resgate = false;

        actions().sleep(5);
        while (tentativas > 0) {
            LogFormatter.logStep(contador + "º tentativa para atualização do saldo");

            String saldoExibido = actions().getText(homePage().getLblSaldoExibido());
            LogFormatter.logStep("saldo exibido: " + saldoExibido);

            int saldoAtual = converterSaldoEmInteiro(saldoExibido);
            resgate = (saldoAtual - converterSaldoEmInteiro(valor)) == saldoAnterior;

            if (resgate)
                break;

            realizarDeslizeParaForcarAtualizacaoDoSaldo();
            actions().sleep(7);
            tentativas--;
            contador++;
        }
        assertTrue("Não foi possível validar se houve o desconto do valor da transferência no saldo", resgate);
    }

    public void clicarBtnVisaoExibirValorFaturaHome(boolean exibir) {
        if (exibir) {
            LogFormatter.logStep("clico no botão visao para exibir o valor da fatura");
        } else {
            LogFormatter.logStep("clico no botão visao para ocultar o valor da fatura");
        }

        actions().waitForElementToBeDisplayed(homePage().getLblFatura());

        if (actions().isAndroid()) {

            if ((exibir && actions().waitUntilElementIsDisplayed(homePage().getLblFaturaSaldoOcultoAndroid(), 1))
                    || (!exibir
                    && actions().waitUntilElementIsDisplayed(homePage().getLblFaturaSaldoExibidoAndroid(), 1))) {

                actions().click(homePage().getBtnVisaoFaturaAndroid());
            } else {
                LogFormatter.logStep("não houve necessidade de clicar no botão de visão da fatura");
            }
        } else {
            if ((exibir && actions().waitUntilElementIsDisplayed(homePage().getBtnVisaoFaturaDesligadoIos(), 1))
                    || (!exibir && actions().waitUntilElementIsDisplayed(homePage().getBtnVisaoFaturaLigadoIos(), 1))) {
                actions().click(homePage().getBtnVisaoFaturaIos());
            } else {
                LogFormatter.logStep("não houve necessidade de clicar no botão de visão da fatura");
            }
        }
    }

    public void validarDescontoTransacaoLblSaldoDisponivel() {
        validarDescontoLblSaldoDisponivel(ValorManager.getValor());
    }

    public void validarInclusaoResgateLblSaldoDisponivel() {
        validarResgateLblSaldoDisponivel(ValorManager.getValor());
    }

    public void validarNaoDescontoLblSaldoDisponivel() {
        LogFormatter.logStep("valido que não houve desconto do valor da transferência em 'Saldo disponível'");
        int saldoAnterior = converterSaldoEmInteiro(ValorManager.getSaldo());
        int saldoAtual = converterSaldoEmInteiro(actions().getText(homePage().getLblSaldoExibido()));

        assertTrue("Não foi possível validar se não houve o desconto do valor da transferência no saldo",
                saldoAnterior == saldoAtual);
    }

    private int converterSaldoEmInteiro(String saldo) {
        return Integer.parseInt(saldo.replaceAll("\\D", ""));
    }

    public void clicarBtnVerFatura() {
        LogFormatter.logStep("clico no botão para 'Ver fatura'");
        actions().sleep(1);
        actions().verticalSwipe(0.50, 0.65, 1.05);
        actions().sleep(6);
        actions().click(homePage().getBtnVerFatura());
    }

    public void validarHorarioCelularAteriorDezesseis() {
        LogFormatter.logStep("valido que o horário do celular seja anterior as 16h");
        int horaAtual = Integer.parseInt(actions().getDeviceTime("HH"));
        LogFormatter.logStep("hora atual: " + horaAtual);
        boolean validacaoHorario = horaAtual <= 16;
        assertTrue("horário do celular não está anterior as 16h, hora atual: " + horaAtual, validacaoHorario);
    }

    public void clicarBtnPix() {
        LogFormatter.logStep("clico no botão 'Pix'");
        actions().sleep(2);
        actions().click(homePage().getBtnPix());
        actions().sleep(2);
    }

    public void validarTxtAtiveSuaContaDigio() {
        LogFormatter.logStep("validar texto 'Ative sua conta Digio'");
        actions().waitForElementToBeDisplayed(homePage().getTxtAtiveSuaContaDigio());
        assertTrue("Erro na validação do texto 'Ative sua conta Digio'",
                homePage().getTxtAtiveSuaContaDigio().isDisplayed());
    }

    public void clicarBtnDeeplink() {
        LogFormatter.logStep("clico no botão 'DeepLink'");
        actions().verticalSwipeDown();
        actions().sleep(2);
        actions().horizontalSwipeLeft(homePage().getCarrosselBanners(), homePage().getBtnDeepLink(), 5);
        actions().click(homePage().getBtnDeepLink());
    }

    public void validarExibicaoLblRendendoCemPorCentoDoCdi() {
        LogFormatter.logStep("validar texto 'Rendendo 100% do CDI'");
        actions().waitForElementToBeDisplayed(homePage().getLblRendendoCemPorCentoDoCdi());
        assertTrue("Erro na validação do texto 'Rendendo 100% do CDI'",
                homePage().getLblRendendoCemPorCentoDoCdi().isDisplayed());
    }

    public void validarStatusDaFaturaAberta() {
        LogFormatter.logStep("valido o status da fatura 'Aberta'");
        actions().waitForElementToBeDisplayed(homePage().getTxtFaturaAberta());
        assertTrue("Não foi possivel validar o status da fatura",
                homePage().getTxtFaturaAberta().isDisplayed());
    }

    public void validarStatusDaFaturaFechada() {
        LogFormatter.logStep("valido o status da fatura 'Fechada'");
        actions().waitForElementToBeDisplayed(homePage().getTxtFaturaFechada());
        assertTrue("Não foi possivel validar o status da fatura",
                homePage().getTxtFaturaFechada().isDisplayed());
    }

    public void validarStatusDaFaturaVencida() {
        LogFormatter.logStep("valido o status da fatura 'Vencida'");
        actions().waitForElementToBeDisplayed(homePage().getTxtFaturaVencida());
        assertTrue("Não foi possivel validar o status da fatura",
                homePage().getTxtFaturaVencida().isDisplayed());
    }

    public void validarStatusDaFaturaBloqueada() {
        LogFormatter.logStep("valido o status da fatura 'Bloqueada'");
        actions().waitForElementToBeDisplayed(homePage().getTxtFaturaBloqueada());
        assertTrue("Não foi possivel validar o status da fatura",
                homePage().getTxtFaturaBloqueada().isDisplayed());
    }

    public void validarValorFatura() {
        String valorFaturaStr = actions().getText(homePage().getTxtValorFatura());
        LogFormatter.logStep("valido que o valor da fatura seja maior que dez reais: " + valorFaturaStr);
        Assert.assertTrue("Massa está com saldo menor que 10 reais, favor adicionar mais.",
                SaldoUtils.saldoMaiorQueDez(valorFaturaStr));
        ValorManager.setValor(valorFaturaStr);
    }

    public void validarValorLimiteUtilizado() {
        actions().verticalSwipeDownAndSearch(homePage().getTxtValorLimiteUtilizado());
        String valorLimiteUtilizadoStr = actions().getText(homePage().getTxtValorLimiteUtilizado());
        int valorFaturaInt = converterSaldoEmInteiro(ValorManager.getValor());
        int valorLimiteUtilizadoInt = converterSaldoEmInteiro(valorLimiteUtilizadoStr);
        LogFormatter.logStep("Valido que o valor do limite utilizado seja maior ou igual o valor da fatura: "
                + valorLimiteUtilizadoStr);
        assertTrue("Não foi possivel validar que o limite utilizado é maior ou igual o valor da fatura",
                valorLimiteUtilizadoInt >= valorFaturaInt);
        ValorManager.setValorLimite(valorLimiteUtilizadoStr);

    }

    public void validarSaldoMaiorFatura() {
        String valorFaturaStr = ValorManager.getValor().replace(".", "").replace(",", ".").replaceAll("[^0-9.]", "");
        int valorFaturaInt = converterSaldoEmInteiro(valorFaturaStr);
        String saldo = actions().getText(homePage().getLblSaldoExibido());
        int saldoInt = Integer.parseInt(saldo.replaceAll("\\D", ""));
        ValorManager.setSaldo(saldo);
        LogFormatter.logStep("Valido que o saldo seja maior ou igual o da fatura: " + saldo);
        assertTrue("Não foi possivel validar que o saldo é maior ou igual o valor da fatura",
                saldoInt >= valorFaturaInt);
    }

    public void validarDescontoValorFaturaLimite() {
        actions().verticalSwipeDownAndSearch(homePage().getTxtValorLimiteUtilizado());
        String valorFaturaStr = ValorManager.getValor();
        String valorLimiteStr = ValorManager.getValorLimite();
        String valorLimiteAtualStr = actions().getText(homePage().getTxtValorLimiteUtilizado());
        int valorFaturaInt = converterSaldoEmInteiro(valorFaturaStr);
        int valorLimiteInt = converterSaldoEmInteiro(valorLimiteStr);
        int valorLimiteAtualInt = converterSaldoEmInteiro(valorLimiteAtualStr);
        LogFormatter.logStep("valido que houve o desconto do valor da fatura no limite do cartao:");
        LogFormatter.logStep("valor da fatura:" + valorFaturaStr);
        LogFormatter.logStep("valor do limite utilizado anterior: " + valorLimiteStr);
        LogFormatter.logStep("valor do limite utilizado atual: " + valorLimiteAtualStr);
        assertTrue("não foi possivel validar o desconto do valor da fatura no limite utilizado do cartão",
                (valorFaturaInt + valorLimiteAtualInt) == valorLimiteInt);
    }

    public void clicarBtnMeuLimite() {
        LogFormatter.logStep("clico no botão 'Meu limite' na tela 'Home' do 'Cartões'");
        actions().verticalSwipeDownAndSearch(homePage().getBtnVerMinhasCompras(), 5);
        actions().click(homePage().getBtnMeuLimite());
    }

    public void clicarBtnCardOpenFinance() {
        LogFormatter.logStep("clico no card 'Open Finance' na tela 'Home'");
        actions().verticalSwipeDownAndSearch(homePage().getCarrosselProdutosDigio());
        actions().horizontalSwipeLeft(homePage().getCarrosselProdutosDigio(), homePage().getBtnOpenFinance(), 5);
        actions().click(homePage().getBtnOpenFinance());
    }


    public void clicarBtnSacar() {
        LogFormatter.logStep("clico no botão 'Sacar'");
        actions().sleep(2);
        if (actions().isIOS()) {
            if (actions().horizontalSwipeLeftAndSearch(homePage().getBtnPagar(), homePage().getBtnSacar(), 3)) {
                actions().click(homePage().getBtnSacar());
            } else {
                actions().horizontalSwipeLeft(homePage().getBtnPagar(), homePage().getBtnSacar(), 5);
                actions().click(homePage().getBtnSacar());
            }
        } else {
            if (actions().horizontalSwipeLeftAndSearch(homePage().getCarrosselConta(), homePage().getBtnSacar(), 3)) {
                actions().click(homePage().getBtnSacar());
            } else {
                actions().horizontalSwipeLeft(homePage().getCarrosselConta(), homePage().getBtnSacar(), 5);
                actions().click(homePage().getBtnSacar());
            }
        }
    }

    // MÉTODOS PARA VALIDAR TEXTO DO MENU
    public void validarExibicaoTextoNomeMenu() {
        LogFormatter.logStep("valido a exibição do texto 'Nome' na tela 'Menu'");
        actions().waitForElementToBeDisplayed(homePage().getTxtNomeMenu());
        assertTrue("Não foi possível validar a exibição do texto 'Nome' no menu",
                homePage().getTxtNomeMenu().isDisplayed());
    }

    public void validarExibicaoTextoInstituicaoMenu() {
        LogFormatter.logStep("valido a exibição do texto 'Instituição' na tela 'Menu'");
        actions().waitForElementToBeDisplayed(homePage().getTxtInstituicaoMenu());
        assertTrue("Não foi possível validar a exibição do texto 'Instituição' no menu",
                homePage().getTxtInstituicaoMenu().isDisplayed());
    }

    public void validarExibicaoTextoAgenciaMenu() {
        LogFormatter.logStep("valido a exibição do texto 'Agência' na tela 'Menu'");
        actions().waitForElementToBeDisplayed(homePage().getTxtAgenciaMenu());
        assertTrue("Não foi possível validar a exibição do texto 'Agência' no menu",
                homePage().getTxtAgenciaMenu().isDisplayed());
    }

    public void validarExibicaoTextoContaMenu() {
        LogFormatter.logStep("valido a exibição do texto 'Conta' na tela 'Menu'");
        actions().waitForElementToBeDisplayed(homePage().getTxtContaMenu());
        assertTrue("Não foi possível validar a exibição do texto 'Conta' no menu",
                homePage().getTxtContaMenu().isDisplayed());
    }
}
