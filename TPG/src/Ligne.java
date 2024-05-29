import java.time.LocalDate;
import java.util.ArrayList;

/**
 * April 2020
 *
 * @author Thomas Servettaz
 */
public class Ligne {
    private String nom;
    private ArrayList<String> listeDesArrets;
    private ArrayList<Integer> listDureeEntreArrets;
    private boolean compatibleTrolley;
    private int tensionLigne;

    public Ligne(String nom, int tensionLigne) {
        this.nom = nom;
        this.tensionLigne = tensionLigne;

    }

    public ArrayList<String> getLstArrets () {
        return listeDesArrets;
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

    public String ajouterArret () {
        return   
    }

    @Override
    public String toString() {
        return super.toString() + getClass().getName();
    }
}
