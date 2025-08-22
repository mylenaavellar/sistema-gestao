package com.br.sistema.sistema_gestao.controller;

import com.br.sistema.sistema_gestao.dto.ResponsavelResponse;
import com.br.sistema.sistema_gestao.dto.TarefaRequest;
import com.br.sistema.sistema_gestao.dto.TarefaResponse;
import com.br.sistema.sistema_gestao.entity.Prioridade;
import com.br.sistema.sistema_gestao.service.ResponsavelService;
import com.br.sistema.sistema_gestao.service.TarefaService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("tarefaController")
@ViewScoped
public class TarefaController implements Serializable {

    private final TarefaService tarefaService;
    private final ResponsavelService responsavelService;

    private List<TarefaResponse> tarefas;
    private TarefaRequest tarefaRequest = new TarefaRequest();

    private List<ResponsavelResponse> responsaveis;
    private Prioridade[] prioridades;

    @Inject
    public TarefaController(TarefaService tarefaService,  ResponsavelService responsavelService, Prioridade[] prioridades) {
        this.tarefaService = tarefaService;
        this.responsavelService = responsavelService;
    }

    public TarefaController() {
        this.tarefaService = null;
        this.responsavelService = null;
    }

    @PostConstruct
    public void init() {
        this.tarefas = tarefaService.listarTodasAsTarefas();
        this.responsaveis = responsavelService.listarTodos();
        this.prioridades = Prioridade.values();
    }

    public void criarTarefa() {
        try {
            tarefaService.criarTarefa(this.tarefaRequest);
            this.tarefaRequest = new TarefaRequest();
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TarefaResponse buscarTarefaPorId(Long id) {
        return tarefaService.buscarTarefaPorId(id);
    }

    public List<TarefaResponse> listarTarefas() {
        return tarefaService.listarTodasAsTarefas();
    }

    public TarefaResponse atualizarTarefa(Long id, TarefaRequest request) {
        return tarefaService.atualizarTarefa(id, request);
    }

    public void deletarTarefa(Long id) {
        tarefaService.deletarTarefa(id);
        init();
    }

    public TarefaResponse concluirTarefa(Long id) {
        return tarefaService.concluirTarefa(id);
    }

    public List<TarefaResponse> getTarefas() { return tarefas; }

    public void setTarefas(List<TarefaResponse> tarefas) { this.tarefas = tarefas; }

    public TarefaRequest getTarefaRequest() { return tarefaRequest; }

    public void setTarefaRequest(TarefaRequest tarefaRequest) { this.tarefaRequest = tarefaRequest; }

    public List<ResponsavelResponse> getResponsaveis() { return responsaveis; }

    public Prioridade[] getPrioridades() { return prioridades; }
}
