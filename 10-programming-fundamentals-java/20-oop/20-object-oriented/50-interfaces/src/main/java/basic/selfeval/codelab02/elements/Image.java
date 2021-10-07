package basic.selfeval.codelab02.elements;

import basic.selfeval.codelab02.Clickable;
import basic.selfeval.codelab02.Downloadable;

public class Image implements Clickable, Downloadable {

    private final String url;
    private final int heightInPixel;
    private final int widthInPixel;

    public Image(String url, int heightInPixel, int widthInPixel) {
        this.url = url;
        this.heightInPixel = heightInPixel;
        this.widthInPixel = widthInPixel;
    }

    public String getUrl() {
        return url;
    }

    public String getDimensions() {
        return widthInPixel + "x" + heightInPixel;
    }

    @Override
    public String click() {
        return "Clicked on Image";
    }

    @Override
    public String doubleClick() {
        return "Double clicked on image";
    }

    @Override
    public String download() {
        return getUrl();
    }
}
