import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Informations {
    public static void main(String[] args) {
        ArrayList<Personne> listePersonne = ScannerTexte("fichier_scanner.txt");
        for (Personne personnes : listePersonne) {
            System.out.println(personnes);
        }
    }

    public static ArrayList<Personne> ScannerTexte(String nomFichier) {
        Scanner sc_ligne = new Scanner(nomFichier);
        ArrayList<Personne> listePersonne = new ArrayList<>();
        while (sc_ligne.hasNextLine()) {
            Scanner sc_element = new Scanner(sc_ligne.nextLine());
            sc_element.useDelimiter(";");
                while (sc_element.hasNext()) {
                    String prenom = sc_element.next();
                    String nom = sc_element.next();
                    int age = sc_element.nextInt();
                    LocalDate date = LocalDate.of(sc_element.nextInt(), sc_element.nextInt(), sc_element.nextInt());

                    Personne personne = new Personne(prenom, nom, age, date);
                    listePersonne.add(personne);
                }

        }
        return listePersonne;
    }
}
