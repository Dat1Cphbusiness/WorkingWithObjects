public class BankAccount {
    
    private String accountHolder;
    private double balance;
    
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }
    
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " kr. New balance: " + balance + " kr.");
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " kr. New balance: " + balance + " kr.");
        } else {
            System.out.println("Insufficient funds! Balance: " + balance + " kr.");
        }
    }
    
    public void showBalance() {
        System.out.println(accountHolder + "'s balance: " + balance + " kr.");
    }
    
    public void transfer(BankAccount other, double amount) {
        if (balance >= amount) {
            balance -= amount;
            other.balance += amount;
            System.out.println("Transferred " + amount + " kr to " + other.accountHolder);
        } else {
            System.out.println("Cannot transfer. Insufficient funds!");
        }
    }
}
