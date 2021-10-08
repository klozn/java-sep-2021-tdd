package lambdas.basic.codelab01;

import java.util.Comparator;
import java.util.List;

public class Team {
    private final List<Footballer> footballers;

    public Team(List<Footballer> footballers) {
        this.footballers = footballers;
    }

    public List<Footballer> getFootballers() {
        return footballers;
    }

    void sortFootballersAttackingScoreDescending() {
        footballers.sort((f1, f2) -> -Integer.compare(f1.getAttackingScore(), f2.getAttackingScore()));
    }

    void sortFootballersAttackingScoreAscending() {
        footballers.sort(Comparator.comparingInt(Footballer::getAttackingScore));
    }

    void sortFootballersDefendingScoreDescending() {
        footballers.sort((f1, f2) -> -Integer.compare(f1.getDefendingScore(), f2.getDefendingScore()));
    }

    void sortFootballersDefendingScoreAscending() {
        footballers.sort(Comparator.comparingInt(Footballer::getDefendingScore));
    }

    void sortFootballersAverageScoreDescending() {
        footballers.sort((f1, f2) -> -Integer.compare(f1.getAverageScore(), f2.getAverageScore()));
    }
}
