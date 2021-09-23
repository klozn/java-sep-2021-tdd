package codelab01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    @Test
    void givenDefaultTrain_whenGetHoursDelayedIsCalled_thenReturnsDefaultValue() {
        Train defaultTrain = new Train();
        int hoursDelayed = defaultTrain.getHoursDelayed();
        assertEquals(0, hoursDelayed);
    }

    @Test
    void givenNegativeValue_whenSettingHoursDelayed_thenSetHoursDelayedToZero() {
        Train train = new Train();
        train.setHoursDelayed(-1);
        assertEquals(0, train.getHoursDelayed());
    }

    @Test
    void givenZeroHoursDelay_whenCustomerSatisfactionCalled_returnRightString() {
        Train train = new Train();
        train.setHoursDelayed(0);
        assertEquals("Nice 'n rolling", train.customerSatisfaction());
    }

}