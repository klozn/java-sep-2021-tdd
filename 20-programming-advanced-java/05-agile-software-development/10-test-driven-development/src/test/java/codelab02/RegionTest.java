package codelab02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {
    class GrowableStub implements Growable {
        GrowthStatus growthStatus;

        @Override
        public void plant(Region region) {
        }

        @Override
        public void grow() {
            growthStatus = growthStatus.next();
        }
    }

    private Region region;

    @BeforeEach
    void setUpRegion() {
        region = new Region();
    }

    @Nested
    @DisplayName("Method plant:")
    class Planting {
        @Test
        @DisplayName("adds growable to growables array")
        void plant_whenGivenGrowable_thenAddsGrowableToArray() {
            //given
            Growable stub = new GrowableStub();
            //when
            region.plant(stub);
            //then
            assertEquals(stub, region.getGrowables()[0]);
        }

        @Test
        @DisplayName("when growable Array is full does nothing")
        void plant_whenGrowableArrayIsFull_thenDoesNothing() {
            //given
            fillRegion();
            Growable stub = new GrowableStub();
            //when
            region.plant(stub);
            //then
            assertNotEquals(stub, region.getGrowables()[4]);
        }
    }

    @Test
    @DisplayName("Advance season method grows all planted growables one level")
    void advanceSeason_growsAllGrowablesInRegion() {
        //given
        GrowableStub stubSeed = new GrowableStub();
        GrowableStub stubPlant = new GrowableStub();
        stubSeed.growthStatus = GrowthStatus.SEED;
        stubPlant.growthStatus = GrowthStatus.PLANT;
        region.plant(stubPlant);
        region.plant(stubSeed);
        //when
        region.advanceSeason();
        //then
        assertEquals(GrowthStatus.SPROUT, stubSeed.growthStatus);
        assertEquals(GrowthStatus.TREE, stubPlant.growthStatus);
    }

    private void fillRegion() {
        int i = 0;
        while (i < 5) {
            region.plant(new GrowableStub());
            i++;
        }
    }

}