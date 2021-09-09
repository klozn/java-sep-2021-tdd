package codelab08;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

public class DateTimeApp {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate feb20_2015 = LocalDate.of(2015, 02, 20);
        LocalDate feb21_2015 = LocalDate.parse("2015-02-21");

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        LocalDate previousMonthSameDay = LocalDate.now().minusMonths(1);
        LocalDate same = LocalDate.now().minus(1, ChronoUnit.MONTHS);

        DayOfWeek sunday = LocalDate.parse("2016-06-12").getDayOfWeek();
        int twelve = LocalDate.parse("2016-06-12").getDayOfMonth();

        boolean leapYear = LocalDate.now().isLeapYear();

        boolean notBefore = LocalDate.parse("2016-06-12")
                .isBefore(LocalDate.parse("2016-06-11"));
        boolean isAfter = LocalDate.parse("2016-06-12")
                .isAfter(LocalDate.parse("2016-06-11"));

        LocalDateTime beginningOfDay = LocalDate.parse("2016-06-12").atStartOfDay();
        LocalDate firstDayOfMonth = LocalDate.parse("2016-06-12")
                .with(TemporalAdjusters.firstDayOfMonth());

        LocalTime now = LocalTime.now();
        LocalTime sixThirty = LocalTime.parse("06:30");
        LocalTime sixForty = LocalTime.of(6, 40);

        LocalTime sevenThirty = LocalTime.parse("06:30")
                .plus(1, ChronoUnit.HOURS);
        int six = sixThirty.getHour();
        boolean isBefore = sixThirty.isBefore(sixForty);
        LocalTime maxTime = LocalTime.MAX;

        LocalDateTime now2 = LocalDateTime.now();

        ZoneId parisZone = ZoneId.of("Europe/Paris");
        Set<String> allZoneIds = ZoneId.getAvailableZoneIds();
        ZonedDateTime zonedDateTime = ZonedDateTime.of(now2, parisZone);
        zonedDateTime = ZonedDateTime.parse("2015-05-03T10:15:30+01:00[Europe/Paris");

        LocalDateTime localDateTime = LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30);
        ZoneOffset offset = ZoneOffset.of("+02:00");
        OffsetDateTime offSetByTwo = OffsetDateTime.of(localDateTime, offset);

        LocalDate initialDate = LocalDate.parse("2007-05-10");
        LocalDate finalDate = initialDate.plus(Period.ofDays(5));

        int five = Period.between(initialDate, finalDate).getDays();
        long jive = ChronoUnit.DAYS.between(initialDate, finalDate);

        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));

        long thirty = Duration.between(initialTime, finalTime).getSeconds();
        long thirsty = ChronoUnit.SECONDS.between(initialTime, finalTime);
    }
}