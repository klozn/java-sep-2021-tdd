package advanced.codelab01.domain;

/**
 * Read the README.md.
 * (the current code of this class is OK)
 */
public class HarryPotterBook {
    public final static double BASE_PRICE = 8;

    private final HarryPotterBookTitle titleOfBook;

    public HarryPotterBook(HarryPotterBookTitle titleOfBook) {
        this.titleOfBook = titleOfBook;
    }

    public HarryPotterBookTitle getTitleOfBook() {
        return titleOfBook;
    }

    @Override
    public String toString() {
        return titleOfBook.name().toLowerCase();
    }
}
