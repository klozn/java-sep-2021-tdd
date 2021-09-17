package codelab05;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Alarm defaultAlarm = new Alarm();
        System.out.println(Arrays.toString(defaultAlarm.makeSound()));
        Alarm tirolAlarm = new Alarm("HEJULAJULAHEYOOOOO");
        System.out.println(Arrays.toString(tirolAlarm.makeSound(10)));
    }
}
