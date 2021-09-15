import java.util.Random;

public class RandomTester {

    public static void main(String[] args) {
        Random random1 = new Random(1);
        Random random2 = new Random(1);
        Random random3 = new Random();
        Random random4 = new Random();
        Random random5 = new Random(2);
        Random random6 = new Random(2);

        System.out.println(random1.nextInt(101));
        System.out.println(random2.nextInt(101));
        System.out.println(random3.nextInt(101));
        System.out.println(random4.nextInt(101));
        System.out.println(random5.nextInt(101));
        System.out.println(random6.nextInt(101 + 1));

    }
}
