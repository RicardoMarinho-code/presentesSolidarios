package com.grasp.exemplo;

import com.grasp.exemplo.model.Beneficiario;
import com.grasp.exemplo.model.Doacao;
import com.grasp.exemplo.model.Doador;
import com.grasp.exemplo.model.Presente;
import com.grasp.exemplo.service.SistemaDeDoacoes;

import java.time.format.DateTimeFormatter;

/**
 * Classe principal para demonstrar o sistema funcionando.
 *
 * PRINCÍPIOS GRASP APLICADOS:
 *
 * 1. EXPERT:
 *    - `Beneficiario` cuida da sua lista de desejos.
 *    - `Doador` cuida do seu histórico.
 *
 * 2. CREATOR:
 *    - `SistemaDeDoacoes` cria os objetos `Doacao`.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Sistema de Presentes Solidários ===\n");

        SistemaDeDoacoes sistema = new SistemaDeDoacoes();

        Doador doadorCarlos = new Doador("Carlos", "São Paulo");
        sistema.registrarDoador(doadorCarlos);

        Beneficiario beneficiarioJoao = new Beneficiario("João", "Rio de Janeiro");
        Beneficiario beneficiariaMaria = new Beneficiario("Maria", "Belo Horizonte");
        sistema.registrarBeneficiario(beneficiarioJoao);
        sistema.registrarBeneficiario(beneficiariaMaria);

        // Beneficiários cadastram desejos
        // João, como expert, gerencia a própria lista.
        Presente desejo1Joao = new Presente("Cesta Básica", "Alimentos", "Uma cesta com itens essenciais.");
        Presente desejo2Joao = new Presente("Violão", "Instrumento Musical", "Um violão para aprender a tocar.");
        beneficiarioJoao.adicionarDesejo(desejo1Joao);
        beneficiarioJoao.adicionarDesejo(desejo2Joao);

        Presente desejo1Maria = new Presente("Kit de material escolar", "Educação", "Cadernos, lápis e mochila para o filho.");
        beneficiariaMaria.adicionarDesejo(desejo1Maria);

        System.out.println("--- Listas de Desejos Iniciais ---");
        System.out.println("Desejos de " + beneficiarioJoao.getNome() + ": " + beneficiarioJoao.getListaDesejos().size());
        System.out.println("Desejos de " + beneficiariaMaria.getNome() + ": " + beneficiariaMaria.getListaDesejos().size());
        System.out.println();

        // Doador presenteia
        // SistemaDeDoacoes é o criador do objeto Doacao
        System.out.println("--- Processando Doações ---");
        System.out.println(doadorCarlos.getNome() + " decide doar uma Cesta Básica para " + beneficiarioJoao.getNome() + ".");

        Doacao doacaoRealizada = sistema.processarDoacao(doadorCarlos, beneficiarioJoao, desejo1Joao);

        if (doacaoRealizada != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("SUCESSO! Doação registrada em " + doacaoRealizada.getDataDaDoacao().format(formatter));
            System.out.println("  De: " + doacaoRealizada.getDoador().getNome());
            System.out.println("  Para: " + doacaoRealizada.getBeneficiario().getNome());
            System.out.println("  Presente: " + doacaoRealizada.getPresente().getNome());
        }
        System.out.println();

        System.out.println("--- Estado Final do Sistema ---");
        System.out.println("Lista de desejos de " + beneficiarioJoao.getNome() + " foi atualizada.");
        System.out.println("  Desejos restantes: " + beneficiarioJoao.getListaDesejos().size());
        for(Presente p : beneficiarioJoao.getListaDesejos()){
            System.out.println("  - " + p.getNome());
        }
        System.out.println();

        System.out.println("Histórico de doações de " + doadorCarlos.getNome() + " foi atualizado.");
        System.out.println("  Total de doações feitas: " + doadorCarlos.getHistoricoDoacoes().size());
        for(Doacao d : doadorCarlos.getHistoricoDoacoes()){
            System.out.println("  - Presenteou '" + d.getPresente().getNome() + "' para " + d.getBeneficiario().getNome());
        }
    }
}
