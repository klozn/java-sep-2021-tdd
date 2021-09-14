package codelab01;

public class TimeRunner {


    public static void main(String[] args) {
        Time noon = new Time(12, 0);
        Time alarm = new Time(6, 30);
        Time brushTeeth = new Time(6, 40);
        Time firstSecondOfTheDay = new Time(0, 0,1);
        Time goToBed = new Time(22, 24,17.66);

        System.out.println(Time.TEA_TIME_HOUR);
        System.out.println(noon);
        System.out.println(alarm);
        System.out.println(Time.highestHour(firstSecondOfTheDay, goToBed));
        System.out.println(Time.highestHour(alarm, brushTeeth));
    }
}
