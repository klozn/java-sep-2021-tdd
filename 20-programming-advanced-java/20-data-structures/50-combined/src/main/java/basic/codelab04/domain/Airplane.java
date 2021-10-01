package basic.codelab04.domain;

import java.util.List;

public class Airplane {
    private final List<CrewMember> crew;
    private final List<Passenger> passengers;
    private Watchtower watchtower;

    public Airplane(List<CrewMember> crew, List<Passenger> passengers, Watchtower watchtower) {
        this.crew = crew;
        this.passengers = passengers;
        this.watchtower = watchtower;
    }

    public Watchtower getWatchtower() {
        return watchtower;
    }

    public TaxiRequest requestForTaxi() {
        if (!watchtower.getTrackedAirplanes().contains(this)) {
            throw new IllegalStateException("Watchtower is not tracking this airplane.");
        }
        TaxiRequest taxiRequest = new TaxiRequest(this, watchtower);
        watchtower.getTaxiRequests().offer(taxiRequest);
        return taxiRequest;
    }
}
