import java.time.LocalDate;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Bus extends Vehicule{
    private double consommation; //consommation de diesel pour 100km

    public Bus(int nbPassagersMax, long prixAchat, LocalDate dateAcquisition, int kmAuCompteur) {
        super(nbPassagersMax, prixAchat, dateAcquisition, kmAuCompteur);
        consommation = 0;
    }

    @Override
    public String toString() {
        return super.toString() + getClass().getName() + " avec " + getKmAuCompteur();
    }
}
