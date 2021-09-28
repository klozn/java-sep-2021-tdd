package advanced.codelab02.movies;

public class ChildrensMovie extends Movie {
    public static final int PRICE_CODE = 2;

    public ChildrensMovie(String title) {
        super(title, PRICE_CODE);
    }
}
