package com.grasp.exemplo.service;

import com.grasp.exemplo.model.Beneficiario;
import com.grasp.exemplo.model.Doacao;
import com.grasp.exemplo.model.Doador;
import com.grasp.exemplo.model.Presente;

import java.util.ArrayList;
import java.util.List;

/**
 * Centraliza a lógica de negócio do sistema
 * Gerencia os participantes e o processo de doação
 *
 * PRINCÍPIO GRASP: CREATOR
 * - Aplicação: O método `processarDoacao` cria os objetos `Doacao`
 * - Justificativa: Essa classe tem os dados necessários
 *   para criar uma `Doacao`, então ela fica com essa responsabilidade
 */
public class SistemaDeDoacoes {

    private final List<Doador> doadores = new ArrayList<>();
    private final List<Beneficiario> beneficiarios = new ArrayList<>();

    public void registrarDoador(Doador doador) {
        this.doadores.add(doador);
    }

    public void registrarBeneficiario(Beneficiario beneficiario) {
        this.beneficiarios.add(beneficiario);
    }

    /**
     * Processa a doação de um presente de um doador para um beneficiário
     * Aplica o princípio CREATOR para criar o objeto Doacao
     *
     * @param doador O doador que está presenteando
     * @param beneficiario O beneficiário que está recebendo
     * @param presente O presente que está sendo doado
     * @return A instância da Doacao criada, ou null se não tiver a lista de desejos
     */
    public Doacao processarDoacao(Doador doador, Beneficiario beneficiario, Presente presente) {
        //Vê se o presente está na lista de desejos
        if (!beneficiario.getListaDesejos().contains(presente)) {
            System.out.println("Falha na doação: O presente '" + presente.getNome() + "' não está na lista de desejos de " + beneficiario.getNome() + ".");
            return null;
        }

        Doacao novaDoacao = new Doacao(doador, beneficiario, presente);

        beneficiario.removerDesejo(presente); // Beneficiario gerencia sua lista
        doador.adicionarDoacaoAoHistorico(novaDoacao); // Doador gerencia seu histórico

        return novaDoacao;
    }

    public List<Doador> getDoadores() { return doadores; }
    public List<Beneficiario> getBeneficiarios() { return beneficiarios; }
}
