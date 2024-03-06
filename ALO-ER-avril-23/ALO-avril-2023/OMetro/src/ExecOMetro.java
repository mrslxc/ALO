//vos noms et prénoms ici

import java.util.ArrayList;

public class ExecOMetro
{
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


    public static void main(String[] args)
    {
        //AVANT TOUT
        //la lecture des données
        ArrayList<Arret> ligneMM = null; //affectation à modifier bien sûr

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
    private static void afficherDureesMaximales(ArrayList<Arret> ligneMM)
    {
        // ici votre code
    }

    private static void afficherDureesTotales(ArrayList<Arret> ligneMM)
    {
        // ici votre code
    }
    private static void testQuestionB3(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM)
    {
        System.out.println("Trajet de "+nomArretDepart+" à "+nomArretArrivee);
        // ici votre code
    }

    private static void testQuestionB4(String nomArretDepart, String nomArretArrivee, ArrayList<Arret> ligneMM)
    {
        System.out.println("Prix pour un trajet de "+nomArretDepart+" à "+nomArretArrivee);
        // ici votre code
    }

    //vos méthodes ici











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
