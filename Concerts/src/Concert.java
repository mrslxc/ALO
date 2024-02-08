import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Concert {
    private String nomArtiste;
    private LocalDate date;
    private boolean IsComplet;
    private int nbTicketsVendus;
    private Salle salle;

    private Ville ville;

    // Création du constructeur de la classe Concert
    public Concert(String nomArtiste, LocalDate date, Salle salle) {
        this.nomArtiste = nomArtiste;
        this.date = date;
        this.IsComplet = false;
        this.salle = salle;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isComplet() {
        return IsComplet;
    }

    public int getNbTicketsVendus() {
        return nbTicketsVendus;
    }

    public void achatBillet() {
        if (!isComplet()) {
            if (nbTicketsVendus < ville.getNbMaxSpectateursAuMetreCarre()) {
                if (ville.getNbMaxSpectateursAuMetreCarre() == nbTicketsVendus) {
                    this.IsComplet = true;
                }
                nbTicketsVendus += 1;
            }
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Artiste : " + getNomArtiste() + " | Date : " + dateFormat.format(getDate()) + " | Complet : "
                + isComplet() + " | Billets vendus : " + getNbTicketsVendus();
    }
}
