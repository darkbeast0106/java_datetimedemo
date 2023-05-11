package com.example.datetimedemo;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Date sqlDate = Date.valueOf("2022-01-12");
        LocalDate localDate = LocalDate.parse("2005-01-13");

        System.out.println(sqlDate);
        System.out.println(localDate);
        System.out.println(sqlDate.toLocalDate());
        System.out.println(Date.valueOf(localDate));
        LocalDate.now();
        String date = "2023. 05. 11.";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd.");
        System.out.println(LocalDate.parse(date, formatter));

        LocalDateTime localDateTime = LocalDateTime.parse("2001-11-03T03:11:22");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. HH:mm");
        String dateTime = "2023. 05. 11. 15:48";
        System.out.println(localDateTime.format(dateTimeFormatter));
        System.out.println(LocalDateTime.parse(dateTime, dateTimeFormatter));
        Timestamp sqlTimestamp = Timestamp.valueOf("2021-11-03 17:11:22");
        System.out.println(sqlTimestamp);
        System.out.println(sqlTimestamp.toLocalDateTime());
        System.out.println(Timestamp.valueOf(localDateTime));

        Period period;
        Duration duration;

        period = Period.between(localDate, LocalDate.now());
        System.out.println(period);
        System.out.println(period.getYears());
        System.out.println(period.getDays());
        System.out.println( Duration.between(localDate.atTime(0,0,0),
                LocalDateTime.now()).toHours() / 24);


        duration = Duration.between(localDateTime, LocalDateTime.now());
        System.out.println(duration);
        System.out.println(duration.toHours());
        System.out.println(duration.toHoursPart());
        Period periodDatetime = Period.between(localDateTime.toLocalDate(), LocalDate.now());

        List<Example> dates = new ArrayList<>();
        dates.add(new Example(1, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now()));
        dates.add(new Example(2, LocalDate.parse("2000-01-01"), LocalDateTime.parse("2000-01-01T11:22:33"),LocalDateTime.parse("2000-01-01T11:22:33")));

        System.out.println(dates.stream()
                .min(Comparator.comparingLong(value -> value.getDatetime().toEpochSecond(ZoneOffset.UTC))).get());
        // toEpochSecond -> 1970-01-01 00:00:00 óta eltelt másodpercekké alakítja az időpontot.

        /*
        Java kódban tárolás, műveletvégzés
            LocalDate / LocalDateTime
        Stringből átalakítás / stringgé alakítás
            DateTimeFormatter segítségével
            LocalDate.parse / objektumNeve.format
        Eltelt idő
            Duration - óra / perc / másodperc
            Perios - év / hónap / nap
        Adatbáziskezelőből adatkinyerés / adatttovábbítás
            Date - java.sql.Date és nem java.util.Date
            Timestamp - datetime és timestamp mysql objektumra is
         */
        HelloApplication.main(args);
    }
}
