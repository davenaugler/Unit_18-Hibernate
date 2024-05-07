package com.coderscampus.Unit_18_Hibernate.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    public static String formatDateTimeToZone(LocalDateTime localDateTime, String timeZoneId) {
        ZoneId timeZone = timeZoneId != null ? ZoneId.of(timeZoneId) : ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = localDateTime.atZone(timeZone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        return zonedDateTime.format(formatter);
    }
}

