package advanced.codelab01;

import advanced.codelab01.domain.HarryPotterBook;
import advanced.codelab01.domain.HarryPotterBookTitle;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Read the README.md.
 */
public class BookService {
    public static final double[] PERCENTAGES = {0, 5, 10, 20, 25};

    public double calculateTotalPrice(ArrayList<HarryPotterBook> books) {
        if (books.size() == 1) {
            return HarryPotterBook.BASE_PRICE;
        }
        HashMap<HarryPotterBookTitle, Integer> bookTitleOccurrenceMap = getBookTitleOccurrenceMap(books);
        int amountOfUniqueBooks = bookTitleOccurrenceMap.size();
        double discountPrice = calculateDiscountPrice(amountOfUniqueBooks);
        double totalPrice = 0;

        for (int amount : bookTitleOccurrenceMap.values()) {
            totalPrice += amount * HarryPotterBook.BASE_PRICE;
        }

        if (amountOfUniqueBooks > 1) {
            return totalPrice + discountPrice - (amountOfUniqueBooks * HarryPotterBook.BASE_PRICE);
        }
        return totalPrice;
    }

    private HashMap<HarryPotterBookTitle, Integer> getBookTitleOccurrenceMap(ArrayList<HarryPotterBook> books) {
        HashMap<HarryPotterBookTitle, Integer> bookTitleOccurrenceMap = new HashMap<>();
        for (HarryPotterBook book : books) {
            HarryPotterBookTitle title = book.getTitleOfBook();
            if (bookTitleOccurrenceMap.containsKey(title)) {
                bookTitleOccurrenceMap.put(title, bookTitleOccurrenceMap.get(title) + 1);
            } else {
                bookTitleOccurrenceMap.put(title, 1);
            }
        }
        return bookTitleOccurrenceMap;
    }

    private double calculateDiscountPrice(int amountOfUniqueBooks) {
        double percentage = PERCENTAGES[amountOfUniqueBooks - 1];
        return amountOfUniqueBooks * HarryPotterBook.BASE_PRICE * ((100 - percentage) / 100);
    }
}
