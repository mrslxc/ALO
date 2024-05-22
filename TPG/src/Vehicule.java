import java.time.LocalDate;

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

    public Vehicule(int nbPassagersMax, long prixAchat, LocalDate dateAcquisition, int kmAuCompteur) {
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

    @Override
    public String toString() {
        // return String.format("Véhicule (prix: CHF %d, nb. passagers max: %d) de type: ", prixAchat, nbPassagersMax);
        return "Véhicule (prix: CHF " + prixAchat + ", nb. passagers max: "
                + nbPassagersMax + ") de type : ";
    }

    public String getActifLigne() {
        return actifLigne;
    }
}