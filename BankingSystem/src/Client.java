import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Client {
    private String nom;
    private String prenom;
    private int ID;
    private LocalDate birthdate;
    private ArrayList<Account> accounts;

    // Builder d'instance
    public Client(int ID, String nom, String prenom, LocalDate birthDate){
        this.nom = nom;
        this.prenom = prenom;
        this.ID = ID;
        this.birthdate = birthDate;
        this.accounts = new ArrayList<Account>();
    }

    public ArrayList<Account> getAccounts(){
        return accounts;
    }

    public Account getAccount(String numCompte){
        for (int i = 0; i < accounts.size(); i++) {
            Account account = accounts.get(i);
            if(account.getAccountNumber().equals(numCompte)){
                return account;
            }
        }
        return null;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Client<Nom=" + nom + ", Prénom=" + prenom + ", ID=" + ID + ", Date de naissance=" + formatter.format(birthdate) + ", Comptes=" + accounts + ">";
    }
}