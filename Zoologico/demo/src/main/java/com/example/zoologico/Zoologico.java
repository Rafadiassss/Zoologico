package com.example.zoologico;

import com.example.zoologico.Controller.AnimalController;
import com.example.zoologico.Controller.CadastroFuncionario;
import com.example.zoologico.Controller.CadastroJaula;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Zoologico {

    public static void main(String[] args) {
        // Inicializa o Firebase
        FirebaseService.initializeFirebase();

        try (// Scanner para ler as opções do usuário
        Scanner leia = new Scanner(System.in)) {
            int escolha;

            // Menu principal de navegação
            do {
                mostrarMenu();
                escolha = leia.nextInt();

                switch (escolha) {
                    case 1:
                        // Chama o menu de funcionário
                        funcionario();
                        break;
                    case 2:
                        // Chama o menu de jaula
                        jaula();
                        break;
                    case 3:
                        // Chama o menu de animal
                        animal();
                        break;
                    case 4:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (escolha != 4);
        }
    }

    // Função para mostrar o menu principal
    private static void mostrarMenu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Funcionario");
        System.out.println("2 - Jaulas");
        System.out.println("3 - Animais");
        System.out.println("4 - Sair");
    }

    // Função para o menu de opções do Funcionário
    private static void funcionario() {
        try (Scanner leia = new Scanner(System.in)) {
            int escolha;

            // Menu para operações com Funcionário
            do {
                mostrarMenuFuncionario();
                escolha = leia.nextInt();
                switch (escolha) {
                    case 1:
                        CadastroFuncionario.cadastrarFuncionario();
                        break;
                    case 2:
                        CadastroFuncionario.listarFuncionario();
                        break;
                    case 3:
                        CadastroFuncionario.buscarFuncionario();
                        break;
                    case 4:
                        CadastroFuncionario.atualizarFuncionario();
                        break;
                    case 5:
                        CadastroFuncionario.deletarFuncionario();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (escolha != 6);
        }
    }

    // Função para o menu de opções da Jaula
    private static void jaula() {
        @SuppressWarnings("resource")
        Scanner leia = new Scanner(System.in);
        int escolha;

        // Menu para operações com Jaula
        do {
            mostrarMenuJaula();
            escolha = leia.nextInt();
            switch (escolha) {
                case 1:
                    CadastroJaula.cadastrarJaula();
                    break;
                case 2:
                    CadastroJaula.listarJaulas();;
                    break;
                case 3:
                    CadastroJaula.buscarJaula();
                    break;
                case 4:
                    CadastroJaula.atualizarJaula();
                    break;
                case 5:
                    CadastroJaula.deletarJaula();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (escolha != 6);
    }

    // Função para o menu de opções do Animal
    private static void animal() {
        try (Scanner leia = new Scanner(System.in)) {
            int escolha;
            AnimalController animalController = new AnimalController();
            // Menu para operações com Animal
            do {
                mostrarMenuAnimal();
                escolha = leia.nextInt();
                switch (escolha) {
                    case 1:
                        animalController.cadastrarAnimal();
                        break;
                    case 2:
                        animalController.listarAnimal();
                        break;
                    case 3:
                        animalController.buscarAnimal();
                        break;
                    case 4:
                        animalController.atualizarAnimal();
                        break;
                    case 5:
                        animalController.deletarAnimal();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } while (escolha != 6);
        }
    }

    // Menu auxiliar para opções de funcionário
    private static void mostrarMenuFuncionario() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Listar Funcionários");
        System.out.println("3 - Buscar Funcionário");
        System.out.println("4 - Atualizar Funcionário");
        System.out.println("5 - Deletar Funcionário");
        System.out.println("6 - Voltar");
    }

    // Menu auxiliar para opções de Jaula
    private static void mostrarMenuJaula() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Jaula");
        System.out.println("2 - Listar Jaulas");
        System.out.println("3 - Buscar Jaula");
        System.out.println("4 - Atualizar Jaula");
        System.out.println("5 - Deletar Jaula");
        System.out.println("6 - Voltar");
    }

    // Menu auxiliar para opções de Animal
    private static void mostrarMenuAnimal() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Listar Animais");
        System.out.println("3 - Buscar Animal");
        System.out.println("4 - Atualizar Animal");
        System.out.println("5 - Deletar Animal");
        System.out.println("6 - Voltar");
    }
}

class FirebaseService {
    public static void initializeFirebase() {
        try {
            // Seu código de inicialização do Firebase
            System.out.println("Firebase Inicializado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao inicializar o Firebase: " + e.getMessage());
        }
    }
}

class FuncionarioService {
    public static void cadastrarFuncionario() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        Firestore db = FirestoreClient.getFirestore();
        System.out.print("Digite o nome do Funcionario: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o cargo do Funcionario: ");
        String cargo = scanner.nextLine();
        Map<String, Object> funcionario = new HashMap<>();
        funcionario.put("nome", nome);
        funcionario.put("cargo", cargo);
        @SuppressWarnings("unused")
        ApiFuture<WriteResult> writeResult = db.collection("funcionarios").document().set(funcionario);
        System.out.println("Funcionario cadastrado com sucesso.");
    }

    public static void listarFuncionario() {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("funcionarios").get();
        try {
            QuerySnapshot querySnapshot = query.get();
            for (QueryDocumentSnapshot doc : querySnapshot.getDocuments()) {
                System.out.println(doc.getId() + ": " + doc.getData());
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar funcionários: " + e.getMessage());
        }
    }

    public static void buscarFuncionario() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do Funcionario: ");
        String id = scanner.nextLine();
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("funcionarios").document(id);
        ApiFuture<DocumentSnapshot> future = docRef.get();
        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                System.out.println("Funcionario encontrado: " + document.getData());
            } else {
                System.out.println("Funcionario não encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar funcionário: " + e.getMessage());
        }
    }

    public static void atualizarFuncionario() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o ID do Funcionario para atualizar: ");
        String id = scanner.nextLine();
        Firestore db = FirestoreClient.getFirestore();
        DocumentReference docRef = db.collection("funcionarios").document(id);
        System.out.print("Digite o novo cargo do Funcionario: ");
        String cargo = scanner.nextLine();
        Map<String, Object> updates = new HashMap<>();
        updates.put("cargo", cargo);
        @SuppressWarnings("unused")
        ApiFuture<WriteResult> writeResult = docRef.update(updates);
        System.out.println("Funcionario atualizado com sucesso.");
    }

    public static void deletarFuncionario() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o ID do Funcionario para deletar: ");
            String id = scanner.nextLine();
            Firestore db = FirestoreClient.getFirestore();
            DocumentReference docRef = db.collection("funcionarios").document(id);
            @SuppressWarnings("unused")
            ApiFuture<WriteResult> writeResult = docRef.delete();
        }
        System.out.println("Funcionario deletado com sucesso.");
    }
}

// As classes JaulaService e AnimalService seguem o mesmo padrão do FuncionarioService
