package basic.codelab02;

public class Browser {
    public static void multiDownload(Downloadable[] elementsToDownload) {
        for (Downloadable element: elementsToDownload) {
            System.out.println(element.download());
        }
    }
}
