package br.com.gabriel.taskmanager.model;

public class Tarefa {
    private String titulo;
    private String descricao;
    private boolean concluida;
    private int id;
    private static int contador = 1;


    public Tarefa(String titulo, String descricao) {
        this.id = contador++;
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
