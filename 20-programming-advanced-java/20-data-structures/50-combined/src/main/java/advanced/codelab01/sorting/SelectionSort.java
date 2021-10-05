package advanced.codelab01.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectionSort implements SortingAlgorithm {

    @Override
    public List<Integer> sort(List<Integer> listToSort) {
        List<Integer> copy = new ArrayList<>(listToSort);
        for (int i = 0; i < copy.size() - 1; i++) {
            int indexOfLowest = i;
            for (int j = i + 1; j < copy.size(); j++) {
                if (copy.get(indexOfLowest) > copy.get(j)) {
                    indexOfLowest = j;
                }
            }
            if (indexOfLowest != i) {
                Collections.swap(copy, i, indexOfLowest);
            }
        }
        return copy;
    }

}
