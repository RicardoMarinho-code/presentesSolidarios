# Projeto Presentes Solidários

Este projeto é um sistema simples em Java para gerenciar doações de presentes, conectando doadores a beneficiários. O objetivo é permitir que pessoas em situação de vulnerabilidade possam cadastrar uma lista de desejos e que doadores possam atender a esses desejos a qualquer momento, sem a necessidade de datas comemorativas.

O sistema foi desenvolvido como um exercício para aplicar os princípios de design de software **GRASP** (General Responsibility Assignment Software Patterns).

## Funcionalidades

- Cadastro de Doadores e Beneficiários.
- Beneficiários podem criar e gerenciar uma lista de presentes desejados.
- Doadores podem visualizar beneficiários e suas listas de desejos.
- Sistema para processar a doação de um presente de um doador para um beneficiário.

## Princípios GRASP Aplicados

1.  **Information Expert (Especialista da Informação):**
    - A classe `Beneficiario` é a especialista em sua própria lista de desejos. Ela contém a lista e os métodos para manipulá-la (`adicionarDesejo`, `removerDesejo`).
    - A classe `Doador` é a especialista em seu histórico de doações.

2.  **Creator (Criador):**
    - A classe `SistemaDeDoacoes` é responsável por criar objetos `Doacao`. Ela possui as informações agregadas (doador, beneficiário, presente) necessárias para instanciar uma doação, centralizando a lógica de criação.