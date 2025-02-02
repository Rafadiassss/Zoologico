package zoologico;

import java.util.ArrayList;

public class DaoAnimal implements DAO {
    private ArrayList<Animal> animais = new ArrayList<>();

    @Override
    public void gravar() {
        // Lógica para salvar um animal na lista ou banco de dados
    }

    @Override
    public void atualizar() {
        // Método genérico da interface (não usado diretamente)
    }

    @Override
    public void deletar() {
        // Método genérico da interface (não usado diretamente)
    }

    public ArrayList<Animal> listar() {
        return animais;
    }

    public Animal buscar(int codAnimal) {
        for (Animal a : animais) {
            if (a.getCodAnimal() == codAnimal) {
                return a;
            }
        }
        return null;
    }

    // Método para deletar um animal da lista
    public void deletar(int codAnimal) {
        animais.removeIf(a -> a.getCodAnimal() == codAnimal);
    }
}
