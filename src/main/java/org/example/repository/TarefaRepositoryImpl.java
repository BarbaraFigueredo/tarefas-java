package org.example.repository;

import org.example.model.Tarefa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TarefaRepositoryImpl implements TarefaRepository{
    private final Map<Long, Tarefa> banco = new HashMap<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    @Override
    public Tarefa criar(Tarefa tarefa){
        Long id = contadorId.getAndIncrement();
        tarefa.setId(Math.toIntExact(id));
        banco.put(id, tarefa);
        return tarefa;
    }

    @Override
    public Tarefa buscarPorId(Long id){
        return banco.get(id);
    }

    @Override
    public List<Tarefa> buscarTodos(){
        return new ArrayList<>(banco.values());
    }

    @Override
    public Tarefa atualizar(Long id, Tarefa novaTarefa){
        if (banco.containsKey(id)) {
            return null;
        }
        novaTarefa.setId(Math.toIntExact(id));
        banco.put(id, novaTarefa);
        return novaTarefa;
    }

    @Override
    public boolean deletar(Long id){
        return banco.remove(id) != null;
    }
}
