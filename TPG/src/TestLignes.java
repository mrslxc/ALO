import com.sun.jdi.connect.IllegalConnectorArgumentsException;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestLignes {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Vehicule> lstVehicle = lireDonnees("vehicules.csv");
        for (Vehicule vehicule : lstVehicle) {
            System.out.println(vehicule);
        }
        System.out.println(lstVehicle.size() + " véhicules lus.");
    }
    public static ArrayList<Vehicule> lireDonnees(String nomFichier) {
        ArrayList<Vehicule> lstVehicle = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(nomFichier));
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                Scanner sc_ligne = new Scanner(scanner.nextLine());
                sc_ligne.useDelimiter(",");

                try {
                    String matricule = sc_ligne.next();
                    String type = sc_ligne.next();
                    String marque = sc_ligne.next();
                    int prixAchat = sc_ligne.nextInt();
                    int nbPassagers = sc_ligne.nextInt();
                    LocalDate dateAcquisition = LocalDate.parse(sc_ligne.next(), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                    int km = sc_ligne.nextInt();
                    String actifLigne = sc_ligne.next();

                    int tension;
                    if (sc_ligne.hasNextInt()) {
                        tension = sc_ligne.nextInt();
                    } else {
                        tension = 0;
                    }
                    //String moteurSecours = sc_ligne.hasNext() ? sc_ligne.next() : "";
                    String moteurSecours = sc_ligne.next();
                    if (moteurSecours.equals("non")) {
                        moteurSecours = "oui";
                    } else {
                        moteurSecours = "non";
                    }

                    //Vehicule vehicule = new Vehicule(nbPassagers, prixAchat, dateAcquisition);
                    Ligne ligne = new Ligne(nbPassagers, prixAchat, dateAcquisition, matricule, tension);
                    Trolley trolley = new Trolley(nbPassagers, prixAchat, dateAcquisition, tension, moteurSecours.equals("oui"));

                    lstVehicle.add(ligne);
                    lstVehicle.add(trolley);
                } catch (Exception e) {
                    System.out.println("Erreur lors du traitement de la ligne: " + e.getMessage());
                } finally {
                    sc_ligne.close();
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier est introuvable !");
        }
        return lstVehicle;
    }

    public static ArrayList<Vehicule> afficheDonnees(String nomFichier) {
        ArrayList<Vehicule> lstVehicle = lireDonnees(nomFichier);
        for (Vehicule vehicule : lstVehicle) {
            System.out.println(vehicule);
        }
        return lstVehicle;
    }
}
