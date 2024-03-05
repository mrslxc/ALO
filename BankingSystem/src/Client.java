import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private int ID;
    private LocalDate birthdate;

    // On creée une liste de compte pour les stocker
    private ArrayList<Account> accounts;

    // Builder d'instance
    public Client(int ID, String nom, String prenom, LocalDate birthDate){
        this.nom = nom;
        this.prenom = prenom;
        this.ID = ID;
        this.birthdate = birthDate;

        // On initialise la liste dans les éléments du constructeur (et non pas en paramètre)
        this.accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts(){

        return accounts;
    }

    // On crée une méthode qui permet de récupérer pour chaque compte existant
    public Account getAccount(String numCompte){
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if(account.getAccountNumber().equals(numCompte)){
                return account;
            }
        }
        return null;
    }

    // On crée une méthode qui permet d'ajouter le compte a partir de la classe Account
    public void addAccount(Account account){
        accounts.add(account);
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Client<Nom=" + nom + ", Prénom=" + prenom + ", ID=" + ID + ", Date de naissance="
                + formatter.format(birthdate) + ", Comptes=" + accounts + ">";
    }
}