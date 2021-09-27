package codelab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrowthStatusTest {
    @Test
    void next_whenCalledOnSeed_thenReturnSprout() {
        GrowthStatus status = GrowthStatus.SEED;

        assertEquals(GrowthStatus.SPROUT, status.next());
    }
    @Test
    void next_whenCalledOnSprout_thenReturnPlant() {
        GrowthStatus status = GrowthStatus.SPROUT;

        assertEquals(GrowthStatus.PLANT, status.next());
    }
    @Test
    void next_whenCalledOnPlant_thenReturnTree() {
        GrowthStatus status = GrowthStatus.PLANT;

        assertEquals(GrowthStatus.TREE, status.next());
    }
    @Test
    void next_whenCalledOnTree_thenReturnTree() {
        GrowthStatus status = GrowthStatus.TREE;

        assertEquals(GrowthStatus.TREE, status.next());
    }
}