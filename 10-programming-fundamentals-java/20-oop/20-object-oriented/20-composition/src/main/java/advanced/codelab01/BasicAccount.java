package advanced.codelab01;

import basic.codelab03.Account;
import basic.codelab03.AccountOwner;

public class BasicAccount extends Account {

    public BasicAccount(double balance, AccountOwner owner) {
        super(balance, owner);
        setMaxWithdraw(1000);
    }
}
