import java.time.LocalDate;

public class Billeterie {
    public static void main(String[] args) {
        Ville Montreux = new Ville("Montreux", 3);
        Ville Bruxelles = new Ville("Bruxelles", 2.7);
        Ville Carouge = new Ville("Carouge", 3.8);

        Salle Stravinsky = new Salle(75, 20, 20, 10, Montreux);
        Salle Arena = new Salle(100, 30, 30, 15, Bruxelles);
        Salle ChatNoir = new Salle(15, 6, 6, 3, Carouge);

        Concert Mozart = new Concert("Mozart", LocalDate.of(2020, 07, 25), Stravinsky);
        Concert Chopin = new Concert("Chopin", LocalDate.of(2020, 07, 26), Stravinsky);
        Concert Stromae = new Concert("Stromae", LocalDate.of(2020, 10, 10), Arena);
        Concert Angele = new Concert("Angèle", LocalDate.of(2020, 03, 13), ChatNoir);

        acheterBillet(Stromae);
        achatBillet(Angele);
        achatBillet(Mozart);
        achatBillet(Chopin);
    }

    public static void acheterBillet(Concert nomConcert) {
        if (nomConcert.isComplet()) {
            System.out.println("Le concert est complet");
        } else {
            System.out.println("Le concert n'est pas complet");
        }
    }

    public static boolean achatUnBillet(Concert nomConcert) {
        if (nomConcert.isComplet()) {
            return false;
        } nomConcert.achatBillet();
        return true;
    }

    public static void achatBillet(Concert nomConcert) {
        for (int i = 0; i <= 8000; i++) {
            if (!achatUnBillet(nomConcert)) {
                System.out.println("Le concert est complet");
                break;
            }
        }
    }
}
