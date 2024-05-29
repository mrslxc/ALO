import java.time.LocalDate;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Trolley extends Vehicule {
    private int tensionNeccessaire; // nb de Volt nécessaires pour propulser le Trolley à pleine charge
    private boolean moteurThermique; // le Trolley est-il équipé d'un moteur thermique (Diesel) de secours?
    private String marque;

    public Trolley(String marque, int nbPassagersMax, long prixAchat, LocalDate dateAcquisition, int kmAuCompteur, int tensionNeccessaire, boolean moteurThermique) {
        super(marque, nbPassagersMax, prixAchat, dateAcquisition, kmAuCompteur);
        this.marque = marque;
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

    @Override
    public int getKmInterval() {
        return 200000;
    }

    @Override
    public int getCoutControle() {
        return 8000 + (isMoteurThermique() ? 1200 : 0);
    }

    @Override
    public int getCoutControleAnnuel() {
        return 2000;
    }

    public void setMoteurThermique(boolean moteurThermique) {
        this.moteurThermique = moteurThermique;
    }

    public String getMarque() {
        return marque;
    }

    @Override
    public String toString() {
        // return super.toString() + "Trolley{" + "tensionNeccessaire=" + tensionNeccessaire + ", moteurThermique=oui}";
        return super.toString() + getClass().getName() + " " + this.marque;
    }
}

