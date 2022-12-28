package com.rewards.service.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class DateTimeMapperUtils {

    public static LocalDateTime toLocalDatTime(Timestamp timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDateTime();
        } else {
            return null;
        }
    }

    public static Object toSQLTimeStamp(LocalDateTime columnValue) {
        if (columnValue != null) {
            return Timestamp.valueOf(columnValue);
        }
        return null;
    }
}
