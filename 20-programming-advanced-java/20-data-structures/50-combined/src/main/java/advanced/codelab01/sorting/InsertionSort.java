package advanced.codelab01.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort implements SortingAlgorithm {

    @Override
    public List<Integer> sort(List<Integer> listToSort) {
        var copy = new ArrayList<>(listToSort);
        int i = 1;
        while (i < copy.size()) {
            int j = i;
            while (j > 0 && copy.get(j - 1) > copy.get(j)) {
                Collections.swap(copy, j, j - 1);
                j--;
            }
            i++;
        }
        return copy;
    }

}
