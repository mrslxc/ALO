/*********************/
// LOIC AGOSTA
//
/*********************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class EprPaques {
    public static final String[] TAB_CAT_CHOC = {"au lait", "blanc", "noir", "matcha"};

    public static void main(String[] args) {
        ArrayList<Lapin> liste = new ArrayList<>();
        JardinPaques jardin = new JardinPaques();

        // ici appelez votre méthode lireDonnees_Q1() de la façon adaptée à votre approche de façon à remplir al liste
        // des lapins de votre jardin
        lireDonnees_Q1("AGOSTA Loïc Joyce/AGOSTA_LOIC_Trewelu_G3/RabbitData.txt");

        // si vous n'arrivez pas à remplir la liste, utilisez la méthode de secours
        // en décommentant la ligne ci-dessous
        //liste = Util.methodeDeSecours();

        //une fois qu'on a la liste on peut la mettre dans le jardin de Pâques
        jardin.setLapins(liste);

        //pour vérification de la lecture de la liste
        for (Lapin rabbit : jardin.getLapins()) {
            System.out.println(rabbit);
        }

        System.out.println("Question 2");
        afficherPoidsMoyens_Q2(jardin);
        System.out.println();

        System.out.println("Question 3");
        afficherInfoPlusLourd_Q3b(jardin);
        System.out.println();


        System.out.println("Question 4");
        // à décommenter pour tester afficherDistanceAvecLesAutres_Q4a
        // afficherDistanceAvecLesAutres_Q4a est à définir dans la classe Lapin
        // car il faut que la liste soit remplie
        // l'appel ci-dessous vous donne un exemple qui produit les distances entre le premier lapin et les autres
        // Lapin premier = jardin.getLapins().get(0);
        //  premier.afficherDistanceAvecLesAutres_Q4a(jardin.getLapins()); // le premier lapin par exemple

        afficherToutesLesDistances_Q4b(jardin);
        System.out.println();
    }


    // lecture des données : à adapter à votre approche, vous pouvez également déplacer cette méthode ailleurs si vous le souhaitez
    public static ArrayList<Lapin> lireDonnees_Q1(String nomFichier) {
        ArrayList<Lapin> lstLapin = new ArrayList();
        try {
            Scanner sc_ligne = new Scanner(new File(nomFichier));
            while (sc_ligne.hasNextLine()) {
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                sc_element.useDelimiter(";");
                String nomLapin = sc_element.next();
                int codeLapin = sc_element.nextInt();

                String typeChocolat;
                if (codeLapin == 1) {
                    typeChocolat = "blanc";
                } else if (codeLapin == 2) {
                    typeChocolat = "noir";
                } else if (codeLapin == 3) {
                    typeChocolat = "au lait";
                } else {
                    typeChocolat = "matcha";
                }

                boolean garni;
                String estGarni;
                estGarni = sc_element.next();
                if (estGarni.equals("oui")) {
                    garni = true;
                } else {
                    garni = false;
                }

                double poids = sc_element.nextDouble() / 1000.0;
                int posDebut = sc_element.nextInt();
                int posFin = sc_element.nextInt();

                Lapin l = new Lapin(nomLapin, typeChocolat, garni, posDebut, posFin, poids);
                lstLapin.add(l);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return lstLapin;
    }

    private static int getPositionLapinDebut(int posDebut) {
        ArrayList<Lapin> lstLapin = new ArrayList<>();

        for (int i = 0; i < lstLapin.size(); i++) {
            if (lstLapin.get(i).getNom().equals(posDebut)) {

            }
        }
        return posDebut;
    }

    private static int getPositionLapinFin(int posFin) {
        ArrayList<Lapin> lstLapin = new ArrayList<>();

        for (int i = 0; i < lstLapin.size(); i++) {
            if (lstLapin.get(i).getNom().equals(posFin)) {

            }
        }
        return posFin;
    }

    public static void lapinLePlusLourd_Q3a(JardinPaques jardinPaques){
        double max = jardinPaques.getLapins().get(0).getPoids();

        for (Lapin lapin : jardinPaques.getLapins()) {
            if (lapin.getPoids() > max) {
                max = lapin.getPoids();
            }
        }
    }

    private static void afficherPoidsMoyens_Q2 (JardinPaques jardin){
        //vous avez la possibilité d'utiliser la liste ci-dessous pour vous faciliter la vie ou pas
        String[] TAB_CAT_CHOC = {"au lait", "blanc", "noir", "matcha"};
        HashMap<String, Double> poidsMoyens = new HashMap<>();
        for (String cat : TAB_CAT_CHOC) {
            poidsMoyens.put(cat, 0.0);
        }

        for (Lapin lapin : jardin.getLapins()) {
            String typeChocolat = lapin.getTypeChocolat();
            double poids = lapin.getPoids();
            poidsMoyens.put(typeChocolat, poidsMoyens.get(typeChocolat) + poids);
        }

        for (String cat : TAB_CAT_CHOC) {
            System.out.println("Poids moyen des lapins de chocolat " + cat + " : " + poidsMoyens.get(cat) / jardin.getLapins().size());
        }
    }


    private static void afficherInfoPlusLourd_Q3b (JardinPaques jardin) {
        String nomLapin = jardin.lapinLePlusLourd_Q3a().getNom();
        System.out.println("Le lapin le plus lourd est " + nomLapin);
    }

    private static void afficherToutesLesDistances_Q4b (JardinPaques jardin) {
        for (Lapin lapin : jardin.getLapins()) {
            for (Lapin lapin2 : jardin.getLapins())
                if (!lapin.getNom().equals(lapin2.getNom())) {
                    System.out.println("Distance entre " + lapin.getNom() + " et " + lapin2.getNom() + " : "
                            + lapin.distanceAvec(lapin2));
                }
        }
    }
}