package org.ttrzcinski.utils;

import org.ttrzcinski.dictionaries.DateWithTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeUtil {

    // TODO GET CURRENT TIMESTAMP
    public static String todayNNow() {
        return LocalDateTime.now().toString();
    }

    // TODO GET CURRENT DATE
    public static String today() {
        return LocalDate.now().toString();
    }

    // TODO GET CURRENT TIME
    public static String now() {
        return LocalTime.now().toString();
    }

    // TODO PARSE DATE FROM TIMESTAMP
    private static String parseDateNTime(String dateToParse) {
        return LocalDateTime.parse(dateToParse).toString();
    }

    /**
     * Returns given date'n'time in wanted form.
     *
     * @param date wanted form
     * @param localDateTime passed date'n'time moment
     * @return formatted date'n'time
     */
    public static String asTime(DateWithTime date, LocalDateTime localDateTime) {
        LocalDateTime dateTime = localDateTime != null ? localDateTime : LocalDateTime.now();
        switch (date) {
            case YEAR_ONLY -> {
                return Integer.toString(dateTime.getYear());
            }
            case DATE_ONLY -> {
                return dateTime.toLocalDate().toString();
            }
            case TIME_WITHOUT_SECONDS -> {
                return dateTime.toLocalTime().toString();
            }
            case TIME_WITH_SECONDS -> {
                return dateTime.toLocalTime().toString();
            }
            default -> {
                return dateTime.toString();
            }
        }
    }

    /**
     * Returns current moment in wanted form.
     *
     * @param date wanted form
     * @return converted current moment to passed form
     */
    public static String asTime(DateWithTime date) {
        return asTime(date, LocalDateTime.now());
    }
}
