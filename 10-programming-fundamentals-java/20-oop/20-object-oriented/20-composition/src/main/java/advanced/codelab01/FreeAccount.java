package advanced.codelab01;

import basic.codelab03.Account;
import basic.codelab03.AccountOwner;

public class FreeAccount extends Account {

    public FreeAccount(double balance, AccountOwner owner) {
        super(balance, owner);
        setMaxWithdraw(100);
    }
}
