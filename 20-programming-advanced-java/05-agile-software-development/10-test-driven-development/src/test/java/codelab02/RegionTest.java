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

    @Test
    @DisplayName("Default region has BroadLeaf as vegetation")
    void defaultRegionHasBroadLeafVegetation() {
        //when
        region = new Region();
        //then
        assertEquals(Vegetation.BROADLEAF, region.getVegetation());
    }

    @Nested
    @DisplayName("Method plant:")
    class Planting {
        @BeforeEach
        void setUpRegion() {
            region = new Region();
        }

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

    @Nested
    @DisplayName("Method advanceSeason:")
    class AdvancingSeason {
        @Test
        @DisplayName("BroadLeaf region grows all planted growables one level")
        void advanceSeason_whenBroadLeaf_thenAllGrowablesGrowOneLevels() {
            //given
            region = new Region(Vegetation.BROADLEAF);
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

        @Test
        @DisplayName("RainForrest region grows all planted growables two level")
        void advanceSeason_whenRainForrest_thenAllGrowablesGrowTwoLevels() {
            //given
            region = new Region(Vegetation.RAINFOREST);
            GrowableStub stubSeed = new GrowableStub();
            GrowableStub stubSprout = new GrowableStub();
            stubSeed.growthStatus = GrowthStatus.SEED;
            stubSprout.growthStatus = GrowthStatus.SPROUT;
            region.plant(stubSprout);
            region.plant(stubSeed);
            //when
            region.advanceSeason();
            //then
            assertEquals(GrowthStatus.PLANT, stubSeed.growthStatus);
            assertEquals(GrowthStatus.TREE, stubSprout.growthStatus);
        }

        @Test
        @DisplayName("Steppe region doesn't grow Growables")
        void advanceSeason_whenSteppe_thenDoesntGrowGrowables() {
            //given
            region = new Region(Vegetation.STEPPE);
            GrowableStub stubSeed = new GrowableStub();
            GrowableStub stubSprout = new GrowableStub();
            stubSeed.growthStatus = GrowthStatus.SEED;
            stubSprout.growthStatus = GrowthStatus.SPROUT;
            region.plant(stubSprout);
            region.plant(stubSeed);
            //when
            region.advanceSeason();
            //then
            assertEquals(GrowthStatus.SEED, stubSeed.growthStatus);
            assertEquals(GrowthStatus.SPROUT, stubSprout.growthStatus);
        }

    }

    private void fillRegion() {
        int i = 0;
        while (i < 5) {
            region.plant(new GrowableStub());
            i++;
        }
    }

}