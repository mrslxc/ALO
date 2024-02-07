public class AccountTest {
    public static void main(String[] args) {
        testerDebitNegatif();
    }

    private static void testerAffichage() {
        Account account1 = new Account("A1");
        System.out.println(account1);
    }
    private static void testerGetBalance() {
        Account account2 = new Account("1234");
        System.out.println("Après construction, le solde devrait être de 0. Obtenu: " + account2.getAccountBalance());
    }

    public static void testerCredit() {
        Account account1 = new Account("A1");
        account1.Credit(50);
        System.out.println("Après crédit du compte, le compte est désormais à " + account1.getAccountBalance());
        account1.Credit(20.5);
        System.out.println("Après crédit du compte, le compte est désormais à " + account1.getAccountBalance());
    }

    public static void testerDebit() {
        Account account2 = new Account("A2");
        account2.Debit(50);
        System.out.println("Après débit du compte, le compte est désormais à " + account2.getAccountBalance());
        account2.Debit(20.5);
        System.out.println("Après débit du compte, le compte est désormais à " + account2.getAccountBalance());
    }

    public static void testerCreditNegatif() {
        Account account3 = new Account("A3");
        System.out.println("Solde du compte : " + account3.getAccountBalance());
        account3.Credit(-20);
        System.out.println("Ajout de -20 dans le solde du compte : " + account3.getAccountBalance());
        account3.Credit(50);
        System.out.println("Ajout de 50 dans le solde du compte : " + account3.getAccountBalance());
    }

    public static void testerDebitNegatif() {
        Account account4 = new Account("A4");
        System.out.println("Solde du compte : " + account4.getAccountBalance());
        account4.Debit(100);
        System.out.println("Débit de -20 dans le solde du compte : " + account4.getAccountBalance());
        account4.Debit(50);
        System.out.println("Débit de 50 dans le solde du compte : " + account4.getAccountBalance());
    }
}
