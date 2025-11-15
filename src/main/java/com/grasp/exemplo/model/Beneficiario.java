package com.grasp.exemplo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa a pessoa que recebe a doação.
 * Herda de Pessoa e gerencia sua lista de desejos.
 *
 * PRINCÍPIO GRASP: INFORMATION EXPERT
 * - Aplicação: A classe Beneficiario é especialista na sua lista de desejos.
 *   Ela tem a lista e os métodos para cuidar dela.
 * - Justificativa: A responsabilidade de gerenciar os desejos é do próprio
 *   Beneficiario, para aumentar a coesão.
 */
public class Beneficiario extends Pessoa {

    private final List<Presente> listaDesejos;

    public Beneficiario(String nome, String cidade) {
        super(nome, cidade);
        this.listaDesejos = new ArrayList<>();
    }

    /**
     * Adiciona um novo presente à lista de desejos.
     * Como Expert, ele mesmo gerencia sua lista.
     * @param presente O presente para adicionar.
     */
    public void adicionarDesejo(Presente presente) {
        if (presente != null) {
            this.listaDesejos.add(presente);
        }
    }

    /**
     * Remove um presente da lista de desejos.
     * @param presente O presente para remover.
     */
    public void removerDesejo(Presente presente) {
        this.listaDesejos.remove(presente);
    }

    /**
     * Retorna uma cópia da lista de desejos para proteger a original.
     * @return A lista de presentes desejados.
     */
    public List<Presente> getListaDesejos() {

        return new ArrayList<>(listaDesejos);
    }
}