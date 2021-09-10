package codelab07;

import java.util.Objects;

public class BankAccount {
    private String accountNumber;
    private String name;
    private int balance;

    public BankAccount(String accountNumber, String name) {
        this.accountNumber = accountNumber;
        this.name = name;
    }

    public BankAccount(String accountNumber, String name, int balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int credit(int amount) {
        balance += amount;
        return balance;
    }

    public int debit(int amount) {
        if (amount < balance) {
            balance -= amount;
            return balance;
        }
        System.out.println("The amount can not be subtracted.");
        return balance;
    }

    public int transfer(int amount, BankAccount receivingBankAccount) {
        if (amount < balance) {
            this.debit(amount);
            receivingBankAccount.credit(amount);
            return balance;
        }
        System.out.println("The amount can not be transferred.");
        return balance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BankAccount{");
        sb.append("accountNumber='").append(accountNumber).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return accountNumber.equals(that.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }
}
