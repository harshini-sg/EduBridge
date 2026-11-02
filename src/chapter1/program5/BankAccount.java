package chapter1.program5;

public class BankAccount {
    private static int totalAccounts = 0;

    private final String accountId;      // assigned once in the constructor
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber, double openingBalance) {
        this.accountNumber = accountNumber;
        this.balance = openingBalance >= 0 ? openingBalance : 0;
        totalAccounts++;
        this.accountId = "ACC" + String.format("%04d", totalAccounts);
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be positive.");
            return false;
        }
        balance += amount;
        System.out.println("Deposited " + amount + ". New balance: " + balance);
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal rejected: invalid amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Withdrawal rejected: insufficient balance.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + ". New balance: " + balance);
        return true;
    }

    public double getBalance()        { return balance; }
    public String getAccountId()      { return accountId; }
    public String getAccountNumber()  { return accountNumber; }
    public static int getTotalAccounts() { return totalAccounts; }
}
