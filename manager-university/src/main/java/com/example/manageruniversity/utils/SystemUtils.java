package com.example.manageruniversity.utils;

import java.time.format.DateTimeFormatter;

public class SystemUtils {
    public static final DateTimeFormatter PATTERN_DATE_ENG = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    public static final DateTimeFormatter PATTERN_DATE_VIE = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
}
