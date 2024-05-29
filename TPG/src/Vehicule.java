import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * April 2020
 *
 * @author Mirko Steinle, Thomas Servettaz
 */
public class Vehicule
{
    private int nbPassagersMax;
    private long prixAchat;
    private int kmAuCompteur;
    private LocalDate dateAcquisition;
    private String actifLigne;
    private String marque;

    public Vehicule(String marque, int nbPassagersMax, long prixAchat, LocalDate dateAcquisition, int kmAuCompteur) {
        this.marque = marque;
        this.nbPassagersMax = nbPassagersMax;
        this.prixAchat = prixAchat;
        this.dateAcquisition = dateAcquisition;
        this.kmAuCompteur = kmAuCompteur;
    }

    public void setKmAuCompteur(int kmAuCompteur) {
        if(kmAuCompteur > 0)
            this.kmAuCompteur = kmAuCompteur;
        else
            throw new IllegalArgumentException();
    }

    public int getNbPassagersMax()
    {
        return nbPassagersMax;
    }

    public void setNbPassagersMax(int nbPassagersMax)
    {
        this.nbPassagersMax = nbPassagersMax;
    }

    public int getPrixAchat() {
        return (int) prixAchat;
    }

    public int getKmAuCompteur() {
        return kmAuCompteur;
    }

    public String getActifLigne() {
        return actifLigne;
    }

    public String getMarque() {
        return marque;
    }

    public int getKmInterval() {
        return 0;
    }

    public int getCoutControle() {
        return 0;
    }

    public int getCoutControleAnnuel() {
        return 0;
    }
    public int getAnneesService () {
        return (int) ChronoUnit.YEARS.between(dateAcquisition, LocalDate.now());
    }

    @Override
    public String toString() {
        // return String.format("Véhicule (prix: CHF %d, nb. passagers max: %d) de type: ", prixAchat, nbPassagersMax);
        return "Véhicule (prix: CHF " + prixAchat + ", nb. passagers max: "
                + nbPassagersMax + ") de type : ";
    }


}