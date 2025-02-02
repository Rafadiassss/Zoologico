package zoologico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner leia = new Scanner(System.in)) {
			int escolha;
			do{
				menu();
				escolha = leia.nextInt();
				switch (escolha){
				case 1:{
					funcionario();
				}
				break;
				case 2:{
					jaula();
				}
				break;
				case 3:{
					animal();
				}
				break;
				case 4: {
					sair();
				}
				break;
				}
			}while(escolha != 4);
		}
	}


	private static void sair() {
		System.out.println("Saindo...");
		System.exit(0);
	}

	private static void animal() {
		try (Scanner leia = new Scanner(System.in)) {
			int escolha;
			do{
				menu2();
				escolha = leia.nextInt();
				switch (escolha){
				case 1:{
					cadastrarAnimal();
				}
				break;
				case 2:{
					listarAnimal();
				}
				break;
				case 3:{
					buscarAnimal();

				}
				break;
				case 4: {
					atualizarAnimal();
				}
				break;
				case 5: {
					deletarAnimal();
				}
				break;
				case 6:
					break;
				}
			}while(escolha != 6);
		}
	}



	private static void cadastrarAnimal() {
    try (Scanner leia = new Scanner(System.in)) {
		DaoAnimal dao = new DaoAnimal();
		Animal animal = new Animal();

		System.out.println("Digite os dados do novo animal:");

		// Pedir e definir o código do animal
		System.out.print("Código do animal: ");
		animal.setCodAnimal(leia.nextInt());
		leia.nextLine(); // Limpar o buffer de entrada

		// Pedir e definir o nome do animal
		System.out.print("Nome do animal: ");
		animal.setNomeAnimal(leia.nextLine());

		// Pedir e definir a espécie do animal
		System.out.print("Espécie do animal: ");
		animal.setEspecies(leia.nextLine());

		// Pedir e definir o sexo do animal
		System.out.print("Sexo do animal (M/F): ");
		animal.setSexo(leia.nextLine());

		// Pedir e definir a data de nascimento do animal
		System.out.print("Data de nascimento (dd/MM/yyyy): ");
		String dataStr = leia.nextLine();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
		    Date dataNasc = formato.parse(dataStr);
		    animal.setDataNasc(dataNasc);
		} catch (ParseException e) {
		    System.out.println("Data inválida! A data não foi registrada.");
		}

		// Pedir e definir o número da jaula
		System.out.print("Número da jaula: ");
		animal.setQuantJaula(leia.nextInt());

		leia.nextLine(); // Limpar o buffer de entrada

		// Pedir as alimentações e horários
		System.out.print("Alimentação 1: ");
		animal.setAlimentacao1(leia.nextLine());

		System.out.print("Horário da alimentação 1 (em horas): ");
		animal.setHalimentacao1(leia.nextInt());

		leia.nextLine(); // Limpar o buffer de entrada

		System.out.print("Alimentação : ");
		animal.setAlimentacao2(leia.nextLine());

		System.out.print("Horário da alimentação 2 (em horas): ");
		animal.setHalimentacao2(leia.nextInt());

		leia.nextLine(); // Limpar o buffer de entrada

		System.out.print("Alimentação 3: ");
		animal.setAlimentacao3(leia.nextLine());

		System.out.print("Horário da alimentação 3 (em horas): ");
		animal.setHalimentacao3(leia.nextInt());

		// Gravar o animal
		dao.gravar();
	}
    System.out.println("Animal cadastrado com sucesso!");
}

	private static void listarAnimal() {
		DaoAnimal dao = new DaoAnimal();
		ArrayList<Animal> animais = dao.listar(); // Agora o método existe!
	
		if (animais.isEmpty()) {
			System.out.println("Nenhum animal cadastrado.");
		} else {
			for (Animal a : animais) {
				System.out.println(a);
			}
		}
	}

	private static void buscarAnimal() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoAnimal dao = new DaoAnimal();

			System.out.print("Digite o código do animal que deseja buscar: ");
			int codAnimal = leia.nextInt();

			Animal encontrado = dao.buscar(codAnimal); // Assumindo que `DaoAnimal` tenha um método `buscar()`

			if (encontrado != null) {
				System.out.println("Animal encontrado: " + encontrado);
			} else {
				System.out.println("Animal não encontrado.");
			}
		}
	}

	private static void atualizarAnimal() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoAnimal dao = new DaoAnimal();

			System.out.print("Digite o código do animal que deseja atualizar: ");
			int codAnimal = leia.nextInt();
			leia.nextLine(); // Limpar buffer

			Animal animal = dao.buscar(codAnimal); // Buscar o animal pelo código

			if (animal != null) {
				System.out.println("Animal encontrado: " + animal);
				
				System.out.print("Novo nome: ");
				animal.setNomeAnimal(leia.nextLine());

				System.out.print("Nova espécie: ");
				animal.setEspecies(leia.nextLine());

				System.out.print("Novo sexo (M/F): ");
				animal.setSexo(leia.nextLine());

				System.out.print("Novo número da jaula: ");
				animal.setQuantJaula(leia.nextInt());
				leia.nextLine(); // Limpar buffer

				System.out.print("Nova alimentação 1: ");
				animal.setAlimentacao1(leia.nextLine());

				System.out.print("Novo horário da alimentação 1 (em horas, ex: 12 para meio-dia): ");
				animal.setHalimentacao1(leia.nextInt());

				dao.atualizar(); // Chamar o método atualizar no DAO

				System.out.println("Animal atualizado com sucesso!");
			} else {
				System.out.println("Animal não encontrado.");
			}
		}
	}

	private static void deletarAnimal() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoAnimal dao = new DaoAnimal();

			System.out.print("Digite o código do animal que deseja deletar: ");
			int codAnimal = leia.nextInt();

			Animal animal = dao.buscar(codAnimal); // Buscar o animal pelo código

			if (animal != null) {
				dao.deletar(codAnimal); // Chamar o método deletar no DAO
				System.out.println("Animal removido com sucesso!");
			} else {
				System.out.println("Animal não encontrado.");
			}
		}
	}
	

	private static void jaula() {
		try (Scanner leia = new Scanner(System.in)) {
			int escolha;
			do{
				menu2();
				escolha = leia.nextInt();
				switch (escolha){
				case 1:{
					cadastrarJaula();
				}
				break;
				case 2:{
					listarJaula();
				}
				break;
				case 3:{
					buscarJaula();

				}
				break;
				case 4: {
					atualizarJaula();
				}
				break;
				case 5: {
					deletarJaula();
				}
				break;
				case 6:
					break;
				}
			}while(escolha != 6);
		}
	}

	private static void cadastrarJaula() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoJaula dao = new DaoJaula();
			Jaula jaula = new Jaula();

			System.out.println("Digite os dados da nova jaula:");

			// Pedir e definir o número da jaula
			System.out.print("Número da jaula: ");
			jaula.setNumJaula(leia.nextInt());

			// Pedir e definir o tamanho da jaula
			System.out.print("Tamanho da jaula (m²): ");
			jaula.setTamanho(leia.nextInt());

			leia.nextLine(); // Limpar buffer

			// Pedir e definir a última data de limpeza
			System.out.print("Última limpeza (dd/MM/yyyy): ");
			String dataStr = leia.nextLine();
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dataLimpeza = formato.parse(dataStr);
				jaula.setLimpeza(dataLimpeza);
			} catch (ParseException e) {
				System.out.println("Data inválida! A data não foi registrada.");
			}

			// Pedir e definir o status de manutenção
			System.out.print("A jaula está em manutenção? (Sim/Não): ");
			jaula.setManutencao(leia.nextLine());

			// Gravar a jaula
			dao.gravar();
		}
		System.out.println("Jaula cadastrada com sucesso!");
	}

	private static void listarJaula() {
		DaoJaula dao = new DaoJaula();
		ArrayList<Jaula> jaulas = dao.listar(); // Obtém a lista de jaulas cadastradas
	
		if (jaulas.isEmpty()) {
			System.out.println("Nenhuma jaula cadastrada.");
		} else {
			System.out.println("Lista de Jaulas:");
			for (Jaula j : jaulas) {
				System.out.println(j);
			}
		}
	}
	
	private static void buscarJaula() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoJaula dao = new DaoJaula();

			System.out.print("Digite o número da jaula que deseja buscar: ");
			int numJaula = leia.nextInt();

			Jaula j = dao.buscar(numJaula); // Busca a jaula pelo número

			if (j != null) {
				System.out.println("Jaula encontrada:");
				System.out.println(j);
			} else {
				System.out.println("Jaula não encontrada.");
			}
		}
	}
	
	private static void atualizarJaula() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoJaula dao = new DaoJaula();

			System.out.print("Digite o número da jaula que deseja atualizar: ");
			int numJaula = leia.nextInt();
			leia.nextLine(); // Consumir quebra de linha

			Jaula j = dao.buscar(numJaula); // Busca a jaula pelo número

			if (j != null) {
				System.out.println("Jaula encontrada. Digite as novas informações.");

				System.out.print("Novo tamanho da jaula: ");
				j.setTamanho(leia.nextInt());
				leia.nextLine(); // Consumir quebra de linha

				// Converter a data usando SimpleDateFormat
				System.out.print("Nova data da última limpeza (YYYY-MM-DD): ");
				String dataLimpeza = leia.nextLine();
				
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date = sdf.parse(dataLimpeza); // Converte a string para java.util.Date
					j.setLimpeza(date); // Atualiza a jaula com a nova data
				} catch (Exception e) {
					System.out.println("Erro ao converter a data: " + e.getMessage());
				}

				System.out.print("Nova situação de manutenção: ");
				j.setManutencao(leia.nextLine());

				dao.atualizar(j); // Atualiza a jaula no DAO
				System.out.println("Jaula atualizada com sucesso!");
			} else {
				System.out.println("Jaula não encontrada.");
			}
		}
	}
	
	private static void deletarJaula() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoJaula dao = new DaoJaula();

			System.out.print("Digite o número da jaula que deseja deletar: ");
			int numJaula = leia.nextInt();
			leia.nextLine(); // Consumir quebra de linha

			Jaula j = dao.buscar(numJaula); // Busca a jaula pelo número

			if (j != null) {
				System.out.println("Jaula encontrada: " + j);
				System.out.print("Tem certeza que deseja deletar? (S/N): ");
				String confirmacao = leia.nextLine();

				if (confirmacao.equalsIgnoreCase("S")) {
					dao.deletar(); // Remove a jaula do DAO
					System.out.println("Jaula deletada com sucesso!");
				} else {
					System.out.println("Operação cancelada.");
				}
			} else {
				System.out.println("Jaula não encontrada.");
			}
		}
	}
	

	private static void funcionario() {
		try (Scanner leia = new Scanner(System.in)) {
			int escolha;
			do{
				menu2();
				escolha = leia.nextInt();
				switch (escolha){
				case 1:{
					cadastrarFuncionario();
				}
				break;
				case 2:{
					listarFuncionario();
				}
				break;
				case 3:{
					buscarFuncionario();

				}
				break;
				case 4: {
					atualizarFuncionario();
				}
				break;
				case 5: {
					deletarFuncionario();
				}
				break;
				case 6:
					break;
				}
			}while(escolha != 6);
		}
	}

	private static void cadastrarFuncionario() {
		Scanner leia = new Scanner(System.in); // Criar o scanner fora do try
	
		try {
			Funcionario f = new Funcionario(); // Cria um novo funcionário
			DaoFuncionario dao = new DaoFuncionario();
	
			System.out.print("Nome: ");
			f.setNome(leia.nextLine());
	
			System.out.print("Código: ");
			f.setCodFuncionario(leia.nextInt());
	
			leia.nextLine(); // Consumir quebra de linha
	
			System.out.print("Função: ");
			f.setFuncao(leia.nextLine());
	
			System.out.print("Turno: ");
			f.setTurno(leia.nextLine());
	
			System.out.print("CPF: ");
			f.setCpf(leia.nextInt());
	
			leia.nextLine(); // Consumir quebra de linha
	
			System.out.print("Telefone: ");
			f.setTelefone(leia.nextLine());
	
			dao.setF(f);
			dao.gravar(); // Salva o funcionário usando o DAO
	
			System.out.println("Funcionário cadastrado com sucesso!");
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar funcionário: " + e.getMessage());
		} finally {
			leia.close(); // Fechar o scanner depois de usá-lo
		}
	}
	

	private static void listarFuncionario() {
		DaoFuncionario dao = new DaoFuncionario();
		ArrayList<Funcionario> funcionarios = dao.listar(); // Supondo que você tenha um método `listar()` no DAO
	
		if (funcionarios.isEmpty()) {
			System.out.println("Nenhum funcionário encontrado.");
		} else {
			for (Funcionario f : funcionarios) {
				System.out.println(f); // Exibe as informações do funcionário
			}
		}
	}

	private static void buscarFuncionario() {
		try (Scanner leia = new Scanner(System.in)) {
			System.out.print("Digite o código do funcionário: ");
			int codFuncionario = leia.nextInt();
			leia.nextLine(); // Consumir quebra de linha

			DaoFuncionario dao = new DaoFuncionario();
			Funcionario f = dao.buscar(codFuncionario); // Método buscar() deve ser implementado no DaoFuncionario

			if (f != null) {
				System.out.println("Funcionário encontrado: " + f);
			} else {
				System.out.println("Funcionário não encontrado.");
			}
		}
	}

	private static void atualizarFuncionario() {
		try (Scanner leia = new Scanner(System.in)) {
			DaoFuncionario dao = new DaoFuncionario();

			System.out.print("Digite o código do funcionário que deseja atualizar: ");
			int codFuncionario = leia.nextInt();
			leia.nextLine(); // Consumir quebra de linha

			Funcionario f = dao.buscar(codFuncionario); // Busca o funcionário pelo código

			if (f != null) {
				System.out.println("Funcionário encontrado. Digite as novas informações.");

				System.out.print("Novo nome: ");
				f.setNome(leia.nextLine());

				System.out.print("Nova função: ");
				f.setFuncao(leia.nextLine());

				System.out.print("Novo turno: ");
				f.setTurno(leia.nextLine());

				System.out.print("Novo CPF: ");
				f.setCpf(leia.nextInt());

				leia.nextLine(); // Consumir quebra de linha

				System.out.print("Novo telefone: ");
				f.setTelefone(leia.nextLine());

				dao.atualizar(); // Atualiza o funcionário no DAO
				System.out.println("Funcionário atualizado com sucesso!");
			} else {
				System.out.println("Funcionário não encontrado.");
			}
		}
	}
	private static void deletarFuncionario() {
		try (Scanner leia = new Scanner(System.in)) {
			System.out.print("Digite o código do funcionário que deseja excluir: ");
			int codFuncionario = leia.nextInt();
			leia.nextLine(); // Consumir quebra de linha

			DaoFuncionario dao = new DaoFuncionario();
			Funcionario f = dao.buscar(codFuncionario); // Busca o funcionário pelo código

			if (f != null) {
				dao.deletar(); // Deleta o funcionário
				System.out.println("Funcionário deletado com sucesso!");
			} else {
				System.out.println("Funcionário não encontrado.");
			}
		}
	}
		


	private static void menu() {
		System.out.println(" escolha uma opção: ");
		System.out.println("1-Funcionario\n"
				+ "2-Jaulas\n"
				+ "3-Animais\n"
				+ "4-Sair\n"
				+ "Opção: ");
	}

	private static void menu2() {
		
		System.out.println(" escolha uma opção: ");
		System.out.println("1-Castratar\n"
				+ "2-Listar\n"
				+ "3-Buscar\n"
				+ "4-Atualizar\n"
				+ "5-deletar\n"
				+ "6-voltar\n"
				+ "Opção: ");
	}


}
