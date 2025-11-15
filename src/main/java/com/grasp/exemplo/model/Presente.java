package com.grasp.exemplo.model;

/**
 * Representa o presente que vai ser doado
 * É um Information Expert dos seus próprios dados
 */
public class Presente {
    private String nome;
    private String categoria;
    private String descricao;

    public Presente(String nome, String categoria, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Presente{" +
                "nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}