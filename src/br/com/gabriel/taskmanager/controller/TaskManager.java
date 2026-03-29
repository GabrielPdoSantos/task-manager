package br.com.gabriel.taskmanager.controller;

import br.com.gabriel.taskmanager.exceptions.TarefaException;
import br.com.gabriel.taskmanager.model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    List<Tarefa> listaDeTarefas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void adicionarTarefas() {
        System.out.println("Título da tarefa: ");
        String titulo = scanner.nextLine();
        if (titulo == null || titulo.isBlank()) {
            titulo = "Título em branco";
        }
        System.out.println("Descrição da tarefa: ");
        String descricao = scanner.nextLine();
        Tarefa tarefa = new Tarefa(titulo, descricao);
        listaDeTarefas.add(tarefa);
        System.out.println("Tarefa feita com sucesso.");

    }

    public void listarTarefas() {
        System.out.println("Lista de Tarefas");
        //Foreach com as opções
        for (Tarefa lista : listaDeTarefas) {
            System.out.println(lista.getId() + "- " + lista.getTitulo());
        }
        System.out.println("Qual deseja ver: ");
        //Ta feio mas achei essa forma para resolver
        int resposta = lerNumero();
        for (Tarefa lista : listaDeTarefas) {
            if (lista.getId() == resposta) {
                System.out.println(lista.getTitulo());
                System.out.println("----------------------");
                System.out.println(lista.getDescricao());
                System.out.println("Estado de conclusão: " + lista.isConcluida());
                System.out.println("===========================================");
            }
        }
    }

    public void concluirTarefa() {
        String estado = "não concluida";
        System.out.println("Lista de Tarefas");
        for (Tarefa lista : listaDeTarefas) {
            if (!lista.isConcluida()) {
                System.out.println(lista.getId() + "- " + lista.getTitulo() + " " + estado);
            }
        }
        System.out.println("Marque a que você deseja concluir: ");

        int resposta = lerNumero();
        for (Tarefa lista : listaDeTarefas) {
            if (resposta == lista.getId()) {
                lista.setConcluida(true);
                System.out.println(lista.getTitulo() + " Foi concluída com sucesso");
            }
        }


    }

    public void removerTarefa() {
        System.out.println("Remoção de Tarefas");
        for (Tarefa lista : listaDeTarefas) {
            System.out.println(lista.getId() + ". " + lista.getTitulo());
        }
        System.out.println("Digite a que você deseja excluir:  ");
        int resposta = lerNumero();
        Tarefa aux = new Tarefa(" ", " ");
        for (Tarefa lista : listaDeTarefas) {
            if (resposta == lista.getId()) {
                aux = lista;
            }
        }
        listaDeTarefas.remove(aux);
        System.out.println("Tarefa removida");
    }


    private int lerNumero() {
        String entrada = scanner.nextLine().trim();

        if (entrada.isBlank()) {
            throw new TarefaException("Entrada vazia não é permitida.");
        }

        try {
            return Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            throw new TarefaException("Digite apenas números.");
        }
    }
}

