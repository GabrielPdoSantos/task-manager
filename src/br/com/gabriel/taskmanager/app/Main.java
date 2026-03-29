package br.com.gabriel.taskmanager.app;


import br.com.gabriel.taskmanager.controller.TaskManager;
import br.com.gabriel.taskmanager.exceptions.TarefaException;
import br.com.gabriel.taskmanager.model.Tarefa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Scanner scanner = new Scanner(System.in);
        boolean condicaoPrograma = true;

        //Menu
        do {
            try {
                menu();
                int resposta = Integer.parseInt(scanner.nextLine());
                switch (resposta) {
                    case 1:
                        taskManager.adicionarTarefas();
                        break;
                    case 2:
                        taskManager.listarTarefas();
                        break;
                    case 3:
                        taskManager.concluirTarefa();
                        break;
                    case 4:
                        taskManager.removerTarefa();
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        condicaoPrograma = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }

            } catch (TarefaException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Tente novamente!!");
                System.out.println("Digite apenas números no menu");
            }
        } while(condicaoPrograma);


    }

    public static void menu(){
        System.out.println("========== MENU ==========");
        System.out.println("1. Criar nova tarefa");
        System.out.println("2. Listar tarefas");
        System.out.println("3. Marcar tarefa como concluída");
        System.out.println("4. Remover tarefa");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }
}
