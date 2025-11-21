public class BankAccount2 {
    
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;
    private double interestRate;
    
    // Constructor with account number and holder only
    public BankAccount2(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0;
        this.accountType = "Checking";
        this.interestRate = 0.01;
    }
    
    // Constructor with initial balance
    public BankAccount2(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = "Checking";
        this.interestRate = 0.01;
    }
    
    // Constructor with account type
    public BankAccount2(String accountNumber, String accountHolder, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = accountType;
        
        // Set interest rate based on account type
        if (accountType.equals("Savings")) {
            this.interestRate = 0.03;
        } else if (accountType.equals("Premium")) {
            this.interestRate = 0.05;
        } else {
            this.interestRate = 0.01;
        }
    }
    
    // Constructor with all parameters
    public BankAccount2(String accountNumber, String accountHolder, double initialBalance, String accountType, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.interestRate = interestRate;
    }
    
    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }
    
    public String getAccountHolder() {
        return accountHolder;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public String getAccountType() {
        return accountType;
    }
    
    public double getInterestRate() {
        return interestRate;
    }
    
    // Setters
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    
    // Helper methods
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " kr. New balance: " + balance + " kr");
    }
    
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrew " + amount + " kr. New balance: " + balance + " kr");
        } else {
            System.out.println("Insufficient funds!");
        }
    }
    
    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest applied: " + interest + " kr. New balance: " + balance + " kr");
    }
    
    public void displayInfo() {
        System.out.println("=== Account " + accountNumber + " ===");
        System.out.println("Holder: " + accountHolder);
        System.out.println("Type: " + accountType);
        System.out.println("Balance: " + balance + " kr");
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
    }
}
