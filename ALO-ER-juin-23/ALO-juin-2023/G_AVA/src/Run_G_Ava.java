import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

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
        for (AuSol pers_ausol : groundStaff) {
            int anneesRestantes = pers_ausol.calculerAnneeRestantes();
            System.out.println(pers_ausol.getNom() + " : " + (anneesRestantes > 0 ? anneesRestantes : "retraite !"));
        }
    }
    // A MODIFIER sauf le paramètre
    private static ArrayList<AuSol> lireDonneesPartieA(String nomFichier) {
        ArrayList<AuSol> lstStaff = new ArrayList<>();
        try
        {
            Scanner sc = new Scanner(new File(nomFichier));
            sc.nextLine();
            while (sc.hasNextLine()) {
                Scanner scElements = new Scanner(sc.nextLine());
                scElements.useDelimiter(";");
                String nom = scElements.next();
                String genre = scElements.next();
                boolean estGenre;
                if (genre.equals("F")) {
                    estGenre = true;
                } else {
                    estGenre = false;
                }
                String canton = scElements.next();
                String type = scElements.next();
                int anciennete = scElements.nextInt();

                AuSol auSol;
                if (type.equals("Admin")) {
                    String refBureau = scElements.next() + scElements.next() + scElements.next();
                    auSol = new DeService(nom, estGenre, canton, anciennete, refBureau);

                } else {
                    String specialite = scElements.next();
                    auSol = new Admin(nom, estGenre, canton, anciennete, specialite);
                }
                lstStaff.add(auSol);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fichier non trouvé");
        }
        return lstStaff;
    }

    private static void calculerAnneeRestantes() {

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

        int nbFemmes = 0;
        for (Navigant nav_femme : airCrew) {
            if (nav_femme.estFemme()) {
                nbFemmes++;
            }
        }

        int nbHommes = 0;
        for (Navigant nav_hommes : airCrew) {
            if (!nav_hommes.estFemme()) {
                nbHommes++;
            }
        }
        System.out.println("Il y a en pourcentage " + arrondi((double)nbFemmes / airCrew.size() * 100) +
                "% de femmes et " + arrondi((double)nbHommes / airCrew.size() * 100) + "% d'hommes");
    }

    private static void exo2B_afficherPlusExperimente(ArrayList<Navigant> airCrew) //A COMPLETER
    {
        System.out.println(LF+"=== Exo 2B ===");
        // ici appel de la fonction pilotePlusExperimente qui renvoie une instance de Pilote
        System.out.println("Le pilote le plus expérimenté est : " + pilotePlusExperimente(airCrew).getNom() + " avec "
                + pilotePlusExperimente(airCrew).getNbHeuresVol() + " heures de vol");
    }

    private static Pilote pilotePlusExperimente(ArrayList<Navigant> airCrew) { //A COMPLETER
       int maxHeures = 0;
       Navigant personne = null;

       for (Navigant nav : airCrew) {
           if (nav instanceof Pilote) {
               Pilote pilote = (Pilote) nav;
               if (pilote.getNbHeuresVol() > maxHeures) {
                   maxHeures = pilote.getNbHeuresVol();
                   personne = pilote;
               }
           }
       }
       return (Pilote) personne;
    }


    private static void exo3B_afficherRevalidations(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 3B ===");

        System.out.println("Liste des pilotes devant valider à nouveau leur brevet");
        ArrayList<Pilote> listePilotes = listerRevalidations(airCrew);
        //ici affichage de listePilotes

        for (Pilote pilote : listePilotes) {
            System.out.printf(pilote.getNom() + " - brevet en date du " + Pilote.DATE_FORMATTER.format(pilote.getDateValidationBrevet()) + LF);
        }
    }

    private static ArrayList<Pilote> listerRevalidations(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        ArrayList<Pilote> liste = new ArrayList<>();

        for (Navigant nav : airCrew) {
            if (nav instanceof Pilote) {
                Pilote pilote = (Pilote) nav;
                if (age(pilote.getDateValidationBrevet()) >= 5) {
                    liste.add(pilote);
                }
            }
        }
        //A COMPLETER
        return liste;
    }


    public static void exo4B_afficherRepartition(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 4B ===");
        HashMap<String,Integer> hmRepartition = repartitionSelonLieuxDeResidence(airCrew);
        System.out.println("Liste des cantons/départements de résidence");
        System.out.println(hmRepartition.keySet());
        System.out.println("Répartition des navigants par canton/département de résidence");
        for (Map.Entry<String, Integer> entry : hmRepartition.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

    private static HashMap<String, Integer> repartitionSelonLieuxDeResidence(ArrayList<Navigant> airCrew) {
        HashMap<String, Integer> hmRepartition = new HashMap<>();
        for (Navigant nav : airCrew) {
            String canton = nav.getCanton();
            if (!hmRepartition.containsKey(canton)) {
                hmRepartition.put(canton, 1);
            } else {
                hmRepartition.put(canton, hmRepartition.get(canton) + 1);
            }
        }
        return hmRepartition;
    }


    private static void exo5B_effectuerMiseAJour(ArrayList<Navigant> airCrew)///A COMPLETER
    {
        System.out.println(LF+"=== Exo 5B ===");
        int[][] tableauSemaine = acquérirTableauHebdo();
        vérificationLecture(tableauSemaine);

        int vacances = 0;
        int maladie = 0;
        int formation = 0;
        int cptHeures = 0;

        for (int i = 0; i < tableauSemaine.length; i++) {
            for (int j = 0; j < tableauSemaine[i].length; j++) {
                if (tableauSemaine[i][j] == CODE_VACANCES) {
                    vacances++;
                } else if (tableauSemaine[i][j] == CODE_SANTE) {
                    maladie++;
                } else if (tableauSemaine[i][j] == CODE_FORMATION) {
                    formation++;
                }
                else {
                    cptHeures += tableauSemaine[i][j];
                }
            }
            // airCrew.get(i).setNbHeuresVol(airCrew.get(i).getNbHeuresVol() + cptHeures); // 982 + 18
        }
        
        for (int i = 0; i < tableauSemaine.length; i++) {
            int sommeHeuresSemaine = 0;
            for (int j = 0; j < tableauSemaine[i].length; j++) {
                if (tableauSemaine[i][j] != CODE_VACANCES && tableauSemaine[i][j] != CODE_SANTE && tableauSemaine[i][j] != CODE_FORMATION) {
                    sommeHeuresSemaine += tableauSemaine[i][j];
                }
            }
            airCrew.get(i).setNbHeuresVol(airCrew.get(i).getNbHeuresVol() + sommeHeuresSemaine);
        }
        afficherStatHebdo(airCrew, vacances, maladie, formation);
    }// A MODIFIER AVEC VOS COMPTEURS

    private static void vérificationLecture(int[][] tab)
    {
        HelperG_AVA.vérificationLecture(tab);
    }


    /*************************** METHODES FOURNIES - NE PAS MODIFIER ! *****************/

    //NE PAS MODIFIER, surtout le type du paramètre !
    private static void vérificationLecture(ArrayList<?> liste)
    {
        if ( liste != null )
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
