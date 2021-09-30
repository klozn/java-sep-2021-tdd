package basic.codelab01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FootballTeamTest {
    private static FootballTeam testTeam = new FootballTeam();

    @BeforeAll
    static void init() {
        testTeam.addAllFootballers(
                List.of(new Footballer("jean", LocalDate.of(1993, 4, 21), "11", Position.MIDFIELDER),
                        new Footballer("jaques", LocalDate.of(1983, 1, 21), "1", Position.GOALKEEPER),
                        new Footballer("jeff", LocalDate.of(1994, 4, 21), "20", Position.STRIKER),
                        new Footballer("jules", LocalDate.of(1995, 4, 21), "7", Position.DEFENDER),
                        new Footballer("joachim", LocalDate.of(1990, 4, 21), "13", Position.MIDFIELDER)));
    }

    @Test
    void getFootballersSortedByBirthdayTest() {
        List<Footballer> footballers = testTeam.getFootballersSortedByBirthdayDesc();
        assertEquals(new Footballer("jules", LocalDate.of(1995, 4, 21)), footballers.get(0));
        assertEquals(new Footballer("jeff", LocalDate.of(1994, 4, 21)), footballers.get(1));
        assertEquals(new Footballer("jean", LocalDate.of(1993, 4, 21)), footballers.get(2));
        assertEquals(new Footballer("joachim", LocalDate.of(1990, 4, 21)), footballers.get(3));
        assertEquals(new Footballer("jaques", LocalDate.of(1983, 1, 21)), footballers.get(4));
    }

    @Test
    void getFootballersSortedByShirtNumberTest() {
        List<Footballer> footballers = testTeam.getFootballersSortedByShirtNumberAsc();
        assertEquals(new Footballer("jaques", LocalDate.of(1983, 1, 21)), footballers.get(0));
        assertEquals(new Footballer("jules", LocalDate.of(1995, 4, 21)), footballers.get(1));
        assertEquals(new Footballer("jean", LocalDate.of(1993, 4, 21)), footballers.get(2));
        assertEquals(new Footballer("joachim", LocalDate.of(1990, 4, 21)), footballers.get(3));
        assertEquals(new Footballer("jeff", LocalDate.of(1994, 4, 21)), footballers.get(4));
    }

    @Test
    void getFootballersSortedByPositionTest() {
        List<Footballer> footballers = testTeam.getFootballersSortedByPosition();
        assertEquals(new Footballer("jean", LocalDate.of(1993, 4, 21)), footballers.get(0));
        assertEquals(new Footballer("joachim", LocalDate.of(1990, 4, 21)), footballers.get(1));
        assertEquals(new Footballer("jules", LocalDate.of(1995, 4, 21)), footballers.get(2));
        assertEquals(new Footballer("jaques", LocalDate.of(1983, 1, 21)), footballers.get(3));
        assertEquals(new Footballer("jeff", LocalDate.of(1994, 4, 21)), footballers.get(4));
    }
}