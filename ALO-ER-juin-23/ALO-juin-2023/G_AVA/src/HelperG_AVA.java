

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 *******************************************
    NE SURTOUT PAS MODIFIER CETTE CLASSE !!
 *******************************************
*/
public class HelperG_AVA
{
    //NE PAS MODIFIER
    static void afficherStatHebdo(ArrayList<Navigant> airCrew, int vac, int mala, int form)
    {
        ArrayList<Navigant> avant = acquérirDonnéesPartieB();
        System.out.println("Evolution des heures de vol");
        System.out.println("Semaine du lundi 6 au dimanche 12 juin 2050");
        System.out.println("Congés : "+vac+" jours; Santé : "+mala+" jours; Formation : "+form+ " jours");
        Tabular.separator(37);
        for (int pos = 0; pos < avant.size(); pos++)
        {
            Tabular.print(avant.get(pos).getNom());
            Tabular.print(avant.get(pos).getNbHeuresVol());
            Tabular.print("->");
            Tabular.print(airCrew.get(pos).getNbHeuresVol());
            Tabular.println(false);
        }
        Tabular.separator(37);
    }

    //NE PAS MODIFIER
    static ArrayList<Navigant> acquérirDonnéesPartieB()
    {
        ArrayList<Navigant> liste = new ArrayList<>();
        try
        { liste = Files.readString(Paths.get("AirCrew.csv")).lines().skip(1)
                .map(l ->((Function<String[], Navigant>)
                    (t ->(t.length == 4) ?
                      (new AdB(t[0], t[1].equals("F"), t[2], Integer.parseInt(t[3]), false)):
                      (new Pilote(t[0], t[1].equals("F"), t[2], Integer.valueOf(t[3]), LocalDate.of(Integer.parseInt(t[4]),
                                                   Integer.parseInt(t[5]), Integer.parseInt(t[6]))) )))
                 .apply(l.split(";"))).collect(Collectors.toCollection(ArrayList<Navigant>::new));
        } catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("APPELEZ LE SURVEILLANT !");
            throw new RuntimeException(e);
        } finally
        {
            return liste;
        }
    }

    static String arrondi(double d)//NE PAS MODIFIER !!
    {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.#");
        df.setRoundingMode(java.math.RoundingMode.HALF_UP);
        return df.format(d);
    }

    static int[][] acquérirTableauHebdo()//NE PAS MODIFIER
    {
        int[][] tab =
                {{6, 0, 0, 6, 2, 2, 2},
                        {-1, -1, 0, 4, 3, -1, -1},
                        {8, 0, 7, 0, -2, 2, 7},
                        {6, 0, 4, 4, 0, 4, 0},
                        {4, 0, 7, 6, 0, -1, -1},
                        {0, 6, -2, 0, 6, 0, 8},
                        {7, 0, -3, -3, -3, 0, 3},
                        {3, 4, -2, 0, 4, 5, 8},
                        {8, 0, 3, 0, 0, 2, 8},
                        {0, -1, -1, -1, -1, -1, -1},
                        {4, -1, -1, 5, 7, 0, 0},
                        {8, 5, 5, 1, -1, 0, 3},
                        {-1, -3, 7, 5, 0, 4, 4},
                        {-1, -1, -1, -1, -1, -1, -1},
                        {-1, 6, 5, 0, 4, 3, 4},
                        {2, 3, 0, 8, -1, 3, 5},
                        {4, -1, 6, 4, 0, 7, 6},
                        {0, 3, 8, 0, 4, 3, 7},
                        {-3, -3, -3, 4, 0, 4, 5}};
        return tab;
    }

    public static void vérificationLecture(int[][] tab)
    {
        System.out.println("Tableau hebdomadaire");
        Tabular.header();
        for (int lig = 0; lig < tab.length; lig++)
        {
            for (int col = 0; col < tab[lig].length; col++)
            {
                Tabular.print(tab[lig][col]);
            }
            Tabular.println(true);
        }
        Tabular.separator(64);
        System.out.println();
    }
   private static class Tabular //NE SURTOUT PAS MODIFIER !!
   {
       private static final ArrayList<Object> line = new ArrayList<>();// système de buffer

       public static void separator(int n)
       {
           System.out.println(new String(new char[n]).replace('\0', '-'));
       }

       public static void header()
       {
           separator(64);
           for ( DayOfWeek d : DayOfWeek.values() )
               System.out.printf("|%1$-8s", joliJour(d));
           endOfLine();
           separator(64);
       }

       public static String joliJour(DayOfWeek jour)
       {
           String r =jour.getDisplayName(TextStyle.FULL, Locale.FRENCH);
           return (r.length()<8)?" "+r:r;
       }
       public static void print(Object obj)
       {
           line.add(obj);
       }

       private static void endOfLine()
       {
           System.out.printf("|%n");
       }

       public static void println(boolean avecBarre)
       {
           //on affiche ce qui est "bufferisé"
           for (Object obj : line)
               if (obj instanceof String && ((String) obj).length() > 2) //les noms
                   System.out.printf("| %1$15s |", obj);
               else if (obj instanceof Integer)// les heures de vol
               {
                   if ( avecBarre )//provenance tableau 2D
                       System.out.printf("| %1$6d ", obj);
                   else //provenance liste des pilotes
                        System.out.printf(" %1$5d ", obj);
               }
               else // ->
                   System.out.printf(" %1$2s", obj);
           endOfLine();
           line.clear();//on vide le buffer
       }
   }
}
