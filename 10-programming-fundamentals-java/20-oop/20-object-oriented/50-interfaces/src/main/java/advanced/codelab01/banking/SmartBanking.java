package advanced.codelab01.banking;

public class SmartBanking implements BankingFacade {
    private double balance;
    public final static int MAX_DEPOSIT = 14500;

    public SmartBanking(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public double withdraw(String uncheckedAmount) {
        double maxWithdrawal = getBalance() / 2;
        double withdrawal = 0;
        try {
            withdrawal = Math.abs(Double.parseDouble(uncheckedAmount));
        } catch (NumberFormatException ignored) {
        }
        if (withdrawal <= maxWithdrawal) {
            setBalance(getBalance() - withdrawal);
        }
        return getBalance();
    }

    @Override
    public double deposit(String uncheckedAmount) {
        double deposit = 0;
        try {
            deposit = Math.abs(Double.parseDouble(uncheckedAmount));
        } catch (NumberFormatException ignored) {
        }
        if (deposit <= MAX_DEPOSIT) {
            setBalance(getBalance() + deposit);
        }
        return getBalance();
    }
}
