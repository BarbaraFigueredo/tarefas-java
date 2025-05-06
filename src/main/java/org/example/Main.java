package org.example;

import org.example.model.Tarefa;
import org.example.repository.TarefaRepository;
import org.example.repository.TarefaRepositoryImpl;
import org.example.service.TarefaService;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TarefaRepository repository = new TarefaRepositoryImpl();
        TarefaService service = new TarefaService(repository);

        Tarefa t1 = service.criarTarefa("Estudar Java", "Focar em orientação a objetos");
        Tarefa t2 = service.criarTarefa("Aprender Spring", "Criar uma API REST");

        System.out.println("Tarefas criadas:");
        service.listarTodasTarefas().forEach(System.out::println);

        System.out.println("\nAtualizando tarefa:");
        service.atualizarTarefa(t1.getId(), "Estudar Java Avançado", null, "EM ANDAMENTO");

        System.out.println("\nTarefa atualizada:");
        System.out.println(service.buscarTarefaPorId(t1.getId()));

        System.out.println("\nRemoção:");
        System.out.println("Tarefa removida? " + service.deletarTarefa(t2.getId()));

        System.out.println("\nTarefas restantes:");
        service.listarTodasTarefas().forEach(System.out::println);
    }
}
