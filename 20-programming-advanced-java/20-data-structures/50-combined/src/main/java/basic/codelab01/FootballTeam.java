package basic.codelab01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FootballTeam {
    private final List<Footballer> footballers;

    public FootballTeam() {
        this.footballers = new ArrayList<>();
    }

    public void addAllFootballers(List<Footballer> footballers) {
        this.footballers.addAll(footballers);
    }

    public List<Footballer> getFootballersSortedByBirthdayDesc() {
        Collections.sort(footballers);
        return footballers;
    }

    public List<Footballer> getFootballersSortedByShirtNumberAsc() {
        footballers.sort(new FootballerShirtNumberComparator());
        return footballers;
    }

    public List<Footballer> getFootballersSortedByPosition() {
        footballers.sort(new FootballerPositionComparator());
        return footballers;
    }
}
