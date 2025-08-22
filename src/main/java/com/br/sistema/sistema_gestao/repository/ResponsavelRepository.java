package com.br.sistema.sistema_gestao.repository;

import com.br.sistema.sistema_gestao.entity.Responsavel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class ResponsavelRepository {

    @PersistenceContext
    private EntityManager em;

    public Responsavel buscarPorId(Long id) {
        return em.find(Responsavel.class, id);
    }

    public List<Responsavel> listarTodos() {
        return em.createQuery("SELECT r FROM Responsavel r ORDER BY r.nome", Responsavel.class)
                .getResultList();
    }

    public void salvarResponsavel(Responsavel responsavel) {
        em.persist(responsavel);
    }
}
