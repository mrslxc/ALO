//vos noms et prénoms ici

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ExecOMetro
{
    //début des constantes fournies NE PAS MODIFIER

    // tarif des billets selon les zones traversées
    // ici on a choisi la correspondance directe : le nombre de zones est la position dans la liste (d'où le -1 en position 0)
    public static final ArrayList<Double>  TARIF_PAR_NB_ZONES/*_traversées*/ = new ArrayList<>(java.util.List.of( -1.0, 2.5, 3.5, 5.0, 5.5));

    public static final String NOM_FICHIER_ARRETS = "C:\\Users\\itslx\\Documents\\GitHub\\ALO\\ALO-ER-avril-23\\ALO-avril-2023\\OMetro\\ligneMM.csv";
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

        int compteur = 0;
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
            if (ligneMM.get(i).getNomArret().equals(nomArret)) {
                return i + 1;
            }
        }
        return CODE_ARRET_INCONNU; // en cas d'erreur de position -> -1
    }

    private static void testQuestionB3(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        System.out.println("Trajet de "+nomArretDepart+" à "+nomArretArrivee);
        // On récupère la position de l'arrêt de départ et d'arrivée
        int positionDepart = getPositionArret(nomArretDepart, ligneMM);
        int positionArriver = getPositionArret(nomArretArrivee, ligneMM);

        // On vérifie si l'arrêt est inconnu pour éviter les erreurs
        if (positionDepart == CODE_ARRET_INCONNU || positionArriver == CODE_ARRET_INCONNU) {
            System.out.println("L'arrêt est inconnu");
        }

        // On récupère la position minimale et maximale pour obtenir les arrêts entre les deux positions
        int minPosition, maxPosition;

        /*
        * Si la position de départ est inférieur à la position d'arrivée
        * Alors on instantice la position de départ comme la position minimale et la position d'arrivée comme la position maximale
        * A l'inverse, on instantie la position d'arrivée comme la position minimale et la position de départ comme la position maximale
        * */
        if (positionDepart < positionArriver) {
            minPosition = positionDepart;
            maxPosition = positionArriver;
        } else {
            minPosition = positionArriver;
            maxPosition = positionDepart;
        }

        /*
        * On crée une boucle pour parcourir la liste des arrêts
        * On récupère l'arrêt à partir de la position minimale et maximale
        * On affiche le nom de l'arrêtw
        * */
        for (int i = minPosition; i <= maxPosition; i++) {
            Arret arret = ligneMM.get(i - 1); // Décalage de 1 pour obtenir l'indice correct dans la liste
            System.out.println(arret.getNomArret());
        }

        // Création et remplissage de la nouvelle liste avec les arrêts entre les positions de départ et d'arrivée
        ArrayList<Arret> lstArrets = new ArrayList<>();
        for (int i = minPosition; i <= maxPosition; i++) {
            Arret arret = ligneMM.get(i - 1); // Décalage de 1 pour obtenir l'indice correct dans la liste
            lstArrets.add(arret);
        }
    }

    private static void testQuestionB4(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM)
    {
        System.out.println("Prix pour un trajet de "+nomArretDepart+" à "+nomArretArrivee);
        int positionDepart = getPositionArret(nomArretDepart, ligneMM);
        int positionArriver = getPositionArret(nomArretArrivee, ligneMM);
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
            r = java.util.Arrays.stream(java.nio.file.Files.readString(java.nio.file.Paths.get("ligneMM.csv")).split("\n")).map(l -> ((java.util.function.Function<String[], Arret>) (t -> new Arret(t[0], t[1], Integer.valueOf(t[2]), Integer.valueOf(t[3])))).apply(l.split(";"))).collect(java.util.stream.Collectors.toCollection(ArrayList::new));
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
