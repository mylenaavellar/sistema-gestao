package com.br.sistema.sistema_gestao.mapper;

import com.br.sistema.sistema_gestao.dto.TarefaRequest;
import com.br.sistema.sistema_gestao.dto.TarefaResponse;
import com.br.sistema.sistema_gestao.entity.Prioridade;
import com.br.sistema.sistema_gestao.entity.Responsavel;
import com.br.sistema.sistema_gestao.entity.Tarefa;

public class TarefaMapper {
    public static Tarefa toTarefa(TarefaRequest request, Responsavel responsavel) {
        Prioridade prioridade = Prioridade.valueOf(request.getPrioridade().toUpperCase());

        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(request.getTitulo());
        tarefa.setDescricao(request.getDescricao());
        tarefa.setResponsavel(responsavel);
        tarefa.setDeadline(request.getDeadline());
        tarefa.setPrioridade(prioridade);
        tarefa.setConcluida(request.isConcluida());

        return tarefa;
    }

    public static TarefaResponse toResponse(Tarefa tarefa) {
        TarefaResponse response = new TarefaResponse();
        response.setId(tarefa.getId());
        response.setTitulo(tarefa.getTitulo());
        response.setDescricao(tarefa.getDescricao());
        response.setResponsavelId(tarefa.getResponsavel().getId());
        response.setDeadline(tarefa.getDeadline());
        response.setPrioridade(tarefa.getPrioridade().getNome());
        response.setConcluida(tarefa.isConcluida());

        return response;
    }

    public static void atualizarTarefaDeDto(Tarefa tarefaExistente, TarefaRequest request, Responsavel responsavel) {
        Prioridade prioridade = Prioridade.valueOf(request.getPrioridade().toUpperCase());

        tarefaExistente.setTitulo(request.getTitulo());
        tarefaExistente.setDescricao(request.getDescricao());
        tarefaExistente.setResponsavel(responsavel);
        tarefaExistente.setDeadline(request.getDeadline());
        tarefaExistente.setPrioridade(prioridade);
        tarefaExistente.setConcluida(request.isConcluida());
    }
}
