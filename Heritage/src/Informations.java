import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Informations {

    // Résultat final à afficher :
    //
    // Leroy Julie née le 2005-11-30 est un élève qui est un élève de première année.
    // Simon Manon née le 2006-08-12 est un élève qui est un élève de première année.
    // Laurent Emma née le 2005-10-08 est un élève qui est un élève de première année.
    // Dubois Camille née le 2005-06-25 est un élève qui est un élève de première année.
    // Durand Marie née le 2004-07-20 est un élève qui est un élève de deuxième année.
    // Moreau Lucas née le 2004-04-18 est un élève qui est un élève de deuxième année.
    // Martin Sophie née le 1982-11-08 est un professeur qui enseigne ALO
    public static void main(String[] args) {
        ArrayList<Personne> listePersonne = lireDonnes("fichier_personnes.txt");

        for (Personne personne : listePersonne) {
            System.out.println(personne);
        }
    }

    public static ArrayList<Personne> lireDonnes(String nomFichier) {
        ArrayList<Personne> tableauPersonne = new ArrayList();

        try {
            Scanner sc_ligne = new Scanner(new File(nomFichier));
            while (sc_ligne.hasNextLine()) {
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                sc_element.useDelimiter("/");
                String nom = sc_element.next();
                String prenom = sc_element.next();
                String date = sc_element.next();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(date, formatter);

                String categorie = sc_element.next();

                if (categorie.equals("professeur")) {
                    String matiere = sc_element.next();
                    tableauPersonne.add(new Professeur(nom, prenom, localDate, categorie, matiere));
                } else {
                    String niveau = sc_element.next();
                    tableauPersonne.add(new Eleves(nom, prenom, localDate, categorie, niveau));
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        return tableauPersonne;
    }
}
