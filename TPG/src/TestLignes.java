import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestLignes {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Vehicule> lstVehicle = lireDonnees("vehicules.csv");
    }

    public static ArrayList<Vehicule> lireDonnees (String nomFichier) {
        ArrayList<Vehicule> lstVehicle = new ArrayList<Vehicule>();

        try {
            Scanner scanner = new Scanner(new File(nomFichier));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                scanner.useDelimiter(",");
                Scanner sc_ligne = new Scanner(scanner.nextLine());
                int matricule = sc_ligne.nextInt(); // 1227
                String type = sc_ligne.next(); // trolley
                String marque = sc_ligne.next(); // Siemens
                int prixAchat = sc_ligne.nextInt(); // 366549
                int nbPassagers = sc_ligne.nextInt(); // 61
                LocalDate dateAcquisition = LocalDate.parse(sc_ligne.next()); // 2015-12-01
                int km = sc_ligne.nextInt(); // 646542
                String actifLigne = Arrays.toString(sc_ligne.next().split("-")); //10-19
                int tension = sc_ligne.nextInt(); // 543
                String moteur = sc_ligne.next(); // oui/non

                if (type.equals("trolley")) {
                    Trolley trolley = new Trolley(nbPassagers, prixAchat, dateAcquisition, tension, moteur.equals("oui"));
                    lstVehicle.add(trolley);
                } else {
                    Vehicule vehicule = new Vehicule(nbPassagers, prixAchat, dateAcquisition);
                    lstVehicle.add(vehicule);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier est introuvable !");
        }
    return lstVehicle;
    }
}
