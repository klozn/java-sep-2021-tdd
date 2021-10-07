package basic.selfeval.codelab02;

import basic.selfeval.codelab02.elements.Button;
import basic.selfeval.codelab02.elements.Image;
import basic.selfeval.codelab02.elements.Table;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Browser.multiDownload(List.of(
                new Table(5,7),
                new Table(6,3),
                new Image("../../whatever.jpg", 500, 350),
                new Image("./niceGif.gif", 700, 700)
        ));

        List.of(new Button("myButton"), new Image("./myImage.jpg", 50, 50))
                .forEach(c -> System.out.println(c.doubleClick()));
    }
}
