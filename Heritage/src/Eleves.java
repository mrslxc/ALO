import java.time.LocalDate;

public class Eleves extends Personne {

    private String niveau;

    public Eleves(String nom, String prenom, LocalDate date, String categorie, String niveau) {
        super(nom, prenom, date, categorie);
        this.niveau = niveau;
    }

    public String toString() {
        return this.getNom() + this.getPrenom() + " née le " + this.getDate()
                + " est un " + this.getCategorie() + " qui est un élève de " + super.toString() + " année.";
    }
}
