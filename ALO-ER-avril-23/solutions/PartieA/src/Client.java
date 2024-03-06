import java.util.ArrayList;

/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class Client {
    private int identifiant;
    private String nomComplet;

    private ArrayList<Abo> listeAbonnements;

    public Client(int identifiant, String nomComplet) {
        this.identifiant = identifiant;
        this.nomComplet = nomComplet;
        listeAbonnements = new ArrayList<>();
    }

    public void afficherDetailsAbo() {
        for (Abo a : listeAbonnements) {
            System.out.println(a);
        }
    }

    public void ajouterAbo(int noAbonnement, Magazine magazine, int jourDebut, int moisDebut, int anneeDebut,int nbParutions) {
        listeAbonnements.add(new Abo(noAbonnement,identifiant,magazine,jourDebut,moisDebut,anneeDebut,nbParutions));
    }

    @Override
    public String toString() {
        String res = nomComplet + " (client n°" + identifiant + ") a " + listeAbonnements.size() + " abonnement(s) :";
        for (Abo a : listeAbonnements) {
            res += "\n- " + a.getMagazine().getTitre();
        }
        return res;
    }
}
