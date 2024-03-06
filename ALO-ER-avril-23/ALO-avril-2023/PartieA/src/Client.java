//vos noms et prénoms ici

import java.sql.PreparedStatement;
import java.util.ArrayList;

public class Client {
    private int identifiant;
    private String nomComplet;
    private ArrayList<Abo> lstAbonnements;

    public Client(int identifiant, String nomComplet) {
        this.identifiant = identifiant;
        this.nomComplet = nomComplet;
        this.lstAbonnements = new ArrayList<>();
    }

    public void afficherDetailsAbo() {
        for (Abo abo : lstAbonnements) {
            System.out.println(abo);
        }
    }

    public void ajouterAbo(int noAbonnement, Magazine nomMagazine, int jour, int mois, int annee, int nbParutions) {
        lstAbonnements.add(new Abo(noAbonnement, identifiant, nomMagazine, jour, mois, annee, nbParutions));
    }

    @Override
    public String toString() {
        String resultat = this.nomComplet + " (client n°" + this.identifiant + ") a " + lstAbonnements.size() + " abonnement(s)";
        for (Abo abo : lstAbonnements) {
            resultat += "\n- " + abo.getNomMagazine().getTitre();
        }
        return resultat;
    }
}
