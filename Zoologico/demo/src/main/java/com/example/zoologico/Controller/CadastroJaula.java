package com.example.zoologico.Controller;

import java.util.Scanner;
import com.example.zoologico.Model.DaoJaula;
import com.example.zoologico.View.Jaula;

public class CadastroJaula {
    private static DaoJaula daoJaula = new DaoJaula(); // Instancia o DAO para manipular as jaulas

    // Função para cadastrar uma nova jaula
    public static void cadastrarJaula() {
        Scanner scanner = new Scanner(System.in);

        // Coleta as informações da jaula
        System.out.print("Digite o número da jaula: ");
        int numJaula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o nome da jaula: ");
        String nomeJaula = scanner.nextLine();
        System.out.print("Digite a capacidade da jaula: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o tipo de animal da jaula: ");
        String tipoAnimal = scanner.nextLine();

        // Cria o objeto Jaula com os dados informados
        Jaula novaJaula = new Jaula(numJaula, nomeJaula, capacidade, tipoAnimal);

        // Chama o DAO para adicionar a jaula
        daoJaula.adicionarJaula(novaJaula);
        daoJaula.gravar(); // Simula a gravação no banco de dados
        System.out.println("Jaula cadastrada com sucesso!");
    }

    // Função para listar todas as jaulas
    public static void listarJaulas() {
        System.out.println("Listando todas as jaulas:");
        for (Jaula jaula : daoJaula.listar()) {
            System.out.println(jaula);
        }
    }

    // Função para buscar uma jaula pelo número
    public static void buscarJaula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da jaula que deseja buscar: ");
        int numJaula = scanner.nextInt();
        Jaula jaulaEncontrada = daoJaula.buscar(numJaula);

        if (jaulaEncontrada != null) {
            System.out.println("Jaula encontrada: " + jaulaEncontrada);
        } else {
            System.out.println("Jaula não encontrada.");
        }
    }

    // Função para atualizar uma jaula existente
    public static void atualizarJaula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da jaula que deseja atualizar: ");
        int numJaula = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Jaula jaulaExistente = daoJaula.buscar(numJaula);
        if (jaulaExistente != null) {
            // Atualiza os dados da jaula
            System.out.print("Digite o novo nome da jaula: ");
            String nomeJaula = scanner.nextLine();
            System.out.print("Digite a nova capacidade da jaula: ");
            int capacidade = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            System.out.print("Digite o novo tipo de animal da jaula: ");
            String tipoAnimal = scanner.nextLine();

            jaulaExistente.setNomeJaula(nomeJaula);
            jaulaExistente.setCapacidade(capacidade);
            jaulaExistente.setTipoAnimal(tipoAnimal);

            daoJaula.atualizarJaula(jaulaExistente);
            System.out.println("Jaula atualizada com sucesso!");
        } else {
            System.out.println("Jaula não encontrada.");
        }
    }

    // Função para deletar uma jaula
    public static void deletarJaula() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número da jaula que deseja deletar: ");
        int numJaula = scanner.nextInt();
        
        Jaula jaulaEncontrada = daoJaula.buscar(numJaula);
        if (jaulaEncontrada != null) {
            daoJaula.deletarJaula(numJaula);
            System.out.println("Jaula deletada com sucesso!");
        } else {
            System.out.println("Jaula não encontrada.");
        }
    }
}
