public class Account {
    private String accountNumber;

    private double accountBalance;

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.accountBalance = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void Credit(double montant) {
        if (montant > 0) {
            System.out.println("Le montant doit être supérieur que 0");
        } else {
            accountBalance += montant;
        }
    }

    public void Debit(double montant) {
        if (montant > 0 && accountBalance >= montant) {
            accountBalance -= montant;
        } else {

            System.out.println("Un solde négatif ne peut être disponible.");
        }
    }

    @Override
    public String toString() {
        return "Numéro de compte : " + getAccountNumber() + " | Balance du compte : " + getAccountBalance();
    }
}
