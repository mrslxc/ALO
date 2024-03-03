import java.time.LocalDate;

public class Professeur extends Personne {

    private String matiere_enseigne;
    public Professeur(String nom, String prenom, LocalDate date, String categorie, String matiere_enseigne) {
        super(nom, prenom, date, categorie);
        this.matiere_enseigne = matiere_enseigne;
    }

    public String toString() {
        return super.getNom() + " " +  super.getPrenom() + " née le " + super.getDate()
                + " est un " + super.getCategorie() + " qui enseigne " + this.matiere_enseigne;
    }
}
