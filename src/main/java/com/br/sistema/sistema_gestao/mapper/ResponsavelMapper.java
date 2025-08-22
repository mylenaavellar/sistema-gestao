package com.br.sistema.sistema_gestao.mapper;

import com.br.sistema.sistema_gestao.dto.ResponsavelResponse;
import com.br.sistema.sistema_gestao.entity.Responsavel;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResponsavelMapper {

    public ResponsavelResponse toResponse(Responsavel responsavel) {
        if (responsavel == null) {
            return null;
        }

        ResponsavelResponse response = new ResponsavelResponse();
        response.setId(responsavel.getId());
        response.setNome(responsavel.getNome());

        return response;
    }
}
