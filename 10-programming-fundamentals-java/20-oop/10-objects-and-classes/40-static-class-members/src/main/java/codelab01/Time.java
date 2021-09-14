package codelab01;

import java.util.Objects;

public class Time {
    public static final int TEA_TIME_HOUR = 16;

    private int hour;
    private int minute;
    private double second;

    public Time() {
        this(13, 30, 0);
    }

    public Time(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time(int hour, int minute, double second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public static Time highestHour(Time t1, Time t2) {
        return t1.getHour() >= t2.getHour()? t1: t2;
    }

    @Override
    public String toString() {
        return String.format("The time is %02d:%02d:%02.2f", hour, minute, second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Time time = (Time) o;
        return hour == time.hour && minute == time.minute && Double.compare(time.second, second) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hour, minute, second);
    }
}
