package lambdas.basic.codelab01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    static List<Footballer> footballers;
    static Team team;

    @BeforeAll
    static void init() {
        footballers = initFootballers();
        team = new Team(footballers);
    }

    @Test
    void sortFootballersAttackingScoreDescendingTest() {
        team.sortFootballersAttackingScoreDescending();
        int firstAttackingScore = team.getFootballers().get(0).getAttackingScore();
        assertEquals(100, firstAttackingScore);
    }

    @Test
    void sortFootballersAttackingScoreAscendingTest() {
        team.sortFootballersAttackingScoreAscending();
        int firstAttackingScore = team.getFootballers().get(0).getAttackingScore();
        assertEquals(10, firstAttackingScore);
    }

    @Test
    void sortFootballersDefendingScoreDescendingTest() {
        team.sortFootballersDefendingScoreDescending();
        int firstDefendingScore = team.getFootballers().get(0).getDefendingScore();
        assertEquals(100, firstDefendingScore);
    }

    @Test
    void sortFootballersDefendingScoreAscendingTest() {
        team.sortFootballersDefendingScoreAscending();
        int firstDefendingScore = team.getFootballers().get(0).getDefendingScore();
        assertEquals(20, firstDefendingScore);
    }

    @Test
    void sortFootballersAverageScoreDescendingTest() {
        team.sortFootballersAverageScoreDescending();
        int firstAttackingScore = team.getFootballers().get(0).getAttackingScore();
        int firstDefendingScore = team.getFootballers().get(0).getDefendingScore();
        assertEquals(90, firstAttackingScore);
        assertEquals(80, firstDefendingScore);
    }

    private static List<Footballer> initFootballers() {
        return Arrays.asList(
                new Footballer(90, 80),
                new Footballer(80, 50),
                new Footballer(70, 90),
                new Footballer(100, 60),
                new Footballer(30, 20),
                new Footballer(20, 25),
                new Footballer(10, 100));
    }
}