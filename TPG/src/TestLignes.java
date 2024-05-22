import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestLignes {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Vehicule> lstVehicle = lireDonnees("vehicules.csv");
        System.out.println("\n 1. Afficher une liste de véhicules existants : ");
        for (Vehicule vehicule : lstVehicle) {
            System.out.println(vehicule);
        }

        System.out.println("\n 2. Afficher le nombre de bus et de trolley :");
        afficherNbBus(lstVehicle);

        System.out.println("\n 3. Afficher le montant total d'investissement représentés par touts les véhicules :");
        System.out.println("Le montant total investi est : " + calculerInvestissement(lstVehicle) + " CHF");

        System.out.println("\n 4. Afficher le nom de la ligne qui utilise le plus de véhicules :");
        // afficherLignePlusVehicules(lstVehicle);

        System.out.println("\n 5. Afficher les véhicules ayant plus de 300'000 km au compteur :");
        afficherListeVehicules(lstVehicle);

        System.out.println("\n 6. Afficher le véhicule ayant le moins de km au compteur :");
        afficherVehiculesMoinsKm(lstVehicle);
    }

    public static ArrayList<Vehicule> lireDonnees(String nomFichier) {
        ArrayList<Vehicule> lstVehicle = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(nomFichier));
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                Scanner sc_ligne = new Scanner(scanner.nextLine());
                sc_ligne.useDelimiter(",");
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
                String moteurSecours = sc_ligne.hasNext() ? sc_ligne.next() : "";

                if (type.equals("trolley")) {
                    Vehicule vehicule = new Trolley(nbPassagers, prixAchat, dateAcquisition, km, tension, moteurSecours.equals("oui"));
                    lstVehicle.add(vehicule);
                } else {
                    Vehicule vehicule = new Bus(nbPassagers, prixAchat, dateAcquisition, km);
                    lstVehicle.add(vehicule);
                }
            }
        }  catch(FileNotFoundException e){
            System.out.println("Le fichier est introuvable !");
        }
        return lstVehicle;
    }

    public static ArrayList<Vehicule> afficherNbBus(ArrayList<Vehicule> lstVehicle) {
        int nbBus = 0;
        int nbTrolley = 0;
        for (Vehicule vehicule : lstVehicle) {
            if (vehicule instanceof Bus) {
                nbBus++;
            } else if (vehicule instanceof Trolley) {
                nbTrolley++;
            }
        }
        System.out.println("Il y a " + nbBus + " bus et " + nbTrolley + " trolley.");
        return lstVehicle;
    }

    public static int calculerInvestissement(ArrayList<Vehicule> lstVehicle) {
        int total = 0;
        for (Vehicule vehicule : lstVehicle) {
            total += vehicule.getPrixAchat();
        }
        return total;
    }

    public static ArrayList<Vehicule> afficherListeVehicules(ArrayList<Vehicule> lstVehicule) {
        ArrayList<Vehicule> lstVehicules = new ArrayList<>();
        int maxKm = 300000;

        for (Vehicule vehicule : lstVehicule) {
            if (vehicule.getKmAuCompteur() >= maxKm) {
                lstVehicules.add(vehicule);
            }
        }
        System.out.println("Les véhicules avec le plus de km sont :");
        for (Vehicule vehicule : lstVehicules) {
            System.out.println(vehicule);
        }
        return lstVehicules;
    }

    public static ArrayList<Vehicule> afficherVehiculesMoinsKm(ArrayList<Vehicule> lstVehicules) {
        // Initialiser minKm à une valeur élevée pour trouver le minimum
        int minKm = lstVehicules.get(0).getKmAuCompteur();
        // int minKm = Integer.MAX_VALUE;

        // Trouver le nombre minimum de kilomètres au compteur
        for (Vehicule vehicule : lstVehicules) {
            if (vehicule.getKmAuCompteur() < minKm) {
                minKm = vehicule.getKmAuCompteur();
            }
        }

        // Créer une liste pour stocker les véhicules avec le nombre minimum de kilomètres
        ArrayList<Vehicule> vehiculesMoinsKm = new ArrayList<>();

        // Ajouter les véhicules avec le nombre minimum de kilomètres à la nouvelle liste
        for (Vehicule vehicule : lstVehicules) {
            if (vehicule.getKmAuCompteur() == minKm) {
                vehiculesMoinsKm.add(vehicule);
            }
        }

        // Afficher les véhicules avec le moins de kilomètres
        System.out.println("Les véhicules avec le moins de km sont :");
        for (Vehicule vehicule : vehiculesMoinsKm) {
            System.out.println(vehicule);
        }
        return vehiculesMoinsKm;
    }

    public static void afficherCoutEntretienVehicule(ArrayList<Vehicule> lstVehicule) {
        
    }
}
