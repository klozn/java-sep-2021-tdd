package basic.codelab04.domain;

public class TaxiRequest {
    private final Airplane airplane;
    private final Watchtower watchtower;
    private boolean approved;

    public TaxiRequest(Airplane airplane, Watchtower watchtower) {
        this.airplane = airplane;
        this.watchtower = watchtower;
    }

    protected Airplane getAirplane() {
        return airplane;
    }

    protected Watchtower getWatchtower() {
        return watchtower;
    }

    public boolean isApproved() {
        return approved;
    }

    protected void setApproved(boolean approved) {
        this.approved = approved;
    }
}
