package com.grasp.exemplo.model;

/**
 * Classe base para Doador e Beneficiario.
 */
public abstract class Pessoa {
    private String nome;
    private String cidade;

    public Pessoa(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
