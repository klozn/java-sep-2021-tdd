package basic.codelab01;

import java.util.Comparator;

public class FootballerPositionComparator implements Comparator<Footballer> {
    @Override
    public int compare(Footballer o1, Footballer o2) {
        return Integer.compare(o1.getPosition().getOrderWeight(), o2.getPosition().getOrderWeight());
    }

}
