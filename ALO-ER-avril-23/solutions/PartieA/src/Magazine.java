/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class Magazine {
    private String titre;
    private String frequence;

    public Magazine(String titre, String frequence) {
        this.titre = titre;
        this.frequence = frequence;
    }

    public int nbSemaines() {
        int nbSemaines;
        if (frequence.equals("hebdo")) {
            nbSemaines = 1;
        } else if (frequence.equals("bimensuel")) {
            nbSemaines = 2;
        } else if (frequence.equals("mensuel")) {
            nbSemaines = 4;
        } else if (frequence.equals("bimestriel")) {
            nbSemaines = 8;
        } else {
            nbSemaines = 0;
            System.out.println("Fréquence inconnue pour " + titre);
        }
        return nbSemaines;
    }

    public String getTitre() {
        return titre;
    }

    @Override
    public String toString() {
        return titre + " est un " + frequence;
    }
}
