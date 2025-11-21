public class BankSystem {
    
    // Static fields - shared across all accounts
    private static double totalDeposits = 0.0;
    private static double totalWithdrawals = 0.0;
    private static int accountCount = 0;
    private static final double TRANSACTION_FEE = 5.0;
    
    // Instance fields
    private String accountNumber;
    private String holder;
    private double balance;
    
    // Constructor
    public BankSystem(String accountNumber, String holder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holder = holder;
        this.balance = initialBalance;
        accountCount++;
        totalDeposits += initialBalance;
    }
    
    // Static methods
    public static int getAccountCount() {
        return accountCount;
    }
    
    public static double getTotalDeposits() {
        return totalDeposits;
    }
    
    public static double getTotalWithdrawals() {
        return totalWithdrawals;
    }
    
    public static double getTransactionFee() {
        return TRANSACTION_FEE;
    }
    
    public static double getNetFlow() {
        return totalDeposits - totalWithdrawals;
    }
    
    public static void displaySystemStats() {
        System.out.println("=== Bank System Statistics ===");
        System.out.println("Total Accounts: " + accountCount);
        System.out.println("Total Deposits: " + totalDeposits + " kr");
        System.out.println("Total Withdrawals: " + totalWithdrawals + " kr");
        System.out.println("Net Flow: " + getNetFlow() + " kr");
        System.out.println("Transaction Fee: " + TRANSACTION_FEE + " kr");
    }
    
    public static void resetSystem() {
        totalDeposits = 0.0;
        totalWithdrawals = 0.0;
        accountCount = 0;
        System.out.println("Bank system reset.");
    }
    
    // Instance methods
    public String getAccountNumber() {
        return this.accountNumber;
    }
    
    public String getHolder() {
        return this.holder;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void deposit(double amount) {
        this.balance += amount;
        totalDeposits += amount;
        System.out.println(holder + " deposited " + amount + " kr. New balance: " + this.balance + " kr");
    }
    
    public void withdraw(double amount) {
        double totalAmount = amount + TRANSACTION_FEE;
        if (this.balance >= totalAmount) {
            this.balance -= totalAmount;
            totalWithdrawals += amount;
            System.out.println(holder + " withdrew " + amount + " kr (fee: " + TRANSACTION_FEE + " kr). New balance: " + this.balance + " kr");
        } else {
            System.out.println("Insufficient funds for " + holder);
        }
    }
    
    public void displayInfo() {
        System.out.println("Account: " + this.accountNumber);
        System.out.println("Holder: " + this.holder);
        System.out.println("Balance: " + this.balance + " kr");
    }
}
