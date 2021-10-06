package advanced.codelab02;

import java.util.List;

public class BinarySearch {

    <T extends Comparable<T>> boolean isElementInList(T elementToSearch, List<T> listToSearchFrom) {
        int listSize = listToSearchFrom.size();
        double leftIndex = 0;
        double rightIndex = listSize - 1;
        while (leftIndex <= rightIndex) {
            int index = (int) Math.floor((leftIndex + rightIndex)/2);
            T current = listToSearchFrom.get(index);
            if (current.compareTo(elementToSearch) < 0) {
                leftIndex = index + 1;
            } else if (current.compareTo(elementToSearch) > 0) {
                rightIndex = index - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
