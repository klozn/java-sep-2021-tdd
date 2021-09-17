package codelab05;

public class Alarm {
    private String soundToMake;

    public Alarm() {
        this("BEEP");
    }

    public Alarm(String soundToMake) {
        this.soundToMake = soundToMake;
    }

    public String[] makeSound() {
        return new String[]{soundToMake, soundToMake, soundToMake};
    }

    public String[] makeSound(int nrOfTimes) {
        if (nrOfTimes < 0) {
            throw new IllegalArgumentException("Argument can't be negative.");
        }
        String[] sounds = new String[nrOfTimes];
        for (int i = 0; i < nrOfTimes; i++) {
            sounds[i] = soundToMake;
        }
        return sounds;
    }
}
