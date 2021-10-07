package basic.selfeval.codelab02;

import java.util.List;

public class Browser {
    public static void multiDownload(List<Downloadable> elementsToDownload) {
        elementsToDownload.forEach(d -> System.out.println(d.download()));
    }
}
