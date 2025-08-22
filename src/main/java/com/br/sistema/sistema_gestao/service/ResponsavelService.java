package com.br.sistema.sistema_gestao.service;

import com.br.sistema.sistema_gestao.dto.ResponsavelResponse;
import com.br.sistema.sistema_gestao.entity.Responsavel;
import com.br.sistema.sistema_gestao.mapper.ResponsavelMapper;
import com.br.sistema.sistema_gestao.repository.ResponsavelRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ResponsavelService {

    private final ResponsavelRepository responsavelRepository;
    private final ResponsavelMapper responsavelMapper;

    @Inject
    public ResponsavelService(ResponsavelRepository responsavelRepository, ResponsavelMapper responsavelMapper) {
        this.responsavelRepository = responsavelRepository;
        this.responsavelMapper = responsavelMapper;
    }

    public ResponsavelResponse buscarPorId(Long id) {
        Responsavel responsavel = responsavelRepository.buscarPorId(id);
        return responsavelMapper.toResponse(responsavel);
    }

    public List<ResponsavelResponse> listarTodos() {
        List<Responsavel> responsaveis = responsavelRepository.listarTodos();

        return responsaveis.stream()
                .map(responsavelMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public ResponsavelResponse criarResponsavel(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do responsável não pode ser vazio.");
        }

        Responsavel novoResponsavel = new Responsavel();
        novoResponsavel.setNome(nome);

        responsavelRepository.salvarResponsavel(novoResponsavel);

        return responsavelMapper.toResponse(novoResponsavel);
    }
}