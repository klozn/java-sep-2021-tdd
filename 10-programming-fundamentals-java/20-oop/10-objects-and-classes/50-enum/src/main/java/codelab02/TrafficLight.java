package codelab02;

import java.util.StringJoiner;

public class TrafficLight {
    private TrafficLightStatus status;
    private TrafficLightColor color;

    public TrafficLight(TrafficLightStatus status, TrafficLightColor color) {
        this.status = status;
        this.color = color;
    }

    public void setStatus(TrafficLightStatus status) {
        this.status = status;
    }

    public void changeColor() {
        color = color.next();
    }

    public String allTrafficLightColors() {
        StringJoiner sj = new StringJoiner(", ");
        StringBuilder sb = new StringBuilder("The possible traffic light colors are: ");
        for (TrafficLightColor color : TrafficLightColor.values()) {
            sj.add(color.getPrintName());
        }
        sb.append(sj).append(".");
        return sb.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TrafficLight{");
        sb.append("status=").append(status);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
}
