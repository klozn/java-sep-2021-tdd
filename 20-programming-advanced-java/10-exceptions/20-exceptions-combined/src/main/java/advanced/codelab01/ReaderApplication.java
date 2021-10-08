package advanced.codelab01;

import java.net.URISyntaxException;

public class ReaderApplication {

    public static void main(String[] args) {

        String fileName1 = "/codelab06/example.txt";
        String fileName2 = "/codelab06/scores.csv";
        String nonExistingFileName = "NON_EXISTING_FILE.txt";
        String separator = "========================";

        MyFileReader myFileReader = new MyFileReader();
        myFileReader.read(fileName1);
        System.out.println(separator);
        myFileReader.read(fileName2);
        myFileReader.read(nonExistingFileName);
        System.out.println(separator);
        System.out.println(separator);
        try {
            myFileReader.readFile(fileName1);
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(separator);
        try {
            myFileReader.readFile(fileName2);
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(separator);
        System.out.println(separator);
        try {
            myFileReader.readFileClean(fileName1);
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(separator);
        try {
            myFileReader.readFileClean(fileName2);
        } catch (URISyntaxException e) {
            System.err.println(e.getMessage());
        }
    }

}
