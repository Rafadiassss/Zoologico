package com.example.zoologico.Model;

import java.util.ArrayList;
import com.example.zoologico.View.Animal;

public class DaoAnimal implements DAO {
    private ArrayList<Animal> animais = new ArrayList<>();

    @Override
    public void gravar() {
        // Lógica para adicionar um novo animal à lista de animais
        System.out.println("Animal gravado no banco de dados (simulação).");
    }

    @Override
    public void atualizar() {
        // Atualizar o método genérico da interface, se necessário
        System.out.println("Animal atualizado no banco de dados (simulação).");
    }

    @Override
    public void deletar() {
        // Deletar o método genérico da interface, se necessário
        System.out.println("Animal deletado do banco de dados (simulação).");
    }

    // Método para listar todos os animais
    public ArrayList<Animal> listar() {
        return animais;
    }

    // Método para buscar um animal pelo código
    public Animal buscar(int codAnimal) {
        for (Animal a : animais) {
            if (a.getCodAnimal() == codAnimal) {
                return a;
            }
        }
        return null;  // Retorna null caso o animal não seja encontrado
    }

    // Método para adicionar um animal à lista
    public void adicionarAnimal(Animal animal) {
        animais.add(animal);
        System.out.println("Animal adicionado com sucesso!");
    }

    // Método para atualizar um animal na lista
    public void atualizarAnimal(Animal novoAnimal) {
        for (int i = 0; i < animais.size(); i++) {
            if (animais.get(i).getCodAnimal() == novoAnimal.getCodAnimal()) {
                animais.set(i, novoAnimal); // Atualiza a posição do animal na lista
                System.out.println("Animal atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Animal não encontrado para atualização.");
    }

    // Método para deletar um animal da lista pelo código
    public void deletarAnimal(int codAnimal) {
        animais.removeIf(a -> a.getCodAnimal() == codAnimal);  // Remove o animal com o código fornecido
        System.out.println("Animal deletado com sucesso!");
    }
}
