package com.example.zoologico.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.zoologico.View.Funcionario;

public class CadastroFuncionario {

    // Lista para armazenar os funcionários
    private static List<Funcionario> listaFuncionarios = new ArrayList<>();

    // Função para cadastrar um novo funcionário
    public static void cadastrarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        // Coleta as informações do funcionário
        System.out.print("Digite o código do funcionário: ");
        int codFuncionario = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite a função do funcionário: ");
        String funcao = scanner.nextLine();
        System.out.print("Digite o turno do funcionário: ");
        String turno = scanner.nextLine();
        System.out.print("Digite o nome do funcionário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF do funcionário: ");
        int cpf = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        System.out.print("Digite o telefone do funcionário: ");
        String telefone = scanner.nextLine();

        // Cria o objeto Funcionario com os dados informados
        Funcionario novoFuncionario = new Funcionario(codFuncionario, funcao, turno, nome, cpf, telefone);

        // Adiciona o funcionário à lista
        listaFuncionarios.add(novoFuncionario);

        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Função para listar os funcionários
    public static void listarFuncionario() {
        // Verifica se há funcionários cadastrados
        if (listaFuncionarios.isEmpty()) {
            System.out.println("Não há funcionários cadastrados.");
        } else {
            System.out.println("Lista de Funcionários:");
            for (Funcionario funcionario : listaFuncionarios) {
                System.out.println(funcionario.toString());
            }
        }
    }

    // Função para buscar um funcionário
    public static void buscarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do funcionário para buscar: ");
        String nomeBusca = scanner.nextLine();

        // Procura o funcionário na lista
        boolean encontrado = false;
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Funcionário encontrado: ");
                System.out.println(funcionario.toString());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Função para atualizar as informações de um funcionário
    public static void atualizarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do funcionário para atualizar: ");
        String nomeBusca = scanner.nextLine();

        // Procura o funcionário na lista
        boolean encontrado = false;
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeBusca)) {
                System.out.println("Funcionário encontrado. Atualizando informações...");

                // Atualiza as informações
                System.out.print("Novo código (deixe em branco para manter o mesmo): ");
                String novoCodStr = scanner.nextLine();
                if (!novoCodStr.isEmpty()) {
                    int novoCod = Integer.parseInt(novoCodStr);
                    funcionario.setCodFuncionario(novoCod);
                }

                System.out.print("Nova função (deixe em branco para manter o mesmo): ");
                String novaFuncao = scanner.nextLine();
                if (!novaFuncao.isEmpty()) {
                    funcionario.setFuncao(novaFuncao);
                }

                System.out.print("Novo turno (deixe em branco para manter o mesmo): ");
                String novoTurno = scanner.nextLine();
                if (!novoTurno.isEmpty()) {
                    funcionario.setTurno(novoTurno);
                }

                System.out.print("Novo nome (deixe em branco para manter o mesmo): ");
                String novoNome = scanner.nextLine();
                if (!novoNome.isEmpty()) {
                    funcionario.setNome(novoNome);
                }

                System.out.print("Novo CPF (deixe em branco para manter o mesmo): ");
                String novoCpfStr = scanner.nextLine();
                if (!novoCpfStr.isEmpty()) {
                    int novoCpf = Integer.parseInt(novoCpfStr);
                    funcionario.setCpf(novoCpf);
                }

                System.out.print("Novo telefone (deixe em branco para manter o mesmo): ");
                String novoTelefone = scanner.nextLine();
                if (!novoTelefone.isEmpty()) {
                    funcionario.setTelefone(novoTelefone);
                }

                System.out.println("Funcionário atualizado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Função para deletar um funcionário
    public static void deletarFuncionario() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do funcionário para deletar: ");
        String nomeBusca = scanner.nextLine();

        // Procura o funcionário na lista
        boolean encontrado = false;
        for (Funcionario funcionario : listaFuncionarios) {
            if (funcionario.getNome().equalsIgnoreCase(nomeBusca)) {
                listaFuncionarios.remove(funcionario);
                System.out.println("Funcionário deletado com sucesso!");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Funcionário não encontrado.");
        }
    }

    // Função para retornar a lista de funcionários
    public static List<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }
}
