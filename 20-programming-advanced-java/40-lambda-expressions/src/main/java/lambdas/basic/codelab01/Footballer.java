package lambdas.basic.codelab01;

public class Footballer {
    private int attackingScore;
    private int defendingScore;

    public Footballer(int attackingScore, int defendingScore) {
        setAttackingScore(attackingScore);
        setDefendingScore(defendingScore);
    }

    public void setAttackingScore(int attackingScore) {
        if (attackingScore > 100 || attackingScore < 0) {
            throw new IllegalArgumentException("0 <= (attacking score) <= 100");
        }
        this.attackingScore = attackingScore;
    }

    public void setDefendingScore(int defendingScore) {
        if (defendingScore > 100 || defendingScore < 0) {
            throw new IllegalArgumentException("0 <= (defending score) <= 100");
        }
        this.defendingScore = defendingScore;
    }

    public int getAverageScore() {
        return attackingScore * defendingScore / 2;
    }

    public int getAttackingScore() {
        return attackingScore;
    }

    public int getDefendingScore() {
        return defendingScore;
    }
}
