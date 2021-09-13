package basic.codelab03;

import java.util.Scanner;

/**
 * Read the README.md file
 */
public class BankRunner {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter account owner's firstname");
        String firstName = scan.next();
        System.out.println("Enter account owner's lastname");
        String lastName = scan.next();
        System.out.println("Enter account's initial balance");
        double balance = scan.nextDouble();

        AccountOwner owner = new AccountOwner(firstName, lastName);
        Account account = new Account(balance, owner);
        System.out.println(account);

        System.out.println("Enter amount to withdraw");
        double withdrawal = scan.nextDouble();
        account.withdraw(withdrawal);
        System.out.println(account);

        System.out.println("Enter amount to deposit");
        double deposit = scan.nextDouble();
        account.deposit(deposit);
        System.out.println(account);
    }

}
