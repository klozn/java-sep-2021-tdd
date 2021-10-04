package basic.codelab01;

public class Box<T> {

    private T contentOfBox;

    void store(T contentOfBox) {
        this.contentOfBox = contentOfBox;
    }

    T getContentOfBox() {
        return contentOfBox;
    }
}
