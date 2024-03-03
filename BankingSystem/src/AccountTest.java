public class AccountTest {
    public static void main(String[] args) {
        testerAffichage();
        testerGetBalance();
        testerCredit();
        testerDebit();
    }

    public static void testerAffichage(){
        Account account1 = new Account("A1");
        System.out.println("Voici mon compte: " + account1);
    }

    private static void testerGetBalance() {
        Account a = new Account("134");
        System.out.println("Après construction, le solde devrait être 0. Obtenu: " + a.getBalance());
    }

    public static double testerCredit(){
        Account account1 = new Account("A1");
        account1.credit(50);
        System.out.println("Après crédit de 50 le solde devrait être de 50. Obtenu: \t"+account1.getBalance());
        account1.credit(20.5);
        System.out.println("Après crédit de 20.5 le solde devrait être de 70.5 Obtenu: \t"+account1.getBalance());
        return account1.getBalance();
    }

    public static double testerDebit(){
        Account account1 = new Account("A1");
        account1.debit(50);
        System.out.println("Après débit de 50 le solde devrait être de -50. Obtenu: \t"+account1.getBalance());
        account1.debit(20.5);
        System.out.println("Après crédit de 50+20.5 le solde devrait être de -70.5 Obtenu: \t"+account1.getBalance());
        return account1.getBalance();
    }
}