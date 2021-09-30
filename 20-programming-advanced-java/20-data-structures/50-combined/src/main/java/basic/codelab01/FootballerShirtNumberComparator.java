package basic.codelab01;

import java.util.Comparator;

public class FootballerShirtNumberComparator implements Comparator<Footballer> {
    @Override
    public int compare(Footballer o1, Footballer o2) {
        int number1 = Integer.parseInt(o1.getShirtNr());
        int number2 = Integer.parseInt(o2.getShirtNr());

        return Integer.compare(number1, number2);
    }
}
