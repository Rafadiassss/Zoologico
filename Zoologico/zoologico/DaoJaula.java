package zoologico;

import java.util.ArrayList;

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
        System.out.println("Jaula adicionada com sucesso!");
    }

    public void atualizar(Jaula novaJaula) {
        for (int i = 0; i < jaulas.size(); i++) {
            if (jaulas.get(i).getNumJaula() == novaJaula.getNumJaula()) {
                jaulas.set(i, novaJaula); // Atualiza a jaula na lista
                return;
            }
        }
    }

    public void deletar(int numJaula) {
        for (int i = 0; i < jaulas.size(); i++) {
            if (jaulas.get(i).getNumJaula() == numJaula) {
                jaulas.remove(i); // Remove a jaula da lista
                return;
            }
        }
    }
    
}
