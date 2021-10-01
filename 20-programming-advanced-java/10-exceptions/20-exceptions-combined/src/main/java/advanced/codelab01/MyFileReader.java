package advanced.codelab01;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class MyFileReader {

    public void read(String fileName) {
        Path pathToFile = null;
        try {
            pathToFile = Paths
                    .get(Paths.get(getClass().getResource(fileName).toURI())
                            .toString());
        } catch (NullPointerException | URISyntaxException e) {
            System.err.println(e.getMessage());
        }
        List<String> lines = null;
        try {
            lines = Files.readAllLines(pathToFile);
        } catch (NullPointerException | IOException e) {
            System.err.println(e.getMessage());
        }
        try {
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());;
        }
    }

    void readFile(String fileName) throws URISyntaxException {

        Path path = Paths.get(Paths.get(getClass().getResource(fileName).toURI()).toString());

        BufferedReader reader = null;

        try {
            reader = Files.newBufferedReader(path, Charset.forName("UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x.getMessage());
        } finally {
            if(reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.err.format("Failed to close BufferedReader: %s%n", e.getMessage());
                }
            }
        }
    }

    void readFileClean(String fileName) throws URISyntaxException {

        Path path = Paths.get(Paths.get(getClass().getResource(fileName).toURI()).toString());

        try (BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
