package advanced.codelab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SwapperTest {

    @Test
    void swapPositionsReturnsExpectedResult() {
        var swapper = new Swapper();
        var ints = new Integer[] {3, 1, 7, 6, 2, 33};

        var swappedInts = swapper.swapPositions(ints, 1, 4);

        assertArrayEquals(new Integer[]{3, 2, 7, 6, 1, 33}, swappedInts);
    }
}