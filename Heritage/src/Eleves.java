import java.time.LocalDate;

public class Eleves extends Personne {

    private String niveau;

    public Eleves(String nom, String prenom, LocalDate date, String categorie, String niveau) {
        super(nom, prenom, date, categorie);
        this.niveau = niveau;
    }

    public String toString() {
        return super.getNom() + " " + super.getPrenom() + " née le " + super.getDate()
                + " est un " + super.getCategorie() + " qui est un élève de " + this.niveau + " année.";
    }
}
