package advanced.codelab01.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort implements SortingAlgorithm {

    @Override
    public List<Integer> sort(List<Integer> listToSort) {
        int listSize = listToSort.size();
        List<Integer> copy = new ArrayList<>(listToSort);
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < listSize; i++) {
                if (copy.get(i - 1) > copy.get(i)) {
                    Collections.swap(copy, i -1, i);
                    swapped = true;
                }
            }
        } while (swapped);
        return copy;
    }

}
