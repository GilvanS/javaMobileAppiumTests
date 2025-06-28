package org.testes.driver.manager;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SaldoManagerTest {

    @Test
    public void testConverterParaDouble() {
        // Teste com valor normal
        assertEquals(4350.00, SaldoManager.converterParaDouble("R$ 4.350,00"), 0.01);
        
        // Teste com valor que tinha problema (espaço extra)
        assertEquals(4450.00, SaldoManager.converterParaDouble("R$ 4.450,00"), 0.01);
        
        // Teste com valor sem espaços
        assertEquals(1000.00, SaldoManager.converterParaDouble("R$1.000,00"), 0.01);
        
        // Teste com valor decimal
        assertEquals(1234.56, SaldoManager.converterParaDouble("R$ 1.234,56"), 0.01);
    }

    @Test
    public void testCalcularSaldoEsperado() {
        // Configurar valores de teste
        SaldoManager.setSaldo("R$ 4.350,00");
        SaldoManager.setValorRegistro("R$ 100,00");
        
        // Calcular saldo esperado
        String saldoEsperado = SaldoManager.calcularSaldoEsperado();
        
        // Validar resultado
        assertEquals("R$ 4.450,00", saldoEsperado);
        
        // Limpar após teste
        SaldoManager.remove();
    }
} 