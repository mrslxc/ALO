import java.time.LocalDate;
import java.util.List;

public class Billeterie {
    public static void main(String[] args) {
        Ville Montreux = new Ville("Montreux", 3);
        Ville Bruxelles = new Ville("Bruxelles", 2.7);
        Ville Carouge = new Ville("Carouge", 3.8);

        Salle Stravinsky = new Salle(75, 20, 20, 10, Montreux);
        Salle Arena = new Salle(100, 30, 30, 15, Bruxelles);
        Salle ChatNoir = new Salle(15, 6, 6, 3, Carouge);

        Concert Mozart = new Concert("Mozart", LocalDate.of(2020, 07, 25),0,  Stravinsky);
        Concert Chopin = new Concert("Chopin", LocalDate.of(2020, 07, 26), 0, Stravinsky);
        Concert Stromae = new Concert("Stromae", LocalDate.of(2020, 10, 10), 0, Arena);
        Concert Angele = new Concert("Angèle", LocalDate.of(2020, 03, 13), 0, ChatNoir);

        Concert[] ListeConcert = new Concert[] {Mozart, Chopin, Stromae, Angele};
        
        for (Concert UnConcert : ListeConcert ) {
            for (int i = 0; i < 8000; i++) {
                UnConcert.setNbTicketsVendus(1);
            }
            System.out.println(UnConcert.toString());
        }
    }
}
