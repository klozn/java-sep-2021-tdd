package basic.codelab04.domain;

import java.util.*;

public class Watchtower {

    private final List<Airplane> trackedAirplanes = new ArrayList<>();
    private final Queue<TaxiRequest> taxiRequests = new LinkedList<>();
    private final Queue<Airplane> airplanesReadyForTakeOff = new LinkedList<>();

    protected List<Airplane> getTrackedAirplanes() {
        return trackedAirplanes;
    }

    protected Queue<TaxiRequest> getTaxiRequests() {
        return taxiRequests;
    }

    protected Queue<Airplane> getAirplanesReadyForTakeOff() {
        return airplanesReadyForTakeOff;
    }

    public void track(Airplane airplane) {
        if (airplane == null) {
            throw new IllegalArgumentException("Null airplanes not allowed.");
        }
        trackedAirplanes.add(airplane);
    }

    public void approveNextTaxiRequest(){
        if (taxiRequests.isEmpty()) {
            throw new IllegalStateException("There are no taxi requests to approve.");
        }
        TaxiRequest taxiRequest = taxiRequests.poll();
        taxiRequest.setApproved(true);
        airplanesReadyForTakeOff.add(taxiRequest.getAirplane());
    }

    public Airplane approveNextAirplaneForTakeOff() {
        if (airplanesReadyForTakeOff.isEmpty()) {
            throw new IllegalStateException("There are no airplanes ready for take off");
        }
        Airplane airplane = new LinkedList<>(airplanesReadyForTakeOff).pollLast();
        airplanesReadyForTakeOff.remove(airplane);
        trackedAirplanes.remove(airplane);
        return airplane;
    }
}
