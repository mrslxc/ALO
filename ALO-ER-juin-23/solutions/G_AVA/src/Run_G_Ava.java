import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * @author Clément Vogt
 * @version Version 1.0
 */
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
        for (AuSol auSol : groundStaff) {
            int anneesRestantes = auSol.calculerAnneesRestantes();
            System.out.println(auSol.getNom() + " : " + (anneesRestantes > 0 ? anneesRestantes : "retraite !"));
        }
    }

    private static ArrayList<AuSol> lireDonneesPartieA(String nomFichier) // A MODIFIER sauf le paramètre
    {
        ArrayList<AuSol> groundStaff = new ArrayList<>();
        try {
            Scanner scLignes = new Scanner(new File(nomFichier));
            scLignes.nextLine();
            while (scLignes.hasNextLine()) {
                Scanner scElements = new Scanner(scLignes.nextLine());
                scElements.useDelimiter(";");
                String nom = scElements.next();
                boolean genre = scElements.next().equals("F") ? true : false;
                String canton = scElements.next();
                String typePersonnel = scElements.next();
                int anciennete = scElements.nextInt();
                AuSol auSol;
                if (typePersonnel.equals("DeService")) {
                    String specialite = scElements.next();
                    auSol = new DeService(nom,genre,canton,anciennete,specialite);
                } else {
                    String referenceBureau = scElements.next() + scElements.next()  + scElements.next();
                    auSol = new Admin(nom,genre,canton,anciennete,referenceBureau);
                }
                groundStaff.add(auSol);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return groundStaff;
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
        for (Navigant nav : airCrew) {
            if (nav.estFemme()) {
                nbFemmes++;
            }
        }
        double pctFemmes = (double)nbFemmes/airCrew.size()*100;
        System.out.println("Parmi les " + airCrew.size() + " membres du personnel navigant,");
        System.out.println("il y a " + arrondi(pctFemmes) + "% de femmes et " + arrondi(100-pctFemmes) + "% d'hommes selon leur état-civil actuel");
    }

    private static void exo2B_afficherPlusExperimente(ArrayList<Navigant> airCrew) //A COMPLETER
    {
        System.out.println(LF+"=== Exo 2B ===");
        Pilote plusExp = pilotePlusExperimente(airCrew);
        System.out.println("Le pilote le plus expérimenté est " + plusExp.getNom() + " avec " + plusExp.getNbHeuresVol() + " heures de vol");
    }

    private static Pilote pilotePlusExperimente(ArrayList<Navigant> airCrew) //A COMPLETER
    {
        Pilote plusExp = null;
        for (Navigant nav: airCrew) {
            if (nav instanceof Pilote) {
                Pilote p = (Pilote)nav;
                if (plusExp == null || p.getNbHeuresVol() > plusExp.getNbHeuresVol()) {
                    plusExp = p;
                }
            }
        }
        return plusExp;
    }

    private static void exo3B_afficherRevalidations(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 3B ===");

        System.out.println("Liste des pilotes devant valider à nouveau leur brevet");
        ArrayList<Pilote> listePilotes = listerRevalidations(airCrew);
        for (Pilote p: listePilotes) {
            System.out.println(p.getNom() + " - brevet en date du " + Pilote.DATE_FORMATTER.format(p.getDateValidationBrevet()));
        }
    }

    private static ArrayList<Pilote> listerRevalidations(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        ArrayList<Pilote> liste = new ArrayList<>();
        for (Navigant nav: airCrew) {
            if (nav instanceof Pilote) {
                Pilote p = (Pilote)nav;
                if (age(p.getDateValidationBrevet()) >= Employe.LIMITE_BREVET) {
                    liste.add(p);
                }
            }
        }
        return liste;
    }

    private static HashMap<String,Integer> repartitionSelonLieuxDeResidence(ArrayList<Navigant> airCrew) {
        HashMap<String,Integer> hmRepartition = new HashMap<>();
        for (Navigant nav: airCrew) {
            String canton = nav.getCanton();
            if (!hmRepartition.containsKey(canton)) {
                hmRepartition.put(canton,1);
            } else {
                hmRepartition.put(canton,hmRepartition.get(canton)+1);
            }
        }
        return hmRepartition;
    }

    public static void exo4B_afficherRepartition(ArrayList<Navigant> airCrew)//A COMPLETER
    {
        System.out.println(LF+"=== Exo 4B ===");
        HashMap<String,Integer> hmRepartition = repartitionSelonLieuxDeResidence(airCrew);
        System.out.println("Liste des cantons/départements de résidence");
        System.out.println(hmRepartition.keySet());
        System.out.println("\nRépartition");
        for (Map.Entry<String, Integer> e : hmRepartition.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }

    private static void exo5B_effectuerMiseAJour(ArrayList<Navigant> airCrew)///A COMPLETER
    {
        System.out.println(LF+"=== Exo 5B ===");
        int[][] tableauSemaine = acquérirTableauHebdo();
        vérificationLecture(tableauSemaine);
        int vac = 0;
        int mala = 0;
        int form = 0;
        for (int noNavigant = 0; noNavigant < tableauSemaine.length; noNavigant++) {
            int sommeHeuresSemaine = 0;
            for (int noJour = 0; noJour < NB_JOURS_SEMAINE; noJour++) {
                int nbHeuresJournaliere = tableauSemaine[noNavigant][noJour];
                if (nbHeuresJournaliere == CODE_VACANCES) {
                    vac++;
                } else if (nbHeuresJournaliere == CODE_SANTE) {
                    mala++;
                } else if (nbHeuresJournaliere == CODE_FORMATION) {
                    form++;
                } else {
                    sommeHeuresSemaine += nbHeuresJournaliere;
                }
            }
            Navigant nav = airCrew.get(noNavigant);
            nav.setNbHeuresVol(nav.getNbHeuresVol()+sommeHeuresSemaine);
        }
        afficherStatHebdo(airCrew, vac, mala, form);
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
