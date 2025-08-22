package com.br.sistema.sistema_gestao.dto;

import java.time.LocalDate;

public class TarefaRequest {
    private String titulo;
    private String descricao;
    private Long responsavelId;
    private LocalDate deadline;
    private String prioridade;
    private boolean concluida;

    public TarefaRequest() {}

    public TarefaRequest(String titulo, String descricao, Long responsavelId, LocalDate deadline, String prioridade, boolean concluida){
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavelId = responsavelId;
        this.deadline = deadline;
        this.prioridade = prioridade;
        this.concluida = concluida;
    }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Long getResponsavelId() {  return responsavelId; }

    public void setResponsavelId(Long responsavelId) { this.responsavelId = responsavelId; }

    public LocalDate getDeadline() { return deadline; }

    public void setDeadline(LocalDate deadline) { this.deadline = deadline; }

    public String getPrioridade() { return prioridade; }

    public void setPrioridade(String prioridade) { this.prioridade = prioridade; }

    public boolean isConcluida() { return concluida; }

    public void setConcluida(boolean concluida) { this.concluida = concluida; }
}
