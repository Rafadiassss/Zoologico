package com.example.zoologico.Model;

import java.util.ArrayList;
import com.example.zoologico.View.Jaula;

public class DaoJaula implements DAO {
    private ArrayList<Jaula> jaulas = new ArrayList<>();

    @Override
    public void gravar() {
        System.out.println("Jaula cadastrada no banco de dados (simulação).");
    }

    @Override
    public void atualizar() {
        System.out.println("Jaula atualizada no banco de dados (simulação).");
    }

    @Override
    public void deletar() {
        System.out.println("Jaula deletada do banco de dados (simulação).");
    }

    // Método para listar todas as jaulas
    public ArrayList<Jaula> listar() {
        return jaulas;
    }

    // Método para buscar uma jaula pelo número
    public Jaula buscar(int numJaula) {
        for (Jaula j : jaulas) {
            if (j.getNumJaula() == numJaula) {
                return j;
            }
        }
        return null;
    }

    // Método para adicionar uma nova jaula
    public void adicionarJaula(Jaula jaula) {
        jaulas.add(jaula);
    }

    // Método para atualizar uma jaula
    public void atualizarJaula(Jaula novaJaula) {
        for (int i = 0; i < jaulas.size(); i++) {
            if (jaulas.get(i).getNumJaula() == novaJaula.getNumJaula()) {
                jaulas.set(i, novaJaula);
                return;
            }
        }
    }

    // Método para deletar uma jaula
    public void deletarJaula(int numJaula) {
        jaulas.removeIf(j -> j.getNumJaula() == numJaula);
    }
}
