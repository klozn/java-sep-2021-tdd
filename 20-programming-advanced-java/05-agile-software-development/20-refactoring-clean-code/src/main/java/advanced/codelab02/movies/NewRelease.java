package advanced.codelab02.movies;

public class NewRelease extends Movie {
    public static final int PRICE_CODE = 1;

    public NewRelease(String title) {
        super(title, PRICE_CODE);
    }
}
