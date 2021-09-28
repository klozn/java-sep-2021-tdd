package basic.codelab02;

import java.util.List;

public class NameApp {
    public static void main(String[] args) {
        NameGenerator.generateFunnyNames().forEach(System.out::println);
        System.out.println(NameGenerator.generateNormalNames().get(0));
        List<String> seriousNames = NameGenerator.generateSeriousNames();
        System.out.println(seriousNames.get(seriousNames.size() - 1));

    }
}
