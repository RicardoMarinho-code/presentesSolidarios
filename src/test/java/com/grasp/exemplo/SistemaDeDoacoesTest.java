package com.grasp.exemplo;

import com.grasp.exemplo.model.Beneficiario;
import com.grasp.exemplo.model.Doacao;
import com.grasp.exemplo.model.Doador;
import com.grasp.exemplo.model.Presente;
import com.grasp.exemplo.service.SistemaDeDoacoes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Testes para o Sistema de Presentes Solidários.
 * Valida a aplicação dos princípios GRASP.
 *
 * PRINCÍPIOS GRASP TESTADOS:
 *
 * 1. INFORMATION EXPERT:
 *    - Testa se `Beneficiario` gerencia bem sua lista de desejos.
 * 2. CREATOR:
 *    - Testa se `SistemaDeDoacoes` cria o objeto `Doacao` corretamente.
 */
public class SistemaDeDoacoesTest {

    private SistemaDeDoacoes sistema;
    private Doador doador;
    private Beneficiario beneficiario;
    private Presente presente1;
    private Presente presente2;

    @Before
    public void setUp() {
        sistema = new SistemaDeDoacoes();
        doador = new Doador("Ana", "Curitiba");
        beneficiario = new Beneficiario("Lucas", "Salvador");

        presente1 = new Presente("Cesta Básica", "Alimentos", "Itens essenciais.");
        presente2 = new Presente("Livro de Java", "Educação", "Livro para estudos.");

        sistema.registrarDoador(doador);
        sistema.registrarBeneficiario(beneficiario);
    }

    /**
     * Testa o princípio INFORMATION EXPERT
     * Vê se o Beneficiario gerencia sua lista de desejos
     */
    @Test
    public void testBeneficiarioGerenciaListaDesejos() {
        assertTrue("A lista de desejos inicial deveria estar vazia.", beneficiario.getListaDesejos().isEmpty());

        beneficiario.adicionarDesejo(presente1);
        assertEquals("A lista de desejos deveria ter 1 item.", 1, beneficiario.getListaDesejos().size());
        assertTrue("A lista de desejos deveria conter o presente adicionado.", beneficiario.getListaDesejos().contains(presente1));

        beneficiario.removerDesejo(presente1);
        assertTrue("A lista de desejos deveria estar vazia após a remoção.", beneficiario.getListaDesejos().isEmpty());
    }

    /**
     * Testa o princípio CREATOR
     * Vê se o SistemaDeDoacoes cria o objeto Doacao
     */
    @Test
    public void testSistemaCriaDoacaoComSucesso() {
        beneficiario.adicionarDesejo(presente1);

        Doacao doacao = sistema.processarDoacao(doador, beneficiario, presente1);

        assertNotNull("O objeto Doacao não deveria ser nulo.", doacao);
        assertEquals("O doador na doação está incorreto.", doador, doacao.getDoador());
        assertEquals("O beneficiário na doação está incorreto.", beneficiario, doacao.getBeneficiario());
        assertEquals("O presente na doação está incorreto.", presente1, doacao.getPresente());
    }

    /**
     * Testa o fluxo da doação
     * Valida se os Experts são atualizados
     * depois que o Creator age
     */
    @Test
    public void testFluxoCompletoDoacao() {
        beneficiario.adicionarDesejo(presente1);
        beneficiario.adicionarDesejo(presente2);
        assertEquals(2, beneficiario.getListaDesejos().size());

        sistema.processarDoacao(doador, beneficiario, presente1);

        assertEquals("A lista de desejos do beneficiário deveria ter apenas 1 item restante.", 1, beneficiario.getListaDesejos().size());
        assertFalse("O presente doado ainda está na lista de desejos.", beneficiario.getListaDesejos().contains(presente1));
        assertTrue("O outro desejo deveria permanecer na lista.", beneficiario.getListaDesejos().contains(presente2));

        assertEquals("O histórico do doador deveria conter 1 doação.", 1, doador.getHistoricoDoacoes().size());
        assertEquals("O presente no histórico do doador está incorreto.", presente1, doador.getHistoricoDoacoes().get(0).getPresente());
    }


    @Test
    public void testFalhaAoDoarPresenteNaoDesejado() {
        assertTrue(beneficiario.getListaDesejos().isEmpty());

        Doacao doacao = sistema.processarDoacao(doador, beneficiario, presente1);

        assertNull("A doação deveria ter falhado, pois o presente não era desejado.", doacao);

        assertTrue("O histórico do doador deveria permanecer vazio.", doador.getHistoricoDoacoes().isEmpty());
    }
}
