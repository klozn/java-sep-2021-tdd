package basic.codelab04.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WatchtowerTest {
    private Watchtower watchtower;
    private Airplane airplane;

    @BeforeEach
    void init() {
        watchtower = new Watchtower();
        airplane = new Airplane(List.of(new CrewMember()), List.of(new Passenger()), watchtower);
    }

    @Test
    void track_addsAirplaneToTrackedAirplanes() {
        watchtower.track(airplane);
        assertTrue(watchtower.getTrackedAirplanes().contains(airplane));
    }

    @Test
    void track_setsAirplaneWatchtower() {
        watchtower.track(airplane);
        assertEquals(watchtower, airplane.getWatchtower());
    }

    @Test
    void track_whenAirplaneIsNull_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> watchtower.track(null));
    }

    @Test
    void approveNextTaxiRequest_setsNextRequestToApproved() {
        watchtower.track(airplane);
        TaxiRequest taxiRequest = airplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        assertTrue(taxiRequest.isApproved());
    }

    @Test
    void approveNextTaxiRequest_firstInFirstOut() {
        Airplane secondAirplane = new Airplane(List.of(new CrewMember()), List.of(new Passenger()), watchtower);
        watchtower.track(airplane);
        watchtower.track(secondAirplane);
        airplane.requestForTaxi();
        TaxiRequest secondTaxiRequest = secondAirplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        assertTrue(watchtower.getTaxiRequests().contains(secondTaxiRequest));
    }

    @Test
    void approveNextTaxiRequest_removesTaxiRequest() {
        watchtower.track(airplane);
        TaxiRequest taxiRequest = airplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        assertFalse(watchtower.getTaxiRequests().contains(taxiRequest));
    }

    @Test
    void approveNextTaxiRequest_whenNoMoreRequests_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> watchtower.approveNextTaxiRequest());
    }

    @Test
    void approveNextTaxiRequest_addsAirplaneToReadyForTakeOffAirplanes() {
        watchtower.track(airplane);
        airplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        assertTrue(watchtower.getAirplanesReadyForTakeOff().contains(airplane));
    }

    @Test
    void approveNextAirplaneForTakeOff_returnsTheAirplane() {
        watchtower.track(airplane);
        airplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        Airplane returned = watchtower.approveNextAirplaneForTakeOff();
        assertEquals(returned, airplane);
    }

    @Test
    void approveNextAirplaneForTakeOff_removesAirplaneFromAirplanesReadyForTakeOff() {
        watchtower.track(airplane);
        airplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        watchtower.approveNextAirplaneForTakeOff();
        assertFalse(watchtower.getAirplanesReadyForTakeOff().contains(airplane));
    }

    @Test
    void approveNextAirplaneForTakeOff_removesAirplaneFromTrackedAirplanes() {
        watchtower.track(airplane);
        airplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        watchtower.approveNextAirplaneForTakeOff();
        assertFalse(watchtower.getTrackedAirplanes().contains(airplane));
    }

    @Test
    void approveNextAirplaneForTakeOff_lastInFirstOut() {
        Airplane secondAirplane = new Airplane(List.of(new CrewMember()), List.of(new Passenger()), watchtower);
        watchtower.track(airplane);
        watchtower.track(secondAirplane);
        airplane.requestForTaxi();
        secondAirplane.requestForTaxi();
        watchtower.approveNextTaxiRequest();
        watchtower.approveNextTaxiRequest();
        watchtower.approveNextAirplaneForTakeOff();
        assertTrue(watchtower.getAirplanesReadyForTakeOff().contains(airplane));
    }

    @Test
    void approveNextAirplaneForTakeOff_whenNoMoreAirplanesReady_throwsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> watchtower.approveNextAirplaneForTakeOff());
    }
}