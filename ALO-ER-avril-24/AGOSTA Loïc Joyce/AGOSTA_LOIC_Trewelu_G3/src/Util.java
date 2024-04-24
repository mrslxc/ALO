/************************/
//NE PAS MODIFIER !!
/************************/

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Util {
    public static void main(String[] args) {
        // exemple d'utilisation de arrondir et arrondir2
        System.out.println (Util.arrondir(235.65)); //va afficher 236 (arrondi à l'entier le plus proche)
        System.out.println (Util.arrondir2(235.659)); //va afficher 235,66 (arrondi à 2 décimales)
        //System.out.println(methodeDeSecours());
    }
    /***** NE PAS MODIFIER !!*/
    /**/static String arrondir(double d)
    /**/{
    /**/	return new java.text.DecimalFormat("0").format(d);
    /**/}
    /**/static String arrondir2(double d)
    /**/{
    /**/	return new java.text.DecimalFormat("0.00").format(d);
    /**/}

    //NE PAS MODIFIER
    public static ArrayList<Lapin> methodeDeSecours()
    {
        ArrayList<Lapin> liste = new ArrayList<>();
        try
        { liste = Files.readString(Paths.get("RabbitData.txt")).lines()
                .map(l -> ((Function<String[], Lapin>)
                        (t -> new Lapin(t[0], EprPaques.TAB_CAT_CHOC[Integer.valueOf(t[1])-1],
                                       t[2].startsWith("o")?true:false, Integer.valueOf(t[3]), Integer.valueOf(t[4]),
                                       Double.valueOf("0."+t[5]))))
                        .apply(l.split("\t"))).collect(Collectors.toCollection(ArrayList<Lapin>::new));
        } catch (Exception e)
        {
            //e.printStackTrace();
            System.out.println("APPELEZ LE SURVEILLANT !");
            throw new RuntimeException(e);
        } finally {
            return liste;
        }
    }
}
