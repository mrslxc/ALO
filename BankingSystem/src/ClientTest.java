import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

public class ClientTest {
    public static void main(String[] args) {
        //testerCompteClient();
        //System.out.println(creerClientAvecComptes());
        //testerLireComptes();
        //executeFichierDesOperations(creerClientAvecComptes(), "AccountOperationData.txt");
        testerOperations();
    }

    private static void testerCompteClient()
    {
        Client client = new Client(101, "Daniel", "Smith", LocalDate.of(1980,6,5));
        Account acc1 = new Account("A1");
        client.addAccount(acc1);
        Account acc2 = new Account("A2");
        client.addAccount(acc2);
        System.out.println("Comptes: " + client.getAccounts());
    }

    /*
    * On crée une méthode qui permet de créer des comptes Client
    * On crée une nouvelle instance de Client avec les informations nécessaires
    * On scan le fichier grâce à la classe Scanner
    * On fait une boucle sur chaque ligne -> sc.ligne
    * On scanne une deuxième fois pour pour les éléments de chaque ligne
    * On crée une instance de Account pour ajouter les comptes grâce à AccountNumber
    * On ajoute les comptes avec la variable "client" et on le fait avec la méthode "addAccount"
    *
    * */
    private static Client creerClientAvecComptes() {
        Client client = new Client(101, "Daniel", "Smith", LocalDate.of(1980, 6, 5));
        try {
            Scanner sc_ligne = new Scanner(new File("ClientAccountData.txt"));
            while (sc_ligne.hasNextLine()) {
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                String accountNumber = sc_element.next();
                Account account = new Account(accountNumber);
                client.addAccount(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }

    private static void testerLireComptes()
    {
        Client client = creerClientAvecComptes();
        System.out.println("Client: " + client);
        System.out.println(client.getAccounts());
    }

    /*
    * On crée une méthode qui permet d'exécuter des opérations sur des comptes
    * On crée une condition sur le type d'opération et suivante le cas on débite ou crédite
    * Si le compte est inexistant, alors on affiche un message, et la boucle s'arrête, à l'inverse
    * on continue
    *
    * */
    private static void executeFichierDesOperations(Client client, String file){
        try {
            Scanner sc_ligne = new Scanner(new File(file));
            while (sc_ligne.hasNextLine()) {
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                while (sc_element.hasNext()) {
                    String numCompte = sc_element.next();
                    String typeTransaction = sc_element.next();
                    double montant = sc_element.nextDouble();
                    Account compte = client.getAccount(numCompte);

                    if (compte != null) {
                        if (typeTransaction.equals("credit")) {
                            compte.credit(montant);
                        } else if (typeTransaction.equals("debit")) {
                            compte.debit(montant);
                        } else {
                            System.out.println("Erreur: credit ou debit introuvable.");
                        }
                    } else {
                        System.out.println("Compte inexistant!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testerOperations() {
        Client client = creerClientAvecComptes();
        executeFichierDesOperations(client, "AccountOperationData.txt");

        // 1e Exercice : Création d'un client
        System.out.println("// 1e Exercice : Création d'un client");
        System.out.println(client);
        System.out.println("\n");
        // 2e Exercice : Obtenir les comptes des clients
        System.out.println(client.getAccounts());
        System.out.println("\n");
        // 3e Exercice : Obtenir les comptes des clients (en liste)
        for(Account element: client.getAccounts()) {
            System.out.println(element);
        }
    }
}