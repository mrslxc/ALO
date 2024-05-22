import java.time.LocalDate;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Trolley extends Vehicule {
    private int tensionNeccessaire; // nb de Volt nécessaires pour propulser le Trolley à pleine charge
    private boolean moteurThermique; // le Trolley est-il équipé d'un moteur thermique (Diesel) de secours?

    public Trolley(int nbPassagersMax, long prixAchat, LocalDate dateAcquisition, int tensionNeccessaire, boolean moteurThermique) {
        super(nbPassagersMax, prixAchat, dateAcquisition);
        this.tensionNeccessaire = tensionNeccessaire;
        this.moteurThermique = moteurThermique;
    }

    public int getTensionNeccessaire() {
        return tensionNeccessaire;
    }

    public void setTensionNeccessaire(int tensionNeccessaire) {
        this.tensionNeccessaire = tensionNeccessaire;
    }

    public boolean isMoteurThermique() {
        return moteurThermique;
    }

    public void setMoteurThermique(boolean moteurThermique) {
        this.moteurThermique = moteurThermique;
    }

    @Override
    public String toString() {
        // return super.toString() + "Trolley{" + "tensionNeccessaire=" + tensionNeccessaire + ", moteurThermique=oui}";
        return super.toString() + getClass().getName() + " avec " + getKmAuCompteur();
    }
}

