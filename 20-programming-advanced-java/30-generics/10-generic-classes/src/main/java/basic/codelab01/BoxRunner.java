package basic.codelab01;

public class BoxRunner {

    public static void main(String[] args) {

        Box<String> whatsInTheBox1 = new Box<>();
        whatsInTheBox1.store("Some simple text");
        String contentOfBox1 = whatsInTheBox1.getContentOfBox();
        System.out.printf("First content of Box: %s%n", contentOfBox1);

        Box<Integer> whatsInTheBox2 = new Box<>();
        whatsInTheBox2.store(15);
        Integer contentOfBox2 = whatsInTheBox2.getContentOfBox();
        System.out.printf("Second content of Box: %s%n", contentOfBox2);

        Box<String> whatsInTheBox3 = new Box<>();
        whatsInTheBox3.store("Again some simple text");
        //Integer contentOfBox3 = whatsInTheBox3.getContentOfBox(); // This will go wrong at runtime!

    }

}
