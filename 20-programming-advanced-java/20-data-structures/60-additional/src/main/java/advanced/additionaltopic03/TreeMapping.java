package advanced.additionaltopic03;

import java.util.TreeMap;

public class TreeMapping {
    public static void main(String[] args) {
        TreeMap<Integer, User> userMap = new TreeMap<>();
        userMap.put(5, new User(5, "five"));
        userMap.put(3, new User(3, "three"));
        userMap.put(7, new User(7, "seven"));
        userMap.put(1, new User(1, "one"));
        userMap.put(4, new User(4, "four"));
        userMap.put(9, new User(9, "nine"));
        userMap.put(4, new User(4, "four"));

        System.out.println(userMap.floorEntry(50));
        System.out.println(userMap.descendingMap().floorEntry(-20));
        System.out.println(userMap.headMap(7, false));

        System.out.println(userMap.lastKey());
        System.out.println(userMap.firstEntry());
    }
}
