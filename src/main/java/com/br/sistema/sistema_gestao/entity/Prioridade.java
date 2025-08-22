package com.br.sistema.sistema_gestao.entity;

public enum Prioridade {
    ALTA("Alta"),
    MEDIA("Média"),
    BAIXA("Baixa");

    private final String nome;

    Prioridade(String nome) { this.nome = nome; }

    public String getNome() { return nome; }
}
