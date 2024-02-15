import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Concert {
    private String nomArtiste;
    private LocalDate date;
    private int nbTicketsVendus;
    private Salle salle;

    // Création du constructeur de la classe Concert
    public Concert(String nomArtiste, LocalDate date, int nbTicketsVendus, Salle salle) {
        this.nomArtiste = nomArtiste;
        this.date = date;
        this.nbTicketsVendus = nbTicketsVendus;
        this.salle = salle;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isComplet() {
        if (getNbTicketsVendus() < this.salle.getVille().getNbMaxSpectateursAuMetreCarre() * salle.getSuperficie()) {
            return false;
        } else {
            return true;
        }
    }

    public int getNbTicketsVendus() {
        return nbTicketsVendus;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setNbTicketsVendus(int nbTicketsVendus) {
        if (this.isComplet() == false) {
            this.nbTicketsVendus += nbTicketsVendus;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Artiste : " + getNomArtiste() + " | Date : " + dateFormat.format(getDate()) + " | Complet : "
                + isComplet() + " | Billets vendus : " + getNbTicketsVendus();
    }
}
