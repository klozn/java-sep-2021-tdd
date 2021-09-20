package codelab05;

import java.util.Arrays;

public class Alarm {
    private final static String DEFAULT_SOUND = "BEEP";
    private final static int DEFAULT_ALARM_REPEATS = 3;
    private final String soundToMake;

    public Alarm() {
        this(DEFAULT_SOUND);
    }

    public Alarm(String soundToMake) {
        this.soundToMake = soundToMake;
    }

    public String[] makeSound() {
        return makeSound(DEFAULT_ALARM_REPEATS);
    }

    public String[] makeSound(int nrOfTimes) {
        if (nrOfTimes < 0) {
            throw new IllegalArgumentException("Argument can't be negative.");
        }
        String[] sounds = new String[nrOfTimes];
        Arrays.fill(sounds, soundToMake);
        return sounds;
    }
}
