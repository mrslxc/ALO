/*********************/
// LOIC AGOSTA
//
/*********************/

public class Livre {
    private String titre;
    private String auteur;
    private int nbPages;
    private TypeLivre typeLivre;

    public Livre(String titre, String auteur, int nbPages, TypeLivre typeLivre) {
        this.titre = titre;
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.typeLivre = typeLivre;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public int getNbPages() {
        return nbPages;
    }

    public TypeLivre getTypeLivre() {
        return typeLivre;
    }

    @Override
    public String toString() {
        return this.titre + " de l'auteur " + this.auteur + " de type " + this.typeLivre + ", avec un nombre de pages de : " + this.nbPages + "\n";
    }
}
