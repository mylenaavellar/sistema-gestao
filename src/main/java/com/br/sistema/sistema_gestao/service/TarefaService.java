package com.br.sistema.sistema_gestao.service;

import com.br.sistema.sistema_gestao.dto.TarefaRequest;
import com.br.sistema.sistema_gestao.dto.TarefaResponse;
import com.br.sistema.sistema_gestao.entity.Responsavel;
import com.br.sistema.sistema_gestao.entity.Tarefa;
import com.br.sistema.sistema_gestao.mapper.TarefaMapper;
import com.br.sistema.sistema_gestao.repository.ResponsavelRepository;
import com.br.sistema.sistema_gestao.repository.TarefaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TarefaService {
    private final TarefaRepository tarefaRepository;
    private final ResponsavelRepository responsavelRepository;

    @Inject
    public TarefaService(TarefaRepository tarefaRepository, ResponsavelRepository responsavelRepository) {
        this.tarefaRepository = tarefaRepository;
        this.responsavelRepository = responsavelRepository;
    }

    @Transactional
    public TarefaResponse criarTarefa(TarefaRequest request) {
        Responsavel responsavel = responsavelRepository.buscarPorId(request.getResponsavelId());
        if (responsavel == null) {
            throw new IllegalArgumentException("Responsável não encontrado.");
        }

        Tarefa novaTarefa = TarefaMapper.toTarefa(request, responsavel);
        tarefaRepository.salvarTarefa(novaTarefa);

        return TarefaMapper.toResponse(novaTarefa);
    }

    public TarefaResponse buscarTarefaPorId(Long id) {
        Tarefa tarefa = tarefaRepository.buscarPorId(id);
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }

        return TarefaMapper.toResponse(tarefa);
    }

    public List<TarefaResponse> listarTodasAsTarefas() {
        List<Tarefa> tarefas = tarefaRepository.listarTodas();
        return tarefas.stream()
                .map(TarefaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public TarefaResponse atualizarTarefa(Long id, TarefaRequest request) {
        Tarefa tarefaExistente = tarefaRepository.buscarPorId(id);
        if (tarefaExistente == null) {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }

        Responsavel responsavel = responsavelRepository.buscarPorId(request.getResponsavelId());
        if (responsavel == null) {
            throw new IllegalArgumentException("Responsável não encontrado.");
        }

        TarefaMapper.atualizarTarefaDeDto(tarefaExistente, request, responsavel);
        Tarefa tarefaAtualizada = tarefaRepository.atualizarTarefa(tarefaExistente);

        return TarefaMapper.toResponse(tarefaAtualizada);
    }

    @Transactional
    public void deletarTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.buscarPorId(id);
        if (tarefa != null) {
            tarefaRepository.deletarTarefa(tarefa);
        } else {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }
    }

    @Transactional
    public TarefaResponse concluirTarefa(Long id) {
        Tarefa tarefa = tarefaRepository.buscarPorId(id);
        if (tarefa == null) {
            throw new IllegalArgumentException("Tarefa não encontrada.");
        }

        tarefa.setConcluida(true);

        return TarefaMapper.toResponse(tarefa);
    }

}
