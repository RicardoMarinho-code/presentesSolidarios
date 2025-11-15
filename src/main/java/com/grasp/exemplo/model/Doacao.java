package com.grasp.exemplo.model;

import java.time.LocalDateTime;
/**
 * Registra uma doação, ligando Doador, Beneficiario e Presente.
 * É criada pelo SistemaDeDoacoes.
 */
public class Doacao {
    private final Doador doador;
    private final Beneficiario beneficiario;
    private final Presente presente;
    private final LocalDateTime dataDaDoacao;

    public Doacao(Doador doador, Beneficiario beneficiario, Presente presente) {
        this.doador = doador;
        this.beneficiario = beneficiario;
        this.presente = presente;
        this.dataDaDoacao = LocalDateTime.now();
    }

    public Doador getDoador() {
        return doador;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public Presente getPresente() {
        return presente;
    }

    public LocalDateTime getDataDaDoacao() {
        return dataDaDoacao;
    }
}