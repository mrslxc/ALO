import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Clément Vogt
 * @version Version 1.0
 */
public class ExecOMetro {
    //début des constantes fournies NE PAS MODIFIER

    // tarif des billets selon les zones traversées
    // ici on a choisi la correspondance directe : le nombre de zones est la position dans la liste (d'où le -1 en position 0)
    public static final ArrayList<Double>  TARIF_PAR_NB_ZONES/*_traversées*/ =
                                                         new ArrayList<>(java.util.List.of( -1.0, 2.5, 3.5, 5.0, 5.5));

    public static final String NOM_FICHIER_ARRETS = "ligneMM.csv";
    public static final int CODE_ARRET_INCONNU = -1;

    public static final ArrayList<Arret> LISTE_SECOURS_ARRETS = affecterListeSecoursArrets();
    public static final ArrayList<Arret> LISTE_SECOURS_NECTARS_FLONFLONS = affecterListeSecoursNectarsFlonflons();
    public static final ArrayList<Arret> LISTE_SECOURS_POIVRAZ_STATION = affecterListeSecoursPoivrazStation();
    //fin des constantes fournies


    public static void main(String[] args) {
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

    private static void afficherDureesTotales(ArrayList<Arret> ligneMM) {
        int sommeSud = 0;
        int sommeNord = 0;
        for (Arret a : ligneMM) {
            sommeSud += a.getDureeVersSud();
            sommeNord += a.getDureeVersNord();
        }
        System.out.println("Durée totale vers sud = " + sommeSud + " minutes");
        System.out.println("Durée totale vers nord = " + sommeNord + " minutes");
    }

    private static void afficherDureesMaximales(ArrayList<Arret> ligneMM) {
        int indMaxSud = 0;
        int indMaxNord = 0;
        Arret arretMaxSud = ligneMM.get(indMaxSud);
        Arret arretMaxNord = ligneMM.get(indMaxNord);
        for (int i = 1; i < ligneMM.size(); i++) {
            Arret arretActuel = ligneMM.get(i);
            if (arretActuel.getDureeVersSud() > arretMaxSud.getDureeVersSud()) {
                arretMaxSud = arretActuel;
                indMaxSud = i;
            }
            if (arretActuel.getDureeVersNord() > arretMaxNord.getDureeVersNord()) {
                arretMaxNord = arretActuel;
                indMaxNord = i;
            }
        }
        System.out.println("Durée max vers le sud = " + arretMaxSud.getDureeVersSud() + " minutes à l'arrêt en position " + indMaxSud + " (" + arretMaxSud.getNomArret() + ")");
        System.out.println("Durée max vers le nord = " + arretMaxNord.getDureeVersNord() + " minutes à l'arrêt en position " + indMaxNord + " (" + arretMaxNord.getNomArret() + ")");
    }

    private static void testQuestionB3(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        System.out.println("Trajet de "+nomArretDepart+" à "+nomArretArrivee);
        afficherArretsPourUnTrajet(nomArretDepart, nomArretArrivee, ligneMM);
    }

    private static void testQuestionB4(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        System.out.println("Prix pour un trajet de "+nomArretDepart+" à "+nomArretArrivee);
        afficherArretsPourUnTrajet(nomArretDepart, nomArretArrivee, ligneMM);
        System.out.println();
        int nbZonesTraversees = getNbZonesTraversees(nomArretDepart,nomArretArrivee,ligneMM);
        System.out.println("Tarif appliqué pour " + nbZonesTraversees + " zones traverséees = " + TARIF_PAR_NB_ZONES.get(nbZonesTraversees));
    }

    private static ArrayList<Arret> lireDonnees(String nomFichier) {
        ArrayList<Arret> ligneMM = new ArrayList<>();
        try {
            Scanner scLignes = new Scanner(new File(nomFichier));
            while (scLignes.hasNextLine()) {
                Scanner scElements = new Scanner(scLignes.nextLine());
                scElements.useDelimiter(";");
                String nomArret = scElements.next();
                String nomZone = scElements.next();
                int dureeVersSud = scElements.nextInt();
                int dureeVersNord = scElements.nextInt();
                Arret arret = new Arret(nomArret,nomZone,dureeVersSud,dureeVersNord);
                ligneMM.add(arret);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return ligneMM;
    }

    private static int getPositionArret(String nomArret, ArrayList<Arret> ligneMM) {
        for (int i = 0; i < ligneMM.size(); i++) {
            if (ligneMM.get(i).getNomArret().equals(nomArret)) {
                return i;
            }
        }
        return CODE_ARRET_INCONNU;
    }

    private static ArrayList<Arret> getArretsPourUnTrajet(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        ArrayList<Arret> arretsTrajet = new ArrayList<>();
        int posArretDepart = getPositionArret(nomArretDepart,ligneMM);
        int posArretArrivee = getPositionArret(nomArretArrivee,ligneMM);
        if (posArretDepart < posArretArrivee) {
            for (int i = posArretDepart; i <= posArretArrivee; i++) {
                arretsTrajet.add(ligneMM.get(i));
            }
        } else {
            for (int i = posArretDepart; i >= posArretArrivee; i--) {
                arretsTrajet.add(ligneMM.get(i));
            }
        }
        return arretsTrajet;
    }

    private static void afficherArretsPourUnTrajet(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        ArrayList<Arret> arretsTrajet = getArretsPourUnTrajet(nomArretDepart,nomArretArrivee,ligneMM);
        System.out.println("Liste des " + arretsTrajet.size() + " arrêts entre " + nomArretDepart + " et " + nomArretArrivee);
        for (Arret a : arretsTrajet) {
            System.out.println(a.getNomArret());
        }
    }

    private static int getNbZonesTraversees(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM) {
        ArrayList<Arret> arretsTrajet = getArretsPourUnTrajet(nomArretDepart,nomArretArrivee,ligneMM);
        String zoneArretDepart = arretsTrajet.get(0).getNomZone();
        int nbZonesTraversees = 1;
        for (int i = 1; i < arretsTrajet.size(); i++) {
            Arret arretActuel = arretsTrajet.get(i);
            if (!arretActuel.getNomZone().equals(zoneArretDepart)) {
                nbZonesTraversees++;
                zoneArretDepart = arretActuel.getNomZone();
            }
        }
        return nbZonesTraversees;
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
        try
        {r = java.util.Arrays.stream(java.nio.file.Files.readString(java.nio.file.Paths.get("ligneMM.csv"))
                .split("\n")).map(l -> ((java.util.function.Function<String[], Arret>)
                  (t -> new Arret(t[0], t[1], Integer.valueOf(t[2]), Integer.valueOf(t[3])))).apply(l.split(";")))
                .collect(java.util.stream.Collectors.toCollection(ArrayList::new));
        }
        catch (Exception e)
        {System.out.println("APPELEZ LE SURVEILLANT !");throw new RuntimeException(e);}
        finally
        {return r;}
    }
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
}
