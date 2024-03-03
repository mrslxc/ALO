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

    private static Client creerClientAvecComptes() {
        Client client = new Client(101, "Daniel", "Smith", LocalDate.of(1980, 6, 5));
        try {
            Scanner sc = new Scanner(new File("ClientAccountData.txt"));
            while (sc.hasNextLine()) {
                String accountNumber = sc.nextLine();
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

    private static  void executeFichierDesOperations(Client client, String file){
        try {
            Scanner sc = new Scanner(new File(file));
            while (sc.hasNextLine()) {
                while (sc.hasNext()){
                    String numCompte = sc.next();
                    String typeTransaction = sc.next();
                    double montant = sc.nextDouble();
                    Account compte = client.getAccount(numCompte);
                    if(compte != null){
                        if(typeTransaction.equals("credit")){
                            compte.credit(montant);
                        }
                        else if(typeTransaction.equals("debit")){
                            compte.debit(montant);
                        }
                        else{
                            System.out.println("Erreur: credit ou debit introuvable.");
                        }
                    }
                    else {
                        System.out.println("Compte inexistant!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testerOperations()
    {
        Client client = creerClientAvecComptes();
        executeFichierDesOperations(client, "AccountOperationData.txt");
        System.out.println(client);
        System.out.println(client.getAccounts());
        for(Account element: client.getAccounts()) {
            System.out.println(element);
        }
    }
}