import java.util.Scanner;
import java.util.ArrayList;

public class Exo1 {
    public static void main(String[] args) {
        String Listemot = "Hello World !";
        ScannerTexte(Listemot);
    }

    public static void ScannerTexte(String texte) {
        Scanner scanner = new Scanner(texte);
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
