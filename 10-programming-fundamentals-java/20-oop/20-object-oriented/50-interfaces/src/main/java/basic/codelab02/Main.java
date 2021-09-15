package basic.codelab02;

import basic.codelab02.elements.Image;
import basic.codelab02.elements.Table;

public class Main {
    public static void main(String[] args) {
        Browser.multiDownload(new Downloadable[] {
                new Table(5,7),
                new Table(6,3),
                new Image("../../whatever.jpg", 500, 350),
                new Image("./niceGif.gif", 700, 700)
        });
    }
}
