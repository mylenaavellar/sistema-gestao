package com.br.sistema.sistema_gestao.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "responsavel")
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "responsavel")
    private List<Tarefa> tarefas;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public List<Tarefa> getTarefas() { return tarefas; }

    public void setTarefas(List<Tarefa> tarefas) { this.tarefas = tarefas; }
}
