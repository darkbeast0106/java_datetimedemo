package com.example.datetimedemo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Example {
    private int id;
    private LocalDate date;
    private LocalDateTime datetime;
    private LocalDateTime timestamp;
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy. MM .dd. HH:mm:ss");

    public Example(int id, LocalDate date, LocalDateTime datetime, LocalDateTime timestamp) {
        this.id = id;
        this.date = date;
        this.datetime = datetime;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getFormattedDateTime() {
        return this.datetime.format(dateTimeFormatter);
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", datetime=" + datetime +
                '}';
    }
}
