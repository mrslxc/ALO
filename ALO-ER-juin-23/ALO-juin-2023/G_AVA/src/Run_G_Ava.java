import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;

public class Run_G_Ava
{
    private static final int NB_JOURS_SEMAINE = 7;
    private static final int CODE_VACANCES = -1;
    private static final int CODE_SANTE = -2;
    private static final int CODE_FORMATION = -3;
    private static String[] TAB_LIEUX = {"1", "74", "GE", "VD"};
    private static ArrayList<String> LISTE_LIEUX = new ArrayList(Arrays.asList(TAB_LIEUX));
    private static final String LF = System.lineSeparator();

    public static void main(String[] args)//NE PAS MODIFIER !
    {
        testPartie_A();
        System.out.println();
        testPartie_B(acquérirDonnéesPartieB());
    }


    /**************** PARTIE A *****************************/
    private static void testPartie_A() //A COMPLETER - PAS DE PARAMETRE à testPartie_A
    {
        ArrayList<AuSol> groundStaff = lireDonneesPartieA("GroundStaff.csv");

        //vérification de la lecture - affiche simplement la liste
        vérificationLecture(groundStaff);

        //ci-dessous le récapitulatif des années à travailler
        System.out.println(LF+"Les années restant à travailler pour nos collaborateurs au sol");
        //A COMPLETER
    }

    private static ArrayList<AuSol> lireDonneesPartieA(String nomFichier) // A MODIFIER sauf le paramètre
    {
         return null;// A MODIFIER !
    }


   /*************** PARTIE B *****************************/
   private static void testPartie_B(ArrayList<Navigant> airCrew)
   {
       //pour vérifier que les données de la partie B sont bonnes
        System.out.println("Liste des navigants :");
        vérificationLecture(airCrew);

        exo1B_afficherProportions(airCrew);
        exo2B_afficherPlusExperimente(airCrew);
        exo3B_afficherRevalidations(airCrew);
        exo4B_afficherRepartition(airCrew);
        exo5B_effectuerMiseAJour(airCrew);
   }


    public static void exo1B_afficherProportions(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 1B ===");

    }

    private static void exo2B_afficherPlusExperimente(ArrayList<Navigant> airCrew) //A COMPLETER
    {
        System.out.println(LF+"=== Exo 2B ===");
        // ici appel de la fonction pilotePlusExperimente qui renvoie une instance de Pilote
    }

    private static Pilote pilotePlusExperimente(ArrayList<Navigant> airCrew) //A COMPLETER
    {
         return null;//A MODIFIER !
    }


    private static void exo3B_afficherRevalidations(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 3B ===");

        System.out.println("Liste des pilotes devant valider à nouveau leur brevet");
        ArrayList<Pilote> listePilotes = listerRevalidations(airCrew);
        //ici affichage de listePilotes
    }

    private static ArrayList<Pilote> listerRevalidations(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        ArrayList<Pilote> liste = new ArrayList<>();
        //A COMPLETER
        return liste;
    }


    public static void exo4B_afficherRepartition(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 4B ===");

    }


    private static void exo5B_effectuerMiseAJour(ArrayList<Navigant> airCrew)///A COMPLETER
    {
        System.out.println(LF+"=== Exo 5B ===");
        int[][] tableauSemaine = acquérirTableauHebdo();
        vérificationLecture(tableauSemaine);
        //A COMPLETER

        afficherStatHebdo(airCrew, 0, 0, 0);// A MODIFIER AVEC VOS COMPTEURS
    }

    private static void vérificationLecture(int[][] tab)
    {
        HelperG_AVA.vérificationLecture(tab);
    }


    /*************************** METHODES FOURNIES - NE PAS MODIFIER ! *****************/

    //NE PAS MODIFIER, surtout le type du paramètre !
    private static void vérificationLecture(ArrayList<? extends Object> liste)
    {
        if ( liste != null)
            for ( Object e : liste )
                System.out.println(e);
        else
            System.out.println("liste à null");
    }

    private static int age(LocalDate date)//NE PAS MODIFIER !!
    {
        return Period.between(date, LocalDate.of(2023, 6, 12)).getYears();
    }

    private static String arrondi(double d)//NE PAS MODIFIER !!
    {
        return HelperG_AVA.arrondi(d);
    }

    private static ArrayList<Navigant> acquérirDonnéesPartieB()
    {
        return  HelperG_AVA.acquérirDonnéesPartieB();
    }

    private static int[][] acquérirTableauHebdo()
    {
        return HelperG_AVA.acquérirTableauHebdo();
    }

    private static void afficherStatHebdo(ArrayList<Navigant> airCrew, int vacances, int maladie, int formation)
    {
         HelperG_AVA.afficherStatHebdo(airCrew, vacances, maladie, formation);
    }
}
