package basic.codelab04.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AirplaneTest {
    private Airplane airplane;

    @BeforeEach
    void init() {
        airplane = new Airplane(List.of(new CrewMember()), List.of(new Passenger()), new Watchtower());
    }

    @Test
    void requestForTaxi_addsTaxiRequestToTrackingWatchtower() {
        Watchtower watchtower = airplane.getWatchtower();
        watchtower.track(airplane);
        TaxiRequest taxiRequest = airplane.requestForTaxi();
        assertTrue(watchtower.getTaxiRequests().contains(taxiRequest));
    }

    @Test
    void requestForTaxi_returnsRequestWithThisAirplaneAndTrackingWatchtower() {
        Watchtower watchtower = airplane.getWatchtower();
        watchtower.track(airplane);
        TaxiRequest taxiRequest = airplane.requestForTaxi();
        assertEquals(airplane, taxiRequest.getAirplane());
        assertEquals(watchtower, taxiRequest.getWatchtower());
    }

    @Test
    void requestForTaxi_whenWatchtowerIsNotTrackingAirplane_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class,
                () -> airplane.requestForTaxi());
    }
}