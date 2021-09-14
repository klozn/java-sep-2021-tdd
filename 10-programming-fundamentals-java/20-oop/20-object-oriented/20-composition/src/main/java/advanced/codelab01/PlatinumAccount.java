package advanced.codelab01;

import basic.codelab03.Account;
import basic.codelab03.AccountOwner;

public class PlatinumAccount extends Account {
    public PlatinumAccount(double balance, AccountOwner owner) {
        super(balance, owner);
    }

    @Override
    public void withdraw(double amount) {
        setBalance(getBalance() - amount);
        System.out.println("We have withdrawn €" + amount + " from your balance.");
    }
}
