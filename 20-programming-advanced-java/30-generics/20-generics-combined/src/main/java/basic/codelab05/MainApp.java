package basic.codelab05;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<String> simpleListStrings = new SimpleList<>();
        simpleListStrings.add("Hello");
        simpleListStrings.add("World");
        String shouldHoldHello = simpleListStrings.get(0);
        int theSizeShouldBe2 = simpleListStrings.size();

        System.out.println(shouldHoldHello + " " + theSizeShouldBe2);

        List<Integer> simpleListInts = new SimpleList<>();
        simpleListInts.add(5);
        simpleListInts.add(6);
        Integer shouldHold6 = simpleListInts.get(1);

        System.out.println(shouldHold6);

    }
}
