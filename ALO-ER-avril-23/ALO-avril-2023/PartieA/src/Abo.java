//vos noms et prénoms ici

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Abo {
    private int noAbonnement;
    private int noClient;
    private Magazine nomMagazine;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    private int nbParutions;

    public Abo(int noAbonnement, int noClient, Magazine nomMagazine, int jour, int mois, int annee, int nbParutions) {
        this.noAbonnement = noAbonnement;
        this.noClient = noClient;
        this.nomMagazine = nomMagazine;
        this.dateDebut = LocalDate.of(annee, mois, jour);
        this.nbParutions = nbParutions;
        
        // On appelle la méthode pour pouvoir effectuer le calcul de la différence de date
        calculerDifferenceDate();
    }

    public Magazine getNomMagazine() {
        return nomMagazine;
    }

    public void calculerDifferenceDate() {

        // On récupère la fréquence à partir de la classe Magazine de la variable "nomMagazine"
        int nbFrequence = nomMagazine.getFrequence();
        if (nbFrequence == 0) {
            System.out.println("Fréquence inconnue pour " + nomMagazine.getTitre());
        }

        // On calcule le nombre de parution avec la frequence obtenu
        int nbSemaine = nbParutions * nbFrequence;
        this.dateFin = dateDebut.plusWeeks(nbSemaine);
    }

    public String toString() {
        return String.format("Abonnement n°" + this.noAbonnement + " (client n°" + this.noClient + ") pour le magazine "
                + this.nomMagazine + " a commencé le " + 
                this.dateDebut.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " et se termine le "
                + this.dateFin.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
