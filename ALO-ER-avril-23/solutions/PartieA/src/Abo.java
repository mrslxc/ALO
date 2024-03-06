import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class Abo {
    private int noAbonnement;
    private int noClient;
    private Magazine magazine;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public Abo(int noAbonnement, int noClient, Magazine magazine, int jourDebut, int moisDebut, int anneeDebut,int nbParutions) {
        this.noAbonnement = noAbonnement;
        this.noClient = noClient;
        this.magazine = magazine;
        dateDebut = LocalDate.of(anneeDebut,moisDebut,jourDebut);
        dateFin = dateDebut.plusWeeks(nbParutions * magazine.nbSemaines());
    }

    public Magazine getMagazine() {
        return magazine;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Abonnement n°" + noAbonnement + " (client n°" + noClient + ") pour le magazine " + magazine.getTitre() + "\na commencé le " + formatter.format(dateDebut) + " et se termine le " + formatter.format(dateFin);
    }
}
