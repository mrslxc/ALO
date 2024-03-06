import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Informations {
    public static void main(String[] args) {
        // Elle permet de lire les données en faisant une boucle
        // lireDonnes("planetes.txt").forEach(System.out::println);
        ArrayList<Planetes> listePlanetes = lireDonnes("systemeSolaire.txt");

        System.out.println("Liste des planètes : ");
        for (Planetes planete : listePlanetes) {
            System.out.println(planete);
        }
        System.out.println("\n");
        System.out.println("1e : Calculer la circonférence maximum des planètes ");
        calculerMaxCirconference(listePlanetes);
        System.out.println("\n");
        System.out.println("2e : Calculer la circonférence minimum des planètes ");
        calculerMinCirconference(listePlanetes);
        System.out.println("\n");
        System.out.println("3e : Calculer le nombre total de satellites dans le système solaire ");
        calculerTotalSatellite(listePlanetes);
        System.out.println("\n");
        System.out.println("4e : Calculer le rayon moyen des planètes ");
        calculerRayonMoyenPlanetes(listePlanetes);
        System.out.println("\n");
        System.out.println("5e : Calculer les planètes qui n'ont aucun satellite ");
        System.out.println(calculerPlaneteAucunSatellite(listePlanetes));
    }

    public static ArrayList<Planetes> lireDonnes(String nomFichier) {
        ArrayList<Planetes> tableauPlanete = new ArrayList();
        try {
            Scanner sc_ligne = new Scanner(new File(nomFichier));
            sc_ligne.nextLine();
            while (sc_ligne.hasNextLine()){
                String ligne = sc_ligne.nextLine();
                Scanner sc_element = new Scanner(ligne);
                String nomPlanete = sc_element.next();
                int rayon = sc_element.nextInt();
                long circonf = sc_element.nextLong();
                int satelite = sc_element.nextInt();

                tableauPlanete.add(new Planetes(nomPlanete, rayon, circonf, satelite));
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return tableauPlanete;
    }

    public static void calculerMaxCirconference(ArrayList<Planetes> tableauPlanete) {
        long maxCirconf = 0;
        String nomPlanete = "";

        for (Planetes planete : tableauPlanete) {
            if (planete.getCirconference() > maxCirconf) {
                maxCirconf = planete.getCirconference();
                nomPlanete = planete.getNom();
            }
        }
        System.out.println("La planète avec la plus grande circonférence est " +
                nomPlanete + " avec une circonférence de " + maxCirconf + " km.");
    }

    public static void calculerMinCirconference(ArrayList<Planetes> tableauPlanete) {
        long minCirconf = 0;
        String nomPlanete = "";

        for (Planetes planete : tableauPlanete) {
            if (planete.getCirconference() < minCirconf) {
                minCirconf = planete.getCirconference();
                nomPlanete = planete.getNom();
            }
        }
        System.out.println("La planète avec la plus petite circonférence est " +
                nomPlanete + " avec une circonférence de " + minCirconf + " km.");
    }

    public static void calculerTotalSatellite(ArrayList<Planetes> tableauPlanete) {
        int totalSatellite = 0;

        for (Planetes planete : tableauPlanete) {
            totalSatellite += planete.getNmbSatelite();
        }
        System.out.println("Le nombre total de satellites dans le système solaire est " + totalSatellite + ".");
    }

    public static void calculerRayonMoyenPlanetes(ArrayList<Planetes> tableauPlanete) {
        int totalRayon = 0;
        int moyenneRayon = 0;

        for (Planetes planete : tableauPlanete) {
            totalRayon += planete.getRayonMoyen();
        }
        moyenneRayon = totalRayon / tableauPlanete.size();
        DecimalFormat df = new DecimalFormat("###,###.##");
        System.out.println("Le rayon moyen de ces planètes est de " + df.format(moyenneRayon) + " km.");
    }

    public static String calculerPlaneteAucunSatellite(ArrayList<Planetes> tableauPlanete) {
        int planeteAucunSatellite = 0;

        for (Planetes planetes : tableauPlanete) {
            if (planetes.getNmbSatelite() == 0) {
                return "Il y a au moins une planète parmi cette liste qui n'a aucun satellite (il 'sagit de " +
                        planetes.getNom() + ").";
            }
        }
        return "Aucune planète";
    }
}