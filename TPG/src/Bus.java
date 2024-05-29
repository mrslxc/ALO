import java.time.LocalDate;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Bus extends Vehicule {
    private double consommation; //consommation de diesel pour 100km
    private String marque;

    public Bus(int nbPassagersMax, String marque, long prixAchat, LocalDate dateAcquisition, int kmAuCompteur) {
        super(marque, nbPassagersMax, prixAchat, dateAcquisition, kmAuCompteur);
        this.consommation = 0;
        this.marque = marque;
    }

    public String getMarque() {
        return marque;
    }

    @Override
    public int getKmInterval() {
        return 50000;
    }

    @Override
    public int getCoutControle() {
        return 6500;
    }

    @Override
    public int getCoutControleAnnuel() {
        return 1500;
    }

    @Override
    public String toString() {
        return super.toString() + getClass().getName() + " " + this.marque;
    }
}
