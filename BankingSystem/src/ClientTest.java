import java.time.LocalDate;

public class ClientTest {
    /*
    LocalDate.of(YYYY, MM, DD) = informations d'une date de manière britanique
     */
    public static void main(String[] args) {
        Client client1 = new Client("AGOSTA", "Loic", 1,
                LocalDate.of(1980, 12, 23));
        System.out.println(client1);
    }
}
