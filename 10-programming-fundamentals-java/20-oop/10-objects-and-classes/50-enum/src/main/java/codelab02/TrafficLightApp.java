package codelab02;

public class TrafficLightApp {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight(TrafficLightStatus.PRISTINE, TrafficLightColor.RED);

        System.out.println(trafficLight.allTrafficLightColors());

        trafficLight.changeColor();
        System.out.println(trafficLight);
        trafficLight.changeColor();
        System.out.println(trafficLight);
        trafficLight.changeColor();
        System.out.println(trafficLight);
        trafficLight.changeColor();
        System.out.println(trafficLight);
        trafficLight.setStatus(TrafficLightStatus.DAMAGED);
        trafficLight.changeColor();
        System.out.println(trafficLight);
    }
}
