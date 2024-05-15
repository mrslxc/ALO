import java.time.LocalDate;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Bus extends Vehicule{
    private double consommation; //consommation de diesel pour 100km
    public Bus(int nbPassagersMax, long prixAchat, LocalDate dateAcquisition) {
        super(nbPassagersMax, prixAchat, dateAcquisition);
        consommation = 0;
    }
}
