package basic.codelab03;

import java.util.Random;

/**
 * Read the README.md file
 */
public class Account {
    private static int accountCounter;

    private double balance;
    private AccountOwner owner;
    private long accountNumber;
    private int maxWithdraw;

    public Account(double balance, AccountOwner owner) {
        this.balance = balance;
        this.owner = owner;
        Random random = new Random();
        accountNumber = random.nextInt(50_000_000);
        accountCounter++;
        setMaxWithdraw(5000);
    }

    public static int getNumberOfAccounts() {
        return accountCounter;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void setMaxWithdraw(int maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    public int getMaxWithdraw() {
        return maxWithdraw;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void withdraw(double amount) {
        if (amount > maxWithdraw) {
            System.out.println("The amount exceeds the withdrawal limit of €" + maxWithdraw +".");
        } else if (balance - amount < 0) {
            System.out.println("The amount exceeds your balance.");
        } else {
            balance -= amount;
            System.out.println("We have withdrawn €" + amount + " from your balance.");
        }
    }

    public void deposit(double amount) {
        if (amount > 80_000) {
            System.out.println("The amount exceeds the depositing limit of €80,000.");
        } else {
            balance += amount;
            System.out.println("We have deposited €" + amount + " to you balance.");
        }
    }

    @Override
    public String toString() {
        return String.format("Account with number %d and owner %s has balance %.2f",
                getAccountNumber(), owner, getBalance());
    }
}
