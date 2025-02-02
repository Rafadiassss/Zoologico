package com.example.zoologico.View;

public class Jaula {
    private int numJaula;
    private String nomeJaula;
    private int capacidade;
    private String tipoAnimal;

    // Construtores
    public Jaula(int numJaula, String nomeJaula, int capacidade, String tipoAnimal) {
        this.numJaula = numJaula;
        this.nomeJaula = nomeJaula;
        this.capacidade = capacidade;
        this.tipoAnimal = tipoAnimal;
    }

    public Jaula() {}

    // Getters e Setters
    public int getNumJaula() {
        return numJaula;
    }

    public void setNumJaula(int numJaula) {
        this.numJaula = numJaula;
    }

    public String getNomeJaula() {
        return nomeJaula;
    }

    public void setNomeJaula(String nomeJaula) {
        this.nomeJaula = nomeJaula;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    @Override
    public String toString() {
        return "Jaula [numJaula=" + numJaula + ", nomeJaula=" + nomeJaula + ", capacidade=" + capacidade + ", tipoAnimal=" + tipoAnimal + "]";
    }
}
