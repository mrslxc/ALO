import java.time.LocalDate;
import java.util.ArrayList;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Ligne extends Vehicule {
    private String nom;
    private ArrayList<String> listeDesArrets;
    private ArrayList<Integer> listDureeEntreArrets;
    private boolean compatibleTrolley;
    private int tensionLigne;
    private String marque;

    public Ligne(String marque, int nbPassagersMax, long prixAchat, LocalDate dateAquisition, int kmAuCompteur, String nom, int tensionLigne) {
        super(marque, nbPassagersMax, prixAchat, dateAquisition, kmAuCompteur);
        this.nom = nom;
        this.tensionLigne = tensionLigne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<String> getListeDesArrets() {
        return listeDesArrets;
    }

    @Override
    public String toString() {
        return super.toString() + getClass().getName();
    }
}
