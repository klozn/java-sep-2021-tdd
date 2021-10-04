package advanced.codelab01;

public class Swapper {

    public <T> T[] swapPositions(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
        return array;
    }
}
