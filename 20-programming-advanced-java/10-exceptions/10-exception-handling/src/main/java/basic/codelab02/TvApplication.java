package basic.codelab02;

public class TvApplication {
    public static void main(String[] args) {
        Television tv = new Television();

        try {
            tv.turnOn();
        } catch (IllegalStateException ise) {
            System.err.println(ise.getMessage());
        }
        tv.plugIn();
        tv.turnOn();
        try {
            tv.switchChannelTo(90);
        } catch (IllegalStateException ise) {
            System.err.println(ise.getMessage());
        } catch (IllegalArgumentException iae) {
            System.err.println("INVALID ARGUMENT: " + iae.getMessage());
        } finally {
            System.out.println(tv);
        }
    }
}
