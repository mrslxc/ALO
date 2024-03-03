import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Informations {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Personne> listePersonne = ScannerTexte("fichier_scanner.txt");

        for (Personne personnes : listePersonne) {
            System.out.println(personnes);
        }
    }

    public static ArrayList<Personne> ScannerTexte(String nomFichier) {
        try {
            Scanner sc_ligne = new Scanner(new File(nomFichier));
            ArrayList<Personne> listePersonne = new ArrayList<>();

            // On crée un scanner pour lire chaque ligne du fichier
            // La boucle permet de lire chaque ligne du fichier
            while (sc_ligne.hasNextLine()) {
                // On crée un scanner pour lire chaque élément de la ligne
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                // On change le délimiteur pour lire chaque élément de la ligne
                sc_element.useDelimiter(";");
                // La boucle permet de lire chaque élément de la ligne
                    // On scanne chaque élément que le fichier contient en prenant compte des types de données
                    String prenom = sc_element.next();
                    String nom = sc_element.next();
                    int age = sc_element.nextInt();
                    String date = sc_element.next();

                    // On met en format la date grâce à un formateur de date "DateTimeFormatter"
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    // Conversion de la chaîne en LocalDate en utilisant le formateur
                    LocalDate localDate = LocalDate.parse(date, formatter);

                    Personne personne = new Personne(prenom, nom, age, localDate);
                    listePersonne.add(personne);
            }
            return listePersonne;
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        }
        return null;
    }
}
