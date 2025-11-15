package com.grasp.exemplo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a pessoa que faz a doação
 * Herda de Pessoa e guarda o histórico de doações
 *
 * PRINCÍPIO GRASP: INFORMATION EXPERT
 * - Aplicação: A classe Doador é especialista no seu histórico de doações
 * - Justificativa: A responsabilidade de controlar as doações é do próprio doador
 */
public class Doador extends Pessoa {

    private final List<Doacao> historicoDoacoes;

    public Doador(String nome, String cidade) {
        super(nome, cidade);
        this.historicoDoacoes = new ArrayList<>();
    }

    /**
     * Adiciona uma doação ao histórico do doador
     * @param doacao A doação realizada
     */
    public void adicionarDoacaoAoHistorico(Doacao doacao) {
        if (doacao != null) {
            this.historicoDoacoes.add(doacao);
        }
    }

    public List<Doacao> getHistoricoDoacoes() {
        return new ArrayList<>(historicoDoacoes);
    }
}