import java.time.LocalDate;

public class Personne {
    private String nom;
    private String prenom;
    private LocalDate date;

    private String categorie;

    public Personne(String nom, String prenom, LocalDate date, String categorie) {
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.categorie = categorie;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCategorie() {
        return categorie;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
