package zoologico;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public class Main {

    public static void main(String[] args) {
        // Firebase initialization
        initializeFirebase();

        // User menu for the zoo management system
        Scanner leia = new Scanner(System.in);
        int escolha;
        do {
            menu();
            escolha = leia.nextInt();
            switch (escolha) {
                case 1:
                    funcionario();
                    break;
                case 2:
                    jaula();
                    break;
                case 3:
                    animal();
                    break;
                case 4:
                    sair();
                    break;
            }
        } while (escolha != 4);
    }

    // Firebase setup
    private static void initializeFirebase() {
        try {
            FileInputStream serviceAccount = new FileInputStream("C:\\path_to_your_service_account.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Menu for the user
    private static void menu() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Funcionario\n2 - Jaulas\n3 - Animais\n4 - Sair");
    }

    private static void funcionario() {
        Scanner leia = new Scanner(System.in);
        int escolha;
        do {
            menu2();
            escolha = leia.nextInt();
            switch (escolha) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionario();
                    break;
                case 3:
                    buscarFuncionario();
                    break;
                case 4:
                    atualizarFuncionario();
                    break;
                case 5:
                    deletarFuncionario();
                    break;
                case 6:
                    break;
            }
        } while (escolha != 6);
    }

    private static void jaula() {
        Scanner leia = new Scanner(System.in);
        int escolha;
        do {
            menu2();
            escolha = leia.nextInt();
            switch (escolha) {
                case 1:
                    cadastrarJaula();
                    break;
                case 2:
                    listarJaula();
                    break;
                case 3:
                    buscarJaula();
                    break;
                case 4:
                    atualizarJaula();
                    break;
                case 5:
                    deletarJaula();
                    break;
                case 6:
                    break;
            }
        } while (escolha != 6);
    }

    private static void animal() {
        Scanner leia = new Scanner(System.in);
        int escolha;
        do {
            menu2();
            escolha = leia.nextInt();
            switch (escolha) {
                case 1:
                    cadastrarAnimal();
                    break;
                case 2:
                    listarAnimal();
                    break;
                case 3:
                    buscarAnimal();
                    break;
                case 4:
                    atualizarAnimal();
                    break;
                case 5:
                    deletarAnimal();
                    break;
                case 6:
                    break;
            }
        } while (escolha != 6);
    }

    // Sample Firebase Firestore query methods for animals
    public static void runQuery(Firestore db) throws Exception {
        ApiFuture<QuerySnapshot> query = db.collection("users").whereLessThan("born", 1900).get();
        QuerySnapshot querySnapshot = query.get();
        List<QueryDocumentSnapshot> documents = querySnapshot.getDocuments();
        for (QueryDocumentSnapshot document : documents) {
            System.out.println("User: " + document.getId());
            System.out.println("First: " + document.getString("first"));
            if (document.contains("middle")) {
                System.out.println("Middle: " + document.getString("middle"));
            }
            System.out.println("Last: " + document.getString("last"));
            System.out.println("Born: " + document.getLong("born"));
        }
    }

    public static void addDocument(Firestore db, String docName) throws Exception {
        DocumentReference docRef = db.collection("users").document(docName);
        Map<String, Object> data = new HashMap<>();
        data.put("first", "Laila");
        data.put("last", "Lovelace");
        data.put("born", 2000);
        ApiFuture<WriteResult> result = docRef.set(data);
        System.out.println("Update time : " + result.get().getUpdateTime());
    }

    // CRUD operations for funcionario, jaula, and animal...
    private static void cadastrarFuncionario() { /* Implementation */ }
    private static void listarFuncionario() { /* Implementation */ }
    private static void buscarFuncionario() { /* Implementation */ }
    private static void atualizarFuncionario() { /* Implementation */ }
    private static void deletarFuncionario() { /* Implementation */ }

    private static void cadastrarJaula() { /* Implementation */ }
    private static void listarJaula() { /* Implementation */ }
    private static void buscarJaula() { /* Implementation */ }
    private static void atualizarJaula() { /* Implementation */ }
    private static void deletarJaula() { /* Implementation */ }

    private static void cadastrarAnimal() { /* Implementation */ }
    private static void listarAnimal() { /* Implementation */ }
    private static void buscarAnimal() { /* Implementation */ }
    private static void atualizarAnimal() { /* Implementation */ }
    private static void deletarAnimal() { /* Implementation */ }

    // Exiting the program
    private static void sair() {
        System.out.println("Saindo...");
    }

    // Menu for CRUD operations
    private static void menu2() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar\n2 - Listar\n3 - Buscar\n4 - Atualizar\n5 - Deletar\n6 - Voltar");
    }
}
