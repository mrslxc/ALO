//vos noms et prénoms ici

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecOMetro
{
    //début des constantes fournies NE PAS MODIFIER

    // tarif des billets selon les zones traversées
    // ici on a choisi la correspondance directe : le nombre de zones est la position dans la liste (d'où le -1 en position 0)
    public static final ArrayList<Double>  TARIF_PAR_NB_ZONES /*_traversées*/ = new ArrayList<>(java.util.List.of( -1.0, 2.5, 3.5, 5.0, 5.5));

    //public static final String NOM_FICHIER_ARRETS = "C:\\Users\\itslx\\Documents\\GitHub\\ALO\\ALO-ER-avril-23\\ALO-avril-2023\\OMetro\\ligneMM.csv";
    public static final String NOM_FICHIER_ARRETS = "D:\\ALO\\ALO-ER-avril-23\\ALO-avril-2023\\OMetro\\ligneMM.csv";
    public static final int CODE_ARRET_INCONNU = -1;

    //public static final ArrayList<Arret> LISTE_SECOURS_ARRETS = affecterListeSecoursArrets();
    //public static final ArrayList<Arret> LISTE_SECOURS_NECTARS_FLONFLONS = affecterListeSecoursNectarsFlonflons();
    //public static final ArrayList<Arret> LISTE_SECOURS_POIVRAZ_STATION = affecterListeSecoursPoivrazStation();
    //fin des constantes fournies


    public static void main(String[] args)
    {
        //AVANT TOUT
        //la lecture des données
        ArrayList<Arret> ligneMM = lireDonnees(NOM_FICHIER_ARRETS); //affectation à modifier bien sûr

        //en cas de problème avec la lecture,
        // décommenter la ligne suivante et ne touchez pas à la déclaration ci-dessus
        //ligneMM = LISTE_SECOURS_ARRETS;

        //question B1- durées totales dans les deux sens
        entete("Question B1");
        afficherDureesTotales(ligneMM);

        //question B2 - durées maximales dans les deux sens
        entete("Question B2");
        afficherDureesMaximales(ligneMM);

        //question B3 - lister les arrêts entre deux arrêts fournis
        entete("Question B3");
        testQuestionB3("Nectars", "Flonflons", ligneMM);
        System.out.println();
        testQuestionB3("Poivraz", "Station", ligneMM);
        System.out.println();

         //question B4 - calculer le prix du trajet
        entete("Question B4");
        testQuestionB4("Nectars", "Flonflons", ligneMM);
        System.out.println();
        testQuestionB4("Poivraz", "Station", ligneMM);
        System.out.println();
    }

    //à compléter
    private static void afficherDureesMaximales(ArrayList<Arret> ligneMM) {
        int maxSud = 0;
        int maxNord = 0;
        String nomSud = "";
        String nomNord = "";

        int positionSud = 0;
        int positionNord = 0;


        // On initialise un compteur pour parcourir la liste des arrêts
        // Le compteur servira pour la position de l'arrêt
        int compteur = 0;

        // On crée une boucle pour parcourir la liste des arrêts
        for (Arret arret :  ligneMM) {
            if (arret.getDureeVersSud() > maxSud) {
                maxSud = arret.getDureeVersSud();
                nomSud = arret.getNomArret();
                positionSud = compteur;
            }
            compteur += 1;
        }
        System.out.println("Durée maximale vers le sud: " + maxSud + " minutes à l'arrêt en position " + positionSud + " (" + nomSud + ")");

        compteur = 0;
        for (Arret arret : ligneMM) {
            if (arret.getDureeVersNord() > maxNord) {
                maxNord = arret.getDureeVersNord();
                nomNord = arret.getNomArret();
                positionNord = compteur;
            }
            compteur += 1;
        }
        System.out.println("Durée maximale vers le nord: " + maxNord + " minutes à l'arrêt en position " + positionNord + " (" + nomNord + ")");
    }

    private static void afficherDureesTotales(ArrayList<Arret> ligneMM) {
        int totalSud = 0;
        int totalNord = 0;

        for (Arret arret : ligneMM) {
            totalSud += arret.getDureeVersSud();
            totalNord += arret.getDureeVersNord();
        }
        System.out.println("Durée totale vers le sud: " + totalSud + " minutes");
        System.out.println("Durée totale vers le nord: " + totalNord + " minutes");
    }

    /*
    * Etape 1 : On crée une méthode "getPositionArret" pour récupérer la position de l'élément à partir du fichier
    * On crée une boucle pour parcourir la liste des arrêts
    * On compare le nom de l'arrêt avec le nom de l'arrêt de départ
    * Si l'arrêt est trouvé, on retourne la position de l'arrêt
    * Sinon, on retourne -1
    * */
    private static int getPositionArret(String nomArret, ArrayList<Arret> ligneMM) {
        for (int i = 0; i < ligneMM.size(); i++) {
            if (ligneMM.get(i).getNomArret().equals(nomArret)) { // ligneMM.get(i) -> on récupère l'arrêt à partir de la position i
                return i;
            }
        }
        return CODE_ARRET_INCONNU; // en cas d'erreur de position -> -1
    }

    private static void testQuestionB3(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        System.out.println("Trajet de " + nomArretDepart + " à " + nomArretArrivee);

        // On récupère la position de l'arrêt de départ et d'arrivée
        ArrayList<Arret> lstArrets = new ArrayList<>();
        int positionDepart = getPositionArret(nomArretDepart, ligneMM);
        int positionArriver = getPositionArret(nomArretArrivee, ligneMM);

        if (positionDepart < positionArriver) {
            for (int i = positionDepart; i <= positionArriver; i++) {
                lstArrets.add(ligneMM.get(i));
            }
        } else {
            // On crée une boucle pour aller en arrière et comparer la position à la position d'arriv
            for (int i = positionDepart; i >= positionArriver; i--) {
                lstArrets.add(ligneMM.get(i));
            }
        }

        /*
         * On crée une boucle pour parcourir la liste des arrêts
         * On récupère l'arrêt à partir de la position minimale et maximale
         * On affiche le nom de l'arrêt
         * */
        System.out.println("Liste des " + lstArrets.size() + " arrêts entre " + nomArretDepart + " à " + nomArretArrivee);
        for (int i = positionDepart; i >= positionArriver; i++) {
            Arret arret = ligneMM.get(i); // Décalage de 1 pour obtenir l'indice correct dans la liste
            System.out.println(arret.getNomArret());
        }
    }

    private static void testQuestionB4(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        // On crée une liste pour stocker les arrêts
        ArrayList<Arret> arretsTrajet = new ArrayList<>();
        int positionDepart = getPositionArret(nomArretDepart, ligneMM);
        int positionArriver = getPositionArret(nomArretArrivee, ligneMM);
        
        // On compare, comme au B3, la position du départ et de l'arrivée
        if (positionDepart < positionArriver) {
            for (int i = positionDepart; i <= positionArriver; i++) {
                arretsTrajet.add(ligneMM.get(i)); // arretsTrajet.add(ligneMM.get(i)) -> on ajoute l'arrêt à la liste
            }
        } else {
            // for (int i = positionDepart; i >= positionArriver; i--) -> on parcourt la liste à l'envers pour obtenir les arrêts entre les deux positions
            for (int i = positionDepart; i >= positionArriver; i--) {
                arretsTrajet.add(ligneMM.get(i));
            }
        }
        
        System.out.println("Prix pour un trajet de "+nomArretDepart+" à "+nomArretArrivee);
        // Vu que la B3, on affichait les différents arrêts, et bien on instancie la question
        System.out.println("Liste des " + arretsTrajet.size() + " arrêts entre " + nomArretDepart + " et " + nomArretArrivee);
        for (Arret arret : arretsTrajet) {
            System.out.println(arret.getNomArret());
        }
        System.out.println("\n");

        // On crée une variable pour stocker la zone, en appelant de la liste "arretTrajet"
        String zoneDepart = arretsTrajet.get(0).getNomZone(); // arretsTrajet.get(0) -> on récupère le premier arrêt de la liste, soit on récupère la zone de départ
        
        // On initialise la variable de la zone à 1
        int nbZonesTraverses = 1;
        /* 
        * A chaque tour de boucle, on récupère le nom des arrêts
        * Si l'arrêt récupéré corresponds bien à la zone définis
        * Alors on compte +1 par zone traversés et on stocke la zone de départ
        * */
        for (int i = 1; i < arretsTrajet.size(); i++) {
            Arret arretActuel = arretsTrajet.get(i);
            if (!arretActuel.getNomZone().equals(zoneDepart)) {
                nbZonesTraverses++;
                zoneDepart = arretActuel.getNomZone(); // zoneDepart = arretActuel.getNomZone() -> on stocke la zone de départ à chaque tour de boucle
            }
        }
        
        // On affiche le résultat étant donné que TARIF_NB_PAR_ZONE est une liste, et 
        // bien la variable en paramètre est le nombre de zone
        System.out.println("Tarif appliqué pour " + nbZonesTraverses + " zones traversées: "
                + TARIF_PAR_NB_ZONES.get(nbZonesTraverses) + " euros"); // TARIF_PAR_NB_ZONES.get(nbZonesTraverses) -> on récupère le tarif à partir du nombre de zones traversées
    }

    //vos méthodes ici

    public static ArrayList<Arret> lireDonnees(String nomFichier) {
        ArrayList<Arret> lstArret = new ArrayList<>();
        try {
            Scanner sc_ligne = new Scanner(new File(nomFichier));
            while (sc_ligne.hasNextLine()) {
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                sc_element.useDelimiter(";");
                String nomArret = sc_element.next();
                String nomLieu = sc_element.next();
                int dureeSud = sc_element.nextInt();
                int dureeNord = sc_element.nextInt();

                lstArret.add(new Arret(nomArret, nomLieu, dureeSud, dureeNord));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstArret;
    }

// code fourni -- ne pas modifier !

    private static void entete(String texte)
    {
        System.out.println();
        System.out.println("=== " + texte + " ===");
    }
    private static ArrayList<Arret> affecterListeSecoursArrets()
    {
        ArrayList<Arret> r = null;
        try {
            r = java.util.Arrays.stream(java.nio.file.Files.readString(java.nio.file.Paths.get("ligneMM.csv")).split("\n")).map(l -> new Arret(l.split(";")[0], l.split(";")[1], Integer.parseInt(l.split(";")[2]), Integer.parseInt(l.split(";")[3]))).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        }
        catch (Exception e) {
            System.out.println("APPELEZ LE SURVEILLANT !");throw new RuntimeException(e);
        }
        finally {
            return r;
        }
    }
    /*
    private static ArrayList<Arret> affecterListeSecoursNectarsFlonflons()

    {
        return new ArrayList<>(affecterListeSecoursArrets().subList(2, 6));
    }
    private static ArrayList<Arret> affecterListeSecoursPoivrazStation()
    {
        java.util.List<Arret> a = affecterListeSecoursArrets().subList(4, 11);
        java.util.Collections.reverse(a);
        return new ArrayList<>(a);
    }
    */
}
