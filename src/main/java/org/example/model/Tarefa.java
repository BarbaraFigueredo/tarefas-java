package org.example.model;

public class Tarefa {

    private String titulo;
    private String descricao;
    private String status;
    private int id;

    public Tarefa(String titulo, String descricao) {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, String status, int id) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", status='" + status + '\'' +
                ", id=" + id +
                '}';
    }
}
