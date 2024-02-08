import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    String nomClient;
    String prenomClient;
    int IdClient;

    LocalDate birthday;

    public Client(String nomClient, String prenomClient, int idClient, LocalDate birthday) {
        this.nomClient = nomClient;
        this.prenomClient = prenomClient;
        this.IdClient = idClient;
        this.birthday = birthday;
    }

    public String toString() {
        /*
        DateTimeFormatter = permet de mettre en forme une date suivant son schéma indiqué

        BirthdayFormat.format("attribut") = on récupère la variable qui est une date à partir du "LocalDate"
         */
        DateTimeFormatter BirthdayFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Identifiant : " + IdClient + " | Nom : " + nomClient + " | Prénom : " + prenomClient +
                " | Date naissance : " + BirthdayFormat.format(birthday);
    }
}
