/*********************/
// LOIC AGOSTA
//
/*********************/

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainBiblio {
    public static void main(String[] args) {

        //section 1
        //déclaration de plusieurs types de livre avec le libellé du type et le ratio de lecture qui s'applique
        TypeLivre roman = new TypeLivre("Roman", 1);
        TypeLivre bd = new TypeLivre("BD", 0.6);
        TypeLivre geoPo = new TypeLivre("Géopolitique", 1.4);

        //section 2
        //déclaration de plusieurs livres avec des types différents
        Livre livre1 = new Livre("Petit Pays","Gaël Faye", 218, roman);
        Livre livre2 = new Livre("Odyséee d'Hakim","Fabian Toulmé", 272, bd);
        Livre livre3 = new Livre("Destruction massive","Jean Ziegler", 384, geoPo);

        //section 3
        //création de plusieurs lecteurs (Ella et Ada) et ajout d'un livre emprunté à chacun d'entre eux, puis affichage du résumé de lectures
        Lecteur ella = new Lecteur("Ella Maillart", "24150_001FAL", 3, 10);
        ArrayList<Livre> listeLivresElla = new ArrayList<>();
        listeLivresElla.add(livre1);
        listeLivresElla.add(livre2);
        ella.setLstLivres(listeLivresElla); // Ella emprunte 2 livres : Petit Pays et Odyssée d'Hakim

       Lecteur ada = new Lecteur("Ada Lovelace", "01010101_01AL", 2.5, 3);
        ArrayList<Livre> listeLivresAda = new ArrayList<>();
        listeLivresAda.add(livre1);
        listeLivresAda.add(livre3);
        ada.setLstLivres(listeLivresAda); // Ada emprunte 2 livres : Petit Pays et Destruction massive

        //section 4
       //affichages des calculs demandés dans l'épreuve pour Ella et pour Ada

        System.out.println("---------------- Ella -----------------");
        afficherQuestion1(ella);//décommenter le code de la méthode afficherQuestion1 lorsque vous êtes prêt.e.s
        System.out.println();
        afficherQuestion2(ella);//décommenter le code de la méthode afficherQuestion2 lorsque vous êtes prêt.e.sSystem.out.println();
        afficherQuestion3(ella);//décommenter le code de la méthode afficherQuestion3 lorsque vous êtes prêt.e.s
        System.out.println();

        System.out.println("---------------- Ada -----------------");
        afficherQuestion1(ada);
        System.out.println();
        afficherQuestion2(ada);
        System.out.println();
        afficherQuestion3(ada);
        System.out.println();
    }

    public static void afficherQuestion1(Lecteur l) {
        System.out.println(l);
    }

    public static void afficherQuestion2(Lecteur l) {
        System.out.println(l.getNom() + " aura besoin d'un total de " +
                          Util.arrondir2(l.calculTotalTempsLectureHeures()) +
                          " heures pour lire les livres empruntés");
    }

    public static void afficherQuestion3(Lecteur l) {
        System.out.println("En tenant compte du temps moyen hebdomadaire consacré à la lecture, " + l.getNom() +
                           " aura besoin de " + Util.arrondir2(l.calculMoisLecture()) + " mois pour lire les " +
                           l.getLstLivres().size() + " livres empruntés");
    }
}