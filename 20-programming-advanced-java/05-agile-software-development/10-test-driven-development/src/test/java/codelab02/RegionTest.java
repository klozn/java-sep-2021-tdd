package codelab02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegionTest {
    class GrowableStub implements Growable {
        @Override
        public void plant(Region region) {
        }
    }
    private Region region;

    @BeforeEach
    void setUpRegion() {
        region = new Region();
    }

    @Nested
    @DisplayName("Method plant():")
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
        @DisplayName("when growable Array is full plant() does nothing")
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

    private void fillRegion() {
        int i = 0;
        while (i < 5) {
            region.plant(new GrowableStub());
            i++;
        }
    }

}