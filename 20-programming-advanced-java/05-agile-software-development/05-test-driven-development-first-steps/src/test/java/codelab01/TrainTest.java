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
    void givenZeroHourDelay_whenCustomerSatisfactionCalled_thenReturnRightMessage() {
        Train train = new Train();
        train.setHoursDelayed(0);
        String message = train.customerSatisfaction();
        assertEquals("Nice 'n rolling!", message);
    }

    @Test
    void givenOneHourDelay_whenCustomerSatisfactionCalled_thenReturnRightMessage() {
        Train train = new Train();
        train.setHoursDelayed(1);
        String message = train.customerSatisfaction();
        assertEquals("Just another day at the train ...", message);
    }

    @Test
    void givenTwoHourDelay_whenCustomerSatisfactionCalled_thenReturnRightMessage() {
        Train train = new Train();
        train.setHoursDelayed(2);
        String message = train.customerSatisfaction();
        assertEquals("This train is annoying me!", message);
    }

    @Test
    void givenThreeHourDelay_whenCustomerSatisfactionCalled_thenReturnRightMessage() {
        Train train = new Train();
        train.setHoursDelayed(3);
        String message = train.customerSatisfaction();
        assertEquals("B-u-u-urn it!", message);
    }

    @Test
    void givenNegativeHourDelay_whenCustomerSatisfactionCalled_thenReturnZeroHourMessage() {
        Train train = new Train();
        train.setHoursDelayed(-1);
        String message = train.customerSatisfaction();
        assertEquals("Nice 'n rolling!", message);
    }

    @Test
    void givenMoreThanThreeHourDelay_whenCustomerSatisfactionCalled_thenThrowIllegalArgumentException() {
        Train train = new Train();
        train.setHoursDelayed(4);
        assertThrows(IllegalArgumentException.class, train::customerSatisfaction);
    }

}