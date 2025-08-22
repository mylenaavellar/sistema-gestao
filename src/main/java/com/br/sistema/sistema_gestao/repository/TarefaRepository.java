package com.br.sistema.sistema_gestao.repository;

import com.br.sistema.sistema_gestao.entity.Prioridade;
import com.br.sistema.sistema_gestao.entity.Responsavel;
import com.br.sistema.sistema_gestao.entity.Tarefa;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class TarefaRepository {

    @PersistenceContext
    private EntityManager em;

    public void salvarTarefa(Tarefa tarefa) {
        em.persist(tarefa);
    }

    public Tarefa buscarPorId(Long id) {
        return em.find(Tarefa.class, id);
    }

    public Tarefa atualizarTarefa(Tarefa tarefa) {
        return em.merge(tarefa);
    }

    public void deletarTarefa(Tarefa tarefa) {
        if (!em.contains(tarefa)) {
            tarefa = em.merge(tarefa);
        }
        em.remove(tarefa);
    }

    public List<Tarefa> listarTodas() {
        return em.createQuery("SELECT t FROM Tarefa t", Tarefa.class).getResultList();
    }

    public List<Tarefa> listarPorTitulo(String titulo) {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t WHERE t.titulo = :titulo", Tarefa.class);
        query.setParameter("titulo", titulo);

        return query.getResultList();
    }

    public List<Tarefa> listarPorDescricao(String descricao) {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t WHERE t.descricao LIKE :descricao", Tarefa.class);
        query.setParameter("descricao", "%" + descricao + "%");

        return query.getResultList();
    }

    public List<Tarefa> listarPorResponsavel(Responsavel responsavel) {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t WHERE t.responsavel = :responsavel", Tarefa.class);
        query.setParameter("responsavel", responsavel);

        return query.getResultList();
    }

    public List<Tarefa> listarPorDeadline(LocalDate deadline) {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t WHERE t.deadline = :deadline", Tarefa.class);
        query.setParameter("deadline", deadline);

        return query.getResultList();
    }

    public List<Tarefa> listarPorPrioridade(Prioridade prioridade) {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t WHERE t.prioridade = :prioridade", Tarefa.class);
        query.setParameter("prioridade", prioridade);

        return query.getResultList();
    }

    public List<Tarefa> listarPorConcluida(boolean concluida) {
        TypedQuery<Tarefa> query = em.createQuery("SELECT t FROM Tarefa t WHERE t.concluida = :concluida", Tarefa.class);
        query.setParameter("concluida", concluida);

        return query.getResultList();
    }
}
