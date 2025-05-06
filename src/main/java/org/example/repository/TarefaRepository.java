package org.example.repository;

import org.example.model.Tarefa;

import java.util.List;

public interface TarefaRepository {

    Tarefa criar(Tarefa tarefa);
    Tarefa buscarPorId(Long id);
    List<Tarefa> buscarTodos();
    Tarefa atualizar(Long id, Tarefa tarefa);
    boolean deletar(Long id);
}
