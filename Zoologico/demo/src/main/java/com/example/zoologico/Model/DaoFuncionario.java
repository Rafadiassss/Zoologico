package com.example.zoologico.Model;

import java.util.ArrayList;

import com.example.zoologico.View.Funcionario;

public class DaoFuncionario implements DAO {
    @Override
    public void gravar() {
        // Implementar o código para gravar o funcionário no Firebase ou outro banco
    }

    @Override
    public void atualizar() {
        // Implementar o código para atualizar o funcionário no banco
    }

    @Override
    public void deletar() {
        // Implementar o código para deletar o funcionário do banco
    }

    public Funcionario buscar(int codFuncionario) {
        // Implementar a busca de funcionário por código
        return null; // Retornar o funcionário encontrado ou null
    }

    public ArrayList<Funcionario> listar() {
        // Implementar a listagem de todos os funcionários
        return new ArrayList<>(); // Retornar a lista de funcionários
    }

    public void setF(Funcionario f) {
    }
}
