package advanced.codelab01;

public class ReaderApplication {

    public static void main(String[] args) {

        MyFileReader myFileReader = new MyFileReader();
        myFileReader.read("/codelab06/example.txt");
            System.out.println("========================");
        myFileReader.read("/codelab06/scores.csv");
        myFileReader.read("NON_EXISTING_FILE.txt");

    }

}
