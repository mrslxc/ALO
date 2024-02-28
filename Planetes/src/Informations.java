import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Informations {
    public static void main(String[] args) {
        ArrayList<Planetes> listePlanetes = scannerPlanetes("systemeSolaire.csv");

        for (Planetes planetes : listePlanetes) {
            System.out.println(planetes);
        }
    }

    public static ArrayList<Planetes> scannerPlanetes(String nomFichier) {
        ArrayList<Planetes> listePlanetes = new ArrayList<>();
        try {
            Scanner sc_ligne = new Scanner(new File(nomFichier));
            sc_ligne.nextLine(); // Ignorer la première ligne

            while (sc_ligne.hasNextLine()) {

                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                sc_ligne.useDelimiter(";");

                while (sc_ligne.hasNext()) {
                    // Lire les informations de base de la planète
                    String nomPlanete = sc_element.next();
                    int rayonMoyen = sc_element.nextInt();
                    int circonferenceOrbite = sc_element.nextInt();
                    int nbSatellites = sc_element.nextInt();

                    // Créer l'objet Planetes avec les informations lues
                    Planetes planete = new Planetes(nomPlanete, rayonMoyen, circonferenceOrbite, nbSatellites);
                    listePlanetes.add(planete);
                }
                sc_element.close(); // Fermer le scanner de ligne
            }
            sc_ligne.close(); // Fermer le scanner de fichier

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return listePlanetes;
    }

}
