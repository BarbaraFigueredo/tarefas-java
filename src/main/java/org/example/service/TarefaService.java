package org.example.service;

import org.example.model.Tarefa;
import org.example.repository.TarefaRepository;

import java.util.List;

public class TarefaService {
    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public Tarefa criarTarefa(String titulo, String descricao) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("O título da tarefa não pode estar vazio.");
        }

        Tarefa nova = new Tarefa(titulo, descricao);
        return repository.criar(nova);
    }

    public Tarefa buscarTarefaPorId(Long id) {
        return repository.buscarPorId(id);
    }

    public List<Tarefa> listarTodasTarefas() {
        return repository.buscarTodos();
    }

    public Tarefa atualizarTarefa(Long id, String novoTitulo, String novaDescricao, String novoStatus) {
        Tarefa existente = repository.buscarPorId(id);
        if (existente == null) {
            return null;
        }

        if (novoTitulo != null && !novoTitulo.isBlank()) {
            existente.setTitulo(novoTitulo);
        }

        if (novaDescricao != null) {
            existente.setDescricao(novaDescricao);
        }

        if (novoStatus != null && !novoStatus.isBlank()) {
            existente.setStatus(novoStatus);
        }

        return repository.atualizar(id, existente);
    }

    public boolean deletarTarefa(Long id) {
        return repository.deletar(id);
    }
}

