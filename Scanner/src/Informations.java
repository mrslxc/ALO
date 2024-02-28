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
            while (sc_ligne.hasNextLine()) {
                Scanner sc_element = new Scanner(sc_ligne.nextLine());
                sc_element.useDelimiter(";");
                while (sc_element.hasNext()) {
                    String prenom = sc_element.next();
                    String nom = sc_element.next();
                    int age = sc_element.nextInt();
                    String date = sc_element.next();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    // Conversion de la chaîne en LocalDate en utilisant le formateur
                    LocalDate localDate = LocalDate.parse(date, formatter);

                    Personne personne = new Personne(prenom, nom, age, localDate);
                    listePersonne.add(personne);
                }
            }
            return listePersonne;
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas");
        }
        return null;
    }
}
