public class Account {
    private String accountNumber;
    private double balance;

    // Builder d'instance
    public Account(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String toString(){
        return "Account<accountNumber=" + accountNumber + ", balance=" + balance + ">";
    }

    public double getBalance() {

        return balance;
    }

    public String getAccountNumber(){
        return accountNumber;
    }

    public void credit(double amount){
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Error: cannot credit negative amount.");
        }
    }

    public void debit(double amount){
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Error: cannot debit negative amount or overdraft account.");
        }
    }
}