import java.time.LocalDate;

public class Professeur extends Personne {

    private String matiere_enseigne;
    public Professeur(String nom, String prenom, LocalDate date, String categorie, String matiere_enseigne) {
        super(nom, prenom, date, categorie);
        this.matiere_enseigne = matiere_enseigne;
    }

    public String toString() {
        return this.getNom() + this.getPrenom() + " née le " + this.getDate()
                + " est un " + this.getCategorie() + " qui enseigne " + super.toString();
    }
}
