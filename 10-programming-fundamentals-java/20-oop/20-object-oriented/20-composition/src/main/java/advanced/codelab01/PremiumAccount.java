package advanced.codelab01;

import basic.codelab03.Account;
import basic.codelab03.AccountOwner;

public class PremiumAccount extends Account {

    public PremiumAccount(double balance, AccountOwner owner) {
        super(balance, owner);
        setMaxWithdraw(2000);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getMaxWithdraw()) {
            System.out.println("The amount exceeds the withdrawal limit of €" + getMaxWithdraw() +".");
        } else if (getBalance() <= 0) {
            System.out.println("You don't have any money.");
        } else {
            setBalance(getBalance() - amount);
            System.out.println("We have withdrawn " + amount + " from your balance.");
        }
    }
}
