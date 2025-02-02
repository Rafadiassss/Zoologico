package com.example.zoologico.Controller;

import com.example.zoologico.Model.DaoAnimal;
import com.example.zoologico.View.Animal;
import java.util.Date;
import java.util.Scanner;

public class AnimalController {
    public DaoAnimal daoAnimal = new DaoAnimal();

    public AnimalController() {
        this.daoAnimal = new DaoAnimal();  // Inicializa o DAO
    }

    // Método para cadastrar um novo animal
    public void cadastrarAnimal() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Cadastrar Animal:");

            // Solicita as informações do animal
            System.out.print("Código do Animal: ");
            int codAnimal = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada
            
            System.out.print("Nome do Animal: ");
            String nome = scanner.nextLine();

            System.out.print("Espécie: ");
            String especie = scanner.nextLine();
            
            System.out.print("Sexo: ");
            String sexo = scanner.nextLine();

            System.out.print("Data de Nascimento (dd/MM/yyyy): ");
            String dataStr = scanner.nextLine();
            Date dataNascimento = new Date();  // Aqui, você pode formatar a data conforme necessário (ex: usando SimpleDateFormat)

            System.out.print("Número da Jaula: ");
            int quantJaula = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Alimentação 1: ");
            String alimentacao1 = scanner.nextLine();

            System.out.print("Alimentação 2: ");
            String alimentacao2 = scanner.nextLine();

            System.out.print("Alimentação 3: ");
            String alimentacao3 = scanner.nextLine();

            System.out.print("Hora Alimentação 1 (horas): ");
            int halimentacao1 = scanner.nextInt();

            System.out.print("Hora Alimentação 2 (horas): ");
            int halimentacao2 = scanner.nextInt();

            System.out.print("Hora Alimentação 3 (horas): ");
            int halimentacao3 = scanner.nextInt();

            // Cria o novo animal e o adiciona
            Animal novoAnimal = new Animal(codAnimal, nome, especie, sexo, dataNascimento, quantJaula, alimentacao1, alimentacao2, alimentacao3, halimentacao1, halimentacao2, halimentacao3);
            daoAnimal.adicionarAnimal(novoAnimal);
        }
    }

    // Método para listar todos os animais
    public void listarAnimal() {
        System.out.println("Listar todos os Animais:");
        for (Animal animal : daoAnimal.listar()) {
            System.out.println(animal);
        }
    }

    // Método para buscar um animal pelo código
    public void buscarAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código do animal para buscar: ");
        int codAnimal = scanner.nextInt();

        Animal animal = daoAnimal.buscar(codAnimal);
        if (animal != null) {
            System.out.println("Animal encontrado: " + animal);
        } else {
            System.out.println("Animal não encontrado.");
        }
    }

    // Método para atualizar as informações de um animal
    public void atualizarAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código do animal para atualizar: ");
        int codAnimal = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        Animal animalExistente = daoAnimal.buscar(codAnimal);
        if (animalExistente != null) {
            System.out.println("Animal encontrado! Atualizando...");

            // Coleta novas informações do animal
            System.out.print("Novo nome: ");
            String nome = scanner.nextLine();

            System.out.print("Nova espécie: ");
            String especie = scanner.nextLine();

            System.out.print("Novo sexo: ");
            String sexo = scanner.nextLine();

            System.out.print("Nova alimentação 1: ");
            String alimentacao1 = scanner.nextLine();

            System.out.print("Nova alimentação 2: ");
            String alimentacao2 = scanner.nextLine();

            System.out.print("Nova alimentação 3: ");
            String alimentacao3 = scanner.nextLine();

            System.out.print("Novo horário Alimentação 1: ");
            int halimentacao1 = scanner.nextInt();

            System.out.print("Novo horário Alimentação 2: ");
            int halimentacao2 = scanner.nextInt();

            System.out.print("Novo horário Alimentação 3: ");
            int halimentacao3 = scanner.nextInt();

            // Atualiza o animal
            animalExistente.setNomeAnimal(nome);
            animalExistente.setEspecies(especie);
            animalExistente.setSexo(sexo);
            animalExistente.setAlimentacao1(alimentacao1);
            animalExistente.setAlimentacao2(alimentacao2);
            animalExistente.setAlimentacao3(alimentacao3);
            animalExistente.setHalimentacao1(halimentacao1);
            animalExistente.setHalimentacao2(halimentacao2);
            animalExistente.setHalimentacao3(halimentacao3);

            daoAnimal.atualizarAnimal(animalExistente);
        } else {
            System.out.println("Animal não encontrado para atualização.");
        }
    }

    // Método para deletar um animal
    public void deletarAnimal() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o código do animal para deletar: ");
        int codAnimal = scanner.nextInt();

        Animal animal = daoAnimal.buscar(codAnimal);
        if (animal != null) {
            daoAnimal.deletarAnimal(codAnimal);
        } else {
            System.out.println("Animal não encontrado para deletar.");
        }
    }
}
