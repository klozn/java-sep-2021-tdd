package basic.codelab01;

public class Musician {

    public void play() {
        Instrument instrument = new Instrument();
        instrument.makeNoise();
    }

    private class Instrument {
        void makeNoise() {
            System.out.println("Instrument noises.");
        }
    }
}
